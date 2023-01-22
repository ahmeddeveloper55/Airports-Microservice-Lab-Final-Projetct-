package com.example.CitizenServer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CitizenServer.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>{
	

}