package ui;

import data.dao.DAOManager;
import data.dao.PosgreSQLConnector;
import data.entity.*;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Date;

public class ConsoleManager {
    private Scanner scanner = new Scanner(System.in);
    protected final DAOManager daoManager;

    public ConsoleManager(PosgreSQLConnector posgreSQLConnector) {
        this.daoManager = new DAOManager(posgreSQLConnector);
    }


    int showInterface() {
        System.out.println("\nWelcome to our newsagent, сhoose one of the actions:" +
                "\n1 - Show product catalog | 2 - By product     | 3 - Delete product" +
                "\n4 - Add products         | 5 - Update product");
        return scanner.nextInt();
    }

    private void chooseСatalogAction() {
        System.out.println("\n1 - Show all products  | 2 - Show all books" +
                "\n3 - Show all newspapers | 4 - Show all magazines" +
                "\n5 - Return              | 6 - Exit");
        int action = scanner.nextInt();
        String result = "";
        switch (action) {
            case 1:
                for (var publication : daoManager.getAllPublications()) {
                    result += publication.toString();
                }
                break;
            case 2:
                for (var publication : daoManager.getAllBooks()) {
                    result += publication.toString();
                }
                break;
            case 3:
                for (var publication : daoManager.getAllNewspapers()) {
                    result += publication.toString();
                }
                break;
            case 4:
                for (var publication : daoManager.getAllMagazines()) {
                    result += publication.toString();
                }
                break;
        }
        System.out.println(result);
    }

    private void buyPublicationAction() {
        List<Publication> basket = new ArrayList<>();
        System.out.println("\n1 - Book | 2 - Magazine | 3 - Newspaper");
        int action = scanner.nextInt();
        String type;
        System.out.println("Publication id: ");
        long id = scanner.nextLong();

        switch (action) {
            case 1:
                type = "book";
                basket.add(daoManager.buyBId(id, type));
                break;
            case 2:
                type = "magazine";
                basket.add(daoManager.buyBId(id, type));
                break;
            case 3:
                type = "newspaper";
                basket.add(daoManager.buyBId(id, type));
                break;
        }
        for (var publication : basket) {
            System.out.println(publication.toString());
        }
    }

    private void deletePublicationAction() {
        List<Publication> basket = new ArrayList<>();
        System.out.println("\n1 - Book | 2 - Magazine | 3 - Newspaper");
        int action = scanner.nextInt();
        String type;
        System.out.println("Publication id: ");
        Long id = scanner.nextLong();

        switch (action) {
            case 1:
                type = "book";
                daoManager.deleteBId(id, type);
                break;
            case 2:
                type = "magazine";
                daoManager.deleteBId(id, type);
                break;
            case 3:
                type = "newspaper";
                daoManager.deleteBId(id, type);
                break;
        }
    }


    public void start() {
        while (true) {
            switch (showInterface()) {
                case 1:
                    chooseСatalogAction();
                    break;
                case 2:
                    buyPublicationAction();
                    break;
                case 3:
                    deletePublicationAction();
                    break;
                case 4:
                    addPublicationAction();
                case 5:
                    updatePublicationAction();
                    break;
                case 6:
                    return;
            }

        }
    }

    private void addPublicationAction() {
        Publication publication = inputPublication();
        daoManager.insertPublication(publication);
    }

    private void updatePublicationAction() {
        Publication publication = inputPublication();
        System.out.println("Publication id: ");
        Long id = scanner.nextLong();
        daoManager.update(publication, id);
    }


    Date inputTheDate() {
        Calendar calendar = new GregorianCalendar();
        System.out.println("Enter numbers of year: ");
        int year = scanner.nextInt();
        System.out.println("Enter numbers of month: ");
        int month = scanner.nextInt();
        System.out.println("Enter numbers of day: ");
        int day = scanner.nextInt();
        System.out.println("Enter numbers of hour: ");
        int hour = scanner.nextInt();
        System.out.println("Enter numbers of minute: ");
        int minute = scanner.nextInt();
        System.out.println("Enter numbers of second: ");
        int second = scanner.nextInt();
        calendar.set(year, month, day, hour, minute, second);
        return Date.valueOf(calendar.getTime().toString());
    }

    Publication inputPublication() {
        System.out.println("Choose type of publication: 1 - Book, 2 - Magazine, 3 - Newspaper");
        int type = scanner.nextInt();
        System.out.println("Enter title of publication: ");
        String title = scanner.next();
        System.out.println("Enter count of pages: ");
        Long countOfPages = scanner.nextLong();
        Date date = inputTheDate();
        System.out.println("Enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextInt());
        switch (type) {
            case 1:
                return inputBook(title, countOfPages, date, price);
            case 2:
                return inputMagazine(title, countOfPages, date, price);
            default:
                return inputNewspaper(title, countOfPages, date, price);

        }
    }


    Magazine inputMagazine(String title, Long countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter number of magazine: ");
        Long number = scanner.nextLong();
        System.out.println("Enter type of magazine: ");
        String type = scanner.next();
        return new Magazine(title, countOfPages, price, date, number, type);
    }

    Book inputBook(String title, Long countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter publication house: ");
        String publicationHouse = scanner.next();
        System.out.println("Enter author of book: ");
        String author = scanner.next();

        return new Book(title, countOfPages, price, publicationHouse, author, date);
    }

    Newspaper inputNewspaper(String title, Long countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter number of newspaper: ");
        Long number = scanner.nextLong();
        return new Newspaper(title, countOfPages, price, date, number);
    }


}
