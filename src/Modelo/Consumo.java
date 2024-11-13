package Modelo;

public class Consumo {
    
    // Los atributos
    private double res;
    private double pollo;
    private double huevos;
    private double leche;
    private double frutasVerduras;
     private int idConsumo;

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    // Constructor
    public Consumo() {
    }
    
    // Los Getter and Setter

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public double getPollo() {
        return pollo;
    }

    public void setPollo(double pollo) {
        this.pollo = pollo;
    }

    public double getHuevos() {
        return huevos;
    }

    public void setHuevos(double huevos) {
        this.huevos = huevos;
    }

    public double getLeche() {
        return leche;
    }

    public void setLeche(double leche) {
        this.leche = leche;
    }

    public double getFrutasVerduras() {
        return frutasVerduras;
    }

    public void setFrutasVerduras(double frutasVerduras) {
        this.frutasVerduras = frutasVerduras;
    }
    
    // El método para calcular la huella de carbono
    public double calcularHuellaCarbono() {
        double huellaRes = this.res * 27.0; // kg CO2 por kg de res
        double huellaPollo = this.pollo * 6.9; // kg CO2 por kg de pollo
        double huellaHuevos = this.huevos * 4.8; // kg CO2 por kg de huevos
        double huellaLeche = this.leche * 1.9; // kg CO2 por litro de leche
        double huellaFrutasVerduras = this.frutasVerduras * 2.5; // kg CO2 por kg de frutas y verduras
        
        // Suma de la huella de carbono total
        return huellaRes + huellaPollo + huellaHuevos + huellaLeche + huellaFrutasVerduras;
    }
    
}

