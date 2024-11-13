package Modelo;

public class DatosEnergia {

    private double montoelect;
    private int balones10kg;
    private double montogas;

    public DatosEnergia(double montoelect, int balones10kg, double montogas) {
        this.montoelect = montoelect;
        this.balones10kg = balones10kg;
        this.montogas = montogas;
    }

    public double getMontoelect() {
        return montoelect;
    }

    public int getBalones10kg() {
        return balones10kg;
    }

    public double getMontogas() {
        return montogas;
    }

    // Método para calcular la huella de carbono en energía
    private double calcularHuellaCarbono(double montoElectricidad, int balonesGas, double montoGasNatural) {
        double huellaElectricidad = montoElectricidad * 0.5; // kg CO2 por cada unidad monetaria en electricidad
        double huellaGas = balonesGas * 3.5; // kg CO2 por cada balón de 10 kg
        double huellaMontogas = montoGasNatural * 0.3; // kg CO2 por cada unidad monetaria en gas
        return huellaElectricidad + huellaGas + huellaMontogas;
    }

}
