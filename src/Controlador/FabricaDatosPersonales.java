
package Controlador;

// Clase que fabrica los datos personales

import Modelo.DatosPersonales;

public class FabricaDatosPersonales {
    public DatosPersonales crearDatosPersonales(String nombre, String apellido, String correo) {
        return new DatosPersonales(nombre, apellido, correo);
    }
}