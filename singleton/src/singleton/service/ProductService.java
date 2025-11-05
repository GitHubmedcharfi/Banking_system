package singleton.service;

import singleton.db.Connection;
import singleton.db.DatabaseConnectionManager;

public class ProductService {
    public void getAllProducts() {
        Connection conn = DatabaseConnectionManager.getInstance().getConnection();
        if (conn != null) {
            System.out.println(conn.execute("SELECT * FROM products"));
            DatabaseConnectionManager.getInstance().releaseConnection(conn);
        }
    }
}