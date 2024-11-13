package Controlador;

// Clase decoradora para extender la funcionalidad de los datos de energía
public class DatosEnergiaDecorator {
    private double montoElectricidad;
    private int balonesGas;
    private double montoGasNatural;

    public DatosEnergiaDecorator(double montoElectricidad, int balonesGas, double montoGasNatural) {
        this.montoElectricidad = montoElectricidad;
        this.balonesGas = balonesGas;
        this.montoGasNatural = montoGasNatural;
    }

    // Método adicional para mostrar información extendida
    public String obtenerInformacionExtendida() {
        return "Información extendida: " + 
               "Monto Electricidad: " + montoElectricidad + 
               ", Balones de Gas: " + balonesGas + 
               ", Monto Gas Natural: " + montoGasNatural;
    }

    // Métodos para obtener los datos
    public double getMontoElectricidad() {
        return montoElectricidad;
    }

    public int getBalonesGas() {
        return balonesGas;
    }

    public double getMontoGasNatural() {
        return montoGasNatural;
    }
}