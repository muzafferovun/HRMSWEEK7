package kodlamaio.northwind.business.abstracts;

import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CompanyActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;

public interface CompanyActivationCodesService {
	Result activate(CompanyActivationCodes companyActivationCodes);

}
