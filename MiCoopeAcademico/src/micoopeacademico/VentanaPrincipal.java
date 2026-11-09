// Ventana principal del sistema Mi Coope Académico.
// Permite iniciar sesión como asociado o agente administrativo.

package micoopeacademico;
import javax.swing.SwingUtilities;
public class VentanaPrincipal extends javax.swing.JFrame {
    private final SistemaBeneficios sistema = new SistemaBeneficios();
   
    // Preparamos la ventana, sus campos y el botón para iniciar sesión.
    public VentanaPrincipal() {
        initComponents();
        lblUsuario.setLabelFor(txtUsuario);
        lblContrasena.setLabelFor(txtContrasena);
        getRootPane().setDefaultButton(btnIngresar);
        btnIngresar.addActionListener(evento -> iniciarSesion());
        setSize(820, 550);
        setLocationRelativeTo(null);
    }

    // Revisamos las credenciales y mostramos la pantalla del rol correspondiente.
    private void iniciarSesion() {
        try {
            if (!sistema.iniciarSesion(txtUsuario.getText(), new String(txtContrasena.getPassword()))) {
                lblError.setText("Usuario o contraseña incorrectos.");
                txtContrasena.setText("");
                txtContrasena.requestFocusInWindow();
                return;
            }

            if (sistema.getUsuarioActual().getRol() == RolUsuario.ASOCIADO) {
                VentanaCatalogo catalogo = new VentanaCatalogo(sistema);
                catalogo.setBounds(getBounds());
                catalogo.setVisible(true);
                dispose();
            } else {
                lblTitulo.setText("Sesión iniciada");
                lblDetalle.setText(datosSesion(sistema));
                panelAcceso.setVisible(false);
                getRootPane().setDefaultButton(null);
            }
        } catch (IllegalArgumentException ex) {
            lblError.setText(ex.getMessage());
        }
    }

    static String datosSesion(SistemaBeneficios sistema) {
        Usuario usuario = sistema.getUsuarioActual();
        return "Usuario: " + usuario.getNombreUsuario() + " | Rol: " + usuario.getRol();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        panelCuerpo = new javax.swing.JPanel();
        panelAcceso = new javax.swing.JPanel();
        lblDatos = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        lblAcceso = new javax.swing.JLabel();

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
        lblTitulo.setText("Inicio de sesión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 22, 8, 22);
        panelPrincipal.add(lblTitulo, gridBagConstraints);

        lblDetalle.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        lblDetalle.setForeground(new java.awt.Color(72, 83, 93));
        lblDetalle.setText("Ingrese con su cuenta de asociado o de agente administrativo.");
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

        panelCuerpo.setOpaque(false);
        panelCuerpo.setLayout(new java.awt.GridBagLayout());

        panelAcceso.setOpaque(false);
        panelAcceso.setLayout(new java.awt.GridBagLayout());

        lblDatos.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblDatos.setText("Datos de acceso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panelAcceso.add(lblDatos, gridBagConstraints);

        lblUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblUsuario.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        panelAcceso.add(lblUsuario, gridBagConstraints);

        txtUsuario.setColumns(27);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panelAcceso.add(txtUsuario, gridBagConstraints);

        lblContrasena.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblContrasena.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        panelAcceso.add(lblContrasena, gridBagConstraints);

        txtContrasena.setColumns(27);
        txtContrasena.addActionListener(this::txtContrasenaActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panelAcceso.add(txtContrasena, gridBagConstraints);

        lblError.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(151, 38, 43));
        lblError.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panelAcceso.add(lblError, gridBagConstraints);

        btnIngresar.setBackground(new java.awt.Color(46, 89, 119));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panelAcceso.add(btnIngresar, gridBagConstraints);

        lblAcceso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblAcceso.setForeground(new java.awt.Color(72, 83, 93));
        lblAcceso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAcceso.setText("Acceso para asociados y agentes.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        panelAcceso.add(lblAcceso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panelCuerpo.add(panelAcceso, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 22, 22, 22);
        panelPrincipal.add(panelCuerpo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panelPrincipal, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelAcceso;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSeparator separador;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
