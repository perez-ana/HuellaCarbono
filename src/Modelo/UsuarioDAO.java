package Modelo;

import java.sql.*;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    // CREATE: Insertar un nuevo usuario
    public void insertarUsuario(String nombre, String apellido, String correo) {
        String query = "INSERT INTO Usuario (nombre, apellido, correo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.executeUpdate();
            System.out.println("Usuario insertado con éxito."); // Mensaje de éxito
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // READ: Leer usuario por correo
    public DatosPersonales obtenerUsuarioPorCorreo(String correo) {
        String query = "SELECT * FROM Usuario WHERE correo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, correo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Retornar un objeto DatosPersonales con los datos obtenidos
                    DatosPersonales datosPersonales = new DatosPersonales(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo")
                    );
                    datosPersonales.setIdUsuario(rs.getInt("idUsuario")); // Establecer el ID del usuario
                    return datosPersonales;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Si no se encuentra el usuario
    }

    // UPDATE: Actualizar un usuario
    public void actualizarUsuario(int id, String nombre, String apellido, String correo) {
        String query = "UPDATE Usuario SET nombre = ?, apellido = ?, correo = ? WHERE idUsuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Usuario actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar un usuario
    public void eliminarUsuario(int id) {
        String query = "DELETE FROM Usuario WHERE idUsuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    
    






