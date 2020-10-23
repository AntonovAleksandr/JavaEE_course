package domains;

import java.math.BigDecimal;
import java.util.Date;

public class Book extends Publication {

    private String author;
    private String publishingHouse;

    public Book(String title, int countOfPages, String publishingHouse, String author, BigDecimal price) {
        this.publishingHouse = publishingHouse;
        this.author = author;
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setTitle(title);
        this.setData(new Date());
    }

    public Book(String title, int countOfPages, String publishingHouse, String author, BigDecimal price, Date data) {
        this(title, countOfPages, publishingHouse, author, price);
        this.setData(data);
    }


    public String getAuthor() {
        return author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }


}
