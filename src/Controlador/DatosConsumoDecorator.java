package Controlador;

import Modelo.Consumo;

// Clase decoradora que extiende Consumo
public class DatosConsumoDecorator extends Consumo {
    private Consumo consumo;

    public DatosConsumoDecorator(Consumo consumo) {
        this.consumo = consumo;
    }

    // Método adicional para mostrar información extendida
    public String obtenerInformacionExtendida() {
        return "Información extendida: " + 
               "ID: " + consumo.getIdConsumo() + 
               ", Res: " + consumo.getRes() + 
               ", Pollo: " + consumo.getPollo() + 
               ", Huevos: " + consumo.getHuevos() + 
               ", Leche: " + consumo.getLeche() + 
               ", Frutas y Verduras: " + consumo.getFrutasVerduras() + 
               ", Huella de Carbono: " + consumo.calcularHuellaCarbono();
    }

    // Métodos delegados
    @Override
    public int getIdConsumo() {
        return consumo.getIdConsumo();
    }

    @Override
    public double getRes() {
        return consumo.getRes();
    }

    @Override
    public double getPollo() {
        return consumo.getPollo();
    }

    @Override
    public double getHuevos() {
        return consumo.getHuevos();
    }

    @Override
    public double getLeche() {
        return consumo.getLeche();
    }

    @Override
    public double getFrutasVerduras() {
        return consumo.getFrutasVerduras();
    }

    @Override
    public double calcularHuellaCarbono() {
        return consumo.calcularHuellaCarbono();
    }
}