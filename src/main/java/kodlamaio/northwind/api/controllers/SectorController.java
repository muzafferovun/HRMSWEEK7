package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.SectorService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Sector;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {
	private SectorService sectorService;
	@Autowired
	public SectorController(SectorService sectorService) {
		super();
		this.sectorService=sectorService;
	}
	@GetMapping("/getall")
	public DataResult<List<Sector>> getAll(){
		return this.sectorService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Sector sector) {
		return this.sectorService.add(sector);
	}
	
}
