package Main;

import Controlador.ControlDatosPersonalesFacade;
import Vista.Frm_DatosPersonales; // Cambiado a Frm_DatosPersonales
import Modelo.DatabaseConnection; // Asegúrate de importar tu clase de conexión
import Vista.SistemaPrincipalCarbono;


public class Main {
    public static void main(String[] args) {
        // Conectar a la base de datos
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        
        if (dbConnection.getConnection() != null) {
            System.out.println("Conexión a la base de datos establecida con éxito.");
        } else {
            System.out.println("Error al establecer la conexión a la base de datos.");
            return;
        }

        // Crear la vista de datos personales
        Frm_DatosPersonales vista = new Frm_DatosPersonales();
        
        // Crear el controlador y pasar la vista
        ControlDatosPersonalesFacade control = new ControlDatosPersonalesFacade(vista);

        // Hacer visible la vista
        vista.setVisible(true);

        // Añadir un listener para cuando se cierre Frm_DatosPersonales
        vista.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                // Mostrar SistemaPrincipalCarbono después de cerrar Frm_DatosPersonales
                javax.swing.SwingUtilities.invokeLater(() -> {
                    SistemaPrincipalCarbono ventana = new SistemaPrincipalCarbono();
                    ventana.setVisible(true);
                });
            }
        });
    }
}


