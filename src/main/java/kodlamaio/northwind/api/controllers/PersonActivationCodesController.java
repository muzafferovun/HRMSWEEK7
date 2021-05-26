package kodlamaio.northwind.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.PersonActivationCodesService;

import kodlamaio.northwind.core.utilities.results.Result;

import kodlamaio.northwind.entities.concretes.PersonActivationCodes;



@RestController
@RequestMapping("/api/person_activation_codes")
public class PersonActivationCodesController {
	private PersonActivationCodesService personActivationCodesService;
	@Autowired
	public PersonActivationCodesController(PersonActivationCodesService personActivationCodesService) {
		super();
		this.personActivationCodesService=personActivationCodesService;
	}
	@PostMapping("/activate")
	public Result activate(@RequestBody PersonActivationCodes personActivationCodes) {
		return this.personActivationCodesService.activate(personActivationCodes);
	}
	
}
