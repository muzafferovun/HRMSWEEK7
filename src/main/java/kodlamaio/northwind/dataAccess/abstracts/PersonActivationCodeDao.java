package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.northwind.entities.concretes.Person;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;


public interface PersonActivationCodeDao extends JpaRepository<PersonActivationCodes, Integer> {
    @Query(value = "SELECT usr.* FROM person_activation_codes usr WHERE usr.person_id=(:person_id) and usr.activation_code=(:activation_code) ", nativeQuery = true)
    public List<PersonActivationCodes> checkActivationCode(@Param("person_id") int person_id,@Param("activation_code") String activation_code);

}
