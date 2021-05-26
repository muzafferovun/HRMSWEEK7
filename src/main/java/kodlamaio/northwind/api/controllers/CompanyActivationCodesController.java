package kodlamaio.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.CompanyActivationCodesService;
import kodlamaio.northwind.business.abstracts.PersonActivationCodesService;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CompanyActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;


@RestController
@RequestMapping("/api/company_activation_codes")
public class CompanyActivationCodesController {
	private CompanyActivationCodesService companyActivationCodesService;
	@Autowired
	public CompanyActivationCodesController(CompanyActivationCodesService companyActivationCodesService) {
		super();
		this.companyActivationCodesService=companyActivationCodesService;
	}
	@PostMapping("/activate")
	public Result activate(@RequestBody CompanyActivationCodes companyActivationCodes) {
		return this.companyActivationCodesService.activate(companyActivationCodes);
	}
	
}
