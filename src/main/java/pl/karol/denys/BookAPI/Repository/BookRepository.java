package pl.karol.denys.BookAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.karol.denys.BookAPI.Entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
}

