package domains;

import java.math.BigDecimal;
import java.util.Date;

public class Magazine extends Publication {
    private int number;
    private String type;

    public Magazine(String title, int countOfPages, int number, String type, BigDecimal price) {
        this.number = number;
        this.type = type;
        this.setCountOfPages(countOfPages);
        this.setPrice(price);
        this.setTitle(title);
        this.setData(new Date());
    }

    public Magazine(String title, int countOfPages, int number, String type, BigDecimal price, Date data) {
        this(title, countOfPages, number, type, price);
        this.setData(data);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }


}
