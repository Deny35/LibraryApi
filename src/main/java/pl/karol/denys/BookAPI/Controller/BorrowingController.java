package pl.karol.denys.BookAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karol.denys.BookAPI.Entity.Borrowing;
import pl.karol.denys.BookAPI.Service.BorrowingService;

import java.util.List;


@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/borrow")
    public ResponseEntity<Borrowing> borrowBook(@RequestParam Long bookId, @RequestParam String studentNumber) {
        try {
            Borrowing borrowing = borrowingService.borrowBook(bookId, studentNumber);
            return ResponseEntity.ok(borrowing);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PostMapping("/return/{id}")
    public ResponseEntity<Void> returnBook(@PathVariable Long id) {
        borrowingService.returnBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Borrowing>> findBorrowingsByUser(@PathVariable Long userId) {
        List<Borrowing> borrowings = borrowingService.findBorrowingsByUser(userId);
        return new ResponseEntity<>(borrowings, HttpStatus.OK);
    }
}
