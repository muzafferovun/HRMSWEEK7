package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.CountrieCitys;


public interface CountrieCitysService {
	DataResult<List<CountrieCitys>>  getAll();
	Result add(CountrieCitys countrieCitys);

}
