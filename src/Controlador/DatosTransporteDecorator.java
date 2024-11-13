package Controlador;

// Clase decoradora que extiende DatosTransporte

import Modelo.DatosTransporte;

public class DatosTransporteDecorator extends DatosTransporte {
    private DatosTransporte datosTransporte;

    public DatosTransporteDecorator(DatosTransporte datosTransporte) {
        super(datosTransporte.getHorasTransporte(), 
              datosTransporte.getKilometrosRecorridos(), 
              datosTransporte.getMedioTransporteFrecuencia(), 
              datosTransporte.getMedioTransporteUso());
        this.datosTransporte = datosTransporte;
    }

    // Método adicional para mostrar información extendida
    public String obtenerInformacionExtendida() {
        return "Información extendida: " + 
               "Horas: " + datosTransporte.getHorasTransporte() + 
               ", Kilómetros: " + datosTransporte.getKilometrosRecorridos();
    }
}