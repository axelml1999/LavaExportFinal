/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DepartamentoController;
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
public class Pn_departamento extends javax.swing.JPanel {

    DepartamentoController dc = new DepartamentoController();
    String accion;
    int id;
    String area;
    int capacidad;
    DefaultTableModel dm;
    /**
     * Creates new form pnlHome
     */
    public Pn_departamento() {
        initComponents();
        RowApariencia();
        RowApariencia();
        RowHeaderApariencia();

        bloquearComponentes();
        ComponenteNoEditable();
        cbIndexInicial();
        cargarTabla();
        tamañoTabla();

    }
    
    private void filtro(String consulta, JTable jtableBuscar) {
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    } 

    public void cargarTabla() {
        DefaultTableModel tb = dc.tablaDepartamentos();
        jt_departamentos.setModel(tb);
        tamañoTabla();
    }
    
      public void tamañoTabla() {
        TableColumnModel columnModel = jt_departamentos.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);
        columnModel.getColumn(2).setPreferredWidth(180);

    }
 
    public void bloquearComponentes() {

        t_numtrabajadores.setEnabled(false);
        t_area.setEnabled(false);
        bt_nuevo.setEnabled(true);
        bt_guardar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setText("Guardar");
    }

    public void desbloquearComponentes() {

        t_numtrabajadores.setEnabled(true);
        t_area.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(false);

    }
    public void desbloquear_item(){
        t_numtrabajadores.setEnabled(true);
        t_area.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        bt_guardar.setText("Actualizar");
    }

    public void ComponenteNoEditable() {

        t_numtrabajadores.setEditable(false);
        t_numtrabajadores.setEditable(false);
    }

    public void ComponenteEditable() {

        t_numtrabajadores.setEditable(true);
        t_area.setEditable(true);
    }

    public void cbIndexInicial() {

    }

    public void limpiarCampos() {
        t_numtrabajadores.setText("Ingresar número de trabajadores");
        t_area.setText("Ingresar Area de Labor");
        id=0;
        area="";
        capacidad=0;
    }
    public Boolean validarEscritura() {
        Boolean val = true;
        //si el textfield tiene algo diferente a Vacío aparecerá de color negro
        if (!(t_area.getText().equals("Ingresar Area de Labor"))&& !(t_area.getText().equals(""))) {
            t_area.setBorder(null);
            lb_errorArea.setText("");
        } else {

            t_area.setBorder(new LineBorder(Color.RED, 1));
            lb_errorArea.setText("Ingrese un área válida");

            val = false;
        }

                                  
        if (!(t_numtrabajadores.getText().equals("Ingresar número de trabajadores"))&& !(t_numtrabajadores.getText().equals(""))) {
            t_numtrabajadores.setBorder(null);
            lb_errorTrabajadores.setText("");
        } else {

            t_numtrabajadores.setBorder(new LineBorder(Color.RED, 1));
            lb_errorTrabajadores.setText("Ingrese un número válido");

            val = false;
        }
        return val;
    }
    
    public Boolean quitarBordeError() {
        Boolean val = true;

        if (!(t_area.getText().equals(""))) {
            t_area.setBorder(null);
            lb_errorCampos.setText("");
        } else {
            val = false;
        }

        if (!(t_numtrabajadores.getText().equals(""))) {
            t_numtrabajadores.setBorder(null);
            lb_errorCampos.setText("");
        } else {
            val = false;
        }
        return val;
    }
    public void limpiarErrores() {
        lb_errorArea.setText("");
        lb_errorCampos.setText("");
        lb_errorTrabajadores.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        t_area = new javax.swing.JTextField();
        lb_errorArea = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lb_errorTrabajadores = new javax.swing.JLabel();
        t_numtrabajadores = new javax.swing.JTextField();
        bt_guardar = new Utilerias.RSButtonMetro();
        bt_cancelar = new Utilerias.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_departamentos = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        bt_eliminar = new Utilerias.RSButtonMetro();
        bt_nuevo = new Utilerias.RSButtonMetro();
        lb_errorCampos = new javax.swing.JLabel();
        t_empleado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 441, 1020, 10));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivodepartamentosmall.png"))); // NOI18N
        jLabel8.setText("Módulo de Departamentos");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 860, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(128, 128, 131));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Área de Labor");

        t_area.setForeground(new java.awt.Color(153, 153, 153));
        t_area.setText("Ingresar Area de Labor");
        t_area.setBorder(null);
        t_area.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_areaFocusLost(evt);
            }
        });
        t_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_areaMouseClicked(evt);
            }
        });
        t_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_areaActionPerformed(evt);
            }
        });
        t_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_areaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_errorArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_area, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(t_area, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_errorArea, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 70));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(128, 128, 131));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Número de Trabajadores");

        t_numtrabajadores.setForeground(new java.awt.Color(153, 153, 153));
        t_numtrabajadores.setText("Ingresar número de trabajadores");
        t_numtrabajadores.setBorder(null);
        t_numtrabajadores.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numtrabajadoresFocusLost(evt);
            }
        });
        t_numtrabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_numtrabajadoresMouseClicked(evt);
            }
        });
        t_numtrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_numtrabajadoresActionPerformed(evt);
            }
        });
        t_numtrabajadores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numtrabajadoresKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_errorTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_numtrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(t_numtrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_errorTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 400, 70));

        bt_guardar.setBackground(new java.awt.Color(97, 212, 195));
        bt_guardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_guardar.setForeground(new java.awt.Color(255, 255, 255));
        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus24x24.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_guardar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_guardar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_guardar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_guardar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_guardar.setIconTextGap(10);
        bt_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_guardarMouseClicked(evt);
            }
        });
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });
        add(bt_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 140, -1));

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
        bt_cancelar.setIconTextGap(5);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 130, -1));

        jt_departamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_departamentos.getTableHeader().setReorderingAllowed(false);
        jt_departamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_departamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_departamentos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 550, 90));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(128, 128, 131));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Formulario de Ingreso");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 160, -1));

        jSeparator3.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 10, 370));

        bt_eliminar.setBackground(new java.awt.Color(97, 212, 195));
        bt_eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarBlue.png"))); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setColorBorde(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_eliminar.setColorHover(new java.awt.Color(128, 128, 131));
        bt_eliminar.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_eliminar.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_eliminar.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_eliminar.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_eliminar.setIconTextGap(10);
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });
        add(bt_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 140, -1));

        bt_nuevo.setBackground(new java.awt.Color(97, 212, 195));
        bt_nuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_nuevo.setForeground(new java.awt.Color(255, 255, 255));
        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario32x32Blue.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setColorHover(new java.awt.Color(128, 128, 131));
        bt_nuevo.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_nuevo.setColorTextHover(new java.awt.Color(102, 255, 255));
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
        add(bt_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 130, -1));

        lb_errorCampos.setForeground(new java.awt.Color(255, 51, 51));
        add(lb_errorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 300, 20));

        t_empleado.setForeground(new java.awt.Color(153, 153, 153));
        t_empleado.setText("Ingrese Departamento");
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
        add(t_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 150, -1));

        jSeparator5.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 180, 10));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Buscar Departamento");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
       
    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
       cbIndexInicial();
        limpiarCampos();
        limpiarErrores();
        quitarBordeError();
        bloquearComponentes();

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed


    private void cb_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_areaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cb_areaActionPerformed

public void RowApariencia(){
    
        jt_departamentos.setFocusable(false);
}
    private void t_areaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_areaFocusLost
        if (t_area.getText().trim().equals("")) {
            t_area.setText("Ingresar Area de Labor");
            t_area.setForeground(new Color(153, 153, 153));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_areaFocusLost

    private void t_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_areaMouseClicked
        t_area.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_areaMouseClicked

    private void t_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_areaActionPerformed

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:
 
        dc.eliminar(id);

        cargarTabla();
        limpiarCampos();
        bt_eliminar.setText("Eliminar");
    }//GEN-LAST:event_bt_eliminarActionPerformed

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
        limpiarCampos();
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void t_numtrabajadoresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numtrabajadoresFocusLost
         if (t_numtrabajadores.getText().trim().equals("")) {
            t_numtrabajadores.setText("Ingresar número de trabajadores");
            t_numtrabajadores.setForeground(new Color(153, 153, 153));

        }

// TODO add your handling code here:
    }//GEN-LAST:event_t_numtrabajadoresFocusLost

    private void t_numtrabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_numtrabajadoresMouseClicked
        // TODO add your handling code here:
        t_numtrabajadores.setText("");
    }//GEN-LAST:event_t_numtrabajadoresMouseClicked

    private void t_numtrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numtrabajadoresActionPerformed
        // TODO add your handling code here:
        t_numtrabajadores.setText("");
    }//GEN-LAST:event_t_numtrabajadoresActionPerformed

    private void t_areaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_areaKeyTyped
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
            lb_errorArea.setText("No se admiten números");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorArea.setText("");
            t_area.setBorder(null);
            

        }

    }//GEN-LAST:event_t_areaKeyTyped

    private void t_numtrabajadoresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numtrabajadoresKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorTrabajadores.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorTrabajadores.setText("");
            t_numtrabajadores.setBorder(null);

        }
    }//GEN-LAST:event_t_numtrabajadoresKeyTyped

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed

        if (!validarEscritura() == true ) {

            lb_errorCampos.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");

        } else {
            
            
           area = t_area.getText();
            capacidad = Integer.parseInt(t_numtrabajadores.getText());
            //accion = "I";
            dc.guardar(accion, id, area, capacidad);
            
            limpiarCampos();

            lb_errorCampos.setText("");

            bloquearComponentes();
            limpiarCampos();
            cargarTabla();

            bt_guardar.setText("Guardar");
        }
    }                                          

    private void jt_departamentosMouseClicked(java.awt.event.MouseEvent evt) {
        // AQUI VA EL CODIGO PARA SELECCIONAR UN DEPARTAMENTO Y EDITARLO
         desbloquear_item();
        ComponenteEditable();
        int filaSel = jt_departamentos.getSelectedRow();
        id = Integer.parseInt(jt_departamentos.getValueAt(filaSel, 0).toString());
        area = jt_departamentos.getValueAt(filaSel, 1).toString();
        capacidad = Integer.parseInt(jt_departamentos.getValueAt(filaSel, 2).toString());
        t_area.setText(area);
        t_numtrabajadores.setText(String.valueOf(capacidad));
        accion = "M";
         cargarTabla();
        lb_errorCampos.setText("");
    }


           /* bt_guardar.setText("Guardar"); }
    }//GEN-LAST:event_bt_guardarActionPerformed
    */
/*
    private void jt_departamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_departamentosMouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jt_departamentosMouseClicked

*/
    private void bt_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoMouseClicked
        // TODO add your handling code here:
        bt_nuevo.setEnabled(false);
    }//GEN-LAST:event_bt_nuevoMouseClicked

    private void bt_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_guardarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bt_guardarMouseClicked

    private void t_empleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_empleadoFocusLost
        if (t_empleado.getText().trim().equals("")) {
            t_empleado.setText("Ingrese Departamento");
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

    private void t_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_empleadoKeyTyped
char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }

        // TODO add your handling code here:
        filtro(t_empleado.getText(), jt_departamentos);
    }//GEN-LAST:event_t_empleadoKeyTyped
    

    /**
     *
     */
    public void RowApariencia1() {

        jt_departamentos.setFocusable(false);

        //espacio entre comulnas
        jt_departamentos.setIntercellSpacing(new Dimension(0, 1));
        //altura de columnas 
        jt_departamentos.setRowHeight(25);
        //margen entre filas
        jt_departamentos.setRowMargin(0);
//sin lineas verticles
        jt_departamentos.setShowVerticalLines(false);
        jt_departamentos.setSelectionBackground(new Color(97, 212, 195));
    }

    
    
    public void RowHeaderApariencia() {
        jt_departamentos.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        jt_departamentos.getTableHeader().setOpaque(false);
        jt_departamentos.getTableHeader().setBackground(new Color(97, 212, 195));
        jt_departamentos.getTableHeader().setForeground(new Color(255, 255, 255));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utilerias.RSButtonMetro bt_cancelar;
    private Utilerias.RSButtonMetro bt_eliminar;
    private Utilerias.RSButtonMetro bt_guardar;
    private Utilerias.RSButtonMetro bt_nuevo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jt_departamentos;
    private javax.swing.JLabel lb_errorArea;
    private javax.swing.JLabel lb_errorCampos;
    private javax.swing.JLabel lb_errorTrabajadores;
    private javax.swing.JTextField t_area;
    private javax.swing.JTextField t_empleado;
    private javax.swing.JTextField t_numtrabajadores;
    // End of variables declaration//GEN-END:variables

    

    
}
