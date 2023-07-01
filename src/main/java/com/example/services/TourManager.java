package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entities.Tour;

public interface TourManager {
	void addTour(Tour tour);
	void updateCost(double price, int id);
	List<Tour> getTours();
	List<Tour> getByType(String type);
	Optional<Tour> getByName(String name);
	List<Tour> getByPriceRange(double start, double end);
}
