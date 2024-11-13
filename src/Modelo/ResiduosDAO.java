package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResiduosDAO {

    
    private Connection connection;

    public ResiduosDAO() {
        connection = DatabaseConnection.getInstance().getConnection(); // Conexión a la base de datos
    }

    public void insertarResiduos(int bolsas3kg, int bolsas6kg, int bolsas10kg, String tipoResiduos) throws SQLException {
    // Asegúrate de que el nombre de la tabla y las columnas coincidan exactamente con los definidos en tu base de datos.
    String sql = "INSERT INTO Residuos (bolsas3kg, bolsas6kg, bolsas10kg, tipoResiduos) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, bolsas3kg);
        statement.setInt(2, bolsas6kg);
        statement.setInt(3, bolsas10kg);
        statement.setString(4, tipoResiduos);
        statement.executeUpdate();
    }
}


    // READ: Leer todos los residuos
    public void leerResiduos() {
        String query = "SELECT * FROM Residuos";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idResiduos"));
                System.out.println("Bolsas 3kg: " + rs.getInt("bolsas3kg"));
                System.out.println("Bolsas 6kg: " + rs.getInt("bolsas6kg"));
                System.out.println("Bolsas 10kg: " + rs.getInt("bolsas10kg"));
                System.out.println("Tipo de residuos reciclados: " + rs.getString("tipoResiduos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Actualizar datos de residuos
    public void actualizarResiduos(int id, int bolsas3kg, int bolsas6kg, int bolsas10kg, String tipoResiduos) {
        String query = "UPDATE Residuos SET bolsas3kg = ?, bolsas6kg = ?, bolsas10kg = ?, tipoResiduos = ? WHERE idResiduos = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, bolsas3kg);
            pstmt.setInt(2, bolsas6kg);
            pstmt.setInt(3, bolsas10kg);
            pstmt.setString(4, tipoResiduos);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar datos de residuos
    public void eliminarResiduos(int id) {
        String query = "DELETE FROM Residuos WHERE idResiduos = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public DatosResiduos obtenerResiduosPorId(int idResiduos) {
    String query = "SELECT * FROM Residuos WHERE idResiduos = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setInt(1, idResiduos);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new DatosResiduos(
                rs.getInt("bolsas3kg"),
                rs.getInt("bolsas6kg"),
                rs.getInt("bolsas10kg"),
                rs.getString("tipoResiduos")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null; // Si no se encuentra, devolver null
}

    public Object[][] obtenerDatosResiduos() {
        String query = "SELECT Usuario.idUsuario, Usuario.nombre, Usuario.apellido, Usuario.correo, " +
                       "Residuos.idResiduos, Residuos.bolsas3kg, Residuos.bolsas6kg, Residuos.bolsas10kg, Residuos.tipoResiduos " +
                       "FROM Usuario LEFT JOIN Residuos ON Usuario.idUsuario = Residuos.idResiduos";
        List<Object[]> dataList = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getInt("idResiduos"),
                    rs.getInt("bolsas3kg"),
                    rs.getInt("bolsas6kg"),
                    rs.getInt("bolsas10kg"),
                    rs.getString("tipoResiduos")
                };
                dataList.add(row);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener datos de residuos: " + e.getMessage());
            e.printStackTrace();
        }

        return dataList.toArray(new Object[0][]);
    }
 
}
