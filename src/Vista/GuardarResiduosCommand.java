
package Vista;
import Modelo.DatosResiduos;
import Modelo.ResiduosDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GuardarResiduosCommand implements ICommandResiduos {
    private final DatosResiduos datosResiduos;
    private final ResiduosDAO residuosDAO;

    public GuardarResiduosCommand(DatosResiduos datosResiduos, ResiduosDAO residuosDAO) {
        this.datosResiduos = datosResiduos;
        this.residuosDAO = residuosDAO;
    }

    @Override
    public void execute() {
        try {
            residuosDAO.insertarResiduos(
                datosResiduos.getBolsas3kg(),
                datosResiduos.getBolsas6kg(),
                datosResiduos.getBolsas10kg(),
                datosResiduos.getTipoResiduos()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar los datos de residuos.");
        }
    }

    @Override
    public void undo() {
        // Implementar lógica para deshacer si es necesario
    }
}