package data.dao;

import data.entity.*;
import lombok.SneakyThrows;

import java.rmi.server.LogStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosgreSQLConnector implements DataBaseable {

    private Connection connection;
    private Statement statement;

    public PosgreSQLConnector(String url) throws SQLException {
        System.out.println("Testing connection to SQLite JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("SQLite JDBC successfully connected");

        try {
            connection = DriverManager.getConnection(url, "aleksandr", "2924");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
            statement = connection.createStatement();
            connection.setAutoCommit(true);
        }
    }

    private ResultSet executeQuery(String sql) {
        return executeQuery(sql, false);
    }

    @SneakyThrows
    private ResultSet executeQuery(String sql, boolean needResult) {
        ResultSet resultSet = null;
        try {
            if (needResult) {
                resultSet = statement.executeQuery(sql);
            } else
                statement.executeUpdate(sql);
        } catch (SQLException e) {
            if (e.getErrorCode() != 0) {
                e.printStackTrace();
                return null;
            }
            return resultSet;
        }
        return resultSet;
    }

    @Override
    public void insertBook(Book book) {
        executeQuery(String.format("INSERT INTO 'books' (title, pages, price, date1, author, publishing_house) VALUES ('%s', %d, %d,'%s','%s','%s')",
                book.getTitle(), book.getCountOfPages(), book.getPrice(), book.getData(), book.getAuthor(), book.getPublishingHouse()));
    }

    @Override
    public void insertMagazine(Magazine magazine) {
        executeQuery(String.format("INSERT INTO 'magazines' (title, pages, price, date1, number, type) VALUES ('%s', %d, %d,'%s',%d,'%s')",
                magazine.getTitle(), magazine.getCountOfPages(), magazine.getPrice(), magazine.getData(), magazine.getNumber(), magazine.getType()));
    }

    @Override
    public void insertNewspapers(Newspaper newspaper) {
        executeQuery(String.format("INSERT INTO 'newspapers' (title, pages, price, date1, number) VALUES ('%s', %d, %d,'%s',%d)",
                newspaper.getTitle(), newspaper.getCountOfPages(), newspaper.getPrice(), newspaper.getData(), newspaper.getNumber()));
    }

    @Override
    public void insertIntoLogs(Log log) {
        executeQuery(String.format("INSERT INTO 'logs_date' (log_date1, is_add) VALUES ('%s', %b)",
                log.getDate(), log.isIsAdd()));
    }

    @Override
    public void insertLogs(Long log_id, long publication_id, String type) {
        executeQuery(String.format("INSERT INTO 'logs' (publication_id, type_of_publication, log_id) VALUES ( %d,'%s', %d)",
                publication_id, type, log_id));
    }


    @SneakyThrows
    @Override
    public List<Book> selectBooks() {
        ResultSet resSet = executeQuery("SELECT * FROM books;", true);
        List<Book> boks = new ArrayList<>();
        if (resSet != null) {
            while (resSet.next()) {
                Book book = new Book(resSet.getLong("id"),
                        resSet.getString("title"),
                        resSet.getLong("pages"),
                        resSet.getBigDecimal("price"),
                        resSet.getDate("date1"),
                        resSet.getString("author"),
                        resSet.getString("publishing_house"));
                boks.add(book);
            }
        }
        return boks;
    }

    @SneakyThrows
    @Override
    public List<Magazine> selectMagazines() {
        ResultSet resSet = executeQuery("SELECT * FROM magazines;", true);
        List<Magazine> magazines = new ArrayList<>();
        if (resSet != null) {
            while (resSet.next()) {
                Magazine magazine = new Magazine(resSet.getLong("id"),
                        resSet.getString("title"),
                        resSet.getLong("pages"),
                        resSet.getBigDecimal("price"),
                        resSet.getDate("date1"),
                        resSet.getLong("number"),
                        resSet.getString("type"));
                magazines.add(magazine);
            }
        }
        return magazines;
    }


    @SneakyThrows
    @Override
    public List<Newspaper> selectNewspapers() {
        ResultSet resSet = executeQuery("SELECT * FROM newspapers;", true);
        List<Newspaper> magazines = new ArrayList<>();
        if (resSet != null) {
            while (resSet.next()) {
                Newspaper newspaper = new Newspaper(resSet.getLong("id"),
                        resSet.getString("title"),
                        resSet.getLong("pages"),
                        resSet.getBigDecimal("price"),
                        resSet.getDate("date1"),
                        resSet.getLong("number"));
                magazines.add(newspaper);
            }
        }
        return magazines;
    }


    @SneakyThrows
    @Override
    public Book selectBookById(Long id) {
        ResultSet publicationsSet = executeQuery(String.format("SELECT * FROM books where id = %d;", id), true);

        Book book = null;
        if (publicationsSet != null) {
            book = new Book(publicationsSet.getLong("id"),
                    publicationsSet.getString("title"),
                    publicationsSet.getLong("pages"),
                    publicationsSet.getBigDecimal("price"),
                    publicationsSet.getDate("date1"),
                    publicationsSet.getString("author"),
                    publicationsSet.getString("publishing_house"));
        }
        return book;
    }

    @SneakyThrows
    @Override
    public Magazine selectMagazineById(Long id) {
        ResultSet publicationsSet = executeQuery(String.format("SELECT * FROM magazines where id = %d;", id), true);

        Magazine magazine = null;
        if (publicationsSet != null) {
            magazine = new Magazine(publicationsSet.getLong("id"),
                    publicationsSet.getString("title"),
                    publicationsSet.getLong("pages"),
                    publicationsSet.getBigDecimal("price"),
                    publicationsSet.getDate("date1"),
                    publicationsSet.getLong("number"),
                    publicationsSet.getString("type"));
        }
        return  magazine;
    }

    @SneakyThrows
    @Override
    public Newspaper selectNewspaperById(Long id) {
        ResultSet  publicationsSet = executeQuery(String.format("SELECT * FROM newspapers where id = %d;", id), true);
        Newspaper newspaper = null;
        if (publicationsSet != null) {
            newspaper = new Newspaper(publicationsSet.getLong("id"),
                    publicationsSet.getString("title"),
                    publicationsSet.getLong("pages"),
                    publicationsSet.getBigDecimal("price"),
                    publicationsSet.getDate("date1"),
                    publicationsSet.getLong("number"));
        }
        return newspaper;
    }

    @SneakyThrows
    @Override
    public List<Log> selectLogs() {
        ResultSet resSet = executeQuery("SELECT * FROM logs_data;", true);
        List<Log> logs = new ArrayList<>();
        Map<Long, String> logs_data = new HashMap<>();

        if (resSet != null) {
            while (resSet.next()) {
                logs.add(new Log(resSet.getLong("id"), resSet.getDate("date1"), resSet.getBoolean("is_add")));
            }
        }

        resSet = executeQuery("SELECT * FROM logs;", true);
        if (resSet != null) {
            ResultSet publicationsSet;
            while (resSet.next()) {
                for (var log : logs) {
                    if (log.getId() == resSet.getLong("log_id")) {
                        String type = resSet.getString("type_of_publication");
                        switch (type) {
                            case "book":
                                log.addPublication(selectBookById(resSet.getLong("publication_id")));
                                break;
                            case "magazine":
                                log.addPublication(selectMagazineById(resSet.getLong("publication_id")));
                                break;
                            case "newspaper":
                                log.addPublication(selectNewspaperById(resSet.getLong("publication_id")));
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + type);
                        }

                    }
                }
            }
        }
        return  logs;
    }

    @Override
    public void deleteBook(Book book) {
        executeQuery("DELETE from 'books' WHERE id = " + book.getId());
    }
    @Override
    public void deleteNewspaper(Newspaper newspaper) {
        executeQuery("DELETE from 'books' WHERE id = " + newspaper.getId());
    }
    @Override
    public void deleteMagazine(Magazine magazine) {
        executeQuery("DELETE from 'books' WHERE id = " + magazine.getId());
    }

    @Override
    public void deleteBookById(Long id) {
        executeQuery("DELETE from 'books' WHERE id = " + id);
    }
    @Override
    public void deleteNewspaperById(Long id) {
        executeQuery("DELETE from 'books' WHERE id = " + id);
    }
    @Override
    public void deleteMagazineById(Long id) {
        executeQuery("DELETE from 'books' WHERE id = " + id);
    }

    @Override
    public void updateBook(Long id, Book book) {
        executeQuery(String.format("UPDATE 'books' SET title = '%s', price = %d, groupId = %d, pages = %d, publishing house = '%s', author = '%s', date1 = '%s' WHERE id = %d",
                book.getTitle(), book.getPrice(), book.getCountOfPages(),
                book.getPublishingHouse(), book.getAuthor(), book.getData(), id ));
    }

    @Override
    public void updateNewspaper(Long id, Newspaper newspaper) {
        executeQuery(String.format("UPDATE 'newspapers' SET title = '%s', price = %d, groupId = %d, pages = %d, publishing house = %d, date1 = '%s' WHERE id = %d",
                newspaper.getTitle(), newspaper.getPrice(), newspaper.getCountOfPages(),
                newspaper.getNumber(),  newspaper.getData(), id ));
    }

    @Override
    public void updateMagazine(Long id, Magazine magazine) {
        executeQuery(String.format("UPDATE 'magazines' SET title = '%s', price = %d, groupId = %d, pages = %d, number house = '%s', magazine_type = '%s', date1 = '%s' WHERE id = %d",
                magazine.getTitle(), magazine.getPrice(), magazine.getCountOfPages(),
                magazine.getNumber(), magazine.getType(), magazine.getData(), id ));
    }

}
