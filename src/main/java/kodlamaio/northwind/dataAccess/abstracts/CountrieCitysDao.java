package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.CountrieCitys;

public interface CountrieCitysDao extends JpaRepository<CountrieCitys, Integer> {

}
