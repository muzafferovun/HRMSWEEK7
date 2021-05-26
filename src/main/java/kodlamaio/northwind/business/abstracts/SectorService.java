package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Sector;

public interface SectorService {
	DataResult<List<Sector>>  getAll();
	Result add(Sector sector);

	
}
