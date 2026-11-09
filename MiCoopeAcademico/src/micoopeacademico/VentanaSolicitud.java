package micoopeacademico;
import javax.swing.JOptionPane;

// Ventana donde el asociado puede solicitar un beneficio,
// indicar el procedimiento realizado y enviar su solicitud.
public class VentanaSolicitud extends javax.swing.JFrame {
    private final SistemaBeneficios sistema;
    private final VentanaCatalogo catalogo;
    private final Beneficio beneficio;

    // Recibimos los datos del sistema y del beneficio seleccionado
    // para mostrarlos en el formulario de solicitud.
    VentanaSolicitud(SistemaBeneficios sistema, VentanaCatalogo catalogo, Beneficio beneficio) {
        this.sistema = sistema;
        this.catalogo = catalogo;
        this.beneficio = beneficio;
        initComponents();
        lblDetalle.setText(VentanaPrincipal.datosSesion(sistema));
        lblNombre.setText(beneficio.getNombre());
        txtDescripcion.setText(beneficio.getDescripcion());
        lblMotivo.setLabelFor(txtMotivo);
        getRootPane().setDefaultButton(btnRegistrar);
        btnRegistrar.addActionListener(evento -> registrarSolicitud());
        btnCancelar.addActionListener(evento -> volverAlCatalogo());
    }

    // Guardamos la solicitud y mostramos un mensaje de confirmación.
    // Si falta información, avisamos al asociado para que la complete.
    private void registrarSolicitud() {
        Solicitud solicitud;
        try {
            solicitud = sistema.registrarSolicitud(beneficio.getCodigo(), txtMotivo.getText());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Nueva solicitud",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Tu solicitud N.º " + solicitud.getNumero()
                + " fue recibida y será revisada por la cooperativa.",
                "Solicitud enviada correctamente",
                JOptionPane.INFORMATION_MESSAGE);
        volverAlCatalogo();
    }

    private void volverAlCatalogo() {
        catalogo.setBounds(getBounds());
        catalogo.setVisible(true);
        dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        lblSeleccionado = new javax.swing.JLabel();
        panelBeneficio = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextArea();
        lblMotivo = new javax.swing.JLabel();
        scrollMotivo = new javax.swing.JScrollPane();
        txtMotivo = new javax.swing.JTextArea();
        lblEstado = new javax.swing.JLabel();
        panelAcciones = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

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
        lblEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 22, 10, 22));
        lblEncabezado.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelPrincipal.add(lblEncabezado, gridBagConstraints);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setText("Nueva solicitud");
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

        lblSeleccionado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSeleccionado.setText("Beneficio seleccionado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 7, 22);
        panelPrincipal.add(lblSeleccionado, gridBagConstraints);

        panelBeneficio.setBackground(new java.awt.Color(236, 240, 244));
        panelBeneficio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 216, 222)));
        panelBeneficio.setLayout(new java.awt.GridBagLayout());

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblNombre.setText("Nombre del beneficio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 14);
        panelBeneficio.add(lblNombre, gridBagConstraints);

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(38);
        txtDescripcion.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(72, 83, 93));
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(2);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setFocusable(false);
        txtDescripcion.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 14, 10, 14);
        panelBeneficio.add(txtDescripcion, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 16, 22);
        panelPrincipal.add(panelBeneficio, gridBagConstraints);

        lblMotivo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblMotivo.setText("Indique brevemente el servicio que se realizó");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 7, 22);
        panelPrincipal.add(lblMotivo, gridBagConstraints);

        txtMotivo.setColumns(28);
        txtMotivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMotivo.setLineWrap(true);
        txtMotivo.setRows(5);
        txtMotivo.setWrapStyleWord(true);
        scrollMotivo.setViewportView(txtMotivo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 16, 22);
        panelPrincipal.add(scrollMotivo, gridBagConstraints);

        lblEstado.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(72, 83, 93));
        lblEstado.setText("La solicitud será enviada para su revisión y aprobación.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 12, 22);
        panelPrincipal.add(lblEstado, gridBagConstraints);

        panelAcciones.setOpaque(false);
        panelAcciones.setLayout(new java.awt.GridBagLayout());

        btnRegistrar.setBackground(new java.awt.Color(46, 89, 119));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar solicitud");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        panelAcciones.add(btnRegistrar, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        panelAcciones.add(btnCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 22, 22);
        panelPrincipal.add(panelAcciones, gridBagConstraints);

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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblMotivo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeleccionado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelBeneficio;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JScrollPane scrollMotivo;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextArea txtMotivo;
    // End of variables declaration//GEN-END:variables
}
