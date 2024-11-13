
package Vista;

public class EstadoInicialEnergia implements EstadoEnergia {
    @Override
    public void guardarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        validarDatos(contexto, montoElectricidad, balonesGas, montoGasNatural);
    }

    @Override
    public void validarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        if (montoElectricidad > 0 && balonesGas >= 0 && montoGasNatural >= 0) {
            contexto.setEstado(new EstadoValidadoEnergia());
            contexto.getEstado().guardarDatos(contexto, montoElectricidad, balonesGas, montoGasNatural);
        } else {
            contexto.setEstado(new EstadoErrorEnergia());
        }
    }

    @Override
    public String getEstadoActual() {
        return "Estado Inicial";
    }
}