package Vista;

import javax.swing.JOptionPane;
import Modelo.UsuarioDAO;

public class ValidacionDatosPersonales {
    private IValidacionDatos validacion; // Referencia a la interfaz de validación
    private UsuarioDAO usuarioDAO; // Referencia al DAO para la base de datos

    // Constructor que recibe la implementación de validación y el DAO
    public ValidacionDatosPersonales(IValidacionDatos validacion, UsuarioDAO usuarioDAO) {
        this.validacion = validacion; // Inyección de dependencia
        this.usuarioDAO = usuarioDAO; // Inyección de dependencia
    }

    // Método para guardar datos personales
    public boolean guardarDatosPersonales(String nombre, String apellido, String correo) {
        // Validación de campos
        if (!validacion.validarCampos(nombre, apellido, correo)) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            System.out.println("Validación de campos fallida.");
            return false; // Indica que no se guardaron los datos
        }

        // Validación del formato del correo
        if (!validacion.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "Ingrese un correo electrónico válido.");
            System.out.println("Validación de correo fallida.");
            return false; // Indica que no se guardaron los datos
        }

        // Inserción en la base de datos
        usuarioDAO.insertarUsuario(nombre, apellido, correo); // Aquí guardamos en la base de datos
        System.out.println("Datos guardados correctamente.");

        // Mensaje de éxito con los datos guardados
        String mensaje = "Datos guardados correctamente:\n" +
                         "Nombre: " + nombre + "\n" +
                         "Apellido: " + apellido + "\n" +
                         "Correo: " + correo;
        JOptionPane.showMessageDialog(null, mensaje);
        return true; // Indica que los datos se guardaron correctamente
    }
}
