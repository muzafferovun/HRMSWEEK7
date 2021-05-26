package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.PersonService;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Person;
import kodlamaio.northwind.entities.concretes.PersonUser;



@RestController
@RequestMapping("/api/person")
public class PersonController {
	private PersonService personService;
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService=personService;
	}
	@GetMapping("/getall")
	public DataResult<List<Person>> getAll(){
		return this.personService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody PersonUser personUser) {
		return this.personService.add(personUser);
	}
	
}
