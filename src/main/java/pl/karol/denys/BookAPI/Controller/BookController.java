package pl.karol.denys.BookAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.karol.denys.BookAPI.Entity.Book;
import pl.karol.denys.BookAPI.Service.BookService;
import pl.karol.denys.BookAPI.Service.UserService;

import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> findByTitle(@RequestParam String title) {
        List<Book> books = bookService.findByTitle(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}