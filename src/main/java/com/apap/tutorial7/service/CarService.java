package com.apap.tutorial7.service;

import java.util.*;

import com.apap.tutorial7.model.CarModel;

public interface CarService {
	CarModel addCar(CarModel car);
	void deleteCar(CarModel car);
	Optional<CarModel> getCarDetailById(Long id);
	void updateCar(Long oldCarId, CarModel newCar);
	List<CarModel> getAllCar();
}
