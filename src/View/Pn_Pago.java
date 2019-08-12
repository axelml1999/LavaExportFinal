/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

 import Controller.PagoController;  
 import Utilerias.CambiaPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Pn_Pago extends javax.swing.JPanel {
    
     private int limiteTarjeta = 16;
     private int limiteCuenta = 20;

    PagoController pc = new PagoController();  
    String id_empleado;
    String nombre;
    String numero_cuenta;
    String numero_tarjeta;
    String descripcion_pago;
    String accion;
    private DefaultTableModel dm;

    /**
     * Creates new form pnlHome
     */
    public Pn_Pago() {
        initComponents();
         RowApariencia();
         RowHeaderApariencia();
         bloquearComponentes();
         ComponenteNoEditable();

          cargar_tabla();
    }
    public void cargar_tabla(){
        DefaultTableModel md=pc.tablapago();
        jt_empleados.setModel(md);
         TableColumnModel colummodel= jt_empleados.getColumnModel();
       colummodel.getColumn(0).setPreferredWidth(10);
        colummodel.getColumn(1).setPreferredWidth(300);
        colummodel.getColumn(2).setPreferredWidth(10);
        colummodel.getColumn(3).setPreferredWidth(10);
        colummodel.getColumn(4).setPreferredWidth(10);    
        
    }
    public void bloquearComponentes() {
        t_empleado.setEnabled(true);
        t_cuenta.setEnabled(false);
        t_tarjeta.setEnabled(false);
        t_descripcion.setEnabled(false);
        t_nomEmpleado.setEnabled(false);
        t_numEmpleado.setEnabled(false);
        bt_agregar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        t_banco.setEnabled(false);
        bt_eliminar.setEnabled(false);
        jTab_Usuarios.setSelectedIndex(0);
    }

    public void cargar_datos(String id) {
        ResultSet rs = pc.consultar_user_pago(id_empleado);
        try {
            while (rs.next()) {
                numero_cuenta = rs.getString("numero_cuenta");
                numero_tarjeta = rs.getString("numero_tarjeta");
                descripcion_pago = rs.getString("descripcion_pago");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pn_Pago.class.getName()).log(Level.SEVERE, null, ex);
        }
        t_tarjeta.setText(numero_tarjeta);
        t_descripcion.setText(descripcion_pago);
        t_cuenta.setText(numero_cuenta);
        
    }
    
    public void desbloquearComponentes() {
        t_empleado.setEnabled(true);
        t_cuenta.setEnabled(true);
        t_tarjeta.setEnabled(true);
        t_descripcion.setEnabled(true);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        t_banco.setEnabled(true);
        bt_eliminar.setEnabled(true);
        jTab_Usuarios.setSelectedIndex(1);
    }
    
    public void ComponenteNoEditable() {
        t_empleado.setEditable(true);
        t_cuenta.setEditable(false);
        t_tarjeta.setEditable(false);
        t_descripcion.setEditable(false);
        t_nomEmpleado.setEditable(false);
        t_numEmpleado.setEditable(false);
        t_banco.setEditable(false);
        
    }
    
    public void ComponenteEditable() {
        t_empleado.setEditable(true);
        t_cuenta.setEditable(true);
        t_tarjeta.setEditable(true);
        t_descripcion.setEditable(true);
        t_nomEmpleado.setEditable(true);
        t_numEmpleado.setEditable(true);
        t_banco.setEditable(true);
    }
    
    public void limpiarCampos() {
        t_empleado.setText("Ingrese Número de Empleado");
        t_cuenta.setText("Ingresar Número de Cuenta");
        t_tarjeta.setText("Ingresar Número de Tarjeta");
        t_descripcion.setText("Ingresar Descripción");
        t_nomEmpleado.setText("Ingrese Nombre de Empleado");
        t_numEmpleado.setText("Ingrese Número de Empleado");
        t_banco.setText("Ingresar Sucursal Bancaria");
        
    }

    public boolean validarEscritura() {
        boolean val = true;
        //si el textfield tiene algo diferente a Vacío aparecerá de color negro
        if (!(t_cuenta.getText().equals("Ingresar Número de Cuenta")) && !(t_cuenta.getText().equals(""))) {
            t_cuenta.setBorder(null);
            lb_errorCuenta.setText("");
        } else {
            
            t_cuenta.setBorder(new LineBorder(Color.RED, 1));
            lb_errorCuenta.setText("Ingrese una cuenta válida");
            
            val = false;
        }
        if (!(t_tarjeta.getText().equals("Ingresar Número de Tarjeta")) && !(t_tarjeta.getText().equals(""))) {
            t_tarjeta.setBorder(null);
            lb_errorTarjeta.setText("");
        } else {
            
            t_tarjeta.setBorder(new LineBorder(Color.RED, 1));
            lb_errorTarjeta.setText("Ingrese una tarjeta válida");
            
            val = false;
        }
        if (!(t_descripcion.getText().equals("Ingresar Descripción")) && !(t_descripcion.getText().equals(""))) {
            t_descripcion.setBorder(null);
            lb_errorDescripcion.setText("");
        } else {
            
            t_descripcion.setBorder(new LineBorder(Color.RED, 1));
            lb_errorDescripcion.setText("Ingrese una descripción válida");
            
            val = false;
        }
        /* if (!(t_numEmpleado.getText().equals("Ingrese Número de Empleado"))&& !(t_numEmpleado.getText().equals(""))) {
            t_numEmpleado.setBorder(null);
            lb_errorNumero.setText("");
        } else {

            t_numEmpleado.setBorder(new LineBorder(Color.RED, 1));
            lb_errorNumero.setText("Ingrese un número válido");

            val = false;
        }
          if (!(t_nomEmpleado.getText().equals("Ingrese Nombre de Empleado"))&& !(t_nomEmpleado.getText().equals(""))) {
            t_nomEmpleado.setBorder(null);
            lb_errorNombre.setText("");
        } else {

            t_nomEmpleado.setBorder(new LineBorder(Color.RED, 1));
            lb_errorNombre.setText("Ingrese un número válido");

            val = false;*/
        {
            if (!(t_banco.getText().equals("Ingresar Sucursal Bancaria")) && !(t_banco.getText().equals(""))) {
                t_banco.setBorder(null);
                lb_errorBanco.setText("");
            } else {
                
                t_banco.setBorder(new LineBorder(Color.RED, 1));
                lb_errorBanco.setText("Ingrese un Nombre de Banco válido");
                
                val = false;
            }
        }
        return val;
    }
    
    public Boolean quitarBordeError() {
        Boolean val = true;
        
        if (!(t_cuenta.getText().equals(""))) {
            t_cuenta.setBorder(null);
            lb_errorCuenta.setText("");
        } else {
            val = false;
        }
        if (!(t_tarjeta.getText().equals(""))) {
            t_tarjeta.setBorder(null);
            lb_errorTarjeta.setText("");
        } else {
            val = false;
        }
        if (!(t_descripcion.getText().equals(""))) {
            t_descripcion.setBorder(null);
            lb_errorDescripcion.setText("");
        } else {
            val = false;
        }
        return val;
    }

    public void limpiarErrores() {
        lb_errorCuenta.setText("");
        lb_errorDescripcion.setText("");
        lb_errorTarjeta.setText("");
        lb_errorCampos.setText("");
        lb_errorBanco.setText("");
        lb_errorNombre.setText("");
        lb_errorNumero.setText("");
        
    }
private void filtro(String consulta, JTable jtableBuscar){
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jTab_Usuarios = new javax.swing.JTabbedPane();
        Jp_contenido = new javax.swing.JPanel();
        t_empleado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_empleados = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Jp_usuarios = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        bt_nuevo = new Utilerias.RSButtonMetro();
        bt_agregar = new Utilerias.RSButtonMetro();
        bt_cancelar = new Utilerias.RSButtonMetro();
        t_tarjeta = new javax.swing.JTextField();
        t_descripcion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        t_cuenta = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        bt_eliminar = new Utilerias.RSButtonMetro();
        lb_errorCuenta = new javax.swing.JLabel();
        lb_errorTarjeta = new javax.swing.JLabel();
        lb_errorDescripcion = new javax.swing.JLabel();
        lb_errorCampos = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        t_nomEmpleado = new javax.swing.JTextField();
        t_numEmpleado = new javax.swing.JTextField();
        lb_errorNombre = new javax.swing.JLabel();
        lb_errorNumero = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        t_banco = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        lb_errorBanco = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 684));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dallarsmall.png"))); // NOI18N
        jLabel8.setText("Módulo de Formas de Pago ");

        jTab_Usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Jp_contenido.setBackground(new java.awt.Color(255, 255, 255));

        t_empleado.setForeground(new java.awt.Color(153, 153, 153));
        t_empleado.setText("Ingrese Número de Empleado");
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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_empleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_empleadoKeyTyped(evt);
            }
        });

        jt_empleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_empleados.getTableHeader().setReorderingAllowed(false);
        jt_empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_empleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt_empleados);

        jSeparator5.setBackground(new java.awt.Color(128, 128, 131));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(128, 128, 131));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Tabla de contenido de Empleados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Buscar Empleado");

        javax.swing.GroupLayout Jp_contenidoLayout = new javax.swing.GroupLayout(Jp_contenido);
        Jp_contenido.setLayout(Jp_contenidoLayout);
        Jp_contenidoLayout.setHorizontalGroup(
            Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp_contenidoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jp_contenidoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jp_contenidoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(t_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        Jp_contenidoLayout.setVerticalGroup(
            Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp_contenidoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTab_Usuarios.addTab("Lista de Empleados", Jp_contenido);

        Jp_usuarios.setBackground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(128, 128, 131));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Sucursal Bancaria");
        Jp_usuarios.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 170, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 128, 131));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Número de tarjeta");
        Jp_usuarios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, -1));

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
        bt_nuevo.setIconTextGap(25);
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
        Jp_usuarios.add(bt_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, -1, -1));

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
        Jp_usuarios.add(bt_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

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
        Jp_usuarios.add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, -1));

        t_tarjeta.setForeground(new java.awt.Color(153, 153, 153));
        t_tarjeta.setText("Ingresar Número de Tarjeta");
        t_tarjeta.setBorder(null);
        t_tarjeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_tarjetaFocusLost(evt);
            }
        });
        t_tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_tarjetaMouseClicked(evt);
            }
        });
        t_tarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_tarjetaActionPerformed(evt);
            }
        });
        t_tarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_tarjetaKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 160, -1));

        t_descripcion.setForeground(new java.awt.Color(153, 153, 153));
        t_descripcion.setText("Ingresar Descripción");
        t_descripcion.setBorder(null);
        t_descripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_descripcionFocusLost(evt);
            }
        });
        t_descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_descripcionMouseClicked(evt);
            }
        });
        t_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_descripcionActionPerformed(evt);
            }
        });
        t_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_descripcionKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 344, 160, 20));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(128, 128, 131));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Nombre de Empleado");
        Jp_usuarios.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, -1));

        t_cuenta.setForeground(new java.awt.Color(153, 153, 153));
        t_cuenta.setText("Ingresar Número de Cuenta");
        t_cuenta.setBorder(null);
        t_cuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_cuentaFocusLost(evt);
            }
        });
        t_cuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cuentaMouseClicked(evt);
            }
        });
        t_cuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cuentaActionPerformed(evt);
            }
        });
        t_cuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cuentaKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, -1));

        jSeparator8.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 182, 10));

        jSeparator14.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 182, 10));

        jSeparator15.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 182, 10));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(128, 128, 131));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Asignación de Formas de Pago");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        Jp_usuarios.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 260, 30));

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
        Jp_usuarios.add(bt_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 270, 150, -1));
        Jp_usuarios.add(lb_errorCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 180, 20));
        Jp_usuarios.add(lb_errorTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 180, 20));
        Jp_usuarios.add(lb_errorDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 180, 20));

        lb_errorCampos.setForeground(new java.awt.Color(255, 51, 51));
        Jp_usuarios.add(lb_errorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 320, 30));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(128, 128, 131));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Número de Cuenta");
        Jp_usuarios.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 150, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Número de Empleado");
        Jp_usuarios.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, -1));

        jSeparator16.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 182, 10));

        jSeparator17.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 182, 10));

        t_nomEmpleado.setForeground(new java.awt.Color(153, 153, 153));
        t_nomEmpleado.setText("Ingrese Nombre de Empleado");
        t_nomEmpleado.setBorder(null);
        t_nomEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nomEmpleadoFocusLost(evt);
            }
        });
        t_nomEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nomEmpleadoMouseClicked(evt);
            }
        });
        t_nomEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nomEmpleadoActionPerformed(evt);
            }
        });
        t_nomEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nomEmpleadoKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_nomEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, -1));

        t_numEmpleado.setForeground(new java.awt.Color(153, 153, 153));
        t_numEmpleado.setText("Ingrese Número de Empleado");
        t_numEmpleado.setBorder(null);
        t_numEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numEmpleadoFocusLost(evt);
            }
        });
        t_numEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_numEmpleadoMouseClicked(evt);
            }
        });
        t_numEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_numEmpleadoActionPerformed(evt);
            }
        });
        t_numEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numEmpleadoKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_numEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, -1));
        Jp_usuarios.add(lb_errorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 180, 20));
        Jp_usuarios.add(lb_errorNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 180, 20));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(128, 128, 131));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Descripción de pago");
        Jp_usuarios.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 170, -1));

        t_banco.setForeground(new java.awt.Color(153, 153, 153));
        t_banco.setText("Ingresar Sucursal Bancaria");
        t_banco.setBorder(null);
        t_banco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_bancoFocusLost(evt);
            }
        });
        t_banco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_bancoMouseClicked(evt);
            }
        });
        t_banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_bancoActionPerformed(evt);
            }
        });
        t_banco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_bancoKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_banco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 160, -1));

        jSeparator18.setBackground(new java.awt.Color(128, 128, 131));
        Jp_usuarios.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 182, 10));
        Jp_usuarios.add(lb_errorBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 180, 20));

        jTab_Usuarios.addTab("Datos Bancarios", Jp_usuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTab_Usuarios)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(22, 22, 22)
                .addComponent(jTab_Usuarios))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_nuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusGained

    private void bt_nuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusLost

    private void bt_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoMouseClicked

    }//GEN-LAST:event_bt_nuevoMouseClicked

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        desbloquearComponentes();
        ComponenteEditable();
if(t_tarjeta.getText().equals("")||t_cuenta.getText().equals("")){
    accion="I";
}else{
    accion="M";
}        
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_agregarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_bt_agregarMouseClicked

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        // TODO add your handling code here:
        if (!validarEscritura() == true) {
            
            lb_errorCampos.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");
            
        } else {
            id_empleado = t_numEmpleado.getText();
            numero_cuenta = t_cuenta.getText();
            numero_tarjeta = t_tarjeta.getText();
            descripcion_pago = t_descripcion.getText();
            pc.guardar(id_empleado, accion, numero_cuenta, numero_tarjeta, descripcion_pago);
            lb_errorCampos.setText("");
            limpiarCampos();
            bloquearComponentes();            
            bt_nuevo.setEnabled(true);
cargar_tabla();
            //PROGRAMADOR AQUÍ ESCRIBE TU CÓDIGO
            //FIN DEL CÓDIGO DEL PROGRAMADOR
        }
    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        limpiarCampos();
        quitarBordeError();
        limpiarErrores();
bloquearComponentes();
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void t_tarjetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_tarjetaFocusLost
        if (t_tarjeta.getText().trim().equals("")) {
            t_tarjeta.setText("Ingresar Número de Tarjeta");
            t_tarjeta.setForeground(new Color(153, 153, 153));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tarjetaFocusLost

    private void t_tarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_tarjetaMouseClicked
        if (!t_tarjeta.getText().equals("Ingresar Número de Tarjeta")) {
            
        } else {
            t_tarjeta.setText("");
        }
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tarjetaMouseClicked

    private void t_tarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_tarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_tarjetaActionPerformed

    private void t_tarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_tarjetaKeyTyped
        // TODO add your handling code here:
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
            
        }
        
       if (t_tarjeta.getText().length() == limiteTarjeta) {
            evt.consume();
        }
        //
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorTarjeta.setText("Solo se admiten números");
            evt.consume();

            //para borrar el texto
        } else {
            lb_errorTarjeta.setText("");
            t_tarjeta.setBorder(null);
            
        }
    }//GEN-LAST:event_t_tarjetaKeyTyped

    private void t_descripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_descripcionFocusLost
        if (t_descripcion.getText().trim().equals("")) {
            t_descripcion.setText("Ingresar Descripción");
            t_descripcion.setForeground(new Color(153, 153, 153));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_descripcionFocusLost

    private void t_descripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_descripcionMouseClicked
        if (!t_descripcion.getText().equals("Ingresar Descripción")) {
            
        } else {
            t_descripcion.setText("");
        }
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_t_descripcionMouseClicked

    private void t_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_descripcionActionPerformed

    private void t_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_descripcionKeyTyped
        // TODO add your handling code here:
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
            
        }
        //
        if (!Character.isLetter(tecla) /*&& !Character.isDigit(tecla)*/ && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER && tecla != KeyEvent.VK_PERIOD) {
            getToolkit().beep();
            lb_errorDescripcion.setText("Solo se admiten letras");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorDescripcion.setText("");
            t_descripcion.setBorder(null);
        }
    }//GEN-LAST:event_t_descripcionKeyTyped

    private void t_cuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_cuentaFocusLost
        if (t_cuenta.getText().trim().equals("")) {
            t_cuenta.setText("Ingresar Número de Cuenta");
            t_cuenta.setForeground(new Color(153, 153, 153));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cuentaFocusLost

    private void t_cuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cuentaMouseClicked
        
        if (!t_cuenta.getText().equals("Ingresar Número de Cuenta")) {
            
        } else {
            t_cuenta.setText("");
        }
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cuentaMouseClicked

    private void t_cuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cuentaActionPerformed

    private void t_cuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cuentaKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
            
        }
        if (t_cuenta.getText().length() == limiteCuenta) {
            evt.consume();
        }
        //
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorCuenta.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorCuenta.setText("");
            t_cuenta.setBorder(null);
            
        }
    }//GEN-LAST:event_t_cuentaKeyTyped

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:

       id_empleado=t_numEmpleado.getText();
       pc.eliminar(id_empleado);
       cargar_tabla();
        limpiarCampos();
  bloquearComponentes();
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void t_empleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_empleadoFocusLost
        if (t_empleado.getText().trim().equals("")) {
            t_empleado.setText("Ingrese Número de Empleado");
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

    private void t_nomEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nomEmpleadoFocusLost
        if (t_nomEmpleado.getText().trim().equals("")) {
            t_nomEmpleado.setText("");
            t_nomEmpleado.setForeground(new Color(153, 153, 153));
            
        }
// TODO add your handling code here:
    }//GEN-LAST:event_t_nomEmpleadoFocusLost

    private void t_nomEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nomEmpleadoMouseClicked
        // TODO add your handling code here:
        if (!t_nomEmpleado.getText().equals("Ingresar Nombre de Empleado")) {
            
        } else {
            t_nomEmpleado.setText("");
        }
    }//GEN-LAST:event_t_nomEmpleadoMouseClicked

    private void t_nomEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nomEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nomEmpleadoActionPerformed

    private void t_nomEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nomEmpleadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nomEmpleadoKeyTyped

    private void t_numEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numEmpleadoFocusLost
        if (t_numEmpleado.getText().trim().equals("")) {
            t_numEmpleado.setText("");
            t_numEmpleado.setForeground(new Color(153, 153, 153));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_numEmpleadoFocusLost

    private void t_numEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_numEmpleadoMouseClicked
        if (!t_numEmpleado.getText().equals("Ingresar Número de Empleado")) {
            
        } else {
            t_numEmpleado.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_numEmpleadoMouseClicked

    private void t_numEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_numEmpleadoActionPerformed

    private void t_numEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numEmpleadoKeyTyped
        //variable de tipo char
        
    }//GEN-LAST:event_t_numEmpleadoKeyTyped

    private void t_bancoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_bancoFocusLost
        if (t_banco.getText().trim().equals("")) {
            t_banco.setText("Ingresar Sucursal Bancaria");
            t_banco.setForeground(new Color(153, 153, 153));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bancoFocusLost

    private void t_bancoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_bancoMouseClicked
        if (!t_banco.getText().equals("Ingresar Sucursal Bancaria")) {
            
        } else {
            t_banco.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bancoMouseClicked

    private void t_bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_bancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bancoActionPerformed

    private void t_bancoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_bancoKeyTyped
        // TODO add your handling code here:
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
            
        }
        //
        if (!Character.isLetter(tecla) /*&& !Character.isDigit(tecla)*/ && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER && tecla != KeyEvent.VK_PERIOD) {
            getToolkit().beep();
            lb_errorBanco.setText("Solo se admiten letras");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorBanco.setText("");
            t_banco.setBorder(null);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_bancoKeyTyped

    private void jt_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_empleadosMouseClicked
        
        int filasel = jt_empleados.getSelectedRow();
        id_empleado=jt_empleados.getValueAt(filasel, 0).toString();
        nombre = jt_empleados.getValueAt(filasel, 1).toString();
jTab_Usuarios.setSelectedIndex(1);
        cargar_datos(id_empleado);

        t_numEmpleado.setText(id_empleado);
        t_nomEmpleado.setText(nombre);
cargar_datos(id_empleado);


        // TODO add your handling code here:
    }//GEN-LAST:event_jt_empleadosMouseClicked

    private void t_empleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_empleadoKeyReleased

        filtro(t_empleado.getText(), jt_empleados);
        // TODO add your handling code here:
    }//GEN-LAST:event_t_empleadoKeyReleased

    private void t_empleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_empleadoKeyTyped
        // TODO add your handling code here:
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        
    }//GEN-LAST:event_t_empleadoKeyTyped
    
    public void RowApariencia() {
        jt_empleados.setFocusable(false);
        //espacio entre comulnas
        jt_empleados.setIntercellSpacing(new Dimension(0, 1));
        //altura de columnas 
        jt_empleados.setRowHeight(25);
        //margen entre filas
        jt_empleados.setRowMargin(0);
//sin lineas verticles
        jt_empleados.setShowVerticalLines(false);
        jt_empleados.setSelectionBackground(new Color(97, 212, 195));
    }
    
    public void RowHeaderApariencia() {
        jt_empleados.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 14));
        jt_empleados.getTableHeader().setOpaque(false);
        jt_empleados.getTableHeader().setBackground(new Color(97, 212, 195));
        jt_empleados.getTableHeader().setForeground(new Color(255, 255, 255));
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jp_contenido;
    private javax.swing.JPanel Jp_usuarios;
    private Utilerias.RSButtonMetro bt_agregar;
    private Utilerias.RSButtonMetro bt_cancelar;
    private Utilerias.RSButtonMetro bt_eliminar;
    private Utilerias.RSButtonMetro bt_nuevo;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTab_Usuarios;
    private javax.swing.JTable jt_empleados;
    private javax.swing.JLabel lb_errorBanco;
    private javax.swing.JLabel lb_errorCampos;
    private javax.swing.JLabel lb_errorCuenta;
    private javax.swing.JLabel lb_errorDescripcion;
    private javax.swing.JLabel lb_errorNombre;
    private javax.swing.JLabel lb_errorNumero;
    private javax.swing.JLabel lb_errorTarjeta;
    private javax.swing.JTextField t_banco;
    private javax.swing.JTextField t_cuenta;
    private javax.swing.JTextField t_descripcion;
    private javax.swing.JTextField t_empleado;
    private javax.swing.JTextField t_nomEmpleado;
    private javax.swing.JTextField t_numEmpleado;
    private javax.swing.JTextField t_tarjeta;
    // End of variables declaration//GEN-END:variables
}
