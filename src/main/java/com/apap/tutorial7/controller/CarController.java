package com.apap.tutorial7.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.service.CarService;
import com.apap.tutorial7.service.DealerService;

@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@PutMapping(value = "/{carId}")
	private String updateCar(
			@PathVariable (value = "carId") long id,
			@RequestParam("brand") String brand,
			@RequestParam("type") String type,
			@RequestParam("price") Long price,
			@RequestParam("amount") Integer amount,
			@RequestParam("dealerId") Long dealerId) {
		CarModel car = carService.getCarDetailById(id).get();
		if (car.equals(null)) {
			return "Couldn't find your dealer";
		}
		car.setBrand(brand);
		car.setType(type);
		car.setPrice(price);
		car.setAmount(amount);
		carService.updateCar(id, car);
		return "car update success";
	}
	
	@PostMapping()
	private CarModel addCarSubmit(@RequestBody CarModel car) {
		return carService.addCar(car);
	}
	
	@GetMapping(value = "/{carId}")
	private CarModel viewCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarDetailById(carId).get();
	}
	
	@GetMapping()
	private List<CarModel> viewAllCar(Model model) {
		return carService.getAllCar();
	}
	
	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable("carId") long id, Model model) {
		CarModel car = carService.getCarDetailById(id).get();
		carService.deleteCar(car);
		return "car has been deleted";
	}
	
}
