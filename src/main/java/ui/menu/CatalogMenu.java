package ui.menu;

import dao.DAOManager;

import java.util.Scanner;

public class CatalogMenu extends Menu {

    private Menu subMenu;
    private DAOManager daoManager;
    private Scanner scanner;

    public CatalogMenu(Scanner scanner, DAOManager daoManager) {
        this.scanner = scanner;
        this.daoManager = daoManager;
    }

    @Override
    public void ran() {
        chooseAction();
    }


    private int chooseAction() {
        System.out.println("\n1 - Show all products  | 2 - Show all books" +
                "\n3 - Show all newspaper | 4 - Show all magazines" +
                "\n5 - Return");
        return scanner.nextInt();
    }

}
