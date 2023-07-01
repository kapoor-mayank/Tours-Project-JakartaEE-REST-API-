package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Tour;
import com.example.services.TourManager;

@RestController
public class TourController {
	
	@Autowired
	TourManager manager;
	
	@GetMapping(value = "api/getTours")
	public List<Tour> getTours() {
		return manager.getTours();
	}
	
	@PostMapping(value = "api/addTour")
	public void addTour(@RequestBody Tour tour) {
		manager.addTour(tour);
	}
	
	@GetMapping(value = "api/getToursByType/{type}")
	public List<Tour> getByType(@PathVariable String type) {
		return manager.getByType(type);
	}
	
	@GetMapping(value = "api/getTourByName/{name}")
	public Optional<Tour> getTourByName(@PathVariable String name) {
		return manager.getByName(name);
	}
	
	@GetMapping(value = "api/getToursByPriceRange/{start}/{end}")
	public List<Tour> getByPriceRange(@PathVariable double start, @PathVariable double end) {
		return manager.getByPriceRange(start, end);
	}
	
	@PutMapping(value = "api/updateCost/{cost}/{id}")
	public void updateCost(@PathVariable double cost, @PathVariable int id) {
		manager.updateCost(cost, id);
	}
}
