package bookstore.backend.service;

import bookstore.backend.model.Book;
import bookstore.backend.dto.BookDetailsDTO;
import bookstore.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
   @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<BookDetailsDTO> findAllBooksWithDetails() {
        return bookRepository.findAllBooksWithDetails();
    }

/*public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

 */

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setIsbn(updatedBook.getIsbn());
                    book.setPrice(updatedBook.getPrice());
                    book.setPublishDate(updatedBook.getPublishDate());
                    book.setGenre(updatedBook.getGenre());
                    book.setQuantityInStock(updatedBook.getQuantityInStock());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setBookId(id);
                    return bookRepository.save(updatedBook);
                });
    }

    // Add more methods as required
}