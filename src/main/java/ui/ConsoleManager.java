package ui;

import dao.DAOManager;
import domains.*;
import domains.Log;
import ui.menu.*;

import java.math.BigDecimal;
import java.util.*;

public class ConsoleManager {
    private Scanner scanner = new Scanner(System.in);
    private DAOManager daoManager = new DAOManager();
    private Menu menu;

    public void start() {
        while (true) {
            chooseMenu();
        }
    }

    int showInterface() {
        System.out.println("\nWelcome to our newsagent, сhoose one of the actions:" +
                "\n1 - Show product catalog | 2 - Show purchase history | 3 - Take procurement" +
                "\n4 - Dispose products     | 5 - Show profit           | 6 - Search of publication" +
                "                             7 - Exit");
        return scanner.nextInt();
    }


    private void chooseMenu() {
        switch (showInterface()) {
            case 1:
                menu = new CatalogMenu(scanner, daoManager);
                break;
            case 2:
                menu = new HistoryMenu(scanner, daoManager);
                break;
            case 3:
                menu = new ProcurementMenu(scanner, daoManager);
                break;
            case 4:
                menu = new DisposePublicationMenu(scanner, daoManager);
            case 5:
                menu = new ProcurementMenu(scanner, daoManager);
                break;
            case 6:
                menu = new SearchMenu(scanner, daoManager);
            case 7:
                return;

        }
        menu.ran();
    }

    private void subMenuSearchInterface() {
        switch (subMenuSearchPublication()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
        }

    }

//    private void subMenuProductInterface() {
//        switch (subMenuProfit()) {
//            case 1:
//                System.out.println(DAOManager.checkBoxOffice());
//                break;
//            case 2:
//                System.out.println(DAOManager.checkBoxOffice(inputTheDate()));
//                break;
//            case 3:
//                return;
//        }
//    }


//    private void subMenuInterface() {
//        switch (subMenuProductCatalog()) {
//            case 1:
//                System.out.println(stringValue(DAOManager.getPublications()));
//                break;
//            case 2:
//                System.out.println(stringValue(DAOManager.getNewspapers()));
//                break;
//            case 3:
//                System.out.println(stringValue(DAOManager.getBooks()));
//                break;
//            case 4:
//                System.out.println(stringValue(DAOManager.getNewspapers()));
//                break;
//            case 5:
//                return;
//        }
//


    int subMenuSearchPublication() {
        System.out.println("\n1 - Search by author | 2 - Search by title | 3 - Search by publication house" +
                "\n4 - Search by date   | 5 - combined search | 6 - Return");
        return scanner.nextInt();
    }


    int subMenuPurchaseHistory() {
        System.out.println("\n1 - Show all history | 2 - Show history on date | 3 - Return");
        return scanner.nextInt();
    }


    int subMenuGetPublications() {
        System.out.println("\n1 - Get new book  | 2 -  get new bagazine" +
                "\n3 - bewspaper     | 4 - Return");
        return scanner.nextInt();
    }

//    void getPublicationsInterface() {
//        boolean flag = true;
//        Publication newPublication;
//        while (flag) {
//            newPublication = inputPublication();
//            System.out.println("Enter count of publications: ");
//            DAOManager.takeProcurement(newPublication, scanner.nextInt());
//            System.out.println("Choose action 1 - add another publication 2 - enough");
//            if (scanner.nextInt() == 2) {
//                flag = false;
//            }
//        }
//    }


//    int subMenuDisposeProducts() {
//
//    }

    int subMenuProfit() {
        System.out.println("\n1 - Calculate all profit | 2 - Calculate profit in date | 3 - Return");
        return scanner.nextInt();

    }

    StringBuilder stringValue(Map<Publication, Integer> map) {
        Publication publication;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Publication, Integer> element :
                map.entrySet()) {
            publication = element.getKey();
            result.append("Title: ").append(publication.getTitle()).append(", count of pages: ").append(publication.getCountOfPages()).append(", date: ").append(publication.getData().toString()).append(", price: ").append(publication.getPrice().toString());
            if (publication.getClass() == Book.class) {
                result.append(", author: ").append(((Book) publication).getAuthor()).append(", publishing house: ").append(((Book) publication).getPublishingHouse());
            }
            if (publication.getClass() == Magazine.class) {
                result.append(", number of magazine: ").append(((Magazine) publication).getNumber()).append(((Magazine) publication).getType());
            }
            if (publication.getClass() == Newspaper.class) {
                result.append(", number of newspaper: ").append(((Newspaper) publication).getNumber());
            }
            result.append("| count:  ").append(element.getValue().toString());
            result.append("\n");
        }
        return result;
    }

//    void showLog(List<Log> log) {
//        log.forEach((record) -> System.out.println("Date: " + record.getDate().toString() + "\n basket:\n" + stringValue(record.getBasket()).toString() + "\n      price : " + record.getPrice().toString()));
//    }

//    void showLogOnDate() {
//        showLog(DAOManager.getLog(inputTheDate()));
//    }

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
        return calendar.getTime();
    }

    Publication inputPublication() {
        System.out.println("Choose type of publication: 1 - Book, 2 - Magazine, 3 - Newspaper");
        int type = scanner.nextInt();
        System.out.println("Enter title of publication: ");
        String title = scanner.next();
        System.out.println("Enter count of pages: ");
        int countOfPages = scanner.nextInt();
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


    Magazine inputMagazine(String title, int countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter number of magazine: ");
        int number = scanner.nextInt();
        System.out.println("Enter type of magazine: ");
        String type = scanner.next();
        return new Magazine(title, countOfPages, number, type, price, date);
    }

    Book inputBook(String title, int countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter publication house: ");
        String publicationHouse = scanner.next();
        System.out.println("Enter author of book: ");
        String author = scanner.next();

        return new Book(title, countOfPages, publicationHouse, author, price, date);
    }

    Newspaper inputNewspaper(String title, int countOfPages, Date date, BigDecimal price) {
        System.out.println("Enter number of newspaper: ");
        int number = scanner.nextInt();
        return new Newspaper(title, countOfPages, number, price, date);
    }


}
