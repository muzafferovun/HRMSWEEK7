package kodlamaio.northwind.dataAccess.abstracts;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.northwind.entities.concretes.Person;


public interface PersonDao extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT usr.* FROM person usr WHERE usr.national_identity=(:national_identity)", nativeQuery = true)
    public List<Person> findNational_identity(@Param("national_identity") String national_identity);

 
 
    @Modifying
    @Transactional
    @Query(value = "update person set is_verify = true where id = (:id)", nativeQuery = true)
   public void activatePerson(@Param("id") int id);
}
