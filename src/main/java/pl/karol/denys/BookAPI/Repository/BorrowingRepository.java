package pl.karol.denys.BookAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karol.denys.BookAPI.Entity.Borrowing;
import pl.karol.denys.BookAPI.Entity.User;

import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing> findByUserAndReturnedDateIsNull(User user);
}

