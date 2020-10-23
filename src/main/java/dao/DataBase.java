package dao;

import domains.*;

import java.math.BigDecimal;
import java.util.*;

public class DataBase {
    private static DataBase instance;
    private List<Log> logs;
    private List<Publication> storage;
    private List<Publication> basket;
    
    private DataBase(){
        logs = new ArrayList<>();
        storage = new ArrayList<>();
        basket = new ArrayList<>();
    }

    static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }
    
    public void insertPublicationFromStorage(Publication publication){
        storage.add(publication);
    }
    
    public void insertIntoLogs(Log log){
        logs.add(log);
    }

    public List<Publication> getBasket(){
        return basket;
    }
    
    public void insertIntoBasket(Publication publication){
        basket.add(publication);
    }

    public void clearBasket(){
        basket.clear();
    }

    public List<Publication> getStorage(){
        return new ArrayList<>(storage);
    }

    public List<Log> getLogs(){
        return new ArrayList<>(logs);
    }
    public List<Log> getLogs(Date date){
        return new ArrayList<>(logs);
    }

}

