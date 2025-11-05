package singleton.service;

import singleton.db.Connection;
import singleton.db.DatabaseConnectionManager;

public class UserService {
    public void getUserProfile() {
        Connection conn = DatabaseConnectionManager.getInstance().getConnection();
        if (conn != null) {
            System.out.println(conn.execute("SELECT * FROM users WHERE id=1"));
            DatabaseConnectionManager.getInstance().releaseConnection(conn);
        }
    }
}
