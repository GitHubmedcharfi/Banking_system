package singleton.db;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private final ConnectionPool pool;

    private DatabaseConnectionManager() {
        pool = new ConnectionPool(5);
    }

    public static synchronized DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return pool.get();
    }

    public void releaseConnection(Connection c) {
        pool.release(c);
    }

    public void shutdown() {
        pool.closeAll();
    }
}

