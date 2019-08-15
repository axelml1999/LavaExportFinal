/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.HorarioController;
import Utilerias.CambiaPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
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
public class Pn_Horario extends javax.swing.JPanel {
    
    HorarioController hc = new HorarioController();
    String accion;
    int id;
    String hora_entrada;
    String hora_salida;
    String turno;
    DefaultTableModel dm;
    /**
     * Creates new form pnlHome
     */
    public Pn_Horario () {
        initComponents();
        RowApariencia();
        RowApariencia();
        RowHeaderApariencia();
  
        bloquearComponentes();
        ComponenteNoEditable();
        cargarTabla();
        tamañoTabla();

    }
    
     private void filtro(String consulta, JTable jtableBuscar) {
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    } 
   
    
    public void cargarTabla(){
        DefaultTableModel tb = hc.tablaHorarios();
        jt_horarios.setModel(tb);
        tamañoTabla();
    }

   public void bloquearComponentes() {

        t_entrada.setEnabled(false);
        t_salida.setEnabled(false);
        t_turno.setEnabled(false);
        bt_nuevo.setEnabled(true);
        bt_agregar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_agregar.setText("Guardar");
    }

    public void desbloquearComponentes() {

        t_entrada.setEnabled(true);
        t_salida.setEnabled(true);
        t_turno.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(false);

    }
    public void desbloquear_item(){
        t_entrada.setEnabled(true);
        t_salida.setEnabled(true);
        t_turno.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        bt_agregar.setText("Actualizar");
    }

    public void ComponenteNoEditable() {
        t_entrada.setEditable(false);
        t_salida.setEditable(false);
        t_turno.setEditable(false);
        
    }

    public void ComponenteEditable() {
        t_entrada.setEditable(true);
       t_salida.setEditable(true);
        t_turno.setEditable(true);
        
    }

    

    public void limpiarCampos() {
        t_entrada.setText("Ingresar Entrada");
        t_salida.setText("Ingresar Salida");
        t_turno.setText("Ingresar Turno");
        id = 0;
        hora_entrada="";
        hora_salida="";
        turno= "";
        
    }
    public Boolean validarEscritura() {
        Boolean val = true;
        //si el textfield tiene algo diferente a Vacío aparecerá de color negro
        if (!(t_entrada.getText().equals("Ingresar Entrada"))&&!(t_entrada.getText().equals(""))) {
            t_entrada.setBorder(null);
            lb_errorEntrada.setText("");
        } else {

            t_entrada.setBorder(new LineBorder(Color.RED, 1));
            lb_errorEntrada.setText("Ingrese una hora válida");

            val = false;
        }
        if (!(t_salida.getText().equals("Ingresar Salida"))&&!(t_salida.getText().equals(""))) {
            t_salida.setBorder(null);
            lb_errorSalida.setText("");
        } else {

            t_salida.setBorder(new LineBorder(Color.RED, 1));
            lb_errorSalida.setText("Ingrese una hora válida");

            val = false;
        }
        if (!(t_turno.getText().equals("Ingresar Turno"))&&!(t_turno.getText().equals(""))) {
            t_turno.setBorder(null);
            lb_errorTurno.setText("");
        } else {

            t_turno.setBorder(new LineBorder(Color.RED, 1));
            lb_errorTurno.setText("Ingrese un turno válido");

            val = false;
        }
        return val;
    }
    public Boolean quitarBordeError() {
        Boolean val = true;

        if (!(t_entrada.getText().equals(""))) {
            t_entrada.setBorder(null);
            lb_errorEntrada.setText("");
        } else {
            val = false;
        }

        if (!(t_salida.getText().equals(""))) {
            t_salida.setBorder(null);
            lb_errorSalida.setText("");
        } else {
            val = false;
        }
        if (!(t_turno.getText().equals(""))) {
            t_turno.setBorder(null);
            lb_errorTurno.setText("");
        } else {
            val = false;
        }
        return val;
    }
public void limpiarErrores() {
    lb_errorCampos.setText("");
    lb_errorEntrada.setText("");
    lb_errorSalida.setText("");
    lb_errorTurno.setText("");
 
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
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        t_salida = new javax.swing.JTextField();
        lb_errorSalida = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        t_entrada = new javax.swing.JTextField();
        lb_errorEntrada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        t_turno = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lb_errorTurno = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_horarios = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        bt_nuevo = new Utilerias.RSButtonMetro();
        bt_agregar = new Utilerias.RSButtonMetro();
        bt_cancelar = new Utilerias.RSButtonMetro();
        bt_eliminar = new Utilerias.RSButtonMetro();
        lb_errorCampos = new javax.swing.JLabel();
        t_empleado = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();

        jSeparator6.setBackground(new java.awt.Color(128, 128, 131));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivoclocksmall.png"))); // NOI18N
        jLabel8.setText("Módulo de Ingreso para Nuevos Horarios");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 810, -1));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Hora de entrada");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 137, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jSeparator5.setBackground(new java.awt.Color(128, 128, 131));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Hora de Salida");

        t_salida.setForeground(new java.awt.Color(153, 153, 153));
        t_salida.setText("Ingresar Salida");
        t_salida.setBorder(null);
        t_salida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_salidaFocusLost(evt);
            }
        });
        t_salida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_salidaMouseClicked(evt);
            }
        });
        t_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_salidaActionPerformed(evt);
            }
        });
        t_salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_salidaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_errorSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(t_salida))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(t_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_errorSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 400, 80));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jSeparator1.setBackground(new java.awt.Color(128, 128, 131));

        t_entrada.setForeground(new java.awt.Color(153, 153, 153));
        t_entrada.setText("Ingresar Entrada");
        t_entrada.setBorder(null);
        t_entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_entradaFocusLost(evt);
            }
        });
        t_entrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_entradaMouseClicked(evt);
            }
        });
        t_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_entradaActionPerformed(evt);
            }
        });
        t_entrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_entradaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_errorEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(t_entrada))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(t_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_errorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 400, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 128, 131));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Turno");

        t_turno.setForeground(new java.awt.Color(153, 153, 153));
        t_turno.setText("Ingresar Turno");
        t_turno.setToolTipText("");
        t_turno.setBorder(null);
        t_turno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_turnoFocusLost(evt);
            }
        });
        t_turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_turnoMouseClicked(evt);
            }
        });
        t_turno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_turnoActionPerformed(evt);
            }
        });
        t_turno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_turnoKeyTyped(evt);
            }
        });

        jSeparator7.setBackground(new java.awt.Color(128, 128, 131));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_errorTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(t_turno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_errorTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, 80));

        jSeparator2.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 944, 10));

        jSeparator3.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 400, 10));

        jSeparator4.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 400, 10));

        jt_horarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_horarios.getTableHeader().setReorderingAllowed(false);
        jt_horarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_horariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_horarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 900, 100));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de Horarios ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

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
        bt_nuevo.setIconTextGap(30);
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
        add(bt_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, -1, -1));

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
        bt_agregar.setIconTextGap(25);
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
        add(bt_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

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
        bt_cancelar.setIconTextGap(25);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

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
        bt_eliminar.setIconTextGap(25);
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });
        add(bt_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 150, -1));

        lb_errorCampos.setForeground(new java.awt.Color(255, 0, 0));
        add(lb_errorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 290, 20));

        t_empleado.setForeground(new java.awt.Color(153, 153, 153));
        t_empleado.setText("Ingrese Turno");
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
        add(t_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 150, -1));

        jSeparator8.setBackground(new java.awt.Color(128, 128, 131));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 180, 10));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(128, 128, 131));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Buscar Horario");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_nuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusGained

    private void bt_nuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusLost

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        accion="I";
        
        desbloquearComponentes();
        ComponenteEditable();
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
if (!validarEscritura() == true ) {

            lb_errorCampos.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");

        } else {


            //PROGRAMADOR AQUÍ ESCRIBE TU CÓDIGO
           hora_entrada = t_entrada.getText();
            hora_salida = t_salida.getText();
            turno = t_turno.getText();
            //accion = "I";
            hc.guardar(accion, id, hora_entrada, hora_salida, turno);
            cargarTabla();
            lb_errorCampos.setText("");
            limpiarCampos();
            bloquearComponentes();
            bt_nuevo.setEnabled(true);
        //FIN DEL CÓDIGO DEL PROGRAMADOR

            
            
        }

        
    }//GEN-LAST:event_bt_agregarActionPerformed


    private void rSButtonMetro3ActionPerformed(java.awt.event.ActionEvent evt) {                                               

    }
    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        bloquearComponentes();
        limpiarCampos();
        quitarBordeError();
        limpiarErrores();

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void t_entradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_entradaFocusLost
        if (t_entrada.getText().trim().equals("")) {
            t_entrada.setText("Ingresar Entrada");
          
            t_entrada.setForeground(new Color(153, 153, 153));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_entradaFocusLost

    private void t_entradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_entradaMouseClicked
        // TODO add your handling code here:
if(!t_entrada.getText().equals("Ingresar Entrada")){
            
        }
        else{
            t_entrada.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_entradaMouseClicked

    private void t_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_entradaActionPerformed
        t_entrada.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_entradaActionPerformed

    private void t_salidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_salidaFocusLost
        if (t_salida.getText().trim().equals("")) {
            t_salida.setText("Ingresar Salida");
            t_salida.setForeground(new Color(153, 153, 153));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_salidaFocusLost

    private void t_salidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_salidaMouseClicked
        if(!t_salida.getText().equals("Ingresar Salida")){
            
        }
        else{
            t_salida.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salidaMouseClicked

    private void t_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_salidaActionPerformed
        t_salida.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salidaActionPerformed

    private void t_turnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_turnoFocusLost
 if (t_turno.getText().trim().equals("")) {
            t_turno.setText("Ingresar Turno");
            t_turno.setForeground(new Color(153, 153, 153));
 }
 
        // TODO add your handling code here:
    }//GEN-LAST:event_t_turnoFocusLost

    private void t_turnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_turnoMouseClicked
       if(!t_turno.getText().equals("Ingresar Turno")){
            
        }
        else{
            t_turno.setText("");
        }
        // TODO add your handling code here:
        
// TODO add your handling code here:
    }//GEN-LAST:event_t_turnoMouseClicked

    private void t_turnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_turnoActionPerformed
         t_turno.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_t_turnoActionPerformed

    private void jt_horariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_horariosMouseClicked
        ComponenteEditable();
        desbloquear_item();
        
       
        //hc.guardar(accion, id, hora_entrada, hora_salida, turno);
        
        int filaSel = jt_horarios.getSelectedRow();
        id = Integer.parseInt(jt_horarios.getValueAt(filaSel, 0).toString());
        hora_entrada = jt_horarios.getValueAt(filaSel, 1).toString();
        hora_salida = jt_horarios.getValueAt(filaSel, 2).toString();
        turno = jt_horarios.getValueAt(filaSel, 3).toString();
        
        t_entrada.setText(hora_entrada);
        t_salida.setText(hora_salida);
        t_turno.setText(turno);
        
        
            accion = "M";
            bt_agregar.setText("Actualizar");
        
        
        cargarTabla();
        lb_errorCampos.setText("");


    }//GEN-LAST:event_jt_horariosMouseClicked

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:
           hc.eliminar(id);
            cargarTabla();
            limpiarCampos(); 

        
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void t_entradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_entradaKeyTyped
         //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER && tecla != KeyEvent.VK_PERIOD && !evt.isShiftDown() &&!(evt.getKeyCode()==KeyEvent.VK_COLON)) {
            getToolkit().beep();
            lb_errorEntrada.setText("Solo se admiten números y letras");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorEntrada.setText("");
            t_entrada.setBorder(null);
        }
    }//GEN-LAST:event_t_entradaKeyTyped

    private void t_salidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_salidaKeyTyped
          //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //                                                                                                                                                       //con estas dos combinaciones de código aparecen los caracteres especiales
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER && tecla != KeyEvent.VK_PERIOD && !evt.isShiftDown() &&!(evt.getKeyCode()==KeyEvent.VK_COLON )) {
            getToolkit().beep();
            lb_errorSalida.setText("Solo se admiten números y letras");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorSalida.setText("");
            t_salida.setBorder(null);
        }
    }//GEN-LAST:event_t_salidaKeyTyped

    private void t_turnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_turnoKeyTyped
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
            lb_errorTurno.setText("No se admiten números");
            evt.consume();
            //para borrar el texto   
        } else {
            lb_errorTurno.setText("");
            t_turno.setBorder(null);

        }
    }//GEN-LAST:event_t_turnoKeyTyped

    private void bt_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoMouseClicked
        // TODO add your handling code here:
        bt_nuevo.setEnabled(false);
    }//GEN-LAST:event_bt_nuevoMouseClicked

    private void bt_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_agregarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bt_agregarMouseClicked

    private void t_empleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_empleadoFocusLost
        if (t_empleado.getText().trim().equals("")) {
            t_empleado.setText("Ingrese Turno");
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
        filtro(t_empleado.getText(), jt_horarios);
    }//GEN-LAST:event_t_empleadoKeyTyped
   
    public void tamañoTabla() {
        TableColumnModel columnModel = jt_horarios.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);
        columnModel.getColumn(2).setPreferredWidth(180);
        columnModel.getColumn(3).setPreferredWidth(180);

    }
    
    public void RowApariencia() {

    }
     public void RowHeaderApariencia() {
        jt_horarios.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        jt_horarios.getTableHeader().setOpaque(false);
        jt_horarios.getTableHeader().setBackground(new Color(97, 212, 195));
        jt_horarios.getTableHeader().setForeground(new Color(255, 255, 255));
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Utilerias.RSButtonMetro bt_agregar;
    private Utilerias.RSButtonMetro bt_cancelar;
    private Utilerias.RSButtonMetro bt_eliminar;
    private Utilerias.RSButtonMetro bt_nuevo;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jt_horarios;
    private javax.swing.JLabel lb_errorCampos;
    private javax.swing.JLabel lb_errorEntrada;
    private javax.swing.JLabel lb_errorSalida;
    private javax.swing.JLabel lb_errorTurno;
    private javax.swing.JTextField t_empleado;
    private javax.swing.JTextField t_entrada;
    private javax.swing.JTextField t_salida;
    private javax.swing.JTextField t_turno;
    // End of variables declaration//GEN-END:variables
}
