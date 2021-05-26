package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.northwind.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
    @Query(value = "SELECT usr.* FROM global_user usr WHERE usr.email=(:email)", nativeQuery = true)
    public List<User> findEmail(@Param("email") String email);
	
}
