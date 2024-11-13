package Vista;

public interface EstadoEnergia {
    void guardarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural);
    void validarDatos(ContextoEnergia contexto, double montoElectricidad, int balonesGas, double montoGasNatural);
    String getEstadoActual();
}