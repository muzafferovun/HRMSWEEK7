package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Sector;

public interface SectorDao extends JpaRepository<Sector, Integer> {

}
