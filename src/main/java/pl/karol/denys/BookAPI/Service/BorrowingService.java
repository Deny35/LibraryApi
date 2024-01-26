package pl.karol.denys.BookAPI.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.karol.denys.BookAPI.Entity.Book;
import pl.karol.denys.BookAPI.Entity.Borrowing;
import pl.karol.denys.BookAPI.Entity.User;
import pl.karol.denys.BookAPI.Repository.BookRepository;
import pl.karol.denys.BookAPI.Repository.BorrowingRepository;
import pl.karol.denys.BookAPI.Repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public Borrowing borrowBook(Long bookId, String studentNumber) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        if (book.isBorrowed()) {
            throw new IllegalStateException("Book is already borrowed");
        }

        User user = userRepository.findByStudentNumber(studentNumber)
                .orElseThrow(() -> new EntityNotFoundException("User not found with student number: " + studentNumber));

        book.setBorrowed(true);
        bookRepository.save(book);

        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setUser(user);
        borrowing.setBorrowedDate(LocalDate.now());
        borrowing.setReturnedDate(null);

        return borrowingRepository.save(borrowing);
    }

    public void returnBook(Long borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId)
                .orElseThrow(() -> new EntityNotFoundException("Borrowing not found"));

        Book book = borrowing.getBook();
        book.setBorrowed(false);
        bookRepository.save(book);

        borrowing.setReturnedDate(LocalDate.now());
        borrowingRepository.save(borrowing);
    }

    public List<Borrowing> findBorrowingsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return borrowingRepository.findByUserAndReturnedDateIsNull(user);
    }
}
