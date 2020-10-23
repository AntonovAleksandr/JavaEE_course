package domains;

import java.math.BigDecimal;
import java.util.Date;

public class Newspaper extends Publication {
    private int number;

    public Newspaper(String title, int countOfPages, int number, BigDecimal price) {
        this.number = number;
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setTitle(title);
        this.setData(new Date());
    }

    public Newspaper(String title, int countOfPages, int number, BigDecimal price, Date data) {
        this(title, countOfPages, number, price);
        this.setData(data);
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
