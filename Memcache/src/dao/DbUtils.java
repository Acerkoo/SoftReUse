package dao;

import java.sql.*;


public class DbUtils {

    private static DbUtils dbUtils = new DbUtils();

    private static final String url = "jdbc:mysql://localhost:3306/szk?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8";
    private static final String username = "root";
    private static final String password = "root";

    private DbUtils() {}

    public static DbUtils getDbUtils() {
        return dbUtils;
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection) {
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt) {
        try{
            if(stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}