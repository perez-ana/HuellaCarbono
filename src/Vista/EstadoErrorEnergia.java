package Vista;

public class EstadoErrorEnergia implements EstadoEnergia {
    @Override
    public void guardarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        // No se puede guardar en estado de error
    }

    @Override
    public void validarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural) {
        if (montoElectricidad > 0 && balonesGas >= 0 && montoGasNatural >= 0) {
            contexto.setEstado(new EstadoValidadoEnergia()); // Agregar import
        }
    }

    @Override
    public String getEstadoActual() {
        return "Error en los datos";
    }
}
