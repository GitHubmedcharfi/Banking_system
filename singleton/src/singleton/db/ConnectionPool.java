package singleton.db;

import java.util.*;

public class ConnectionPool {
    private Queue<Connection> available = new LinkedList<>();
    private Set<Connection> inUse = new HashSet<>();

    public ConnectionPool(int size) {
        initPool(size);
    }

    private void initPool(int size) {
        for (int i = 0; i < size; i++) {
            available.add(new Connection());
        }
    }

    public synchronized Connection get() {
        if (available.isEmpty()) {
            System.out.println("No connections available!");
            return null;
        }
        Connection conn = available.poll();
        inUse.add(conn);
        return conn;
    }

    public synchronized void release(Connection conn) {
        if (inUse.remove(conn)) {
            available.offer(conn);
        }
    }

    public void closeAll() {
        for (Connection conn : available) conn.close();
        for (Connection conn : inUse) conn.close();
        System.out.println("All connections closed!");
    }
}
