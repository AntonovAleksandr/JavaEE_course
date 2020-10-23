package domains;

import java.math.BigDecimal;
import java.util.Date;


public abstract class Publication {

    private String title;
    private Date data;
    private int countOfPages;
    private BigDecimal price;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public Date getData() {
        return data;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
