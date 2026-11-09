package micoopeacademico;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Ventana donde el asociado puede consultar los beneficios
// disponibles y seleccionar el que desea solicitar.
public class VentanaCatalogo extends javax.swing.JFrame {

    private final SistemaBeneficios sistema;

    VentanaCatalogo(SistemaBeneficios sistema) {
        this.sistema = sistema;
        initComponents();
        lblDetalle.setText(VentanaPrincipal.datosSesion(sistema));
        cargarBeneficios();
    }

    // Recorremos la lista de beneficios y mostramos sus datos
    // en los espacios correspondientes de la ventana. 
    private void cargarBeneficios() {
        ArrayList<Beneficio> beneficios = sistema.consultarBeneficios();
        JLabel[] nombres = {lblNombre1, lblNombre2, lblNombre3};
        JTextArea[] descripciones = {txtDescripcion1, txtDescripcion2, txtDescripcion3};
        JButton[] botones = {btnSolicitar1, btnSolicitar2, btnSolicitar3};

        for (int i = 0; i < beneficios.size(); i++) {
            Beneficio beneficio = beneficios.get(i);
            nombres[i].setText(beneficio.getNombre());
            descripciones[i].setText(beneficio.getDescripcion());
            botones[i].addActionListener(evento -> abrirSolicitud(beneficio));
        }
    }
   // Abrimos el formulario del beneficio seleccionado
   // y ocultamos temporalmente el catálogo.
    private void abrirSolicitud(Beneficio beneficio) {
        VentanaSolicitud solicitud = new VentanaSolicitud(sistema, this, beneficio);
        solicitud.setBounds(getBounds());
        setVisible(false);
        solicitud.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        lblInstruccion = new javax.swing.JLabel();
        panelBeneficio1 = new javax.swing.JPanel();
        lblNombre1 = new javax.swing.JLabel();
        txtDescripcion1 = new javax.swing.JTextArea();
        btnSolicitar1 = new javax.swing.JButton();
        panelBeneficio2 = new javax.swing.JPanel();
        lblNombre2 = new javax.swing.JLabel();
        txtDescripcion2 = new javax.swing.JTextArea();
        btnSolicitar2 = new javax.swing.JButton();
        panelBeneficio3 = new javax.swing.JPanel();
        lblNombre3 = new javax.swing.JLabel();
        txtDescripcion3 = new javax.swing.JTextArea();
        btnSolicitar3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Coope Académico");
        setMinimumSize(new java.awt.Dimension(740, 510));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setBackground(new java.awt.Color(245, 247, 249));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(804, 511));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        lblEncabezado.setBackground(new java.awt.Color(218, 224, 230));
        lblEncabezado.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblEncabezado.setText("Sistema para el trámite de solicitudes de Beneficios para Asociados");
        lblEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lblEncabezado.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelPrincipal.add(lblEncabezado, gridBagConstraints);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Catálogo de beneficios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 22, 8, 22);
        panelPrincipal.add(lblTitulo, gridBagConstraints);

        lblDetalle.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblDetalle.setForeground(new java.awt.Color(72, 83, 93));
        lblDetalle.setText("Usuario:  | Rol: ASOCIADO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 8, 22);
        panelPrincipal.add(lblDetalle, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 16, 22);
        panelPrincipal.add(separador, gridBagConstraints);

        lblInstruccion.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblInstruccion.setForeground(new java.awt.Color(72, 83, 93));
        lblInstruccion.setText("Seleccione el beneficio que desea solicitar.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 12, 22);
        panelPrincipal.add(lblInstruccion, gridBagConstraints);

        panelBeneficio1.setBackground(new java.awt.Color(255, 255, 255));
        panelBeneficio1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBeneficio1.setLayout(new java.awt.GridBagLayout());

        lblNombre1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblNombre1.setText("Beneficio Odontológico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 8);
        panelBeneficio1.add(lblNombre1, gridBagConstraints);

        txtDescripcion1.setEditable(false);
        txtDescripcion1.setColumns(38);
        txtDescripcion1.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtDescripcion1.setForeground(new java.awt.Color(72, 83, 93));
        txtDescripcion1.setLineWrap(true);
        txtDescripcion1.setRows(2);
        txtDescripcion1.setWrapStyleWord(true);
        txtDescripcion1.setFocusable(false);
        txtDescripcion1.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 10, 8);
        panelBeneficio1.add(txtDescripcion1, gridBagConstraints);

        btnSolicitar1.setText("Solicitar");
        btnSolicitar1.setPreferredSize(new java.awt.Dimension(118, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 14);
        panelBeneficio1.add(btnSolicitar1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 12, 22);
        panelPrincipal.add(panelBeneficio1, gridBagConstraints);

        panelBeneficio2.setBackground(new java.awt.Color(255, 255, 255));
        panelBeneficio2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBeneficio2.setLayout(new java.awt.GridBagLayout());

        lblNombre2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblNombre2.setText("Beneficio Oftalmológico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 8);
        panelBeneficio2.add(lblNombre2, gridBagConstraints);

        txtDescripcion2.setEditable(false);
        txtDescripcion2.setColumns(38);
        txtDescripcion2.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtDescripcion2.setForeground(new java.awt.Color(72, 83, 93));
        txtDescripcion2.setLineWrap(true);
        txtDescripcion2.setRows(2);
        txtDescripcion2.setWrapStyleWord(true);
        txtDescripcion2.setFocusable(false);
        txtDescripcion2.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 10, 8);
        panelBeneficio2.add(txtDescripcion2, gridBagConstraints);

        btnSolicitar2.setText("Solicitar");
        btnSolicitar2.setPreferredSize(new java.awt.Dimension(118, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 14);
        panelBeneficio2.add(btnSolicitar2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 12, 22);
        panelPrincipal.add(panelBeneficio2, gridBagConstraints);

        panelBeneficio3.setBackground(new java.awt.Color(255, 255, 255));
        panelBeneficio3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBeneficio3.setLayout(new java.awt.GridBagLayout());

        lblNombre3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblNombre3.setText("Ultrasonido General");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 8);
        panelBeneficio3.add(lblNombre3, gridBagConstraints);

        txtDescripcion3.setEditable(false);
        txtDescripcion3.setColumns(38);
        txtDescripcion3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtDescripcion3.setForeground(new java.awt.Color(72, 83, 93));
        txtDescripcion3.setLineWrap(true);
        txtDescripcion3.setRows(2);
        txtDescripcion3.setWrapStyleWord(true);
        txtDescripcion3.setFocusable(false);
        txtDescripcion3.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 10, 8);
        panelBeneficio3.add(txtDescripcion3, gridBagConstraints);

        btnSolicitar3.setText("Solicitar");
        btnSolicitar3.setPreferredSize(new java.awt.Dimension(118, 34));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 14);
        panelBeneficio3.add(btnSolicitar3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 22, 22);
        panelPrincipal.add(panelBeneficio3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panelPrincipal, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitar1;
    private javax.swing.JButton btnSolicitar2;
    private javax.swing.JButton btnSolicitar3;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblInstruccion;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBeneficio1;
    private javax.swing.JPanel panelBeneficio2;
    private javax.swing.JPanel panelBeneficio3;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextArea txtDescripcion1;
    private javax.swing.JTextArea txtDescripcion2;
    private javax.swing.JTextArea txtDescripcion3;
    // End of variables declaration//GEN-END:variables
}
