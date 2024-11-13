package Vista;

// Interfaz para la validación
public interface IValidacionDatos {
    boolean validarCampos(String nombre, String apellido, String correo);
    boolean validarCorreo(String correo);
}
