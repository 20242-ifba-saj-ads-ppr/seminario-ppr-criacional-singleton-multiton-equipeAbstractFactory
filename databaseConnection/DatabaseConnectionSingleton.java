public class DatabaseConnectionSingleton {
  private static  DatabaseConnectionSingleton instance = null;
  private String connectionString;

  private DatabaseConnectionSingleton(){
    connectionString = "jdbc:mysql://localhost:3306/mydatabase";
  }

  public static DatabaseConnectionSingleton getInstance(){
    if(instance == null){
      instance = new DatabaseConnectionSingleton();
    }
    return instance;
  }
  
  public String getConnectionString(){
    return connectionString;
  }
}