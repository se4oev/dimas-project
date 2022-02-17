package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance;
    private Connection connection;
    private final String login;
    private final String password;
    private final String url;
    private static final String DB_BASE_URL = "jdbc:postgresql://";

    private ConnectionManager (String path, String login, String password){
        this.url = DB_BASE_URL + path;
        this.login = login;
        this.password = password;
    }

    public static ConnectionManager getInstance(){
       if (instance == null){
           throw new AssertionError("ConnectionManager is not initialized");
       }
       return instance;
    }

    public synchronized static ConnectionManager init(String path, String login, String password){
        if(instance != null){
            throw new AssertionError("ConnectionManager is already initialized");
        }
        instance = new ConnectionManager(path, login, password);
        return instance;
    }

    public void initConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }

    public boolean isAlive(){
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
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
