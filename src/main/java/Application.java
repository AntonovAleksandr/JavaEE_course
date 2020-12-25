import data.dao.DAOManager;
import data.dao.PosgreSQLConnector;
import ui.ConsoleManager;

import java.sql.SQLException;

public class Application {
    private final ConsoleManager manager;

    public Application() throws SQLException {
        PosgreSQLConnector posgreSQLConnector = new PosgreSQLConnector("jdbc:postgresql://localhost:5432/JavaProject");
        this.manager = new ConsoleManager(posgreSQLConnector);
    }

    public void run(){
        manager.start();

    }
}