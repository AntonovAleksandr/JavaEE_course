package domains;

import java.math.BigDecimal;
import java.util.*;

public class Log {
    private List<Publication> basket = new ArrayList<>();
    private Date date;
    private BigDecimal price = BigDecimal.valueOf(0);

    public Log(List<Publication> basket, Date date) {
        this.basket = basket;
        this.date = date;
        basket.forEach(element -> price.add(element.getPrice()));
    }

    public Log(List<Publication> basket) {
        this.basket = basket;
        this.date = new Date();
        basket.forEach(element -> price.add(element.getPrice()));
    }

    public Log() {
        this.basket = new ArrayList<>();
        this.price = new BigDecimal("0");
    }

    public List<Publication> getBasket() {
        return basket;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setBasket(List<Publication> basket) {
        this.basket = basket;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void addPublication(Publication publication) {
        basket.add(publication);
        price = price.add(publication.getPrice());
    }

    public void removePublication(Publication publication) {
        basket.add(publication);
        price = price.subtract(publication.getPrice());
    }


}
