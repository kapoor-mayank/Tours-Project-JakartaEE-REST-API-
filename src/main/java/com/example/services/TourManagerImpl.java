package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Tour;
import com.example.repositories.TourRepository;

@Service
public class TourManagerImpl implements TourManager {

	@Autowired
	TourRepository repository;
	@Override
	public void addTour(Tour tour) {
		// TODO Auto-generated method stub
		repository.save(tour);
	}

	@Override
	public List<Tour> getTours() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public List<Tour> getByType(String type) {
		// TODO Auto-generated method stub
		return repository.listType(type);
	}

	@Override
	public Optional<Tour> getByName(String name) {
		// TODO Auto-generated method stub
		return repository.getTourByName(name);
	}

	@Override
	public List<Tour> getByPriceRange(double start, double end) {
		// TODO Auto-generated method stub
		return repository.priceRange(start, end);
	}

	@Override
	public void updateCost(double price, int id) {
		// TODO Auto-generated method stub
		repository.updateTourCost(price, id);
	}

}
