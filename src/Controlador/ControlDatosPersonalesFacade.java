package Controlador;

import Modelo.UsuarioDAO; 
import Vista.Frm_DatosPersonales;  
import Vista.ValidacionDatos; 
import Vista.ValidacionDatosPersonales;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlDatosPersonalesFacade implements ActionListener {
    private Frm_DatosPersonales vista; 
    private ValidacionDatosPersonales validacion; // Usaremos la clase de validación con Bridge

    public ControlDatosPersonalesFacade(Frm_DatosPersonales vista) {
        this.vista = vista;
        UsuarioDAO usuarioDAO = new UsuarioDAO(); // Inicializar el DAO
        this.validacion = new ValidacionDatosPersonales(new ValidacionDatos(), usuarioDAO); // Inyección de la implementación de validación y el DAO

        vista.btnInsertar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {       
        obtenerDatosPersonales();
    }

    private void obtenerDatosPersonales() {
        try {
            String nombre = vista.txtNombre.getText().trim();
            String apellido = vista.txtApellido.getText().trim();
            String correo = vista.txtCorreo.getText().trim();

            // Guardar datos personales
            boolean datosGuardados = validacion.guardarDatosPersonales(nombre, apellido, correo);
            
            // Solo continuar si los datos fueron guardados correctamente
            if (datosGuardados) {
                // Aquí puedes agregar la lógica para navegar a la siguiente página
                // Puedes eliminar o modificar la lógica para mostrar la siguiente vista
                JOptionPane.showMessageDialog(vista, "Datos guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Si no se guardaron, mostrar un mensaje y permanecer en la misma vista
                JOptionPane.showMessageDialog(vista, "No se pudo guardar los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Por favor ingrese valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

