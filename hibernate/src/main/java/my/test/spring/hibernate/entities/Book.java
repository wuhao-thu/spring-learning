package my.test.spring.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HB_BOOK")
public class Book {
    @Id
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private Integer stock;

    public Book() {
    }

    public Book(String isbn, String bookName, Double price, Integer stock) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
