package bookstore.backend.dto;

import java.math.BigDecimal;

public class BookDetailsDTO {
    private String title;
    private String authorName;
    private BigDecimal price;
    private Integer quantityInStock;

    public BookDetailsDTO(String title, String authorName, BigDecimal price, Integer quantityInStock) {
        this.title = title;
        this.authorName = authorName;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for authorName
    public String getAuthorName() {
        return authorName;
    }

    // Setter for authorName
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Getter for price
    public BigDecimal getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Getter for quantityInStock
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    // Setter for quantityInStock
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "BookDetailsDTO{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
