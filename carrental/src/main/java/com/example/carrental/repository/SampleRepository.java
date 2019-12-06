package com.example.carrental.repository;

import com.example.carrental.model.Sample;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

	Optional<Sample> findByPlateNumber(String plateNumber);
}
