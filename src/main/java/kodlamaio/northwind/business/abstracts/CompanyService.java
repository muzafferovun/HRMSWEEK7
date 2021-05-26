package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Company;
import kodlamaio.northwind.entities.concretes.CompanyUser;


public interface CompanyService {
	DataResult<List<Company>>  getAll();
	Result add(CompanyUser companyUser);

}
