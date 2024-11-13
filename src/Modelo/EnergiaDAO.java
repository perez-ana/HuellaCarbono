package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnergiaDAO {

    private Connection connection;

    public EnergiaDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    // CREATE: Insertar energia
    public void insertarEnergia(double montoElectricidad, int balonesGas, double montoGasNatural) {
        String query = "INSERT INTO Energia (montoElectricidad, balonesGas, montoGasNatural) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, montoElectricidad);
            pstmt.setInt(2, balonesGas);
            pstmt.setDouble(3, montoGasNatural);
            pstmt.executeUpdate();
            System.out.println("Energia insertado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al insertar energia: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // READ: Leer todos los datos de energia
    public void leerEnergia() {
        String query = "SELECT * FROM Energia";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idEnergia"));
                System.out.println("Electricidad: " + rs.getDouble("montoElectricidad"));
                System.out.println("Balones Gas: " + rs.getInt("balonesGas"));
                System.out.println("Gas Natural: " + rs.getDouble("montoGasNatural"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Actualizar datos de energia
    public void actualizarEnergia(int id, double montoElectricidad, int balonesGas, double montoGasNatural) {
        String query = "UPDATE Energia SET montoElectricidad = ?, balonesGas = ?, montoGasNatural = ? WHERE idEnergia = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, montoElectricidad);
            pstmt.setInt(2, balonesGas);
            pstmt.setDouble(3, montoGasNatural);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar datos de energia
    public void eliminarEnergia(int id) {
        String query = "DELETE FROM Energia WHERE idEnergia = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Método para obtener una energía por su ID
    public DatosEnergia obtenerEnergiaPorId(int idEnergia) {
        String query = "SELECT * FROM Energia WHERE idEnergia = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idEnergia);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new DatosEnergia(
                        rs.getDouble("montoElectricidad"),
                        rs.getInt("balonesGas"),
                        rs.getDouble("montoGasNatural")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener energía: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
          public Object[][] obtenerDatosEnergia() {
       String query = "SELECT Usuario.idUsuario, Usuario.nombre, Usuario.apellido, Usuario.correo, Energia.idEnergia, Energia.montoElectricidad, Energia.balonesGas, Energia.montoGasNatural " +
                      "FROM Usuario LEFT JOIN Energia ON Usuario.idUsuario = Energia.idEnergia";
       List<Object[]> dataList = new ArrayList<>();

       try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
           while (rs.next()) {
               Object[] row = {
                   rs.getInt("idUsuario"),
                   rs.getString("nombre"),
                   rs.getString("apellido"),
                   rs.getString("correo"),
                   rs.getInt("idEnergia"),
                   rs.getDouble("montoElectricidad"),
                   rs.getInt("balonesGas"),
                   rs.getDouble("montoGasNatural")
               };
               dataList.add(row);
           }
       } catch (SQLException e) {
           System.err.println("Error al obtener datos de energía: " + e.getMessage());
           e.printStackTrace();
       }

       return dataList.toArray(new Object[0][]);
   }
}

