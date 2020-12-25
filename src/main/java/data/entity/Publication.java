package data.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public abstract class Publication {

    private String title;
    private Date data;
    private Long countOfPages;
    private BigDecimal price;
    private Long id;

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", data=" + data +
                ", countOfPages=" + countOfPages +
                ", price=" + price +
                ", id=" + id +
                "}\n";
    }
}
