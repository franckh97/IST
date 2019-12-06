package com.example.carrental.web;
import com.example.carrental.model.Rent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrental.model.Sample;
import com.example.carrental.service.*;


@RestController
public class SampleRestService {
	
	@Autowired
	private SampleService sample_service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/samples", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Sample> getListOfCars(){
		return sample_service.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/samples", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Sample car) throws Exception{
		System.out.println(car);
		sample_service.save(car);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/samples/{plateNumber}", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Sample getCar(@PathVariable String plateNumber){
		return sample_service.getOne(plateNumber).orElse(null);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/samples/{plateNumber}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public	Sample RentCar(@PathVariable String plateNumber,@RequestParam(name="numberOfDays") int numberOfDays) {
		Sample car = sample_service.getOne(plateNumber).orElse(null);
		List<Rent> rents = car.getRents();
		if(rents.size() == 0){
			Rent rent = new Rent();
			rent.setDate(Calendar.getInstance().getTime());
			rents.add(rent);
			rent.setSample(car);
			car.setRented(true);
			car.setNumberOfDays(numberOfDays);
		} else {
			rents.remove(0);
			car.setRented(false);
		}
		System.out.println(car);
		return sample_service.save(car);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/samples/getback/{plateNumber}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public	Sample GetBackcar(@PathVariable String plateNumber,@RequestParam(name="louer" ,required=false) boolean louer) {
		Sample car = sample_service.getOne(plateNumber).orElse(null);
		List<Rent> rents = car.getRents();
		if(rents.size() != 0){
			car.setRented(false);
			car.setNumberOfDays(0);
		} else {
			System.out.println("here");
			car.setRented(false);
		}
		System.out.println(car.isRented());
		return sample_service.save(car);
		
	}

}

//@request