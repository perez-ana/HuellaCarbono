
package Vista;

import Controlador.ControladorFacade;
import Modelo.Consumo;

public class ModificarConsumoCommand implements ICommandConsumo {
    private final Consumo consumoNuevo;
    private Consumo consumoAnterior;
    private final ControladorFacade controlador;

    public ModificarConsumoCommand(Consumo consumoNuevo, ControladorFacade controlador) {
        this.consumoNuevo = consumoNuevo;
        this.controlador = controlador;
        this.consumoAnterior = controlador.obtenerConsumo(consumoNuevo.getIdConsumo());
    }

    @Override
    public void execute() {
        controlador.modificarConsumo(consumoNuevo);
    }

    @Override
    public void undo() {
        if (consumoAnterior != null) {
            controlador.modificarConsumo(consumoAnterior);
        }
    }
}