package pl.karol.denys.BookAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karol.denys.BookAPI.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStudentNumber(String studentNumber);
}
