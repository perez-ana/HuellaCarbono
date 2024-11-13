
package Vista;

import Modelo.EnergiaDAO;

public class ContextoEnergia {
    private EstadoEnergia estado;
    private EnergiaDAO energiaDAO;

    public ContextoEnergia() {
        this.estado = new EstadoInicialEnergia();
        this.energiaDAO = new EnergiaDAO();
    }

    public void setEstado(EstadoEnergia estado) {
        this.estado = estado;
    }

    public EstadoEnergia getEstado() {
        return estado;
    }

    public EnergiaDAO getEnergiaDAO() {
        return energiaDAO;
    }

    public void procesarDatos(double montoElectricidad, int balonesGas, double montoGasNatural) {
        estado.guardarDatos(this, montoElectricidad, balonesGas, montoGasNatural);
    }

    public String getEstadoActual() {
        return estado.getEstadoActual();
    }
}