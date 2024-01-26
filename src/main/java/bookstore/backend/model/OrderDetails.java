package bookstore.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Entity
@Table(name = "Orderdetails")
public class OrderDetails {

    @Embeddable
    public static class OrderDetailsId implements Serializable {
        @Column(name = "orderid")
        protected Long orderId;

        @Column(name = "bookid")
        protected Long bookId;

        // Constructors, getters, setters, equals, and hashCode methods
        public OrderDetailsId() {}

        public OrderDetailsId(Long orderId, Long bookId) {
            this.orderId = orderId;
            this.bookId = bookId;
        }

        // Getters and setters, equals(), and hashCode() methods omitted for brevity
    }

    @EmbeddedId
    private OrderDetailsId id = new OrderDetailsId();

    @ManyToOne
    @JoinColumn(name = "orderid", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "bookid", insertable = false, updatable = false)
    private Book book;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "priceperunit", nullable = false, precision = 10, scale = 2)
    private Double pricePerUnit;

    // Default constructor
    public OrderDetails() {}

    // Constructor with all fields
    public OrderDetails(Order order, Book book, Integer quantity, Double pricePerUnit) {
        this.order = order;
        this.book = book;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.id.orderId = order.getOrderId();
        this.id.bookId = book.getBookId();
    }

    // Getters and setters
    public OrderDetailsId getId() {
        return id;
    }

    public void setId(OrderDetailsId id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", order=" + order +
                ", book=" + book +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}