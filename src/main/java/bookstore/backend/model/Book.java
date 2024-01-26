package bookstore.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@JsonSerialize
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "publishdate")
    private Date publishDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "quantityinstock")
    private Integer quantityInStock;

    // Default constructor
    public Book() {}

    // Constructor with all fields
    public Book(String title, String isbn, BigDecimal price, Date publishDate, String genre, Integer quantityInStock) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publishDate = publishDate;
        this.genre = genre;
        this.quantityInStock = quantityInStock;
    }

    // Getters and setters for all fields
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    // Override toString() for easy printing of Book objects
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", genre='" + genre + '\'' +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    // Other business logic methods can be added here
}
