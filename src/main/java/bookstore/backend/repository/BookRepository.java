package bookstore.backend.repository;

import bookstore.backend.model.Book;
import bookstore.backend.dto.BookDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find books by title
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findByTitleContaining(String title);

    // Find books by author's name using a JOIN on the BookAuthor entity
    @Query("SELECT b FROM Book b JOIN BookAuthor ba ON b.bookId = ba.id.bookId JOIN Author a ON a.authorId = ba.id.authorId WHERE a.name LIKE %:authorName%")
    List<Book> findByAuthorName(String authorName);

    // Find books by genre
    List<Book> findByGenre(String genre);

    // Find books with stock quantity below a certain threshold
    @Query("SELECT b FROM Book b WHERE b.quantityInStock < :threshold")
    List<Book> findBooksLowOnStock(int threshold);

    // Find books within a certain price range
    List<Book> findByPriceBetween(BigDecimal min, BigDecimal max);


    // Custom query to fetch books with details like author names and stock quantity (example)
    @Query("SELECT new bookstore.backend.dto.BookDetailsDTO(b.title, a.name, b.price, b.quantityInStock) " +
            "FROM Book b JOIN BookAuthor ba ON b.bookId = ba.id.bookId JOIN Author a ON a.authorId = ba.id.authorId")
    List<BookDetailsDTO> findAllBooksWithDetails();
}

