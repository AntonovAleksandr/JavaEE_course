package ui.menu;

import dao.DAOManager;

import java.util.Scanner;

public class SearchMenu extends Menu {
    private Scanner scanner;
    private DAOManager daoManager;
    @Override
    public void ran() {

    }

    public SearchMenu(Scanner scanner, DAOManager daoManager) {
        this.scanner = scanner;
        this.daoManager = daoManager;
    }
}
