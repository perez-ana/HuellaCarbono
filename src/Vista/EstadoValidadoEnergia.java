package Vista;

import Modelo.DatosEnergia;

public class EstadoValidadoEnergia implements EstadoEnergia {
    @Override
    public void guardarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        try {
            DatosEnergia datos = new DatosEnergia(montoElectricidad, balonesGas, montoGasNatural);
            contexto.getEnergiaDAO().insertarEnergia(montoElectricidad, balonesGas, montoGasNatural);
            contexto.setEstado(new EstadoGuardadoEnergia());
        } catch (Exception e) {
            contexto.setEstado(new EstadoErrorEnergia());
        }
    }

    @Override
    public void validarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        // Ya validado
    }

    @Override
    public String getEstadoActual() {
        return "Datos Validados";
    }
}