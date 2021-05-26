package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CompanyService;
import kodlamaio.northwind.business.abstracts.PersonService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Company;
import kodlamaio.northwind.entities.concretes.CompanyUser;
import kodlamaio.northwind.entities.concretes.Person;
import kodlamaio.northwind.entities.concretes.PersonUser;


@RestController
@RequestMapping("/api/company")
public class CompanyController {
	private CompanyService companyService;
	@Autowired
	public CompanyController( CompanyService companyService) {
		super();
		this.companyService=companyService;
	}
	@GetMapping("/getall")
	public DataResult<List<Company>> getAll(){
		return this.companyService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CompanyUser companyUser) {
		return this.companyService.add(companyUser);
	}
	
}
