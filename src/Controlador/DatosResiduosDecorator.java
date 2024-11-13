package Controlador;

import Modelo.DatosResiduos;

// Clase decoradora que extiende DatosResiduos
public class DatosResiduosDecorator extends DatosResiduos {
    private DatosResiduos datosResiduos;

    public DatosResiduosDecorator(DatosResiduos datosResiduos) {
        super(datosResiduos.getBolsas3kg(), datosResiduos.getBolsas6kg(), datosResiduos.getBolsas10kg(), datosResiduos.getTipoResiduos());
        this.datosResiduos = datosResiduos;
    }

    // Método adicional para mostrar información extendida
    public String obtenerInformacionExtendida() {
        return "Información extendida: " + 
               "Bolsas de 3kg: " + datosResiduos.getBolsas3kg() + 
               ", Bolsas de 6kg: " + datosResiduos.getBolsas6kg() + 
               ", Bolsas de 10kg: " + datosResiduos.getBolsas10kg() + 
               ", Tipo de Residuos: " + datosResiduos.getTipoResiduos() + 
               ", Huella de Carbono: " + datosResiduos.calcularHuellaCarbono();
    }
}