package singleton.service;

import singleton.db.Connection;
import singleton.db.DatabaseConnectionManager;

public class OrderService {
    public void createOrder() {
        Connection conn = DatabaseConnectionManager.getInstance().getConnection();
        if (conn != null) {
            System.out.println(conn.execute("INSERT INTO orders VALUES (...)"));
            DatabaseConnectionManager.getInstance().releaseConnection(conn);
        }
    }
}
