/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 *
 * @author RojeruSan
 */
public class Pn_Asistencia extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public Pn_Asistencia() {
        initComponents();
  RowApariencia();
  RowHeaderApariencia();
 
   
 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        t_buscar = new javax.swing.JTextField();
        jb_buscar1 = new Utilerias.RSButtonMetro();
        bt_generar = new Utilerias.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Asistencia = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 950, 10));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconcalendar48x48.png"))); // NOI18N
        jLabel8.setText("Módulo de Asistetencias de Empleados ");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 944, -1));

        jSeparator3.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        t_buscar.setForeground(new java.awt.Color(128, 128, 131));
        t_buscar.setText("Buscar Nómina");
        t_buscar.setBorder(null);
        t_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_buscarFocusLost(evt);
            }
        });
        t_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_buscarMouseClicked(evt);
            }
        });
        t_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_buscarActionPerformed(evt);
            }
        });

        jb_buscar1.setBackground(new java.awt.Color(97, 212, 195));
        jb_buscar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jb_buscar1.setForeground(new java.awt.Color(255, 255, 255));
        jb_buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_icon-111-search_314807.png"))); // NOI18N
        jb_buscar1.setText("Buscar");
        jb_buscar1.setColorNormal(new java.awt.Color(97, 212, 195));
        jb_buscar1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jb_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_buscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jb_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_buscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 360, 60));

        bt_generar.setBackground(new java.awt.Color(97, 212, 195));
        bt_generar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_generar.setForeground(new java.awt.Color(255, 255, 255));
        bt_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus24x24.png"))); // NOI18N
        bt_generar.setText("Generar");
        bt_generar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_generar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_generar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_generar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_generar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_generar.setIconTextGap(10);
        bt_generar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_generarMouseClicked(evt);
            }
        });
        bt_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_generarActionPerformed(evt);
            }
        });
        add(bt_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 130, -1));

        jt_Asistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Valor Aproximado"
            }
        ));
        jt_Asistencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt_AsistenciaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jt_Asistencia);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 960, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void t_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_buscarFocusLost
if (t_buscar.getText().trim().equals("") || t_buscar.getText().trim().toLowerCase().equals("Buscar Nómina")) {
            t_buscar.setText("Buscar Nómina");
            t_buscar.setForeground(new Color(153, 153, 153));

        }        
        // TODO add your handling code here:
    }//GEN-LAST:event_t_buscarFocusLost

    private void t_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_buscarMouseClicked
        
        // TODO add your handling code here:
    }//GEN-LAST:event_t_buscarMouseClicked

    private void t_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_buscarActionPerformed

    private void jb_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_buscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_buscar1ActionPerformed

    private void bt_generarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_generarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_generarMouseClicked

    private void bt_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_generarActionPerformed

    }//GEN-LAST:event_bt_generarActionPerformed

    private void jt_AsistenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_AsistenciaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_AsistenciaFocusGained

 public void RowApariencia() {
        jt_Asistencia.setFocusable(false);
        //espacio entre comulnas
        jt_Asistencia.setIntercellSpacing(new Dimension(0, 1));
        //altura de columnas 
        jt_Asistencia.setRowHeight(25);
        //margen entre filas
        jt_Asistencia.setRowMargin(0);
//sin lineas verticles
        jt_Asistencia.setShowVerticalLines(false);
        jt_Asistencia.setSelectionBackground(new Color(97, 212, 195));
 }
 
         public void RowHeaderApariencia() {

        jt_Asistencia.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        jt_Asistencia.getTableHeader().setOpaque(false);
        jt_Asistencia.getTableHeader().setBackground(new Color(97, 212, 195));
        jt_Asistencia.getTableHeader().setForeground(new Color(255, 255, 255));
    
 
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utilerias.RSButtonMetro bt_generar;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private Utilerias.RSButtonMetro jb_buscar1;
    private javax.swing.JTable jt_Asistencia;
    private javax.swing.JTextField t_buscar;
    // End of variables declaration//GEN-END:variables
}
