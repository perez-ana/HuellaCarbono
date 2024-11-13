
package Vista;

import Controlador.ControladorFacade;
import Modelo.Consumo;

public class GuardarConsumoCommand implements ICommandConsumo {
    private final Consumo consumo;
    private final ControladorFacade controlador;

    public GuardarConsumoCommand(Consumo consumo, ControladorFacade controlador) {
        this.consumo = consumo;
        this.controlador = controlador;
    }

    @Override
    public void execute() {
        controlador.guardarDatos(consumo);
    }

    @Override
    public void undo() {
        if (consumo.getIdConsumo() != 0) {
            controlador.eliminarConsumo(consumo.getIdConsumo());
        }
    }
}