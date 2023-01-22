package com.example.VaccinationService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Citizen {
	private int id;
	private String name;
	private int vaccinationCenterId;
}