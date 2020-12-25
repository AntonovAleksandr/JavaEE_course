package data.dao;

import data.entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAOManager {
    private final PosgreSQLConnector posgreSQLConnector;

    public DAOManager(PosgreSQLConnector posgreSQLConnector) {
        this.posgreSQLConnector = posgreSQLConnector;
    }

    public void insertPublication(Publication publication) {
        if (publication.getClass() == Book.class)
            posgreSQLConnector.insertBook((Book) publication);
        if (publication.getClass() == Newspaper.class)
            posgreSQLConnector.insertNewspapers((Newspaper) publication);
        if (publication.getClass() == Magazine.class)
            posgreSQLConnector.insertMagazine((Magazine) publication);
    }


    public List<Publication> getAllPublications() {
        List<Publication> publication = new ArrayList<>();
        publication.addAll(posgreSQLConnector.selectBooks());
        publication.addAll(posgreSQLConnector.selectMagazines());
        publication.addAll(posgreSQLConnector.selectNewspapers());
        return publication;
    }

    public List<Log> getLogs() {
        return posgreSQLConnector.selectLogs();
    }

    public Publication buyBId(long id, String type) {
        Publication result = null;
        switch (type) {
            case "book":
                result = posgreSQLConnector.selectBookById(id);
                posgreSQLConnector.deleteBook((Book) result);
                break;
            case "magazine":
                result = posgreSQLConnector.selectMagazineById(id);
                posgreSQLConnector.deleteMagazine((Magazine) result);
                break;
            case "newspaper":
                result = posgreSQLConnector.selectNewspaperById(id);
                posgreSQLConnector.deleteNewspaper((Newspaper) result);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return result;
    }

    public List<Magazine> getAllMagazines() {
        return posgreSQLConnector.selectMagazines();
    }

    public List<Newspaper> getAllNewspapers() {
        return posgreSQLConnector.selectNewspapers();
    }

    public List<Book> getAllBooks() {
        return posgreSQLConnector.selectBooks();
    }

    public void deleteBId(Long id, String type) {
        Publication result = null;
        switch (type) {
            case "book":
                posgreSQLConnector.deleteBookById(id);
                break;
            case "magazine":
                posgreSQLConnector.deleteMagazineById(id);
                break;
            case "newspaper":
                posgreSQLConnector.deleteNewspaperById(id);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    public void update(Publication publication, Long id) {
        if (publication.getClass() == Book.class)
            posgreSQLConnector.updateBook(id, (Book) publication);
        if (publication.getClass() == Newspaper.class)
            posgreSQLConnector.updateNewspaper(id, (Newspaper) publication);
        if (publication.getClass() == Magazine.class)
            posgreSQLConnector.updateMagazine(id, (Magazine) publication);
    }
}

