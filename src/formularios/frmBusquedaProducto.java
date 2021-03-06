package formularios;

import clases.Datos;
import clases.Utilidades;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class frmBusquedaProducto extends javax.swing.JDialog {
    private DefaultTableModel miTabla;
    private String respuesta = "";
     private Datos misDatos;

     
    public void setDatos(Datos d) {
        this.misDatos = d;
    }
    
    public String getRespuesta() {
        return respuesta;
    }

    public frmBusquedaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Agrupamos los botones para que sean excluyentes
        bgrTipoBusqueda.add(rbtIDProducto);
        bgrTipoBusqueda.add(rbtDescripcion);
    }
    
    private void llenarTabla() {
        String titulos[] = {"Código", "Descripción"};
        String registro[] = new String[2];
        
        miTabla = new DefaultTableModel(null, titulos);
        
        String sql = "";
        ResultSet rs = null;
        //Si no hay texto a buscar, ser cargan todos
        if (txtCriterio.getText().equals("")) {
            sql = "select idProducto, descripcion from productos";
        } else {
            if (rbtDescripcion.isSelected()) {
                sql = "select idProducto, descripcion from productos "
                    + "where descripcion like '%" + txtCriterio.getText() + "%'";
            }
            if (rbtIDProducto.isSelected()) {
                sql = "select idProducto, descripcion from productos "
                    + "where idProducto like '" + txtCriterio.getText() + "'";
            }
        }
        try {
           rs = misDatos.getConsulta(sql);
            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("descripcion");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            Logger.getLogger(frmBusquedaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrTipoBusqueda = new javax.swing.ButtonGroup();
        rbtIDProducto = new javax.swing.JRadioButton();
        rbtDescripcion = new javax.swing.JRadioButton();
        txtCriterio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        rbtIDProducto.setText("Código");
        rbtIDProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIDProductoActionPerformed(evt);
            }
        });

        rbtDescripcion.setSelected(true);
        rbtDescripcion.setText("Descripción");
        rbtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDescripcionActionPerformed(evt);
            }
        });

        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCriterioKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriterioKeyPressed(evt);
            }
        });

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTabla);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept2.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_all.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtIDProducto)
                        .addGap(18, 18, 18)
                        .addComponent(rbtDescripcion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCriterio, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtIDProducto)
                    .addComponent(rbtDescripcion))
                .addGap(18, 18, 18)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Cargamos la tabla con todos los clientes
        llenarTabla();        
        txtCriterio.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void rbtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDescripcionActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        llenarTabla();
    }//GEN-LAST:event_rbtDescripcionActionPerformed

    private void rbtIDProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIDProductoActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        llenarTabla();
    }//GEN-LAST:event_rbtIDProductoActionPerformed

    private void txtCriterioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyTyped
        //llenarTabla();
    }//GEN-LAST:event_txtCriterioKeyTyped

    private void txtCriterioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioKeyPressed

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        llenarTabla();
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        respuesta = "";
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int num = tblTabla.getRowCount();
        if (num == 0) {
            respuesta = "";
            dispose();
            return;
        }
        for (int i = 0; i < num; i++) {
            if (tblTabla.isRowSelected(i)) {
                respuesta = Utilidades.objectToString(tblTabla.getValueAt(i, 0));
                dispose();
                return;
            }
        }
        
        respuesta = Utilidades.objectToString(tblTabla.getValueAt(0, 0));
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmBusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBusquedaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmBusquedaProducto dialog = new frmBusquedaProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrTipoBusqueda;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtDescripcion;
    private javax.swing.JRadioButton rbtIDProducto;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtCriterio;
    // End of variables declaration//GEN-END:variables
}
