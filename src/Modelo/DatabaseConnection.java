
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Singleton
//Esta clase asegura que solo exista una única instancia de la conexión a la base de datos en toda la aplicación
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private static final String URL = "jdbc:sqlserver://GIANCARLO-LAPTO\\SQLEXPRESS:1433;databaseName=HuellaDeCarbono;integratedSecurity=true;encrypt=false";

    
    // Constructor privado para evitar instanciación externa
    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos.");
        }
    }

    // Método para obtener la única instancia de la clase
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}