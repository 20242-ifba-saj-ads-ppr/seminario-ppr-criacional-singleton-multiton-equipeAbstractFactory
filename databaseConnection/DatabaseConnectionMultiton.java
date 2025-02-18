import java.util.HashMap;
import java.util.Map;

public class DatabaseConnectionMultiton {
  private static final Map<String, DatabaseConnectionMultiton> instances = new HashMap<>();
    private String connectionInfo;

    private DatabaseConnectionMultiton(String dbName) {
        this.connectionInfo = "Conectado ao banco de dados: " + dbName;
    }

    public static  DatabaseConnectionMultiton getInstance(String dbName) {
        return instances.computeIfAbsent(dbName, DatabaseConnectionMultiton::new);
    }

    public static void addInstance(String dbName) {
        instances.putIfAbsent(dbName, new DatabaseConnectionMultiton(dbName));
    }

    public static DatabaseConnectionMultiton getInstanceOrAdd(String dbName) {
        return instances.computeIfAbsent(dbName, DatabaseConnectionMultiton::new);
    }

    public static int getInstanceCount() {
        return instances.size();
    }

    public String getConnectionInfo() {
        return connectionInfo;
    }


}
