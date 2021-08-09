package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/finalmodule3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "dung1998";
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
