package com.example.carrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carrental.model.Rent;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

	
}
