package com.example.VaccinationService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VaccinationService.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer>{

}