package com.example.carrental.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Entity
public class Sample {
	@GeneratedValue
	@Id
	private long Id;
	private String plateNumber;
	private String brand;
	private int price;
	private boolean rented;
	private int numberOfDays;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Rent> rents = new ArrayList<Rent>();
	
	public Sample() {
		super();
	}
			
	 public void setId(long id) {
		Id = id;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public Long getId() {
	        return Id;
	    }
	 
		public List<Rent> getRents() {
			return rents;
		}
	    
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}
