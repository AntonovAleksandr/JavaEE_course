package interfaces;

import domains.Publication;
import domains.Log;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Date;

public interface DBServise {
    void insertFromLog(Log log);

    void insertFromStorage(Publication publication, Integer count);

    void insertFromeBasket(Publication publication, Integer count);

    void updateFromStorage(Publication publication, Integer count);

    BigDecimal calculateTheIncome(Date date);

    void removeFromeBasket(Publication publication, Integer count);

    List<Log> selectRecordsFromLog();

    List<Log> selectRecordsFromLog(Date date);

    Map<Publication, Integer> selectPublicationsFromStorage();

    Map<Publication, Integer> selectBooksFromStorage();

    Map<Publication, Integer> selectMagazinesFromStorage();

    Map<Publication, Integer> selectNewspapersFromStorage();

    Map<Publication, Integer> selectPublicationsFromStorageWhere(String author);

    Map<Publication, Integer> selectPublicationsFromStorage(String title);

    void removeFromeStorage(Publication key, Integer value);

    BigDecimal calculateTheIncome();
}
