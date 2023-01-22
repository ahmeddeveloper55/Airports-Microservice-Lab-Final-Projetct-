package com.example.VaccinationService.Model;

import java.util.List;

import com.example.VaccinationService.Entity.Airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RequiredResponse {
	private Airport center;
	private List<Citizen> citizens;
}