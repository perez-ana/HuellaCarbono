package Controlador;

import Vista.SistemaPrincipalCarbono;
import Modelo.TransporteDAO;
import Modelo.DatosTransporte; 
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ControlTransporteFacade implements ActionListener {
    private JTextField txtHorasTransporte;
    private JTextField txtKilometros;
    private JComboBox<String> comboMedioTransporte;
    private JComboBox<String> comboMedioUtilizado;
    private TransporteDAO transporteDAO;

    public ControlTransporteFacade(JTextField txtHorasTransporte, JTextField txtKilometros, JComboBox<String> comboMedioTransporte, JComboBox<String> comboMedioUtilizado) {
        this.txtHorasTransporte = txtHorasTransporte;
        this.txtKilometros = txtKilometros;
        this.comboMedioTransporte = comboMedioTransporte;
        this.comboMedioUtilizado = comboMedioUtilizado;
        this.transporteDAO = new TransporteDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obtenerDatosTransporte();
    }

    private void obtenerDatosTransporte() {
    try {
        DatosTransporte datosTransporte = new DatosTransporte(
            Integer.parseInt(txtHorasTransporte.getText()),
            Double.parseDouble(txtKilometros.getText()),
            comboMedioTransporte.getSelectedItem().toString(),
            comboMedioUtilizado.getSelectedItem().toString()
        );

        // Usa el decorador
        DatosTransporteDecorator decorador = new DatosTransporteDecorator(datosTransporte);

        transporteDAO.insertarTransporte(decorador);

        JOptionPane.showMessageDialog(null, "Datos de transporte guardados:\n"
                + "Horas en transporte: " + decorador.getHorasTransporte() + "\n"
                + "Kilómetros recorridos: " + decorador.getKilometrosRecorridos() + "\n"
                + "Medio de transporte frecuente: " + decorador.getMedioTransporteFrecuencia() + "\n"
                + "Medio de transporte utilizado: " + decorador.getMedioTransporteUso() + "\n"
                + decorador.obtenerInformacionExtendida());

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, 
            "Por favor ingrese valores numéricos válidos", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, 
            "Error al guardar los datos: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
}