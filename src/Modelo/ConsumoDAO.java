package Modelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumoDAO {

    private Connection connection;

    public ConsumoDAO() {
        connection = DatabaseConnection.getInstance().getConnection();
    }

    // CREATE: Insertar un nuevo registro de consumo
    public void insertarConsumo(Consumo consumo) {
        String query = "INSERT INTO Consumo (res, pollo, huevos, leche, frutasVerduras) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, consumo.getRes());
            pstmt.setDouble(2, consumo.getPollo());
            pstmt.setDouble(3, consumo.getHuevos());
            pstmt.setDouble(4, consumo.getLeche());
            pstmt.setDouble(5, consumo.getFrutasVerduras());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ: Leer todos los registros de consumo
    public void leerConsumos() {
        String query = "SELECT * FROM Consumo";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idConsumo"));
                System.out.println("Res: " + rs.getDouble("res") + " kg");
                System.out.println("Pollo: " + rs.getDouble("pollo") + " kg");
                System.out.println("Huevos: " + rs.getDouble("huevos") + " kg");
                System.out.println("Leche: " + rs.getDouble("leche") + " litros");
                System.out.println("Frutas y Verduras: " + rs.getDouble("frutasVerduras") + " kg");
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE: Actualizar un registro de consumo
    public void actualizarConsumo(int id, Consumo consumo) {
        String query = "UPDATE Consumo SET res = ?, pollo = ?, huevos = ?, leche = ?, frutasVerduras = ? WHERE idConsumo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, consumo.getRes());
            pstmt.setDouble(2, consumo.getPollo());
            pstmt.setDouble(3, consumo.getHuevos());
            pstmt.setDouble(4, consumo.getLeche());
            pstmt.setDouble(5, consumo.getFrutasVerduras());
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE: Eliminar un registro de consumo
    public void eliminarConsumo(int id) {
        String query = "DELETE FROM Consumo WHERE idConsumo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener un consumo desde la base de datos
    public Consumo obtenerConsumoPorId(int idConsumo) {
        String query = "SELECT * FROM Consumo WHERE idConsumo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idConsumo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Consumo consumo = new Consumo();
                consumo.setIdConsumo(rs.getInt("idConsumo"));
                consumo.setRes(rs.getDouble("res"));
                consumo.setPollo(rs.getDouble("pollo"));
                consumo.setHuevos(rs.getDouble("huevos"));
                consumo.setLeche(rs.getDouble("leche"));
                consumo.setFrutasVerduras(rs.getDouble("frutasVerduras"));
                return consumo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Si no se encuentra, devolver null
    }

    // Método para modificar un consumo en la base de datos
    public void modificarConsumo(Consumo consumo) {
        String query = "UPDATE Consumo SET res = ?, pollo = ?, huevos = ?, leche = ?, frutasVerduras = ? WHERE idConsumo = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, consumo.getRes());
            pstmt.setDouble(2, consumo.getPollo());
            pstmt.setDouble(3, consumo.getHuevos());
            pstmt.setDouble(4, consumo.getLeche());
            pstmt.setDouble(5, consumo.getFrutasVerduras());
            pstmt.setInt(6, consumo.getIdConsumo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Object[][] obtenerDatosConsumo() {
        String query = "SELECT Usuario.idUsuario, Usuario.nombre, Usuario.apellido, Usuario.correo, " +
                       "Consumo.idConsumo, Consumo.res, Consumo.pollo, Consumo.huevos, Consumo.leche, Consumo.frutasVerduras " +
                       "FROM Usuario LEFT JOIN Consumo ON Usuario.idUsuario = Consumo.idConsumo";
        List<Object[]> dataList = new ArrayList<>();

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("correo"),
                    rs.getInt("idConsumo"),
                    rs.getDouble("res"),
                    rs.getDouble("pollo"),
                    rs.getDouble("huevos"),
                    rs.getDouble("leche"),
                    rs.getDouble("frutasVerduras")
                };
                dataList.add(row);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener datos de consumo: " + e.getMessage());
            e.printStackTrace();
        }

        return dataList.toArray(new Object[0][]);
    }
}

