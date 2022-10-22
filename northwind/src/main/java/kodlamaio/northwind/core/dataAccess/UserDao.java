package kodlamaio.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.northwind.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	User finByEmail(String email);
	//kullanıcı bilgilerine email ile ulaşmak için

}
