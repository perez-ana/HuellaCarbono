package Modelo;

// Clase que representa los datos de residuos del usuario
public class DatosResiduos {
    private int bolsas3kg;
    private int bolsas6kg;
    private int bolsas10kg;
    private String tipoResiduos;

    public DatosResiduos(int bolsas3kg, int bolsas6kg, int bolsas10kg, String tipoResiduos) {
        this.bolsas3kg = bolsas3kg;
        this.bolsas6kg = bolsas6kg;
        this.bolsas10kg = bolsas10kg;
        this.tipoResiduos = tipoResiduos;
    }

    // Métodos getter y setter
    public int getBolsas3kg() {
        return bolsas3kg;
    }

    public int getBolsas6kg() {
        return bolsas6kg;
    }

    public int getBolsas10kg() {
        return bolsas10kg;
    }

    public String getTipoResiduos() {
        return tipoResiduos;
    }
    
    // Método para calcular la huella de carbono en residuos
    public double calcularHuellaCarbono() {
        double huella3kg = bolsas3kg * 0.8; // kg CO2 por cada bolsa de 3 kg
        double huella6kg = bolsas6kg * 1.5; // kg CO2 por cada bolsa de 6 kg
        double huella10kg = bolsas10kg * 2.0; // kg CO2 por cada bolsa de 10 kg
        return huella3kg + huella6kg + huella10kg;
    }
    
}
