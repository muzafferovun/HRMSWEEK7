package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Person;
import kodlamaio.northwind.entities.concretes.PersonUser;


public interface PersonService {
	DataResult<List<Person>>  getAll();
	Result add(PersonUser personUser);

}
