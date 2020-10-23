package ui.menu;

import dao.DAOManager;

import java.util.Scanner;

public class HistoryMenu extends Menu  {
    private Scanner scanner;
    private DAOManager daoManager;

    public HistoryMenu(Scanner scanner, DAOManager daoManager) {
        this.scanner = scanner;
        this.daoManager = daoManager;
    }

    @Override
    public void ran() {
        switch (subMenuPurchaseHistory()) {
            case 1:
                daoManager.getLogs();
                break;
            case 2:
                daoManager.getLogs();
                break;
            case 3:
                return;
        }
    }

    private int subMenuPurchaseHistory() {
        System.out.println("\n1 - Show all history | 2 - Show history on date | 3 - Return");
        return scanner.nextInt();
    }
}
