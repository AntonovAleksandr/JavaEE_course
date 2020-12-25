package data.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class Newspaper extends Publication {
    private Long number;

    public Newspaper(Long id, String title, Long countOfPages, BigDecimal price, Date data, Long number) {
        this.setId(id);
        this.setTitle(title);
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setData(data);
        this.number = number;

    }

    public Newspaper(String title, Long countOfPages, BigDecimal price, Date date, Long number) {
        this.setTitle(title);
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setData(date);
        this.number = number;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + getTitle() + '\'' +
                ", data=" + getData() +
                ", countOfPages=" + getCountOfPages() +
                ", price=" + getPrice() +
                ", id=" + getId() +
                "number=" + number +
                "}\n";
    }

    public Newspaper(Long id, String title, Long countOfPages, BigDecimal price, Long number) {
        this(id, title, countOfPages, price, Date.valueOf(LocalDate.now()), number);
    }


    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
