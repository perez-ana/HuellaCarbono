package Controlador;

import Modelo.DatosEnergia;

public class FabricaDatosEnergia {
    // Método para crear datos de energía
    public DatosEnergia crearDatosEnergia(String montoelect, int balones10kg, String montogas) {
        double montoElectDouble = Double.parseDouble(montoelect);
        double montoGasDouble = Double.parseDouble(montogas);
        return new DatosEnergia(montoElectDouble, balones10kg, montoGasDouble);
    }
}
