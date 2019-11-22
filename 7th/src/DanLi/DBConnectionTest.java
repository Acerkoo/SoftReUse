package DanLi;

class DBConnection {
    private static DBConnection connection = null;

    private DBConnection() {}
    public static DBConnection getConnection() {
        if(connection == null) connection = new DBConnection();
        return connection;
    }
}

public class DBConnectionTest {
    public static void main(String []argc) {
        DBConnection dbConnection = DBConnection.getConnection();

    }
}
