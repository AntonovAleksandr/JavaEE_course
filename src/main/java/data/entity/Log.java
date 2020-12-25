package data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.sql.Date;

@Data
@AllArgsConstructor
public class Log {
    private List<Publication> basket = new ArrayList<>();
    private Date date;
    private Long id;
    private boolean IsAdd;

    public Log(List<Publication> basket, Date date) {
        this.basket = basket;
        this.date = date;
    }
    public Log(List<Publication> basket) {
        this.basket = basket;
        this.date =Date.valueOf(LocalDate.now());
    }

    public Log() {
        this.basket = new ArrayList<>();
    }

    public Log(long log_id, Date date, boolean is_add) {
        this.id = id;
        this.date = date;
    }

    public void addPublication(Publication publication) {
        basket.add(publication);
    }

    public void removePublication(Publication publication) {
        basket.remove(publication);
    }


}
