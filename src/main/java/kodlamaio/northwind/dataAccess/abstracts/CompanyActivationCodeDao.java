package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.northwind.entities.concretes.CompanyActivationCodes;
import kodlamaio.northwind.entities.concretes.PersonActivationCodes;


public interface CompanyActivationCodeDao extends JpaRepository<CompanyActivationCodes, Integer> {
    @Query(value = "SELECT usr.* FROM company_activation_codes usr WHERE usr.company_id=(:company_id) and usr.activation_code=(:activation_code) ", nativeQuery = true)
    public List<CompanyActivationCodes> checkActivationCode(@Param("company_id") int company_id,@Param("activation_code") String activation_code);

}
