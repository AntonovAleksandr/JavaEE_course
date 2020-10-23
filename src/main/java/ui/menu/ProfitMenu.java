package ui.menu;

import dao.DAOManager;

import java.util.Scanner;

public class ProfitMenu extends Menu {
    private Scanner scanner;
    private DAOManager daoManager;

    public ProfitMenu(Scanner scanner, DAOManager daoManager) {
        this.scanner = scanner;
        this.daoManager = daoManager;
    }

    @Override
    public void ran() {

    }
}
