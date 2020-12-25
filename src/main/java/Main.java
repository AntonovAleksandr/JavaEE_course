import data.dao.PosgreSQLConnector;
import data.entity.Newspaper;
import ui.ConsoleManager;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Application application= new Application();
        application.run();

    }
}
