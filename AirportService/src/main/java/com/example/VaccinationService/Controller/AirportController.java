package com.example.VaccinationService.Controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.VaccinationService.Entity.Airport;
import com.example.VaccinationService.Model.Citizen;
import com.example.VaccinationService.Model.RequiredResponse;
import com.example.VaccinationService.repositories.AirportRepository;

@RequestMapping("/airport")
@RestController
public class AirportController {
	
	// @Autowired
	private final AirportRepository airportRepository;
	
	// @Autowired
	private final RestTemplate restTemplate;
	public AirportController(AirportRepository centerRepo, RestTemplate restTemplate){
		this.airportRepository = centerRepo;
		this.restTemplate = restTemplate;
	}
	
	@PostMapping(path ="/add")
	public Airport add(@RequestBody Airport airport) {
		return airportRepository.save(airport);
	}

	@GetMapping("/getAllAirports")
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}
	@GetMapping("/{id}")
	public Airport getAirportById(@PathVariable int id) {
		return airportRepository.findById(id).orElse(null);
	}
	@PutMapping("/{id}")
	public Airport updateAirport(@PathVariable int id, @RequestBody Airport airport) {
		airport.setId(id);
		return airportRepository.save(airport);
	}

	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable int id) {
		airportRepository.deleteById(id);
	}

	@GetMapping(path = "/id/{id}")
	public RequiredResponse getAllDataBasedonCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse =  new RequiredResponse();
		Airport center  = airportRepository.findById(id).get();
		requiredResponse.setCenter(center);
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CitizenServer/citizen/vacc_id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return requiredResponse;
	}
}