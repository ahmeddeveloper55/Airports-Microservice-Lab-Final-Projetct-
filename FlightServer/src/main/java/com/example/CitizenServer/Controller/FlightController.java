package com.example.CitizenServer.Controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.CitizenServer.Entity.Flight;
import com.example.CitizenServer.repositories.FlightRepository;


@RequestMapping("/flight")
@RestController
public class FlightController {


	private final FlightRepository flightRepository;

	public FlightController(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@RequestMapping(path ="/id/{id}")
	public Flight getById(@PathVariable Integer id) {
		return flightRepository.findById(id).orElse(null);
	}


	@GetMapping("/getAllFlight")
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable int id) {
		return flightRepository.findById(id).orElse(null);
	}

	@PostMapping("/addFlight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightRepository.save(flight);
	}

	@PutMapping("/{id}")
	public Flight updateFlight(@PathVariable int id, @RequestBody Flight flight) {
		flight.setId(id);
		return flightRepository.save(flight);
	}

	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable int id) {
		flightRepository.deleteById(id);
	}
}