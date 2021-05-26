package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonUser;

public interface PersonActivationCodesService {
	DataResult<List<PersonActivationCodes>>  getAll();
	Result activate(PersonActivationCodes personActivationCodes);

}
