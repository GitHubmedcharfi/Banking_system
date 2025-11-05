package singleton.db;

public class Connection {
    private boolean active = true;

    public String execute(String query) {
        if (!active) {
            return "Connection is closed, cannot execute query.";
        }
        return "Executed query: " + query;
    }

    public void close() {
        active = false;
        System.out.println("Connection closed.");
    }
}

