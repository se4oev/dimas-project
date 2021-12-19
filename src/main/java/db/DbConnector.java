package db;

public class DbConnector {

    private String login;
    private String password;
    private String DB_URL = "jdbc:postgresql://127.0.0.1:5432/base";


    public DbConnector(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean openConnection() {

        return true;
    }
}
