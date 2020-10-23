package ui.menu;

import dao.DAOManager;

import java.util.Scanner;

public class MainMenu extends Menu {

    private Scanner scanner;
    private DAOManager daoManager;

    public MainMenu(Scanner scanner, DAOManager daoManager) {
        this.scanner = scanner;
        this.daoManager = daoManager;
    }

    @Override
    public void ran() {

    }
}
