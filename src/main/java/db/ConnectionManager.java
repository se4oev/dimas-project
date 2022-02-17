package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection connection;
    private String login;
    private String password;
    private String url;
    private static final String DB_BASE_URL = "jdbc:postgresql://";
    private static final String DEFAULT_DB_PATH = "127.0.0.1:5432/base";

    public ConnectionManager (String path, String login, String password){
        this.url = DB_BASE_URL + path;
        this.login = login;
        this.password = password;
    }

    public ConnectionManager (String login, String password){
        this(DEFAULT_DB_PATH, login, password);
    }

    public void initConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public boolean isAlive(){
        if (connection != null) {
            System.out.println("You successfully connected to database now");
            return true;
        } else {
            System.out.println("Failed to make connection to database");
            return false;
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Нюхай бебру.");
        }
    }

}
