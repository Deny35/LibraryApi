package pl.karol.denys.BookAPI.Entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}