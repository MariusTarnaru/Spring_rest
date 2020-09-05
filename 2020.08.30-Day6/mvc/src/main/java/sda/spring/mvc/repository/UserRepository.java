package sda.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.spring.mvc.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
