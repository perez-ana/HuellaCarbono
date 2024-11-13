package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransporteDAO {
    private Connection connection;

    public TransporteDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    // CREATE: Insertar transporte
    public void insertarTransporte(DatosTransporte datosTransporte) {
       String query = "INSERT INTO Transporte (horasTransporte, kilometrosRecorridos, medioTransporteFrecuencia, medioTransporteUso) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, datosTransporte.getHorasTransporte());
            pstmt.setDouble(2, datosTransporte.getKilometrosRecorridos());
            pstmt.setString(3, datosTransporte.getMedioTransporteFrecuencia());
            pstmt.setString(4, datosTransporte.getMedioTransporteUso());
            pstmt.executeUpdate();
            System.out.println("Transporte insertado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al insertar transporte: " + e.getMessage());
            e.printStackTrace();
        }

    }

    // READ: Leer todos los transportes
    public void leerTransportes() {
        String query = "SELECT * FROM Transporte";
         try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
             while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idTransporte"));
                System.out.println("Horas: " + rs.getInt("horasTransporte"));
                System.out.println("Kilómetros: " + rs.getDouble("kilometrosRecorridos"));
                System.out.println("Medio Frecuente: " + rs.getString("medioTransporteFrecuencia"));
                System.out.println("Medio Usado: " + rs.getString("medioTransporteUso"));
                System.out.println("------------------------------");
             }
         } catch (SQLException e) {
             System.err.println("Error al leer transportes: " + e.getMessage());
             e.printStackTrace();
         }
    }

    // UPDATE: Actualizar un transporte
    public void actualizarTransporte(int id, DatosTransporte datosTransporte) {
        String query = "UPDATE Transporte SET horasTransporte = ?, kilometrosRecorridos = ?, medioTransporteFrecuencia = ?, medioTransporteUso = ? WHERE idTransporte = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, datosTransporte.getHorasTransporte());
            pstmt.setDouble(2, datosTransporte.getKilometrosRecorridos());
            pstmt.setString(3, datosTransporte.getMedioTransporteFrecuencia());
            pstmt.setString(4, datosTransporte.getMedioTransporteUso());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("Transporte actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar transporte: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar un transporte
    public void eliminarTransporte(int id) {
        String query = "DELETE FROM Transporte WHERE idTransporte = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Transporte eliminado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar transporte: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Método para obtener un transporte desde la base de datos
public DatosTransporte obtenerTransportePorId(int idTransporte) {
    String query = "SELECT * FROM Transporte WHERE idTransporte = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setInt(1, idTransporte);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new DatosTransporte(
                rs.getInt("horasTransporte"),
                rs.getDouble("kilometrosRecorridos"),
                rs.getString("medioTransporteFrecuencia"),
                rs.getString("medioTransporteUso")
            );
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener transporte: " + e.getMessage());
        e.printStackTrace();
    }
    return null; 
}


    public Object[][] obtenerDatosTransporte() {
    String query = "SELECT Usuario.idUsuario, Usuario.nombre, Usuario.apellido, Usuario.correo, Transporte.idTransporte, Transporte.horasTransporte, Transporte.kilometrosRecorridos, Transporte.medioTransporteFrecuencia, Transporte.medioTransporteUso FROM Usuario JOIN Transporte ON Usuario.idUsuario = Transporte.idTransporte";
    List<Object[]> dataList = new ArrayList<>();

    try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            Object[] row = {
                rs.getInt("idUsuario"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getInt("idTransporte"),
                rs.getInt("horasTransporte"),
                rs.getDouble("kilometrosRecorridos"),
                rs.getString("medioTransporteFrecuencia"),
                rs.getString("medioTransporteUso")
            };
            dataList.add(row);
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener datos de transporte: " + e.getMessage());
        e.printStackTrace();
    }

    return dataList.toArray(new Object[0][]);
}

    
} 

