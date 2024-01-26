package bookstore.backend.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;


@Entity
@Table(name = "BookAuthor")
public class BookAuthor {

    @Embeddable
    public static class BookAuthorId implements Serializable {
        @Column(name = "bookid")
        protected Long bookId;

        @Column(name = "authorid")
        protected Long authorId;

        // Constructors, getters, setters, equals, and hashCode methods
        public BookAuthorId() {}

        public BookAuthorId(Long bookId, Long authorId) {
            this.bookId = bookId;
            this.authorId = authorId;
        }

        // Getters and setters, equals(), and hashCode() methods omitted for brevity
    }

    @EmbeddedId
    private BookAuthorId id = new BookAuthorId();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookid", insertable = false, updatable = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorid", insertable = false, updatable = false)
    private Author author;

    // Default constructor
    public BookAuthor() {}

    // Constructor with book and author
    public BookAuthor(Book book, Author author) {
        this.book = book;
        this.author = author;
        this.id.authorId = author.getAuthorId();
        this.id.bookId = book.getBookId();
    }

    // Getters and setters for book and author
    public BookAuthorId getId() {
        return id;
    }

    public void setId(BookAuthorId id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
