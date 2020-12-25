package data.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Date;

public class Magazine extends Newspaper {
    private String type;

    public Magazine(Long id, String title, Long countOfPages, BigDecimal price, Date date, Long number, String type) {
        super(id, title, countOfPages, price, date, number);
        this.type = type;
    }

    public Magazine(String title, Long countOfPages, BigDecimal price, Date date, Long number, String type) {
        super(title, countOfPages, price, date, number);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + getTitle() + '\'' +
                ", data=" + getData() +
                ", countOfPages=" + getCountOfPages() +
                ", price=" + getPrice() +
                ", id=" + getId() +
                "type='" + type + '\'' +
                "}\n";
    }
}
