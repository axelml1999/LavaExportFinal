/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CargoController;
import Controller.ExtrasController;
import Utilerias.CambiaPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RojeruSan
 */
public class Pn_Extras extends javax.swing.JPanel {

    ExtrasController ec = new ExtrasController();
    String accion;
    int id;
    String descripcion;

    /**
     * Creates new form pnlHome
     */
    public Pn_Extras() {
        initComponents();
        RowApariencia();
        RowHeaderApariencia();

        bloquearComponentes();
        ComponenteNoEditable();
        cargarTabla();
        tamañoTabla();

    }

    public void cargarTabla() {
        DefaultTableModel tb = ec.tablaExtras();
        jt_Extras.setModel(tb);
        tamañoTabla();
    }
    
     public void tamañoTabla() {
        TableColumnModel columnModel = jt_Extras.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);

    }

    public void bloquearComponentes() {

        t_extra.setEnabled(false);
        bt_agregar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_nuevo.setEnabled(true);
        bt_agregar.setText("Agregar");

    }

    public void desbloquearComponentes() {

        t_extra.setEnabled(true);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        bt_nuevo.setEnabled(false);
    }

    public void desbloquear_item() {

        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_agregar.setText("Actualizar");
    }

    public void ComponenteNoEditable() {

        t_extra.setEditable(false);

    }

    public void ComponenteEditable() {

        t_extra.setEditable(true);

    }

    public void limpiarCampos() {

        t_extra.setText("Ingrese Extra");
        id = 0;
        descripcion = "";
        bt_agregar.setText("Guardar");

        t_extra.setText("Ingrese Evtra");
        id = 0;
        descripcion = "";

    }

    public Boolean validarEscritura() {
        Boolean val = true;
        //si el textfield tiene algo diferente a Vacío aparecerá de color negro
        if (!(t_extra.getText().equals("Ingrese Extra")) && !(t_extra.getText().equals(""))) {
            t_extra.setBorder(null);
            lb_errorExtra.setText("");
        } else {

            t_extra.setBorder(new LineBorder(Color.RED, 1));
            lb_errorExtra.setText("Ingrese un Extra válido");

            val = false;
        }
        return val;
    }

    public Boolean quitarBordeError() {
        Boolean val = true;

        if (!(t_extra.getText().equals(""))) {
            t_extra.setBorder(null);
            lb_errorExtra.setText("");
        } else {
            val = false;
        }
        return val;
    }

    public void limpiarErrores() {
        lb_errorCampos.setText("");
        lb_errorExtra.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        t_extra = new javax.swing.JTextField();
        lb_errorExtra = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bt_eliminar = new Utilerias.RSButtonMetro();
        bt_cancelar = new Utilerias.RSButtonMetro();
        bt_agregar = new Utilerias.RSButtonMetro();
        jSeparator7 = new javax.swing.JSeparator();
        lb_errorCampos = new javax.swing.JLabel();
        bt_nuevo = new Utilerias.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Extras = new javax.swing.JTable();
        t_empleado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();

        jSeparator6.setBackground(new java.awt.Color(128, 128, 131));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconExtrasDescuentos.png"))); // NOI18N
        jLabel8.setText("Módulo de Extras");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 860, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Extras");

        t_extra.setForeground(new java.awt.Color(153, 153, 153));
        t_extra.setText("Ingrese Extra");
        t_extra.setBorder(null);
        t_extra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_extraFocusLost(evt);
            }
        });
        t_extra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_extraMouseClicked(evt);
            }
        });
        t_extra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_extraActionPerformed(evt);
            }
        });
        t_extra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_extraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(t_extra, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(lb_errorExtra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(t_extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_errorExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 360, 70));

        jSeparator2.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1040, 10));

        bt_eliminar.setBackground(new java.awt.Color(97, 212, 195));
        bt_eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarBlue.png"))); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_eliminar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_eliminar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_eliminar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_eliminar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_eliminar.setIconTextGap(15);
        bt_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_eliminarMouseClicked(evt);
            }
        });
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });
        add(bt_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 140, -1));

        bt_cancelar.setBackground(new java.awt.Color(97, 212, 195));
        bt_cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelBlue.png"))); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_cancelar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_cancelar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_cancelar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_cancelar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_cancelar.setIconTextGap(10);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 140, -1));

        bt_agregar.setBackground(new java.awt.Color(97, 212, 195));
        bt_agregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_agregar.setForeground(new java.awt.Color(255, 255, 255));
        bt_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus24x24.png"))); // NOI18N
        bt_agregar.setText("Guardar");
        bt_agregar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_agregar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_agregar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_agregar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_agregar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_agregar.setIconTextGap(10);
        bt_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_agregarMouseClicked(evt);
            }
        });
        bt_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregarActionPerformed(evt);
            }
        });
        add(bt_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 140, -1));

        jSeparator7.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 20, 470));

        lb_errorCampos.setForeground(new java.awt.Color(255, 51, 51));
        add(lb_errorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 260, 20));

        bt_nuevo.setBackground(new java.awt.Color(97, 212, 195));
        bt_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario32x32Blue.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setColorBorde(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_nuevo.setColorHover(new java.awt.Color(128, 128, 131));
        bt_nuevo.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_nuevo.setColorTextHover(new java.awt.Color(153, 255, 255));
        bt_nuevo.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_nuevo.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_nuevo.setIconTextGap(10);
        bt_nuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_nuevoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bt_nuevoFocusLost(evt);
            }
        });
        bt_nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nuevoMouseClicked(evt);
            }
        });
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });
        add(bt_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 140, -1));

        jt_Extras.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_Extras.getTableHeader().setReorderingAllowed(false);
        jt_Extras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt_ExtrasFocusGained(evt);
            }
        });
        jt_Extras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_ExtrasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_Extras);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 470, 90));

        t_empleado.setForeground(new java.awt.Color(153, 153, 153));
        t_empleado.setText("Ingrese Extra");
        t_empleado.setBorder(null);
        t_empleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_empleadoFocusLost(evt);
            }
        });
        t_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_empleadoMouseClicked(evt);
            }
        });
        t_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_empleadoActionPerformed(evt);
            }
        });
        t_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_empleadoKeyTyped(evt);
            }
        });
        add(t_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 130, 150, -1));

        jSeparator5.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 180, 10));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Buscar Extras");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
         int filasel = jt_Extras.getSelectedRow();
        id = Integer.parseInt(jt_Extras.getValueAt(filasel, 0).toString());
        ec.eliminar(id);
        cargarTabla();
        limpiarCampos();
        bt_eliminar.setText("Eliminar");
        
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
         bloquearComponentes();
        limpiarCampos();
        quitarBordeError();
        limpiarErrores();

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void t_extraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_extraFocusLost
        if (t_extra.getText().trim().equals("")) {
            t_extra.setText("Ingrese Extra");
            t_extra.setForeground(new Color(153, 153, 153));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_extraFocusLost

    private void t_extraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_extraMouseClicked
        // TODO add your handling code here:

        t_extra.setText("");
    }//GEN-LAST:event_t_extraMouseClicked

    private void t_extraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_extraActionPerformed
        t_extra.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_extraActionPerformed

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        if (!validarEscritura() == true) {

            lb_errorCampos.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");

        } else {
            descripcion = t_extra.getText();
            ec.guardar(accion, id, descripcion);
            cargarTabla();
            lb_errorCampos.setText("");
            limpiarCampos();
            bloquearComponentes();

            //PROGRAMADOR AQUÍ ESCRIBE TU CÓDIGO
            //FIN DEL CÓDIGO DEL PROGRAMADOR
        }
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void t_extraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_extraKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //validador de escitura
        //quitarBordeError();
        //
        if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorExtra.setText("No se admiten números");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorExtra.setText("");
            t_extra.setBorder(null);

        }

    }//GEN-LAST:event_t_extraKeyTyped

    private void bt_nuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusGained

    private void bt_nuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusLost

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed

        accion = "I";
        desbloquearComponentes();
        ComponenteEditable();
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoMouseClicked
        // TODO add your handling code here:
        bt_nuevo.setEnabled(false);
    }//GEN-LAST:event_bt_nuevoMouseClicked

    private void bt_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_agregarMouseClicked

// TODO add your handling code here:

    }//GEN-LAST:event_bt_agregarMouseClicked

    private void bt_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_eliminarMouseClicked
//        int filasel = jt_Extras.getSelectedRow();
        //      id = Integer.parseInt(jt_Extras.getValueAt(filasel, 0).toString());
        //    ec.eliminar(id);

        // TODO add your handling code here:
        //  cargarTabla();
        //limpiarCampos();
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_eliminarMouseClicked

    private void jt_ExtrasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt_ExtrasFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jt_ExtrasFocusGained

    private void t_empleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_empleadoFocusLost
        if (t_empleado.getText().trim().equals("")) {
            t_empleado.setText("Ingrese Extra");
            t_empleado.setForeground(new Color(153, 153, 153));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_empleadoFocusLost

    private void t_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_empleadoMouseClicked
        // TODO add your handling code here:

        t_empleado.setText("");
    }//GEN-LAST:event_t_empleadoMouseClicked

    private void t_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_empleadoActionPerformed
        t_empleado.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_empleadoActionPerformed

    private void jt_ExtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_ExtrasMouseClicked
         // TODO add your handling code here:
        ComponenteEditable();
        //desbloquear_item();
        int filaSel = jt_Extras.getSelectedRow();
        id = Integer.parseInt(jt_Extras.getValueAt(filaSel, 0).toString());
        descripcion = jt_Extras.getValueAt(filaSel, 1).toString();
        t_extra.setText(descripcion);
        accion = "M";
        bt_agregar.setText("Modificar");
        desbloquearComponentes();
    }//GEN-LAST:event_jt_ExtrasMouseClicked

    private void t_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_empleadoKeyTyped
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        filtro(t_empleado.getText(), jt_Extras);
// TODO add your handling code here:
    }//GEN-LAST:event_t_empleadoKeyTyped
    DefaultTableModel dm;

    private void filtro(String consulta, JTable jtableBuscar) {
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

    public void RowApariencia() {
        jt_Extras.setFocusable(false);
        //espacio entre comulnas
        jt_Extras.setIntercellSpacing(new Dimension(0, 1));
        //altura de columnas 
        jt_Extras.setRowHeight(25);
        //margen entre filas
        jt_Extras.setRowMargin(0);
//sin lineas verticles
        jt_Extras.setShowVerticalLines(false);
        jt_Extras.setSelectionBackground(new Color(97, 212, 195));
    }

    public void RowHeaderApariencia() {
        jt_Extras.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        jt_Extras.getTableHeader().setOpaque(false);
        jt_Extras.getTableHeader().setBackground(new Color(97, 212, 195));
        jt_Extras.getTableHeader().setForeground(new Color(255, 255, 255));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utilerias.RSButtonMetro bt_agregar;
    private Utilerias.RSButtonMetro bt_cancelar;
    private Utilerias.RSButtonMetro bt_eliminar;
    private Utilerias.RSButtonMetro bt_nuevo;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jt_Extras;
    private javax.swing.JLabel lb_errorCampos;
    private javax.swing.JLabel lb_errorExtra;
    private javax.swing.JTextField t_empleado;
    private javax.swing.JTextField t_extra;
    // End of variables declaration//GEN-END:variables

}
