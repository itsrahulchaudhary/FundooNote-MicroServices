package in.rahulit.fundoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rahulit.fundoo.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);

}
