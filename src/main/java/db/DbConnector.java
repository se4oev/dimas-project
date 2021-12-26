package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private String login;
    private String password;
    private String DB_URL = "jdbc:postgresql://127.0.0.1:5432/base";


    public DbConnector(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean checkConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return false;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, login, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return false;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
            return true;
        } else {
            System.out.println("Failed to make connection to database");
            return false;
        }
    }
}
