package Vista;

import Controlador.ConsumoFactory;
import Controlador.ControladorFacade;
import Controlador.FabricaDatosTransporte;
import Modelo.Consumo;
import Modelo.ConsumoDAO;
import Modelo.DatosEnergia;
import Modelo.DatosResiduos;
import Modelo.DatosTransporte;
import Modelo.EnergiaDAO;
import Modelo.ResiduosDAO;
import Modelo.TransporteDAO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SistemaPrincipalCarbono extends JFrame {

    private JPanel menuPanel, contentPanel, titlePanel;
    private JButton inicioButton;
    private JPanel rightPanel;

    public SistemaPrincipalCarbono() {
        setTitle("Sistema de Huella de Carbono");
        setSize(1850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear panel de título con fondo negro y texto blanco
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        JLabel titleLabel = new JLabel("SISTEMA DE HUELLA DE CARBONO");
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 50));
        titleLabel.setForeground(Color.ORANGE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);  // Título en la parte superior

        // Crear el panel de contenido (Panel principal donde se muestran los otros paneles)
        contentPanel = new JPanel(new CardLayout());

        // Crear el panel de menú con botones en horizontal
        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Botones en horizontal, centrados
        menuPanel.setBackground(new Color(0, 191, 255)); // Celeste

        // Crear botones para las secciones
        JButton alimentacionButton = createMenuButton("ALIMENTACIÓN", "/Imagenes/alimentos.png", new Color(128, 0, 128)); // Morado
        JButton transporteButton = createMenuButton("TRANSPORTE", "/Imagenes/transporte.png", new Color(128, 0, 128)); // Morado
        JButton energiaButton = createMenuButton("ENERGÍA", "/Imagenes/energia.png", new Color(128, 0, 128)); // Morado
        JButton residuosButton = createMenuButton("RESIDUOS", "/Imagenes/desperdicio.png", new Color(128, 0, 128)); // Morado
        JButton calculosButton = createMenuButton("CÁLCULOS", "/Imagenes/calcular.png", new Color(128, 0, 128)); // Morado

        // Botones adicionales (con colores fijos)
        inicioButton = new JButton("INICIO");
        inicioButton.setFont(new Font("Verdana", Font.BOLD, 27));
        inicioButton.setBackground(new Color(0, 128, 0)); // Verde
        inicioButton.setForeground(Color.WHITE);
        inicioButton.addActionListener(e -> showInicioPanel());

        // Establecer tamaño preferido para los botones del menú (más pequeños)
        alimentacionButton.setPreferredSize(new Dimension(280, 80));  // Ajustar tamaño
        transporteButton.setPreferredSize(new Dimension(300, 80));    // Ajustar tamaño
        energiaButton.setPreferredSize(new Dimension(260, 80));       // Ajustar tamaño
        residuosButton.setPreferredSize(new Dimension(300, 80));      // Ajustar tamaño
        calculosButton.setPreferredSize(new Dimension(250, 80));      // Ajustar tamaño

        // Establecer tamaño preferido para los botones adicionales (con colores fijos)
        inicioButton.setPreferredSize(new Dimension(180, 80));  // Ajustar tamaño

        // Agregar botones al panel de menú (horizontal)
        menuPanel.add(inicioButton);
        menuPanel.add(transporteButton);
        menuPanel.add(energiaButton);
        menuPanel.add(alimentacionButton);
        menuPanel.add(residuosButton);
        menuPanel.add(calculosButton);

        add(menuPanel, BorderLayout.CENTER);  // Los botones debajo del título
        add(contentPanel, BorderLayout.SOUTH);  // Panel de contenido abajo

        // Action listeners para los botones
        transporteButton.addActionListener(e -> showOptionsDialog("TRANSPORTE"));
        energiaButton.addActionListener(e -> showOptionsDialog("ENERGÍA"));
        alimentacionButton.addActionListener(e -> showOptionsDialog("ALIMENTACIÓN"));
        residuosButton.addActionListener(e -> showOptionsDialog("RESIDUOS"));
        calculosButton.addActionListener(e -> showCalculationsPanel());

        // Mostrar la pantalla de inicio
        showInicioPanel();
    }

    ///////////////////////////////////////////PARA EL INCICIO/////////////////////////////////////////////////////////////////////
    private void showInicioPanel() {
        // Crear un panel de inicio
        JPanel inicioPanel = new JPanel();
        inicioPanel.setLayout(new BorderLayout());

        // Crear el JLabel para el texto
        JLabel welcomeLabel = new JLabel("¡Bienvenido al Sistema de Huella de Carbono!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Verdana", Font.ITALIC, 35));
        welcomeLabel.setForeground(Color.BLACK); // Aseguramos que el texto sea visible
        welcomeLabel.setOpaque(true); // Aseguramos que el texto tenga un fondo transparente

        // Aquí deberías colocar tu ruta de la imagen de bienvenida
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Imagenes/menu_fondo.jpg"));

        // Redimensionar la imagen a un tamaño deseado (por ejemplo, 800x600 píxeles)
        Image img = imageIcon.getImage().getScaledInstance(1800, 580, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(img); // Actualizar el ImageIcon con la imagen redimensionada

        // Crear un JLabel con la imagen redimensionada
        JLabel imageLabel = new JLabel(imageIcon);

        // Crear un panel para el texto
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false); // Hacer transparente el fondo del panel
        textPanel.add(welcomeLabel); // Colocar el texto en el panel

        // Agregar la imagen y el texto al panel de inicio
        inicioPanel.add(imageLabel, BorderLayout.CENTER); // Coloca la imagen en el centro
        inicioPanel.add(textPanel, BorderLayout.NORTH);   // Coloca el texto en la parte superior

        // Actualizar el panel de contenido
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout()); // Asegurarse de que el layout sea BorderLayout
        contentPanel.add(inicioPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

////////////////////////////////////////////PARA EL CUADRO DE LAS OPCIONES////////////////////////////////////////////////////////////////////////////////////
    private void showOptionsDialog(String sectionName) {
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Panel izquierdo para los botones
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(0, 191, 255));
        leftPanel.setPreferredSize(new Dimension(300, 620));

        // Panel derecho (inicialmente vacío)
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(Color.WHITE);

        // Crear botones
        JButton btnAgregar = createOptionButton("AGREGAR");
        JButton btnModificar = createOptionButton("MODIFICAR");
        JButton btnConsultar = createOptionButton("CONSULTAR");
        JButton btnCerrar = createOptionButton("CERRAR");

        // Panel para centrar los botones
        JPanel buttonWrapper = new JPanel();
        buttonWrapper.setLayout(new BoxLayout(buttonWrapper, BoxLayout.Y_AXIS));
        buttonWrapper.setBackground(new Color(0, 191, 255));

        // Agregar espacio y botones
        buttonWrapper.add(Box.createVerticalStrut(50));
        buttonWrapper.add(btnAgregar);
        buttonWrapper.add(Box.createVerticalStrut(30));
        buttonWrapper.add(btnModificar);
        buttonWrapper.add(Box.createVerticalStrut(30));
        buttonWrapper.add(btnConsultar);
        buttonWrapper.add(Box.createVerticalStrut(30));
        buttonWrapper.add(btnCerrar);

        leftPanel.add(buttonWrapper);

        // Configurar acciones de los botones
        btnAgregar.addActionListener(e -> {
            rightPanel.removeAll();
            switch (sectionName) {
                case "ALIMENTACIÓN":
                    rightPanel.add(createAlimentacionAgregarPanel());
                    break;
                case "RESIDUOS":
                    rightPanel.add(createResiduosAgregarPanel());
                    break;
                case "TRANSPORTE":
                    rightPanel.add(createTransporteAgregarPanel());
                    break;
                case "ENERGÍA":
                    rightPanel.add(createEnergiaAgregarPanel());
                    break;
            }
            rightPanel.revalidate();
            rightPanel.repaint();
        });

        btnModificar.addActionListener(e -> {
            rightPanel.removeAll();
            switch (sectionName) {
                case "ALIMENTACIÓN":
                    rightPanel.add(createAlimentacionModificarPanel());
                    break;
                case "RESIDUOS":
                    rightPanel.add(createResiduosModificarPanel());
                    break;
                case "TRANSPORTE":
                    rightPanel.add(createTransporteModificarPanel());
                    break;
                case "ENERGÍA":
                    rightPanel.add(createEnergiaModificarPanel());
                    break;
            }
            rightPanel.revalidate();
            rightPanel.repaint();
        });

        btnConsultar.addActionListener(e -> {
            rightPanel.removeAll();
            switch (sectionName) {
                case "ALIMENTACIÓN":
                    rightPanel.add(createAlimentacionConsultarPanel());
                    break;
                case "RESIDUOS":
                    rightPanel.add(createResiduosConsultarPanel());
                    break;
                case "TRANSPORTE":
                    rightPanel.add(createTransporteConsultarPanel());
                    break;
                case "ENERGÍA":
                    rightPanel.add(createEnergiaConsultarPanel());
                    break;
            }
            rightPanel.revalidate();
            rightPanel.repaint();
        });

        btnCerrar.addActionListener(e -> showInicioPanel());

        // Agregar los paneles al panel principal
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Actualizar el panel de contenido
        contentPanel.removeAll();
        contentPanel.add(mainPanel);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private JButton createOptionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(128, 0, 128)); // Morado
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(250, 60));
        button.setMaximumSize(new Dimension(250, 60));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Efecto hover
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(255, 140, 0)); // Naranja al pasar el mouse
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(128, 0, 128)); // Volver al morado
            }
        });

        return button;
    }

    // Método para mostrar el panel correspondiente basado en la opción seleccionada
    private void showPanel(String panelName) {
        JPanel panel = null;

        switch (panelName) {
            case "TRANSPORTE AGREGAR":
                panel = createTransporteAgregarPanel();
                break;
            case "TRANSPORTE MODIFICAR":
                panel = createTransporteModificarPanel();
                break;
            case "TRANSPORTE CONSULTAR":
                panel = createTransporteConsultarPanel();
                break;
            case "ENERGÍA AGREGAR":
                panel = createEnergiaAgregarPanel();
                break;
            case "ENERGÍA MODIFICAR":
                panel = createEnergiaModificarPanel();
                break;
            case "ENERGÍA CONSULTAR":
                panel = createEnergiaConsultarPanel();
                break;
            case "ALIMENTACIÓN AGREGAR":
                panel = createAlimentacionAgregarPanel();
                break;
            case "ALIMENTACIÓN MODIFICAR":
                panel = createAlimentacionModificarPanel();
                break;
            case "ALIMENTACIÓN CONSULTAR":
                panel = createAlimentacionConsultarPanel();
                break;
            case "RESIDUOS AGREGAR":
                panel = createResiduosAgregarPanel();
                break;
            case "RESIDUOS MODIFICAR":
                panel = createResiduosModificarPanel();
                break;
            case "RESIDUOS CONSULTAR":
                panel = createResiduosConsultarPanel();
                break;
        }

        if (panel != null) {
            rightPanel.removeAll();
            rightPanel.add(panel);
            rightPanel.revalidate();
            rightPanel.repaint();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    // Método para crear botones del menú con colores personalizados
    private JButton createMenuButton(String text, String iconPath, Color defaultColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Verdana", Font.BOLD, 18)); // Cambio a negrita para mejor visibilidad
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setBackground(defaultColor);
        button.setForeground(Color.WHITE);

        // Cambiar color cuando se haga clic
        button.addActionListener(e -> {
            button.setBackground(new Color(255, 140, 0));  // Naranja
            button.repaint(); // Forzar la actualización del color
            resetButtonColors(button); // Restablecer colores de los demás botones
        });

        return button;
    }

// Método para restablecer el color de fondo de los botones, excluyendo los de INICIO y CERRAR
    private void resetButtonColors(JButton clickedButton) {
        for (Component comp : menuPanel.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                // Cambiar esta línea
                if (button != inicioButton && button != clickedButton) {  // Eliminar la referencia a cerrarButton
                    button.setBackground(new Color(128, 0, 128)); // Morado
                    button.repaint();
                }
            }
        }
    }

    ///////para el calculo de huella de carbono de transporte/////
    private double resultadoHuellaTransporte = 0.0;
    private double resultadoHuellaEnergia = 0.0;
    private double resultadoHuellaAlimentacion = 0.0;
    private double resultadoHuellaResiduos = 0.0;

/////////////////////////////////////////////////LOS PANELES/////////////////////////////////////////////////////////////////////////////// 
//////////////////////////////////PARA EL TRANSPORTE//////////////////////////////////
// Métodos para crear los paneles específicos de cada opción
    private JPanel createTransporteAgregarPanel() {
        // Crear los campos de texto y combos
        JTextField txtHorasTransporte = new JTextField();
        JTextField txtKilometros = new JTextField();
        String[] mediosTransporte = {"Seleccione...", "Automóvil", "Moto", "Combi", "Metropolitano", "Bus"};
        JComboBox<String> comboMedioTransporte = new JComboBox<>(mediosTransporte);
        String[] mediosUtilizados = {"Seleccione...", "Avión", "Bus", "Automóvil"};
        JComboBox<String> comboMedioUtilizado = new JComboBox<>(mediosUtilizados);
        JButton btnSiguiente = new JButton("GUARDAR");

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("AGREGAR DATOS DE TRANSPORTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        titulo.setPreferredSize(new Dimension(panel.getWidth(), 40));
        titulo.setBorder(BorderFactory.createLineBorder(new Color(0, 191, 255), 3));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaños
        txtHorasTransporte.setPreferredSize(new Dimension(300, 40));
        txtKilometros.setPreferredSize(new Dimension(300, 40));
        comboMedioTransporte.setPreferredSize(new Dimension(300, 40));
        comboMedioUtilizado.setPreferredSize(new Dimension(300, 40));

        // Configurar fuentes
        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        Font textoEtiqueta = new Font("Arial", Font.PLAIN, 30);

        txtHorasTransporte.setFont(textoCampo);
        txtKilometros.setFont(textoCampo);
        comboMedioTransporte.setFont(textoCampo);
        comboMedioUtilizado.setFont(textoCampo);

        // Crear y configurar etiquetas
        JLabel labelHoras = new JLabel("Horas en transporte a la semana:");
        JLabel labelKilometros = new JLabel("Kilómetros recorridos a la semana:");
        JLabel labelMedioTransporte = new JLabel("Medio de transporte más frecuente:");
        JLabel labelMedioUtilizado = new JLabel("Medio de transporte más utilizado:");

        labelHoras.setFont(textoEtiqueta);
        labelKilometros.setFont(textoEtiqueta);
        labelMedioTransporte.setFont(textoEtiqueta);
        labelMedioUtilizado.setFont(textoEtiqueta);

        // Agregar componentes al panel
        gbc.anchor = GridBagConstraints.CENTER;
        textPanel.add(labelHoras, gbc);
        gbc.gridy = 1;
        textPanel.add(txtHorasTransporte, gbc);

        gbc.gridy = 2;
        textPanel.add(labelKilometros, gbc);
        gbc.gridy = 3;
        textPanel.add(txtKilometros, gbc);

        gbc.gridy = 4;
        textPanel.add(labelMedioTransporte, gbc);
        gbc.gridy = 5;
        textPanel.add(comboMedioTransporte, gbc);

        gbc.gridy = 6;
        textPanel.add(labelMedioUtilizado, gbc);
        gbc.gridy = 7;
        textPanel.add(comboMedioUtilizado, gbc);

        // Configurar botón guardar
        ImageIcon icon = new ImageIcon("Imagenes/guardar.png");
        btnSiguiente.setText("GUARDAR");
        btnSiguiente.setIcon(icon);
        btnSiguiente.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSiguiente.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSiguiente.setBackground(new Color(0, 191, 255));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 24));
        btnSiguiente.setPreferredSize(new Dimension(300, 100));
        btnSiguiente.setFocusPainted(false);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnSiguiente);

        // Agregar paneles al panel principal
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboMedioTransporte.getSelectedIndex() == 0
                            || comboMedioUtilizado.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione todos los campos");
                        return;
                    }

                    // Obtener los valores de los campos
                    int horasTransporte = Integer.parseInt(txtHorasTransporte.getText());
                    double kilometros = Double.parseDouble(txtKilometros.getText());
                    String medioTransporte = comboMedioTransporte.getSelectedItem().toString();
                    String medioUtilizado = comboMedioUtilizado.getSelectedItem().toString();

                    // Usar la fábrica para crear el objeto DatosTransporte
                    FabricaDatosTransporte fabrica = new FabricaDatosTransporte();
                    DatosTransporte datosTransporte = fabrica.crearDatosTransporte(
                            horasTransporte,
                            kilometros,
                            medioTransporte,
                            medioUtilizado
                    );

                    // Calcular la huella de carbono usando el método calcularHuellaCarbono
                    resultadoHuellaTransporte = datosTransporte.calcularHuellaCarbono();

                    // Usar el DAO a través del controlador facade
                    TransporteDAO transporteDAO = new TransporteDAO();
                    transporteDAO.insertarTransporte(datosTransporte);

                    // Notificar a los observadores si es necesario
                    datosTransporte.notificarObservadores();

                    JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON ÉXITO");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingresa valores numéricos válidos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error al guardar los datos: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return panel;
    }

    private JPanel createTransporteModificarPanel() {
        // Crear los campos de texto
        JTextField txtId = new JTextField();
        JTextField txtHorasTransporte = new JTextField();
        JTextField txtKilometros = new JTextField();
        String[] mediosTransporte = {"Seleccione...", "Automóvil", "Moto", "Combi", "Metropolitano", "Bus"};
        JComboBox<String> comboMedioTransporte = new JComboBox<>(mediosTransporte);
        String[] mediosUtilizados = {"Seleccione...", "Avión", "Bus", "Automóvil"};
        JComboBox<String> comboMedioUtilizado = new JComboBox<>(mediosUtilizados);
        JButton btnCargar = new JButton("CARGAR");
        JButton btnModificar = new JButton("MODIFICAR");

        // Crear instancias necesarias
        TransporteDAO transporteDAO = new TransporteDAO();
        FabricaDatosTransporte fabrica = new FabricaDatosTransporte();

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("MODIFICAR DATOS DE TRANSPORTE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaños
        txtId.setPreferredSize(new Dimension(300, 40));
        txtHorasTransporte.setPreferredSize(new Dimension(300, 40));
        txtKilometros.setPreferredSize(new Dimension(300, 40));
        comboMedioTransporte.setPreferredSize(new Dimension(300, 40));
        comboMedioUtilizado.setPreferredSize(new Dimension(300, 40));

        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtId.setFont(textoCampo);
        txtHorasTransporte.setFont(textoCampo);
        txtKilometros.setFont(textoCampo);
        comboMedioTransporte.setFont(textoCampo);
        comboMedioUtilizado.setFont(textoCampo);

        // Etiquetas
        textPanel.add(new JLabel("ID del Transporte:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        textPanel.add(new JLabel("Horas en transporte:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtHorasTransporte, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        textPanel.add(new JLabel("Kilómetros recorridos:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtKilometros, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        textPanel.add(new JLabel("Medio de transporte frecuente:"), gbc);
        gbc.gridx = 1;
        textPanel.add(comboMedioTransporte, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        textPanel.add(new JLabel("Medio de transporte utilizado:"), gbc);
        gbc.gridx = 1;
        textPanel.add(comboMedioUtilizado, gbc);

        // Crear el observer
        TransporteObserver observer = new TransporteObserver() {
            @Override
            public void actualizar(DatosTransporte datos) {
                txtHorasTransporte.setText(String.valueOf(datos.getHorasTransporte()));
                txtKilometros.setText(String.valueOf(datos.getKilometrosRecorridos()));
                comboMedioTransporte.setSelectedItem(datos.getMedioTransporteFrecuencia());
                comboMedioUtilizado.setSelectedItem(datos.getMedioTransporteUso());
            }
        };

// Botón para cargar datos
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtId.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un ID");
                        return;
                    }

                    int idBuscado = Integer.parseInt(txtId.getText());
                    DatosTransporte datos = transporteDAO.obtenerTransportePorId(idBuscado);

                    if (datos != null) {
                        // Notificar al observer existente
                        datos.agregarObservador(observer);
                        datos.notificarObservadores();
                        JOptionPane.showMessageDialog(null, "Datos cargados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el transporte con ID: " + idBuscado);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID válido.");
                }
            }
        });

        // Botón de modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboMedioTransporte.getSelectedIndex() == 0
                            || comboMedioUtilizado.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Por favor seleccione todos los campos");
                        return;
                    }

                    int id = Integer.parseInt(txtId.getText());

                    // Usar la fábrica para crear el objeto DatosTransporte
                    DatosTransporte datosTransporte = fabrica.crearDatosTransporte(
                            Integer.parseInt(txtHorasTransporte.getText()),
                            Double.parseDouble(txtKilometros.getText()),
                            comboMedioTransporte.getSelectedItem().toString(),
                            comboMedioUtilizado.getSelectedItem().toString()
                    );

                    // Agregar el observer
                    datosTransporte.agregarObservador(observer);

                    // Actualizar en la base de datos usando el DAO
                    transporteDAO.actualizarTransporte(id, datosTransporte);

                    JOptionPane.showMessageDialog(null, "Transporte modificado con éxito.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingresa valores numéricos válidos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Error al modificar los datos: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCargar);
        buttonPanel.add(btnModificar);

        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createTransporteConsultarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Crear el botón "Consultar Transporte"
        JButton btnConsultarTransporte = new JButton("Consultar Transporte");
        btnConsultarTransporte.setFont(new Font("Arial", Font.BOLD, 20));
        btnConsultarTransporte.setBackground(new Color(128, 0, 128)); // Morado
        btnConsultarTransporte.setForeground(Color.WHITE);
        btnConsultarTransporte.setFocusPainted(false);

        // Botón de imprimir
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 20));
        btnImprimir.setBackground(new Color(128, 0, 128)); // Morado
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnConsultarTransporte);
        buttonPanel.add(btnImprimir);

        // Agregar el panel del botón a la parte superior
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Acción del botón Consultar
        btnConsultarTransporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón Consultar Transporte presionado");
                JTable table = obtenerDatosTransporte();
                if (table.getRowCount() > 0) {
                    JScrollPane scrollPane = new JScrollPane(table);
                    panel.add(scrollPane, BorderLayout.CENTER);
                    panel.revalidate();
                    panel.repaint();

                    // Acción del botón Imprimir
                    btnImprimir.addActionListener(printEvent -> {
                        try {
                            // Configurar la impresión para ajustar a una página
                            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH,
                                    new MessageFormat("Datos de Transporte"),
                                    new MessageFormat("Página - {0}"));
                            if (complete) {
                                JOptionPane.showMessageDialog(panel, "Impresión completada.");
                            } else {
                                JOptionPane.showMessageDialog(panel, "Impresión cancelada.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(panel, "Error al imprimir: " + ex.getMessage());
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(panel, "No se encontraron datos de transporte.");
                }
            }
        });

        return panel;
    }

    private JTable obtenerDatosTransporte() {
        TransporteDAO transporteDAO = new TransporteDAO();
        Object[][] data = transporteDAO.obtenerDatosTransporte(); // Método que debes implementar
        String[] columnNames = {"ID Usuario", "Nombre", "Apellido", "Correo", "ID Transporte", "Horas Transporte", "Kilómetros", "Medio Frecuente", "Medio Utilizado"};

        return new JTable(data, columnNames);
    }

    //////////////////////////////////PARA LA ENERGIA//////////////////////////////////
    private double calcularHuellaCarbono(double montoElectricidad, int balonesGas, double montoGasNatural) {
        double huellaElectricidad = montoElectricidad * 0.5;
        double huellaGas = balonesGas * 3.5;
        double huellaMontogas = montoGasNatural * 0.3;
        return huellaElectricidad + huellaGas + huellaMontogas;
    }

    private JPanel createEnergiaAgregarPanel() {
        // Crear los campos de texto y el botón
        JTextField txtMontoElectricidad = new JTextField();
        JTextField txtBalonesGas = new JTextField();
        JTextField txtMontoGasNatural = new JTextField();
        JButton btnSiguiente = new JButton("GUARDAR");

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("AGREGAR DATOS DE ENERGÍA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        titulo.setPreferredSize(new Dimension(panel.getWidth(), 40));
        titulo.setBorder(BorderFactory.createLineBorder(new Color(0, 191, 255), 3));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaño y fuente de los campos
        txtMontoElectricidad.setPreferredSize(new Dimension(300, 40));
        txtBalonesGas.setPreferredSize(new Dimension(300, 40));
        txtMontoGasNatural.setPreferredSize(new Dimension(300, 40));

        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtMontoElectricidad.setFont(textoCampo);
        txtBalonesGas.setFont(textoCampo);
        txtMontoGasNatural.setFont(textoCampo);

        Font textoEtiqueta = new Font("Arial", Font.PLAIN, 30);
        JLabel labelElectricidad = new JLabel("Monto por electricidad (soles):");
        JLabel labelBalonesGas = new JLabel("Número de balones de gas de 10 kg:");
        JLabel labelGasNatural = new JLabel("Monto por gas natural (soles):");

        labelElectricidad.setFont(textoEtiqueta);
        labelBalonesGas.setFont(textoEtiqueta);
        labelGasNatural.setFont(textoEtiqueta);

        // Alinear los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        textPanel.add(labelElectricidad, gbc);
        gbc.gridy = 1;
        textPanel.add(txtMontoElectricidad, gbc);

        gbc.gridy = 2;
        textPanel.add(labelBalonesGas, gbc);
        gbc.gridy = 3;
        textPanel.add(txtBalonesGas, gbc);

        gbc.gridy = 4;
        textPanel.add(labelGasNatural, gbc);
        gbc.gridy = 5;
        textPanel.add(txtMontoGasNatural, gbc);

        // Configurar el botón guardar
        ImageIcon icon = new ImageIcon("Imagenes/guardar.png");
        btnSiguiente.setText("GUARDAR");
        btnSiguiente.setIcon(icon);
        btnSiguiente.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSiguiente.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSiguiente.setBackground(new Color(0, 191, 255));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 24));
        btnSiguiente.setPreferredSize(new Dimension(300, 100));
        btnSiguiente.setFocusPainted(false);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnSiguiente);

        // Agregar paneles al panel principal
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Acción del botón
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double montoElectricidad = Double.parseDouble(txtMontoElectricidad.getText());
                    int balonesGas = Integer.parseInt(txtBalonesGas.getText());
                    double montoGasNatural = Double.parseDouble(txtMontoGasNatural.getText());

                    // Crear y usar el contexto de energía
                    ContextoEnergia contexto = new ContextoEnergia();

                    // Calcular la huella de carbono
                    resultadoHuellaEnergia = calcularHuellaCarbono(montoElectricidad, balonesGas, montoGasNatural);

                    contexto.procesarDatos(montoElectricidad, balonesGas, montoGasNatural);

                    // Verificar el estado final
                    if (contexto.getEstado() instanceof EstadoGuardadoEnergia) {
                        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON ÉXITO");
                    } else if (contexto.getEstado() instanceof EstadoErrorEnergia) {
                        JOptionPane.showMessageDialog(null, "Error al guardar los datos",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos.");
                }
            }
        });

        return panel;
    }

    private JPanel createEnergiaModificarPanel() {
        // Crear los campos de texto
        JTextField txtId = new JTextField();
        JTextField txtMontoElectricidad = new JTextField();
        JTextField txtBalonesGas = new JTextField();
        JTextField txtMontoGasNatural = new JTextField();
        JButton btnCargar = new JButton("CARGAR");
        JButton btnModificar = new JButton("MODIFICAR");

        // Crear instancias necesarias
        EnergiaDAO energiaDAO = new EnergiaDAO();

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("MODIFICAR DATOS DE ENERGÍA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaños
        Dimension fieldSize = new Dimension(300, 40);
        txtId.setPreferredSize(fieldSize);
        txtMontoElectricidad.setPreferredSize(fieldSize);
        txtBalonesGas.setPreferredSize(fieldSize);
        txtMontoGasNatural.setPreferredSize(fieldSize);

        // Establecer fuente
        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtId.setFont(textoCampo);
        txtMontoElectricidad.setFont(textoCampo);
        txtBalonesGas.setFont(textoCampo);
        txtMontoGasNatural.setFont(textoCampo);

        // Agregar campos al panel
        textPanel.add(new JLabel("ID de Energía:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        textPanel.add(new JLabel("Monto Electricidad:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtMontoElectricidad, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        textPanel.add(new JLabel("Balones de Gas:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtBalonesGas, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        textPanel.add(new JLabel("Monto Gas Natural:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtMontoGasNatural, gbc);

        // Botón para cargar datos
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtId.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un ID");
                        return;
                    }

                    int idBuscado = Integer.parseInt(txtId.getText());
                    DatosEnergia datos = energiaDAO.obtenerEnergiaPorId(idBuscado);

                    if (datos != null) {
                        txtMontoElectricidad.setText(String.valueOf(datos.getMontoelect()));
                        txtBalonesGas.setText(String.valueOf(datos.getBalones10kg()));
                        txtMontoGasNatural.setText(String.valueOf(datos.getMontogas()));
                        JOptionPane.showMessageDialog(null, "Datos cargados con éxito");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la energía con ID: " + idBuscado);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID válido.");
                }
            }
        });

        // Botón de modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    double montoElectricidad = Double.parseDouble(txtMontoElectricidad.getText());
                    int balonesGas = Integer.parseInt(txtBalonesGas.getText());
                    double montoGasNatural = Double.parseDouble(txtMontoGasNatural.getText());

                    energiaDAO.actualizarEnergia(id, montoElectricidad, balonesGas, montoGasNatural);
                    JOptionPane.showMessageDialog(null, "Energía modificada con éxito.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingresa valores numéricos válidos.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Panel para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCargar);
        buttonPanel.add(btnModificar);

        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createEnergiaConsultarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JButton btnConsultarEnergia = new JButton("Consultar Energía");
        btnConsultarEnergia.setFont(new Font("Arial", Font.BOLD, 20));
        btnConsultarEnergia.setBackground(new Color(128, 0, 128));
        btnConsultarEnergia.setForeground(Color.WHITE);
        btnConsultarEnergia.setFocusPainted(false);

        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 20));
        btnImprimir.setBackground(new Color(128, 0, 128));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnConsultarEnergia);
        buttonPanel.add(btnImprimir);

        panel.add(buttonPanel, BorderLayout.NORTH);

        btnConsultarEnergia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = obtenerDatosEnergia();
                if (table.getRowCount() > 0) {
                    JScrollPane scrollPane = new JScrollPane(table);
                    panel.add(scrollPane, BorderLayout.CENTER);
                    panel.revalidate();
                    panel.repaint();

                    btnImprimir.addActionListener(printEvent -> {
                        try {
                            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH,
                                    new MessageFormat("Datos de Energía"),
                                    new MessageFormat("Página - {0}"));
                            if (complete) {
                                JOptionPane.showMessageDialog(panel, "Impresión completada.");
                            } else {
                                JOptionPane.showMessageDialog(panel, "Impresión cancelada.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(panel, "Error al imprimir: " + ex.getMessage());
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(panel, "No se encontraron datos de energía.");
                }
            }
        });

        return panel;
    }

    private JTable obtenerDatosEnergia() {
        EnergiaDAO energiaDAO = new EnergiaDAO();
        Object[][] data = energiaDAO.obtenerDatosEnergia();
        String[] columnNames = {"ID Usuario", "Nombre", "Apellido", "Correo", "ID Energía", "Electricidad", "Balones Gas", "Gas Natural"};

        return new JTable(data, columnNames);
    }

    //////////////////////////////////PARA LA ALIMENTACION//////////////////////////////////
    private JPanel createAlimentacionAgregarPanel() {
        // Crear el panel para "Agregar Alimentación"
        // Crear los campos de texto y el botón
        JTextField txtRes = new JTextField();
        JTextField txtPollo = new JTextField();
        JTextField txtHuevos = new JTextField();
        JTextField txtLeche = new JTextField();
        JTextField txtFrutasVerduras = new JTextField();
        JButton btnSiguiente = new JButton("GUARDAR");

        // Controlador Facade
        ControladorFacade controlador = new ControladorFacade();

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("AGREGAR DATOS DE ALIMENTACIÓN", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255)); // Celeste
        titulo.setPreferredSize(new Dimension(panel.getWidth(), 40));
        titulo.setBorder(BorderFactory.createLineBorder(new Color(0, 191, 255), 3));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaño y fuente de los JTextFields
        txtRes.setPreferredSize(new Dimension(300, 40));
        txtPollo.setPreferredSize(new Dimension(300, 40));
        txtHuevos.setPreferredSize(new Dimension(300, 40));
        txtLeche.setPreferredSize(new Dimension(300, 40));
        txtFrutasVerduras.setPreferredSize(new Dimension(300, 40));

        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtRes.setFont(textoCampo);
        txtPollo.setFont(textoCampo);
        txtHuevos.setFont(textoCampo);
        txtLeche.setFont(textoCampo);
        txtFrutasVerduras.setFont(textoCampo);

        Font textoEtiqueta = new Font("Arial", Font.PLAIN, 30);
        JLabel labelRes = new JLabel("Res (kg):");
        JLabel labelPollo = new JLabel("Pollo (kg):");
        JLabel labelHuevos = new JLabel("Huevos (kg):");
        JLabel labelLeche = new JLabel("Leche (litros):");
        JLabel labelFrutasVerduras = new JLabel("Frutas y Verduras (kg):");

        labelRes.setFont(textoEtiqueta);
        labelPollo.setFont(textoEtiqueta);
        labelHuevos.setFont(textoEtiqueta);
        labelLeche.setFont(textoEtiqueta);
        labelFrutasVerduras.setFont(textoEtiqueta);

        // Alinear los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        textPanel.add(labelRes, gbc);
        gbc.gridy = 1;
        textPanel.add(txtRes, gbc);

        gbc.gridy = 2;
        textPanel.add(labelPollo, gbc);
        gbc.gridy = 3;
        textPanel.add(txtPollo, gbc);

        gbc.gridy = 4;
        textPanel.add(labelHuevos, gbc);
        gbc.gridy = 5;
        textPanel.add(txtHuevos, gbc);

        gbc.gridy = 6;
        textPanel.add(labelLeche, gbc);
        gbc.gridy = 7;
        textPanel.add(txtLeche, gbc);

        gbc.gridy = 8;
        textPanel.add(labelFrutasVerduras, gbc);
        gbc.gridy = 9;
        textPanel.add(txtFrutasVerduras, gbc);

        // Botón de guardar
        ImageIcon icon = new ImageIcon("Imagenes/guardar.png");  // Reemplaza con la ruta de la imagen
        btnSiguiente.setText("GUARDAR");
        btnSiguiente.setIcon(icon);
        btnSiguiente.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSiguiente.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSiguiente.setBackground(new Color(0, 191, 255));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 24));
        btnSiguiente.setPreferredSize(new Dimension(300, 100));
        btnSiguiente.setFocusPainted(false);

        // Panel para el botón
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnSiguiente);

        // Agregar paneles al panel principal
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Acción del botón
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double res = Double.parseDouble(txtRes.getText());
                    double pollo = Double.parseDouble(txtPollo.getText());
                    double huevos = Double.parseDouble(txtHuevos.getText());
                    double leche = Double.parseDouble(txtLeche.getText());
                    double frutasVerduras = Double.parseDouble(txtFrutasVerduras.getText());

                    // Crear el consumo usando la fábrica
                    Consumo consumo = ConsumoFactory.crearConsumo(res, pollo, huevos, leche, frutasVerduras);

                    // Calcular la huella de carbono
                    resultadoHuellaAlimentacion = consumo.calcularHuellaCarbono();
                    
                    // Crear y ejecutar el comando
                    ConsumoCommandInvoker invoker = new ConsumoCommandInvoker();
                    ICommandConsumo guardarCommand = new GuardarConsumoCommand(consumo, controlador);
                    invoker.executeCommand(guardarCommand);

                    JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CON ÉXITO");

                    // Si necesitas deshacer:
                    // invoker.undo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos.");
                }
            }
        });

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SistemaPrincipalCarbono().setVisible(true));
    }

    private JPanel createAlimentacionModificarPanel() {
        // Crear los campos de texto
        JTextField txtId = new JTextField(); // Campo para el ID del consumo
        JTextField txtRes = new JTextField();
        JTextField txtPollo = new JTextField();
        JTextField txtHuevos = new JTextField();
        JTextField txtLeche = new JTextField();
        JTextField txtFrutasVerduras = new JTextField();
        JButton btnCargar = new JButton("CARGAR");
        JButton btnModificar = new JButton("MODIFICAR");

        // Controlador Facade
        ControladorFacade controlador = new ControladorFacade();

        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Título de la sección
        JLabel titulo = new JLabel("MODIFICAR DATOS DE ALIMENTACIÓN", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaño y fuente de los JTextFields
        txtId.setPreferredSize(new Dimension(300, 40));
        txtRes.setPreferredSize(new Dimension(300, 40));
        txtPollo.setPreferredSize(new Dimension(300, 40));
        txtHuevos.setPreferredSize(new Dimension(300, 40));
        txtLeche.setPreferredSize(new Dimension(300, 40));
        txtFrutasVerduras.setPreferredSize(new Dimension(300, 40));

        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtId.setFont(textoCampo);
        txtRes.setFont(textoCampo);
        txtPollo.setFont(textoCampo);
        txtHuevos.setFont(textoCampo);
        txtLeche.setFont(textoCampo);
        txtFrutasVerduras.setFont(textoCampo);

        // Etiquetas
        textPanel.add(new JLabel("ID del Consumo:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        textPanel.add(new JLabel("Res (kg):"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtRes, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        textPanel.add(new JLabel("Pollo (kg):"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtPollo, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        textPanel.add(new JLabel("Huevos (kg):"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtHuevos, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        textPanel.add(new JLabel("Leche (litros):"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtLeche, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        textPanel.add(new JLabel("Frutas y Verduras (kg):"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtFrutasVerduras, gbc);

        // Botón para cargar datos
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    Consumo consumo = controlador.obtenerConsumo(id);
                    if (consumo != null) {
                        txtRes.setText(String.valueOf(consumo.getRes()));
                        txtPollo.setText(String.valueOf(consumo.getPollo()));
                        txtHuevos.setText(String.valueOf(consumo.getHuevos()));
                        txtLeche.setText(String.valueOf(consumo.getLeche()));
                        txtFrutasVerduras.setText(String.valueOf(consumo.getFrutasVerduras()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Consumo no encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID válido.");
                }
            }
        });

        // Botón de modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double res = Double.parseDouble(txtRes.getText());
                    double pollo = Double.parseDouble(txtPollo.getText());
                    double huevos = Double.parseDouble(txtHuevos.getText());
                    double leche = Double.parseDouble(txtLeche.getText());
                    double frutasVerduras = Double.parseDouble(txtFrutasVerduras.getText());

                    // Crear un nuevo objeto Consumo
                    Consumo consumo = new Consumo();
                    consumo.setIdConsumo(Integer.parseInt(txtId.getText())); // Establecer el ID
                    consumo.setRes(res);
                    consumo.setPollo(pollo);
                    consumo.setHuevos(huevos);
                    consumo.setLeche(leche);
                    consumo.setFrutasVerduras(frutasVerduras);

                    // Actualizar en la base de datos
                    controlador.modificarConsumo(consumo);

                    JOptionPane.showMessageDialog(null, "Consumo modificado con éxito.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos.");
                }
            }
        });

        // Agregar botones al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCargar);
        buttonPanel.add(btnModificar);

        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createAlimentacionConsultarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Crear el botón "Consultar Consumo"
        JButton btnConsultarConsumo = new JButton("Consultar Consumo");
        btnConsultarConsumo.setFont(new Font("Arial", Font.BOLD, 20));
        btnConsultarConsumo.setBackground(new Color(128, 0, 128)); // Morado
        btnConsultarConsumo.setForeground(Color.WHITE);
        btnConsultarConsumo.setFocusPainted(false);

        // Botón de imprimir
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 20));
        btnImprimir.setBackground(new Color(128, 0, 128)); // Morado
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnConsultarConsumo);
        buttonPanel.add(btnImprimir);

        // Agregar el panel del botón a la parte superior
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Acción del botón Consultar
        btnConsultarConsumo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = obtenerDatosConsumo();
                if (table.getRowCount() > 0) {
                    JScrollPane scrollPane = new JScrollPane(table);
                    panel.add(scrollPane, BorderLayout.CENTER);
                    panel.revalidate();
                    panel.repaint();

                    // Acción del botón Imprimir
                    btnImprimir.addActionListener(printEvent -> {
                        try {
                            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH,
                                    new MessageFormat("Datos de Consumo"),
                                    new MessageFormat("Página - {0}"));
                            if (complete) {
                                JOptionPane.showMessageDialog(panel, "Impresión completada.");
                            } else {
                                JOptionPane.showMessageDialog(panel, "Impresión cancelada.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(panel, "Error al imprimir: " + ex.getMessage());
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(panel, "No se encontraron datos de consumo.");
                }
            }
        });

        return panel;
    }

    private JTable obtenerDatosConsumo() {
        ConsumoDAO consumoDAO = new ConsumoDAO();
        Object[][] data = consumoDAO.obtenerDatosConsumo();
        String[] columnNames = {"ID Usuario", "Nombre", "Apellido", "Correo", "ID Consumo", "Res", "Pollo", "Huevos", "Leche", "Frutas y Verduras"};

        return new JTable(data, columnNames);
    }

    //////////////////////////////////PARA EL RESIDUO//////////////////////////////////
    private JPanel createResiduosAgregarPanel() {
        // Constructor para crear el panel
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE); // Fondo blanco para el panel

        // Definir fuentes y colores
        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        Font textoEtiqueta = new Font("Arial", Font.PLAIN, 24);
        Color colorCeleste = new Color(0, 191, 255);

        // Título de la sección
        JLabel titulo = new JLabel("AGREGAR DATOS DE RESIDUOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(colorCeleste);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado
        panel.add(titulo, gbc);

        // Crear los componentes
        JLabel lblBolsas3kg = new JLabel("Bolsas de residuos (3kg):");
        JTextField txtBolsas3kg = new JTextField();
        JLabel lblBolsas6kg = new JLabel("Bolsas de residuos (6kg):");
        JTextField txtBolsas6kg = new JTextField();
        JLabel lblBolsas10kg = new JLabel("Bolsas de residuos (10kg):");
        JTextField txtBolsas10kg = new JTextField();
        JLabel lblTipoResiduos = new JLabel("¿Qué tipo de residuos reciclas?");
        String[] tiposResiduos = {"Seleccione...", "Vidrio", "Plástico", "Aluminio", "Ninguno"};
        JComboBox<String> comboTipoResiduos = new JComboBox<>(tiposResiduos);
        JButton btnGuardar = new JButton("GUARDAR");

        // Establecer los estilos de los JTextField
        txtBolsas3kg.setFont(textoCampo);
        txtBolsas6kg.setFont(textoCampo);
        txtBolsas10kg.setFont(textoCampo);
        txtBolsas3kg.setPreferredSize(new Dimension(300, 40));
        txtBolsas6kg.setPreferredSize(new Dimension(300, 40));
        txtBolsas10kg.setPreferredSize(new Dimension(300, 40));

        // Establecer los estilos de las etiquetas (JLabel)
        lblBolsas3kg.setFont(textoEtiqueta);
        lblBolsas6kg.setFont(textoEtiqueta);
        lblBolsas10kg.setFont(textoEtiqueta);
        lblTipoResiduos.setFont(textoEtiqueta);

        // Establecer el tamaño del JComboBox
        comboTipoResiduos.setPreferredSize(new Dimension(300, 40));
        comboTipoResiduos.setFont(textoCampo);

        // Añadir etiquetas y campos de texto al panel
        gbc.gridwidth = 1; // Restablecer a una columna
        gbc.gridy = 1;
        panel.add(lblBolsas3kg, gbc);
        gbc.gridy = 2;
        panel.add(txtBolsas3kg, gbc);

        gbc.gridy = 3;
        panel.add(lblBolsas6kg, gbc);
        gbc.gridy = 4;
        panel.add(txtBolsas6kg, gbc);

        gbc.gridy = 5;
        panel.add(lblBolsas10kg, gbc);
        gbc.gridy = 6;
        panel.add(txtBolsas10kg, gbc);

        gbc.gridy = 7;
        panel.add(lblTipoResiduos, gbc);
        gbc.gridy = 8;
        panel.add(comboTipoResiduos, gbc);

        // Configurar el botón
        ImageIcon icon = new ImageIcon("/Imagenes/guardar.png"); // Reemplaza con la ruta de la imagen
        btnGuardar.setIcon(icon);
        btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnGuardar.setBackground(colorCeleste);
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 24));
        btnGuardar.setPreferredSize(new Dimension(300, 100));
        btnGuardar.setFocusPainted(false);

        // Panel para el botón y centrado
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnGuardar);
        gbc.gridy = 9; // Fila para el botón
        panel.add(buttonPanel, gbc);

        // Acción del botón "Guardar"
        ResiduosDAO residuosDAO = new ResiduosDAO();
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarCampos(txtBolsas3kg, txtBolsas6kg, txtBolsas10kg, comboTipoResiduos)) {
                    try {
                        int bolsas3kg = Integer.parseInt(txtBolsas3kg.getText().trim());
                        int bolsas6kg = Integer.parseInt(txtBolsas6kg.getText().trim());
                        int bolsas10kg = Integer.parseInt(txtBolsas10kg.getText().trim());
                        String tipoResiduos = comboTipoResiduos.getSelectedItem().toString();

                        DatosResiduos datosResiduos = new DatosResiduos(bolsas3kg, bolsas6kg, bolsas10kg, tipoResiduos);
                        
                        // Calcular la huella de carbono de residuos
                        resultadoHuellaResiduos = datosResiduos.calcularHuellaCarbono();
                        
                        ResiduosCommandInvoker invoker = new ResiduosCommandInvoker();
                        ICommandResiduos guardarCommand = new GuardarResiduosCommand(datosResiduos, residuosDAO);
                        invoker.executeCommand(guardarCommand);

                        JOptionPane.showMessageDialog(panel, "DATOS GUARDADOS CON ÉXITO");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(panel, "Por favor ingrese valores numéricos válidos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        return panel;
    }

// Función de validación de campos
    private boolean validarCampos(JTextField txtBolsas3kg, JTextField txtBolsas6kg, JTextField txtBolsas10kg, JComboBox<String> comboTipoResiduos) {
        if (txtBolsas3kg.getText().isEmpty() || txtBolsas6kg.getText().isEmpty() || txtBolsas10kg.getText().isEmpty()
                || comboTipoResiduos.getSelectedItem().equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private JPanel createResiduosModificarPanel() {
        // Crear los campos de texto
        JTextField txtId = new JTextField(); // Campo para el ID de residuos
        JTextField txtBolsas3kg = new JTextField();
        JTextField txtBolsas6kg = new JTextField();
        JTextField txtBolsas10kg = new JTextField();
        JComboBox<String> comboTipoResiduos = new JComboBox<>(new String[]{"Seleccione...", "Vidrio", "Plástico", "Aluminio", "Ninguno"});
        JButton btnCargar = new JButton("CARGAR");
        JButton btnModificar = new JButton("MODIFICAR");

        // Instancia del DAO
        ResiduosDAO residuosDAO = new ResiduosDAO();

        // Crear el panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Título de la sección
        JLabel titulo = new JLabel("MODIFICAR DATOS DE RESIDUOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(new Color(0, 191, 255));
        panel.add(titulo, BorderLayout.NORTH);

        // Crear el panel para los campos de texto
        JPanel textPanel = new JPanel(new GridBagLayout());
        textPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 20);

        // Establecer tamaño y fuente de los JTextFields
        Dimension fieldSize = new Dimension(300, 40);
        txtId.setPreferredSize(fieldSize);
        txtBolsas3kg.setPreferredSize(fieldSize);
        txtBolsas6kg.setPreferredSize(fieldSize);
        txtBolsas10kg.setPreferredSize(fieldSize);
        comboTipoResiduos.setPreferredSize(fieldSize);

        Font textoCampo = new Font("Arial", Font.PLAIN, 16);
        txtId.setFont(textoCampo);
        txtBolsas3kg.setFont(textoCampo);
        txtBolsas6kg.setFont(textoCampo);
        txtBolsas10kg.setFont(textoCampo);
        comboTipoResiduos.setFont(textoCampo);

        // Etiquetas
        textPanel.add(new JLabel("ID de Residuos:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        textPanel.add(new JLabel("Bolsas de 3kg:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtBolsas3kg, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        textPanel.add(new JLabel("Bolsas de 6kg:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtBolsas6kg, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        textPanel.add(new JLabel("Bolsas de 10kg:"), gbc);
        gbc.gridx = 1;
        textPanel.add(txtBolsas10kg, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        textPanel.add(new JLabel("Tipo de Residuos:"), gbc);
        gbc.gridx = 1;
        textPanel.add(comboTipoResiduos, gbc);

        // Botón para cargar datos
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    DatosResiduos residuos = residuosDAO.obtenerResiduosPorId(id);
                    if (residuos != null) {
                        txtBolsas3kg.setText(String.valueOf(residuos.getBolsas3kg()));
                        txtBolsas6kg.setText(String.valueOf(residuos.getBolsas6kg()));
                        txtBolsas10kg.setText(String.valueOf(residuos.getBolsas10kg()));
                        comboTipoResiduos.setSelectedItem(residuos.getTipoResiduos());
                    } else {
                        JOptionPane.showMessageDialog(null, "Residuos no encontrados.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID válido.");
                }
            }
        });

        // Botón de modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bolsas3kg = Integer.parseInt(txtBolsas3kg.getText());
                    int bolsas6kg = Integer.parseInt(txtBolsas6kg.getText());
                    int bolsas10kg = Integer.parseInt(txtBolsas10kg.getText());
                    String tipoResiduos = comboTipoResiduos.getSelectedItem().toString();

                    DatosResiduos nuevosDatos = new DatosResiduos(bolsas3kg, bolsas6kg, bolsas10kg, tipoResiduos);
                    ResiduosCommandInvoker invoker = new ResiduosCommandInvoker();
                    ICommandResiduos modificarCommand = new ModificarResiduosCommand(Integer.parseInt(txtId.getText()), nuevosDatos, residuosDAO);
                    invoker.executeCommand(modificarCommand);

                    JOptionPane.showMessageDialog(null, "Datos de residuos modificados con éxito.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa valores numéricos válidos.");
                }
            }
        });

        // Agregar botones al panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCargar);
        buttonPanel.add(btnModificar);

        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createResiduosConsultarPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        // Botón para consultar residuos
        JButton btnConsultarResiduos = new JButton("Consultar Residuos");
        btnConsultarResiduos.setFont(new Font("Arial", Font.BOLD, 20));
        btnConsultarResiduos.setBackground(new Color(128, 0, 128)); // Morado
        btnConsultarResiduos.setForeground(Color.WHITE);
        btnConsultarResiduos.setFocusPainted(false);

        // Botón para imprimir
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.setFont(new Font("Arial", Font.BOLD, 20));
        btnImprimir.setBackground(new Color(128, 0, 128)); // Morado
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setFocusPainted(false);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(btnConsultarResiduos);
        buttonPanel.add(btnImprimir);

        panel.add(buttonPanel, BorderLayout.NORTH);

        // Acción del botón Consultar
        btnConsultarResiduos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = obtenerDatosResiduos();
                if (table.getRowCount() > 0) {
                    JScrollPane scrollPane = new JScrollPane(table);
                    panel.add(scrollPane, BorderLayout.CENTER);
                    panel.revalidate();
                    panel.repaint();

                    // Acción del botón Imprimir
                    btnImprimir.addActionListener(printEvent -> {
                        try {
                            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH,
                                    new MessageFormat("Datos de Residuos"),
                                    new MessageFormat("Página - {0}"));
                            if (complete) {
                                JOptionPane.showMessageDialog(panel, "Impresión completada.");
                            } else {
                                JOptionPane.showMessageDialog(panel, "Impresión cancelada.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(panel, "Error al imprimir: " + ex.getMessage());
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(panel, "No se encontraron datos de residuos.");
                }
            }
        });

        return panel;
    }

    private JTable obtenerDatosResiduos() {
        ResiduosDAO residuosDAO = new ResiduosDAO();
        Object[][] data = residuosDAO.obtenerDatosResiduos();
        String[] columnNames = {"ID Usuario", "Nombre", "Apellido", "Correo", "ID Residuos", "Bolsas 3kg", "Bolsas 6kg", "Bolsas 10kg", "Tipo de Residuos"};

        return new JTable(data, columnNames);
    }

    //////////////////////////////////PARA EL CALCULO//////////////////////////////////
    private void showCalculationsPanel() {
        // Instancias del Originator y Caretaker
    OriginatorCalculo originator = new OriginatorCalculo();
    CaretakerCalculo caretaker = new CaretakerCalculo();

    JPanel calculosPanel = new JPanel();
    calculosPanel.setBackground(Color.LIGHT_GRAY);
    calculosPanel.setLayout(new BorderLayout());

    JLabel titulo = new JLabel("RESULTADO DE CÁLCULO DE HUELLA DE CARBONO", SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 40));
    titulo.setForeground(new Color(128, 0, 128));
    calculosPanel.add(titulo, BorderLayout.NORTH);

    // Calculando el total de la huella de carbono
    double resultadoHuellaGeneral = resultadoHuellaTransporte + resultadoHuellaEnergia
            + resultadoHuellaAlimentacion + resultadoHuellaResiduos;

    // Guardar el estado actual en el Memento
    originator.setEstado(resultadoHuellaGeneral);
    MementoCalculo memento = originator.createMemento();
    caretaker.addMemento(memento);  // Guardar el estado en el Caretaker

    // Crear el panel de resultados
    JPanel resultadoPanel = new JPanel();
    resultadoPanel.setBackground(Color.LIGHT_GRAY);
    resultadoPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;

    
    JLabel etiquetaResultado = new JLabel("Tu huella de carbono general es:", SwingConstants.CENTER);
    etiquetaResultado.setFont(new Font("Arial", Font.PLAIN, 24));
    resultadoPanel.add(etiquetaResultado, gbc);

    gbc.gridy++;
    JTextField campoResultado = new JTextField(String.valueOf(resultadoHuellaGeneral));
    campoResultado.setFont(new Font("Arial", Font.PLAIN, 24));
    campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
    campoResultado.setEditable(false);
    campoResultado.setPreferredSize(new Dimension(300, 50));
    resultadoPanel.add(campoResultado, gbc);

   
    gbc.gridy++;
    JProgressBar progressBar = new JProgressBar(0, 900);
    progressBar.setValue((int) resultadoHuellaGeneral);
    progressBar.setStringPainted(true);
    progressBar.setPreferredSize(new Dimension(1500, 40));

    // Color de la barra de progreso según el valor
    if (resultadoHuellaGeneral <= 250) {
        progressBar.setForeground(Color.GREEN);
    } else if (resultadoHuellaGeneral <= 600) {
        progressBar.setForeground(Color.ORANGE);
    } else {
        progressBar.setForeground(Color.RED);
    }

    resultadoPanel.add(progressBar, gbc);

    gbc.gridy++;
    JLabel mensaje = new JLabel();
    mensaje.setFont(new Font("Verdana", Font.PLAIN, 18));
    mensaje.setHorizontalAlignment(SwingConstants.CENTER);

    // Mostrar recomendaciones según el nivel de la huella
    if (resultadoHuellaGeneral <= 100) {
        mensaje.setText("<html><center>Tu huella de carbono es baja. ¡Sigue así!<br>"
                + "Continúa con hábitos de transporte ecológicos, utilizando más energía renovable y minimizando el consumo de productos de alto impacto.<br>"
                + "Considera pequeños cambios adicionales, como optimizar el uso de electricidad en casa y compartir estos consejos con familiares y amigos para promover un estilo de vida sostenible.<br>"
                + "Procura reducir el uso de plásticos desechables, aprovechar el compostaje en tus residuos orgánicos, y optar por productos locales y ecológicos cuando hagas tus compras.<br>"
                + "Además, podrías considerar apoyar iniciativas locales de conservación ambiental o participar en programas de voluntariado ecológico para fortalecer tu compromiso con el planeta.</center></html>");
    } else if (resultadoHuellaGeneral <= 300) {
        mensaje.setText("<html><center>Tu huella de carbono es moderada. <br>"
                + "Considera reducir el uso de vehículos privados, aumentar la eficiencia energética de tu hogar, y consumir más alimentos locales y de bajo impacto ambiental.<br>"
                + "Piensa en alternativas de transporte más sostenibles, como caminar, andar en bicicleta, o compartir tu vehículo para reducir tu huella.<br>"
                + "También puedes mejorar el aislamiento en casa para disminuir el consumo de calefacción o aire acondicionado y elegir productos con menos embalaje.<br>"
                + "Este es un buen momento para evaluar tus patrones de consumo y reducir la compra de productos innecesarios o de alto impacto.</center></html>");
    } else {
        mensaje.setText("<html><center>Tu huella de carbono es alta. <br>"
                + "¡Es hora de tomar acción! Cambia tu estilo de vida a uno más sostenible. Usa transporte público o alternativo, reduce el consumo de carne y busca alternativas de energía limpia.<br>"
                + "Considera reducir significativamente tu consumo de energía en casa, opta por electrodomésticos eficientes y evita dejar los dispositivos en espera.<br>"
                + "Aumenta tu consumo de alimentos de origen vegetal, ya que tienen un menor impacto ambiental en comparación con los productos de origen animal.<br>"
                + "Participa en programas de reciclaje y reutiliza siempre que sea posible. Pequeños cambios diarios pueden generar un gran impacto en tu huella.</center></html>");
    }

    resultadoPanel.add(mensaje, gbc);

    
    gbc.gridy++;
    JLabel textoDias = new JLabel("<html><center>Los valores de huella de carbono son cálculos para un periodo de 7 días.</center></html>");
    textoDias.setFont(new Font("Arial", Font.ITALIC, 14));
    textoDias.setHorizontalAlignment(SwingConstants.CENTER);
    resultadoPanel.add(textoDias, gbc);

    
    gbc.gridy++;
    ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/login_2.jpeg"));
    Image image = imagen.getImage().getScaledInstance(500, 160, Image.SCALE_SMOOTH);
    JLabel imagenLabel = new JLabel(new ImageIcon(image));
    resultadoPanel.add(imagenLabel, gbc);

    
    calculosPanel.add(resultadoPanel, BorderLayout.CENTER);

    // Espacio inferior
    JPanel emptyPanel = new JPanel();
    emptyPanel.setPreferredSize(new Dimension(1, 10));
    calculosPanel.add(emptyPanel, BorderLayout.SOUTH);

    // Actualizar el contenido
    contentPanel.removeAll();
    contentPanel.add(calculosPanel);
    contentPanel.revalidate();
    contentPanel.repaint();
    }

}
