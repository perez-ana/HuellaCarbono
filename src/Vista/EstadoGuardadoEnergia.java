
package Vista;

public class EstadoGuardadoEnergia implements EstadoEnergia {
    @Override
    public void guardarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        // Ya guardado
    }

    @Override
    public void validarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        // Ya validado
    }

    @Override
    public String getEstadoActual() {
        return "Datos Guardados";
    }
}