package data.dao;

import data.entity.*;
import lombok.SneakyThrows;

import java.util.*;

public interface DataBaseable {
    void insertBook(Book book);

    void insertMagazine(Magazine magazine);

    void insertNewspapers(Newspaper magazine);

    public void insertIntoLogs(Log log);

    void insertLogs(Long log_id, long publication_id, String type);

    @SneakyThrows
    List<Book> selectBooks();

    @SneakyThrows
    List<Magazine> selectMagazines();

    @SneakyThrows
    List<Newspaper> selectNewspapers();

    @SneakyThrows
    Book selectBookById(Long id);

    @SneakyThrows
    Magazine selectMagazineById(Long id);

    @SneakyThrows
    Newspaper selectNewspaperById(Long id);

    @SneakyThrows
    List<Log> selectLogs();

    void deleteBook(Book book);

    void deleteNewspaper(Newspaper newspaper);

    void deleteMagazine(Magazine magazine);

    void deleteBookById(Long id);

    void deleteNewspaperById(Long id);

    void deleteMagazineById(Long id);

    void updateBook(Long id, Book book);

    void updateNewspaper(Long id, Newspaper book);

    void updateMagazine(Long id, Magazine book);
}

