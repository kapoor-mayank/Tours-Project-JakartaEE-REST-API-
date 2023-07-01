package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Tour;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TourRepository extends JpaRepository<Tour, Integer>{
	
	@Query("from Tour t where t.type=:type")
	List<Tour> listType(@Param("type") String type);
	
	@Query("from Tour t where t.name=:name")
	Optional<Tour> getTourByName(@Param("name") String name);
	
	@Query(value = "select * from tour where cost between :start and :end", nativeQuery=true)
	List<Tour> priceRange(@Param("start") double start, @Param("end") double end);
	
	@Modifying
	@Query(value = "update tour set cost=:price where t_id=:id", nativeQuery=true)
	void updateTourCost(@Param("price") double price, @Param("id") int id);
}
