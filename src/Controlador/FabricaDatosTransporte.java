package Controlador;

// Clase de fábrica para crear instancias de DatosTransporte

import Modelo.DatosTransporte;

public class FabricaDatosTransporte {
    public DatosTransporte crearDatosTransporte(int horasTransporte, double kilometrosRecorridos, String medioTransporteFrecuencia, String medioTransporteUso) {
        return new DatosTransporte(horasTransporte, kilometrosRecorridos, medioTransporteFrecuencia, medioTransporteUso);
    }
}

