package Controlador;

import Vista.SistemaPrincipalCarbono;
import Vista.ContextoEnergia;
import Vista.EstadoErrorEnergia;
import Vista.EstadoGuardadoEnergia;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ControlEnergiaFacade implements ActionListener {
    private JTextField txtMontoElectricidad;
    private JTextField txtBalonesGas;
    private JTextField txtMontoGasNatural;
    private ContextoEnergia contexto;

    public ControlEnergiaFacade(JTextField txtMontoElectricidad, JTextField txtBalonesGas, JTextField txtMontoGasNatural) {
        this.txtMontoElectricidad = txtMontoElectricidad;
        this.txtBalonesGas = txtBalonesGas;
        this.txtMontoGasNatural = txtMontoGasNatural;
        this.contexto = new ContextoEnergia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obtenerDatosElectricidad();
    }

    private void obtenerDatosElectricidad() {
    try {
        double montoElectricidad = Double.parseDouble(txtMontoElectricidad.getText());
        int balonesGas = Integer.parseInt(txtBalonesGas.getText());
        double montoGasNatural = Double.parseDouble(txtMontoGasNatural.getText());

        // Usa el decorador
        DatosEnergiaDecorator decorador = new DatosEnergiaDecorator(montoElectricidad, balonesGas, montoGasNatural);

        contexto.procesarDatos(decorador.getMontoElectricidad(), decorador.getBalonesGas(), decorador.getMontoGasNatural());

        if (contexto.getEstado() instanceof EstadoGuardadoEnergia) {
            JOptionPane.showMessageDialog(null, "Datos guardados exitosamente\n" + decorador.obtenerInformacionExtendida());
        } else if (contexto.getEstado() instanceof EstadoErrorEnergia) {
            JOptionPane.showMessageDialog(null, "Error al procesar los datos", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos", 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}