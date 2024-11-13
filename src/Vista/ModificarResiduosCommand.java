
package Vista;

import Modelo.DatosResiduos;
import Modelo.ResiduosDAO;

public class ModificarResiduosCommand implements ICommandResiduos {
    private final int id;
    private final DatosResiduos nuevosDatos;
    private final ResiduosDAO residuosDAO;
    private DatosResiduos datosAnteriores;

    public ModificarResiduosCommand(int id, DatosResiduos nuevosDatos, ResiduosDAO residuosDAO) {
        this.id = id;
        this.nuevosDatos = nuevosDatos;
        this.residuosDAO = residuosDAO;
        // Aquí podrías obtener los datos anteriores si es necesario para el undo
    }

    @Override
    public void execute() {
        residuosDAO.actualizarResiduos(
            id,
            nuevosDatos.getBolsas3kg(),
            nuevosDatos.getBolsas6kg(),
            nuevosDatos.getBolsas10kg(),
            nuevosDatos.getTipoResiduos()
        );
    }

    @Override
    public void undo() {
        // Implementar lógica para deshacer si es necesario
    }
}