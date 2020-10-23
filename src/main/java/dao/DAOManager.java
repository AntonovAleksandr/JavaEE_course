package dao;

import domains.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOManager {
    private DataBase dataBase;

    public DAOManager() {
        dataBase = DataBase.getInstance();
    }
    
    public void writeNewLog(List<Publication> basket){
        dataBase.insertIntoLogs(new Log(basket, new Date()));
    }

    public void createBase() {
        dataBase.insertPublicationFromStorage(new Book("1984", 450, "house", "George Orwell", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Book("Harry Potter and the Philosophers Stone", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Book("Harry Potter and the Chamber of Secrets", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Book("Harry Potter and the Goblet of Fire", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Book("Harry Potter and the Deathly Hallows", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));

        dataBase.insertPublicationFromStorage(new Magazine("", 250, 1, "", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Magazine("", 250, 1, "", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Magazine("", 250, 1, "", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Magazine("", 250, 1, "", BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Magazine("", 250, 1, "", BigDecimal.valueOf(700)));

        dataBase.insertPublicationFromStorage(new Newspaper("", 250, 1, BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Newspaper("", 250, 1, BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Newspaper("", 250, 1, BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Newspaper("", 250, 1, BigDecimal.valueOf(700)));
        dataBase.insertPublicationFromStorage(new Newspaper("", 250, 1, BigDecimal.valueOf(700)));

        dataBase.insertIntoBasket(new Book("Harry Potter and the Chamber of Secrets", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));
        dataBase.insertIntoBasket(new Book("Harry Potter and the Goblet of Fire", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));
        dataBase.insertIntoBasket(new Book("Harry Potter and the Deathly Hallows", 450, "Mahaon", "J. K. Rowling", BigDecimal.valueOf(700)));

        dataBase.insertIntoLogs(new Log());

    }

    public void insertProcurement(Publication publication, Integer count){
        for (int i = 0; i < count; i++) {
            dataBase.insertPublicationFromStorage(publication);
        }
    }

    public void getBuy(){
        dataBase.insertIntoLogs(new Log(dataBase.getBasket()));
        dataBase.clearBasket();
    }

    public List<Publication> getStorage(){
        return dataBase.getStorage();
    }

    public List<Publication> getBasket(){
        return new ArrayList<>(dataBase.getBasket());
    }

    public List<Log> getLogs(){
        return dataBase.getLogs();
    }

    public List<Log> getLogs(Date date){
        return dataBase.getLogs();
    }

}
