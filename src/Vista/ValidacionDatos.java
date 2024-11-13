package Vista;

// Implementación de la validación de datos
public class ValidacionDatos implements IValidacionDatos {
    @Override
    public boolean validarCampos(String nombre, String apellido, String correo) {
        return !(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty());
    }

    @Override
    public boolean validarCorreo(String correo) {
        return correo.contains("@") && 
               (correo.endsWith("@gmail.com") || correo.endsWith("@hotmail.com"));
    }
}
