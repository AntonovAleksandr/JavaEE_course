package data.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
@Data
public class Book extends Publication {

    private String author;
    private String publishingHouse;

    public Book(Long id, String title, Long countOfPages, BigDecimal price, Date data, String author, String publishingHouse) {
        this.setId(id);
        this.setTitle(title);
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setData(data);
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public Book(Long id, String title, Long countOfPages, BigDecimal price, String author, String publishingHouse) {
        this(id, title, countOfPages, price, Date.valueOf(LocalDate.now()), author, publishingHouse);
    }

    public Book(String title, Long countOfPages, BigDecimal price, String publicationHouse, String author, Date date) {
        this.setTitle(title);
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setData(date);
        this.author = author;
        this.publishingHouse = publishingHouse;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", data=" + getData() +
                ", countOfPages=" + getCountOfPages() +
                ", price=" + getPrice() +
                ", id=" + getId() +
                "author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                "}\n";
    }
}

