package formularios;

import clases.Datos;
import clases.DesktopConFondo;
import com.bulenkov.darcula.DarculaLaf;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class frmPrincipal extends javax.swing.JFrame {

    private Datos misDatos;
    private int perfil;
    private String clave;
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        //String titulo = "Sistema de Facturación - Usuario: " + this.usuario;
        /*if (perfil == 1) {
            titulo = titulo + " - Perfil: Administrador";
        } else {
            titulo = titulo + " - Perfil: Usuario";
        }*/
        //this.setTitle(titulo);
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDatos(Datos d) {
        this.misDatos = d;
    }

    public frmPrincipal() {
        initComponents();
        setIcono();
        cerrar(); //añadimos el listener de cierre al constructor
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new DesktopConFondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuArchivoClientes = new javax.swing.JMenuItem();
        mnuArchivoProductos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoUsuarios = new javax.swing.JMenuItem();
        mnuArchivoCambioClave = new javax.swing.JMenuItem();
        mnuArchivoCambioUsuario = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoSalir = new javax.swing.JMenuItem();
        mnuMovimientos = new javax.swing.JMenu();
        mnuMovimientosNuevaFactura = new javax.swing.JMenuItem();
        mnuMovimientosReporteFacturas = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaAcercaDe = new javax.swing.JMenuItem();
        mnuAyudaAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Facturación");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnEscritorio.setBackground(new java.awt.Color(143, 143, 143));
        dpnEscritorio.setForeground(new java.awt.Color(132, 132, 132));

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/archivo.png"))); // NOI18N
        mnuArchivo.setText("Archivo");

        mnuArchivoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        mnuArchivoClientes.setText("Clientes");
        mnuArchivoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoClientesActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoClientes);

        mnuArchivoProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/products.png"))); // NOI18N
        mnuArchivoProductos.setText("Productos");
        mnuArchivoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoProductosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoProductos);
        mnuArchivo.add(jSeparator1);

        mnuArchivoUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/users2.png"))); // NOI18N
        mnuArchivoUsuarios.setText("Usuarios");
        mnuArchivoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoUsuariosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoUsuarios);

        mnuArchivoCambioClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change_pass.png"))); // NOI18N
        mnuArchivoCambioClave.setText("Cambio Clave");
        mnuArchivoCambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoCambioClaveActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoCambioClave);

        mnuArchivoCambioUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change_user.png"))); // NOI18N
        mnuArchivoCambioUsuario.setText("Cambio Usuario");
        mnuArchivoCambioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoCambioUsuarioActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoCambioUsuario);
        mnuArchivo.add(jSeparator2);

        mnuArchivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuArchivoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        mnuArchivoSalir.setText("Salir");
        mnuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoSalir);

        jMenuBar1.add(mnuArchivo);

        mnuMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/movimientos.png"))); // NOI18N
        mnuMovimientos.setText("Movimientos");

        mnuMovimientosNuevaFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invoice.png"))); // NOI18N
        mnuMovimientosNuevaFactura.setText("Nueva Factura");
        mnuMovimientosNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosNuevaFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosNuevaFactura);

        mnuMovimientosReporteFacturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        mnuMovimientosReporteFacturas.setText("Reporte Facturas");
        mnuMovimientosReporteFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosReporteFacturasActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosReporteFacturas);

        jMenuBar1.add(mnuMovimientos);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ayuda.png"))); // NOI18N
        mnuAyuda.setText("Ayuda");

        mnuAyudaAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        mnuAyudaAcercaDe.setText("Acerca de...");
        mnuAyudaAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAcercaDe);

        mnuAyudaAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        mnuAyudaAyuda.setText("Ayuda");
        mnuAyuda.add(mnuAyudaAyuda);

        jMenuBar1.add(mnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuArchivoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoClientesActionPerformed
        try {
            frmClientes misClientes = new frmClientes();
            misClientes.setDatos(misDatos);
            misClientes.setSize(805, 600);
            dpnEscritorio.add(misClientes);
            Dimension dpnSize = dpnEscritorio.getSize();
            Dimension frameSize = misClientes.getSize();
            misClientes.setLocation(
            (dpnSize.width - frameSize.width) / 2,
            (dpnSize.height - frameSize.height) / 2);
            misClientes.setMaximum(true);
            misClientes.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArchivoClientesActionPerformed

    private void mnuMovimientosReporteFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosReporteFacturasActionPerformed
        frmReporteFacturas misReportes = new frmReporteFacturas();
        misReportes.setDatos(misDatos);
        dpnEscritorio.add(misReportes);
        //este metodo devuelve el tamaño de la pantalla
        Dimension dpnSize = dpnEscritorio.getSize();
        //obtenemos el tamaño de la ventana
        Dimension frameSize = misReportes.getSize();
        //para centrar la ventana lo hacemos con el siguiente calculo
        misReportes.setLocation(
                (dpnSize.width - frameSize.width) / 2,
                (dpnSize.height - frameSize.height) / 2);

        misReportes.show();
    }//GEN-LAST:event_mnuMovimientosReporteFacturasActionPerformed

    private void mnuArchivoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoUsuariosActionPerformed
        try {
            frmUsuarios misUsuarios = new frmUsuarios();
            misUsuarios.setDatos(misDatos);
            dpnEscritorio.add(misUsuarios);
            Dimension dpnSize = dpnEscritorio.getSize();
            Dimension frameSize = misUsuarios.getSize();
            misUsuarios.setLocation(
                    (dpnSize.width - frameSize.width) / 2,
                    (dpnSize.height - frameSize.height) / 2);
            misUsuarios.setMaximum(true);
            misUsuarios.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArchivoUsuariosActionPerformed

    private void mnuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoSalirActionPerformed
        salir();
    }//GEN-LAST:event_mnuArchivoSalirActionPerformed

    private void mnuArchivoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoProductosActionPerformed
        try {
            frmProductos misProductos = new frmProductos();
            misProductos.setDatos(misDatos);
            dpnEscritorio.add(misProductos);
            //Centramos el formulario
            Dimension dpnSize = dpnEscritorio.getSize();
            Dimension frameSize = misProductos.getSize();
            misProductos.setLocation(
                    (dpnSize.width - frameSize.width) / 2,
                    (dpnSize.height - frameSize.height) / 2);
            misProductos.setMaximum(true);
            misProductos.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuArchivoProductosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Establece la imagen de fondo
        ((DesktopConFondo) dpnEscritorio).setImagen("/images/fondo.jpg");

        //Establece permisos
        if (perfil == 2) { //Si es empleado eliminamos permisos
            mnuArchivoClientes.setEnabled(false);
            mnuArchivoProductos.setEnabled(false);
            mnuArchivoUsuarios.setEnabled(false);
            mnuMovimientosReporteFacturas.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void mnuArchivoCambioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoCambioUsuarioActionPerformed
        //Ocultamos el formulario principal
        this.setVisible(false);
        frmLogin miLogin = new frmLogin();
        miLogin.setDatos(misDatos);
        miLogin.setCambioUsuario(true);
        
        //Centramos el formulario en pantalla
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);
    }//GEN-LAST:event_mnuArchivoCambioUsuarioActionPerformed

    private void mnuArchivoCambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoCambioClaveActionPerformed
        frmCambioClave miCambio = new frmCambioClave(this, rootPaneCheckingEnabled);
        miCambio.setClave(clave);
        miCambio.setUsuario(usuario);
        miCambio.setDatos(misDatos);
        //Mostramos el formulario cambioClave centrado en la pantalla
        miCambio.setLocationRelativeTo(this);
        miCambio.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuArchivoCambioClaveActionPerformed

    private void mnuAyudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAcercaDeActionPerformed
        frmAcercaDe acercaDe = new frmAcercaDe(this, rootPaneCheckingEnabled);
        acercaDe.setLocationRelativeTo(this);
        acercaDe.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuAyudaAcercaDeActionPerformed

    private void mnuMovimientosNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosNuevaFacturaActionPerformed
        try {
            frmFactura miFactura = new frmFactura();
            miFactura.setDatos(misDatos);
            dpnEscritorio.add(miFactura);
            //Centramos el formulario
            Dimension dpnSize = dpnEscritorio.getSize();
            Dimension frameSize = miFactura.getSize();
            miFactura.setLocation(
                    (dpnSize.width - frameSize.width) / 2,
                    (dpnSize.height - frameSize.height) / 2);
            miFactura.setMaximum(true);
            miFactura.show();
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuMovimientosNuevaFacturaActionPerformed

    public void loadTheme() {
        try {
            UIManager.setLookAndFeel(new DarculaLaf());

        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void setIcono() {
        // obtenemos la ruta de la imagen
        URL url = getClass().getResource("/images/32x32.png");
        ImageIcon img = new ImageIcon(url);
        // ponemos la imagen como icono
        setIconImage(img.getImage());
    }

    public final void cerrar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    salir();
                }
            });
        } catch (Exception e) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void salir() {
        Object[] options = {"Sí", "No"};
        int respuesta = JOptionPane.showOptionDialog(
                rootPane,
                "¿Está seguro de salir de la aplicación?",
                "Salir de la aplicación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, options, options[1]);
        if (respuesta != 0) {
            return;
        }
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuArchivoCambioClave;
    private javax.swing.JMenuItem mnuArchivoCambioUsuario;
    private javax.swing.JMenuItem mnuArchivoClientes;
    private javax.swing.JMenuItem mnuArchivoProductos;
    private javax.swing.JMenuItem mnuArchivoSalir;
    private javax.swing.JMenuItem mnuArchivoUsuarios;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaAcercaDe;
    private javax.swing.JMenuItem mnuAyudaAyuda;
    private javax.swing.JMenu mnuMovimientos;
    private javax.swing.JMenuItem mnuMovimientosNuevaFactura;
    private javax.swing.JMenuItem mnuMovimientosReporteFacturas;
    // End of variables declaration//GEN-END:variables
}
