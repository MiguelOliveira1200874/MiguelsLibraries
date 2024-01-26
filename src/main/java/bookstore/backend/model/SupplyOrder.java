package bookstore.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Supplyorders")
public class SupplyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplyorderid")
    private Long supplyOrderId;

    @ManyToOne
    @JoinColumn(name = "supplierid", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "bookid", nullable = false)
    private Book book;

    @Column(name = "orderdate", nullable = false)
    @Temporal(TemporalType.DATE) // specify the precision of date/time
    private Date orderDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "priceperunit", nullable = false, precision = 10, scale = 2)
    private Double pricePerUnit;

    // Default constructor
    public SupplyOrder() {}

    // Constructor with all fields
    public SupplyOrder(Supplier supplier, Book book, Date orderDate, Integer quantity, Double pricePerUnit) {
        this.supplier = supplier;
        this.book = book;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    // Getters and setters
    public Long getSupplyOrderId() {
        return supplyOrderId;
    }

    public void setSupplyOrderId(Long supplyOrderId) {
        this.supplyOrderId = supplyOrderId;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
        return "SupplyOrder{" +
                "supplyOrderId=" + supplyOrderId +
                ", supplier=" + supplier +
                ", book=" + book +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}