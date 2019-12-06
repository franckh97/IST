package com.example.carrental.service;



import javax.transaction.Transactional;
import com.example.carrental.model.Rent;
import org.springframework.stereotype.Service;
import com.example.carrental.repository.RentRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RentService {

	
	@Autowired
	private RentRepository rentrepository;
	
	public List<Rent>findall(){
		return rentrepository.findAll();
	}
}
