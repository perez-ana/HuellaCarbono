
package Controlador;

import Modelo.DatosResiduos;

public class FabricaDatosResiduos {
    public DatosResiduos crearDatosResiduos(int bolsas3kg, int bolsas6kg, int bolsas10kg, String tipoResiduos) {
        DatosResiduos datosResiduos = new DatosResiduos(bolsas3kg, bolsas6kg, bolsas10kg, tipoResiduos);
        // Usa el decorador para extender la funcionalidad
        DatosResiduosDecorator decorador = new DatosResiduosDecorator(datosResiduos);
        System.out.println(decorador.obtenerInformacionExtendida());
        return decorador;
    }
}
