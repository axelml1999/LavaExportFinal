/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CargoController;
import Controller.DepartamentoController;
import Controller.EmpleadoController;
import Controller.HorarioController;
import Utilerias.CambiaPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
public class Pn_Nuevo_Empleado  extends javax.swing.JPanel {

    private int limiteCurp = 18;
    private int limiteRFC = 13;
    private int limiteNSS = 11;
    

    DepartamentoController dc = new DepartamentoController();
    EmpleadoController ec = new EmpleadoController();
    CargoController cc = new CargoController();

    HorarioController hc = new HorarioController();

    String accion;
    String id_empleado;
    String id_horario;
    String id_cargo;
    String nombre;
    String a_paterno;
    String a_materno;
    String curp;
    String id_departamento;
    String direccion;
    String salario;
    String sexo;
    String estatus;
    String num_seg_social;
    String rfc;
    String gratificacion;
    String fecha_nacimiento;
    String fecha_entrada;
    
    DefaultTableModel dm;

    /**
     * Creates new form pnlHome
     */
    public Pn_Nuevo_Empleado() {
        initComponents();
        RowApariencia();
        RowHeaderApariencia();
        

        aparenciaTabs();
        bloquearComponentes();
        ComponenteNoEditable();
        cbIndexInicial();
        cargarTabla();
        cargarDepartamentos();
        cargarCargos();
        cargarHorarios();
        tamañoTabla();

    }
    
 
     public void tamañoTabla() {
        TableColumnModel columnModel = jt_empleados.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(180);
        columnModel.getColumn(2).setPreferredWidth(240);
        columnModel.getColumn(3).setPreferredWidth(180);
        columnModel.getColumn(4).setPreferredWidth(180);
        columnModel.getColumn(5).setPreferredWidth(180);
        columnModel.getColumn(6).setPreferredWidth(180);
        columnModel.getColumn(7).setPreferredWidth(100);

    }
    
    private void filtro(String consulta, JTable jtableBuscar) {
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    } 

    public void cargarHorarios() {
        DefaultComboBoxModel md = hc.consultarHorariosTodos();
        cb_horario.setModel(md);
    }

    public void cargarCargos() {
        DefaultComboBoxModel md = cc.consultarCargosTodos();
        cb_puesto.setModel(md);
    }

    public void cargarDepartamentos() {
        DefaultComboBoxModel md = dc.consultarDepartamentosTodos();
        cb_departamento.setModel(md);
    }

    public void cargarTabla() {
        DefaultTableModel tb = ec.tablaEmpleado();
        jt_empleados.setModel(tb);
        tamañoTabla();
    }

    public void consultarId(String id_empleado) {
        ResultSet rs = ec.consultarEmpleadoPorCodigo(id_empleado);
        try {
            while (rs.next()) {
                id_empleado = rs.getString("id_empleado");
                id_horario = rs.getString("id_horario");
                id_cargo = rs.getString("id_cargo");
                nombre = rs.getString("nombre");
                a_paterno = rs.getString("apellido_paterno");
                a_materno = rs.getString("apellido_materno");
                curp = rs.getString("curp");
                id_departamento = rs.getString("id_departamento");
                direccion = rs.getString("direccion");
                salario = rs.getString("salario");
                gratificacion = rs.getString("gratificacion");
                sexo = rs.getString("sexo");
                estatus = rs.getString("estatus");
                num_seg_social = rs.getString("num_seg_social");
                rfc = rs.getString("rfc");
                fecha_nacimiento = rs.getString("fecha_nacimiento");
                fecha_entrada = rs.getString("fecha_entrada");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pn_Nuevo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        t_control.setText(id_empleado);
        t_nombre.setText(nombre);
        t_apaterno.setText(a_paterno);
        t_amaterno.setText(a_materno);
        t_direccion.setText(direccion);

        if (sexo.equals("1")) {
            //Hacer lo mismo con los else if
            cb_sexo.setSelectedItem("Masculino");

        } else if (sexo.equals("2")) {
            cb_sexo.setSelectedItem("Femenino");

        } else if (sexo.equals("3")) {
            cb_sexo.setSelectedItem("No Especificar");
        }

        if (estatus.equals("1")) {
            //Hacer lo mismo con los else if
            cb_estatus.setSelectedItem("Activo");
        } else if (estatus.equals("2")) {
            cb_estatus.setSelectedItem("Inactivo");
        } else if (estatus.equals("3")) {
            cb_estatus.setSelectedItem("Lista Negra");
        }
        t_curp.setText(curp);
        cb_horario.setSelectedItem(hc.consultarIdHorarioController(String.valueOf(id_horario)));
        cb_puesto.setSelectedItem(cc.consultarDescripcionCargoController(String.valueOf(id_cargo))); //Hacer lo mismo con los demas cb
        cb_departamento.setSelectedItem(dc.consultarIdDepartamentoController(String.valueOf(id_departamento)));
        t_gratificacion.setText(String.valueOf(gratificacion));
        t_salario.setText(String.valueOf(salario));
        t_nss.setText(num_seg_social);
        t_rfc.setText(rfc);
       
        java.util.Date fechap = null;
        java.util.Date fechad = null;
        try {
            fechap = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_entrada);
            fechad = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_nacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Pn_Nuevo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDateNacimiento.setDate(fechad);
        jDateIngreso.setDate(fechap);

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
        Jp_usuarios = new javax.swing.JPanel();
        t_rfc = new javax.swing.JTextField();
        t_nss = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        t_amaterno = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        t_direccion = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        bt_nuevo = new Utilerias.RSButtonMetro();
        jLabel14 = new javax.swing.JLabel();
        bt_agregar = new Utilerias.RSButtonMetro();
        cb_departamento = new javax.swing.JComboBox<>();
        bt_cancelar = new Utilerias.RSButtonMetro();
        jLabel17 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        t_nombre = new javax.swing.JTextField();
        cb_sexo = new javax.swing.JComboBox<>();
        t_apaterno = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cb_puesto = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cb_estatus = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        t_salario = new javax.swing.JTextField();
        t_curp = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        t_gratificacion = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        bt_eliminar = new Utilerias.RSButtonMetro();
        lb_errorNombre = new javax.swing.JLabel();
        lb_errorAPaterno = new javax.swing.JLabel();
        lb_errorAMaterno = new javax.swing.JLabel();
        lb_errorDomicilio = new javax.swing.JLabel();
        lb_errorSexo = new javax.swing.JLabel();
        lb_errorEstatus = new javax.swing.JLabel();
        lb_errorCurp = new javax.swing.JLabel();
        lb_errorPuesto = new javax.swing.JLabel();
        lb_errorDepartamento = new javax.swing.JLabel();
        lb_errorGratificacion = new javax.swing.JLabel();
        lb_errorSalario = new javax.swing.JLabel();
        lb_errorNSS = new javax.swing.JLabel();
        lb_errorRFC = new javax.swing.JLabel();
        lb_errorCampos = new javax.swing.JLabel();
        t_control = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lb_errorControl = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb_horario = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        Jp_usuarios1 = new javax.swing.JPanel();
        t_rfc1 = new javax.swing.JTextField();
        t_nss1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        t_amaterno1 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        t_direccion1 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        bt_nuevo1 = new Utilerias.RSButtonMetro();
        jLabel31 = new javax.swing.JLabel();
        bt_agregar1 = new Utilerias.RSButtonMetro();
        cb_departamento1 = new javax.swing.JComboBox<>();
        bt_cancelar1 = new Utilerias.RSButtonMetro();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        t_nombre1 = new javax.swing.JTextField();
        cb_sexo1 = new javax.swing.JComboBox<>();
        t_apaterno1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        cb_puesto1 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        cb_estatus1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        t_salario1 = new javax.swing.JTextField();
        t_curp1 = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        t_gratificacion1 = new javax.swing.JTextField();
        jSeparator20 = new javax.swing.JSeparator();
        bt_eliminar1 = new Utilerias.RSButtonMetro();
        lb_errorNombre1 = new javax.swing.JLabel();
        lb_errorAPaterno1 = new javax.swing.JLabel();
        lb_errorAMaterno1 = new javax.swing.JLabel();
        lb_errorDomicilio1 = new javax.swing.JLabel();
        lb_errorSexo1 = new javax.swing.JLabel();
        lb_errorEstatus1 = new javax.swing.JLabel();
        lb_errorCurp1 = new javax.swing.JLabel();
        lb_errorPuesto1 = new javax.swing.JLabel();
        lb_errorDepartamento1 = new javax.swing.JLabel();
        lb_errorGratificacion1 = new javax.swing.JLabel();
        lb_errorSalario1 = new javax.swing.JLabel();
        lb_errorNSS1 = new javax.swing.JLabel();
        lb_errorRFC1 = new javax.swing.JLabel();
        lb_errorCampos1 = new javax.swing.JLabel();
        t_control1 = new javax.swing.JTextField();
        jSeparator21 = new javax.swing.JSeparator();
        lb_errorControl1 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cb_horario1 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jDateNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jDateIngreso = new com.toedter.calendar.JDateChooser();
        jSeparator03 = new javax.swing.JSeparator();
        Jp_contenido = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_empleados = new javax.swing.JTable();
        t_empleado = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1086, 684));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(128, 128, 131));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/archivonuevoempleadosmall.png"))); // NOI18N
        jLabel8.setText("Módulo de ingreso para nuevos Empleados ");

        jTab_Usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Jp_usuarios.setBackground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_rfc.setForeground(new java.awt.Color(153, 153, 153));
        t_rfc.setText("Registro Federal de Contribuyentes");
        t_rfc.setBorder(null);
        t_rfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_rfcFocusLost(evt);
            }
        });
        t_rfc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_rfcMouseClicked(evt);
            }
        });
        t_rfc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rfcActionPerformed(evt);
            }
        });
        t_rfc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_rfcKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_rfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 180, -1));

        t_nss.setForeground(new java.awt.Color(153, 153, 153));
        t_nss.setText("Número de Seguridad Social");
        t_nss.setBorder(null);
        t_nss.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nssFocusLost(evt);
            }
        });
        t_nss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nssMouseClicked(evt);
            }
        });
        t_nss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nssActionPerformed(evt);
            }
        });
        t_nss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nssKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_nss, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 162, -1));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(128, 128, 131));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("NSS");
        Jp_usuarios.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 113, -1));

        t_amaterno.setForeground(new java.awt.Color(153, 153, 153));
        t_amaterno.setText("Ingresar Apellido Materno");
        t_amaterno.setBorder(null);
        t_amaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_amaternoFocusLost(evt);
            }
        });
        t_amaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_amaternoMouseClicked(evt);
            }
        });
        t_amaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_amaternoActionPerformed(evt);
            }
        });
        t_amaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_amaternoKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_amaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 162, -1));

        jSeparator10.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 160, 10));

        jSeparator11.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 162, 10));

        t_direccion.setForeground(new java.awt.Color(153, 153, 153));
        t_direccion.setText("Ingresar Domicilio");
        t_direccion.setBorder(null);
        t_direccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_direccionFocusLost(evt);
            }
        });
        t_direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_direccionMouseClicked(evt);
            }
        });
        t_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_direccionActionPerformed(evt);
            }
        });
        t_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_direccionKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 162, -1));

        jSeparator7.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 162, 10));

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
        Jp_usuarios.add(bt_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(128, 128, 131));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Departamento");
        Jp_usuarios.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 113, -1));

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
        Jp_usuarios.add(bt_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, -1, -1));

        cb_departamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_departamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_departamentoItemStateChanged(evt);
            }
        });
        Jp_usuarios.add(cb_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 162, -1));

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
        bt_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelarMouseClicked(evt);
            }
        });
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });
        Jp_usuarios.add(bt_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(128, 128, 131));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Dirección");
        Jp_usuarios.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 113, -1));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(128, 128, 131));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Estatus");
        Jp_usuarios.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 137, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(128, 128, 131));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Salario");
        Jp_usuarios.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 113, -1));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(128, 128, 131));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Gratificación");
        Jp_usuarios.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 113, 20));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(128, 128, 131));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Nombre");
        Jp_usuarios.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 113, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(128, 128, 131));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Apellido Paterno");
        Jp_usuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(128, 128, 131));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Puesto");
        Jp_usuarios.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 113, -1));

        t_nombre.setForeground(new java.awt.Color(153, 153, 153));
        t_nombre.setText("Ingresar Nombre");
        t_nombre.setBorder(null);
        t_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nombreFocusLost(evt);
            }
        });
        t_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nombreMouseClicked(evt);
            }
        });
        t_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombreActionPerformed(evt);
            }
        });
        t_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nombreKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 162, -1));

        cb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Sexo", "Masculino", "Femenino", "No especificar" }));
        cb_sexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_sexoItemStateChanged(evt);
            }
        });
        cb_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sexoActionPerformed(evt);
            }
        });
        Jp_usuarios.add(cb_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 162, -1));

        t_apaterno.setForeground(new java.awt.Color(153, 153, 153));
        t_apaterno.setText("Ingresar Apellido Paterno");
        t_apaterno.setBorder(null);
        t_apaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_apaternoFocusLost(evt);
            }
        });
        t_apaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_apaternoMouseClicked(evt);
            }
        });
        t_apaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_apaternoActionPerformed(evt);
            }
        });
        t_apaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_apaternoKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_apaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 162, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(128, 128, 131));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Sexo");
        Jp_usuarios.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 137, -1));

        cb_puesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_puesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_puestoItemStateChanged(evt);
            }
        });
        cb_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_puestoActionPerformed(evt);
            }
        });
        Jp_usuarios.add(cb_puesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 162, -1));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(128, 128, 131));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("CURP");
        Jp_usuarios.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 113, -1));

        jSeparator1.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 162, 10));

        jSeparator2.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 162, 10));

        cb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Estatus", "Activo", "Inactivo", "Lista Negra" }));
        cb_estatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_estatusItemStateChanged(evt);
            }
        });
        cb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_estatusActionPerformed(evt);
            }
        });
        Jp_usuarios.add(cb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 162, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(128, 128, 131));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Datos nominales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Jp_usuarios.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 220, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(128, 128, 131));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Información General");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Jp_usuarios.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 30));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(128, 128, 131));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Número de Control");
        Jp_usuarios.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        t_salario.setForeground(new java.awt.Color(153, 153, 153));
        t_salario.setText("Ingresar Salario");
        t_salario.setBorder(null);
        t_salario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_salarioFocusLost(evt);
            }
        });
        t_salario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_salarioMouseClicked(evt);
            }
        });
        t_salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_salarioActionPerformed(evt);
            }
        });
        t_salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_salarioKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 162, -1));

        t_curp.setForeground(new java.awt.Color(153, 153, 153));
        t_curp.setText("Ingresar CURP");
        t_curp.setBorder(null);
        t_curp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_curpFocusLost(evt);
            }
        });
        t_curp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_curpMouseClicked(evt);
            }
        });
        t_curp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_curpActionPerformed(evt);
            }
        });
        t_curp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_curpKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_curp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 162, -1));

        jSeparator12.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 162, 10));

        jSeparator14.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 162, 10));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(128, 128, 131));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("RFC");
        Jp_usuarios.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 113, -1));

        t_gratificacion.setForeground(new java.awt.Color(153, 153, 153));
        t_gratificacion.setText("Ingresar Gratificación");
        t_gratificacion.setBorder(null);
        t_gratificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_gratificacionFocusLost(evt);
            }
        });
        t_gratificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_gratificacionMouseClicked(evt);
            }
        });
        t_gratificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_gratificacionActionPerformed(evt);
            }
        });
        t_gratificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_gratificacionKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_gratificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 162, 20));

        jSeparator13.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 162, 10));

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
        bt_eliminar.setIconTextGap(35);
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });
        Jp_usuarios.add(bt_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 150, -1));
        Jp_usuarios.add(lb_errorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 180, 20));
        Jp_usuarios.add(lb_errorAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 190, 20));
        Jp_usuarios.add(lb_errorAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 20));
        Jp_usuarios.add(lb_errorDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 200, 20));
        Jp_usuarios.add(lb_errorSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 210, 20));
        Jp_usuarios.add(lb_errorEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 190, 20));
        Jp_usuarios.add(lb_errorCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 220, 20));
        Jp_usuarios.add(lb_errorPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 190, 20));
        Jp_usuarios.add(lb_errorDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 190, 20));
        Jp_usuarios.add(lb_errorGratificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 200, 20));
        Jp_usuarios.add(lb_errorSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 190, 20));
        Jp_usuarios.add(lb_errorNSS, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 190, 20));
        Jp_usuarios.add(lb_errorRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 200, 20));

        lb_errorCampos.setForeground(new java.awt.Color(255, 51, 51));
        Jp_usuarios.add(lb_errorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 260, 30));

        t_control.setForeground(new java.awt.Color(153, 153, 153));
        t_control.setText("Ingresar Número de Control");
        t_control.setBorder(null);
        t_control.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_controlFocusLost(evt);
            }
        });
        t_control.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_controlMouseClicked(evt);
            }
        });
        t_control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_controlActionPerformed(evt);
            }
        });
        t_control.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_controlKeyTyped(evt);
            }
        });
        Jp_usuarios.add(t_control, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 162, -1));

        jSeparator4.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 10));
        Jp_usuarios.add(lb_errorControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 20));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(128, 128, 131));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Horario");
        Jp_usuarios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 113, -1));

        cb_horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_horario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_horarioItemStateChanged(evt);
            }
        });
        cb_horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_horarioActionPerformed(evt);
            }
        });
        Jp_usuarios.add(cb_horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 162, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(128, 128, 131));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Apellido Materno");
        Jp_usuarios.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jSeparator6.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 162, 10));

        Jp_usuarios1.setBackground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_rfc1.setForeground(new java.awt.Color(153, 153, 153));
        t_rfc1.setText("Registro Federal de Contribuyentes");
        t_rfc1.setBorder(null);
        t_rfc1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_rfc1FocusLost(evt);
            }
        });
        t_rfc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_rfc1MouseClicked(evt);
            }
        });
        t_rfc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_rfc1ActionPerformed(evt);
            }
        });
        t_rfc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_rfc1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_rfc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 180, -1));

        t_nss1.setForeground(new java.awt.Color(153, 153, 153));
        t_nss1.setText("Número de Seguridad Social");
        t_nss1.setBorder(null);
        t_nss1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nss1FocusLost(evt);
            }
        });
        t_nss1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nss1MouseClicked(evt);
            }
        });
        t_nss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nss1ActionPerformed(evt);
            }
        });
        t_nss1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nss1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_nss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 162, -1));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(128, 128, 131));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("NSS");
        Jp_usuarios1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 113, -1));

        t_amaterno1.setForeground(new java.awt.Color(153, 153, 153));
        t_amaterno1.setText("Ingresar Apellido Materno");
        t_amaterno1.setBorder(null);
        t_amaterno1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_amaterno1FocusLost(evt);
            }
        });
        t_amaterno1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_amaterno1MouseClicked(evt);
            }
        });
        t_amaterno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_amaterno1ActionPerformed(evt);
            }
        });
        t_amaterno1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_amaterno1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_amaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 162, -1));

        jSeparator15.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 160, 10));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(128, 128, 131));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Fecha Nacimiento");
        Jp_usuarios1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jSeparator16.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 162, 10));

        t_direccion1.setForeground(new java.awt.Color(153, 153, 153));
        t_direccion1.setText("Ingresar Domicilio");
        t_direccion1.setBorder(null);
        t_direccion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_direccion1FocusLost(evt);
            }
        });
        t_direccion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_direccion1MouseClicked(evt);
            }
        });
        t_direccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_direccion1ActionPerformed(evt);
            }
        });
        t_direccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_direccion1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_direccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 162, -1));

        jSeparator8.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 162, 10));

        jSeparator9.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 162, 10));

        bt_nuevo1.setBackground(new java.awt.Color(97, 212, 195));
        bt_nuevo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_nuevo1.setForeground(new java.awt.Color(255, 255, 255));
        bt_nuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario32x32Blue.png"))); // NOI18N
        bt_nuevo1.setText("Nuevo");
        bt_nuevo1.setColorBorde(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_nuevo1.setColorHover(new java.awt.Color(128, 128, 131));
        bt_nuevo1.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_nuevo1.setColorTextHover(new java.awt.Color(153, 255, 255));
        bt_nuevo1.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_nuevo1.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_nuevo1.setIconTextGap(25);
        bt_nuevo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bt_nuevo1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bt_nuevo1FocusLost(evt);
            }
        });
        bt_nuevo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_nuevo1MouseClicked(evt);
            }
        });
        bt_nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevo1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(bt_nuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, -1, -1));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(128, 128, 131));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Departamento");
        Jp_usuarios1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 113, -1));

        bt_agregar1.setBackground(new java.awt.Color(97, 212, 195));
        bt_agregar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_agregar1.setForeground(new java.awt.Color(255, 255, 255));
        bt_agregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus24x24.png"))); // NOI18N
        bt_agregar1.setText("Guardar");
        bt_agregar1.setColorHover(new java.awt.Color(128, 128, 131));
        bt_agregar1.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_agregar1.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_agregar1.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_agregar1.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_agregar1.setIconTextGap(25);
        bt_agregar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_agregar1MouseClicked(evt);
            }
        });
        bt_agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregar1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(bt_agregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, -1, -1));

        cb_departamento1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_departamento1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_departamento1ItemStateChanged(evt);
            }
        });
        Jp_usuarios1.add(cb_departamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 162, -1));

        bt_cancelar1.setBackground(new java.awt.Color(97, 212, 195));
        bt_cancelar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_cancelar1.setForeground(new java.awt.Color(255, 255, 255));
        bt_cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelBlue.png"))); // NOI18N
        bt_cancelar1.setText("Cancelar");
        bt_cancelar1.setColorHover(new java.awt.Color(128, 128, 131));
        bt_cancelar1.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_cancelar1.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_cancelar1.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_cancelar1.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_cancelar1.setIconTextGap(25);
        bt_cancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelar1MouseClicked(evt);
            }
        });
        bt_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(bt_cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, -1));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(128, 128, 131));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Dirección");
        Jp_usuarios1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 113, -1));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(128, 128, 131));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Estatus");
        Jp_usuarios1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 137, -1));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(128, 128, 131));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Salario");
        Jp_usuarios1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 113, -1));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(128, 128, 131));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Gratificación");
        Jp_usuarios1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 113, 20));

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(128, 128, 131));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Nombre");
        Jp_usuarios1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 113, -1));

        jLabel37.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(128, 128, 131));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Apellido Paterno");
        Jp_usuarios1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel38.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(128, 128, 131));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Puesto");
        Jp_usuarios1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 113, -1));

        t_nombre1.setForeground(new java.awt.Color(153, 153, 153));
        t_nombre1.setText("Ingresar Nombre");
        t_nombre1.setBorder(null);
        t_nombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nombre1FocusLost(evt);
            }
        });
        t_nombre1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_nombre1MouseClicked(evt);
            }
        });
        t_nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombre1ActionPerformed(evt);
            }
        });
        t_nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nombre1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 162, -1));

        cb_sexo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Sexo", "Masculino", "Femenino", "No especificar" }));
        cb_sexo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_sexo1ItemStateChanged(evt);
            }
        });
        cb_sexo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sexo1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(cb_sexo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 162, -1));

        t_apaterno1.setForeground(new java.awt.Color(153, 153, 153));
        t_apaterno1.setText("Ingresar Apellido Paterno");
        t_apaterno1.setBorder(null);
        t_apaterno1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_apaterno1FocusLost(evt);
            }
        });
        t_apaterno1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_apaterno1MouseClicked(evt);
            }
        });
        t_apaterno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_apaterno1ActionPerformed(evt);
            }
        });
        t_apaterno1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_apaterno1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_apaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 162, -1));

        jLabel39.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(128, 128, 131));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Sexo");
        Jp_usuarios1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 137, -1));

        cb_puesto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_puesto1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_puesto1ItemStateChanged(evt);
            }
        });
        cb_puesto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_puesto1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(cb_puesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 162, -1));

        jLabel40.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(128, 128, 131));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("CURP");
        Jp_usuarios1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 113, -1));

        jSeparator3.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 162, 10));

        jSeparator17.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator17.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 162, 10));

        cb_estatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Estatus", "Activo", "Inactivo", "Lista Negra" }));
        cb_estatus1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_estatus1ItemStateChanged(evt);
            }
        });
        cb_estatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_estatus1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(cb_estatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 162, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel41.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(128, 128, 131));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Datos nominales");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel41)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Jp_usuarios1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 220, 30));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 212, 195), 3));

        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(128, 128, 131));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Información General");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel42)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Jp_usuarios1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 30));

        jLabel43.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(128, 128, 131));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("Número de Control");
        Jp_usuarios1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        t_salario1.setForeground(new java.awt.Color(153, 153, 153));
        t_salario1.setText("Ingresar Salario");
        t_salario1.setBorder(null);
        t_salario1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_salario1FocusLost(evt);
            }
        });
        t_salario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_salario1MouseClicked(evt);
            }
        });
        t_salario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_salario1ActionPerformed(evt);
            }
        });
        t_salario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_salario1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_salario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 162, -1));

        t_curp1.setForeground(new java.awt.Color(153, 153, 153));
        t_curp1.setText("Ingresar CURP");
        t_curp1.setBorder(null);
        t_curp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_curp1FocusLost(evt);
            }
        });
        t_curp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_curp1MouseClicked(evt);
            }
        });
        t_curp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_curp1ActionPerformed(evt);
            }
        });
        t_curp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_curp1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_curp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 162, -1));

        jSeparator18.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 162, 10));

        jSeparator19.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator19.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 162, 10));

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(128, 128, 131));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("RFC");
        Jp_usuarios1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 113, -1));

        t_gratificacion1.setForeground(new java.awt.Color(153, 153, 153));
        t_gratificacion1.setText("Ingresar Gratificación");
        t_gratificacion1.setBorder(null);
        t_gratificacion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_gratificacion1FocusLost(evt);
            }
        });
        t_gratificacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_gratificacion1MouseClicked(evt);
            }
        });
        t_gratificacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_gratificacion1ActionPerformed(evt);
            }
        });
        t_gratificacion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_gratificacion1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_gratificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 162, 20));

        jSeparator20.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator20.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 162, 10));

        bt_eliminar1.setBackground(new java.awt.Color(97, 212, 195));
        bt_eliminar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_eliminar1.setForeground(new java.awt.Color(255, 255, 255));
        bt_eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminarBlue.png"))); // NOI18N
        bt_eliminar1.setText("Eliminar");
        bt_eliminar1.setColorHover(new java.awt.Color(128, 128, 131));
        bt_eliminar1.setColorNormal(new java.awt.Color(97, 212, 195));
        bt_eliminar1.setColorTextHover(new java.awt.Color(102, 255, 255));
        bt_eliminar1.setColorTextNormal(new java.awt.Color(255, 255, 255));
        bt_eliminar1.setColorTextPressed(new java.awt.Color(255, 255, 255));
        bt_eliminar1.setIconTextGap(35);
        bt_eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminar1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(bt_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 150, -1));
        Jp_usuarios1.add(lb_errorNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 180, 20));
        Jp_usuarios1.add(lb_errorAPaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 190, 20));
        Jp_usuarios1.add(lb_errorAMaterno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 200, 20));
        Jp_usuarios1.add(lb_errorDomicilio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 200, 20));
        Jp_usuarios1.add(lb_errorSexo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 210, 20));
        Jp_usuarios1.add(lb_errorEstatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 190, 20));
        Jp_usuarios1.add(lb_errorCurp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 220, 20));
        Jp_usuarios1.add(lb_errorPuesto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 190, 20));
        Jp_usuarios1.add(lb_errorDepartamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 190, 20));
        Jp_usuarios1.add(lb_errorGratificacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 200, 20));
        Jp_usuarios1.add(lb_errorSalario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 190, 20));
        Jp_usuarios1.add(lb_errorNSS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 190, 20));
        Jp_usuarios1.add(lb_errorRFC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, 200, 20));

        lb_errorCampos1.setForeground(new java.awt.Color(255, 51, 51));
        Jp_usuarios1.add(lb_errorCampos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 260, 30));

        t_control1.setForeground(new java.awt.Color(153, 153, 153));
        t_control1.setText("Ingresar Número de Control");
        t_control1.setBorder(null);
        t_control1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_control1FocusLost(evt);
            }
        });
        t_control1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_control1MouseClicked(evt);
            }
        });
        t_control1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_control1ActionPerformed(evt);
            }
        });
        t_control1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_control1KeyTyped(evt);
            }
        });
        Jp_usuarios1.add(t_control1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 162, -1));

        jSeparator21.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator21.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 10));
        Jp_usuarios1.add(lb_errorControl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 180, 20));

        jLabel45.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(128, 128, 131));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Horario");
        Jp_usuarios1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 113, -1));

        cb_horario1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_horario1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_horario1ItemStateChanged(evt);
            }
        });
        cb_horario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_horario1ActionPerformed(evt);
            }
        });
        Jp_usuarios1.add(cb_horario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 162, -1));

        jLabel46.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(128, 128, 131));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Apellido Materno");
        Jp_usuarios1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jSeparator22.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator22.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 162, 10));
        Jp_usuarios1.add(jDateNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 160, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(128, 128, 131));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Fecha Ingreso");
        Jp_usuarios1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, -1, -1));
        Jp_usuarios1.add(jDateIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 160, -1));

        jSeparator03.setBackground(new java.awt.Color(128, 128, 131));
        jSeparator03.setForeground(new java.awt.Color(255, 255, 255));
        Jp_usuarios1.add(jSeparator03, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 162, 10));

        Jp_usuarios.add(Jp_usuarios1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTab_Usuarios.addTab("tab1", Jp_usuarios);

        Jp_contenido.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lista de empleados ");

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

        t_empleado.setForeground(new java.awt.Color(153, 153, 153));
        t_empleado.setText("Ingrese Nombre del Empleado");
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

        jSeparator5.setBackground(new java.awt.Color(128, 128, 131));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(128, 128, 131));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Buscar Empleado");

        javax.swing.GroupLayout Jp_contenidoLayout = new javax.swing.GroupLayout(Jp_contenido);
        Jp_contenido.setLayout(Jp_contenidoLayout);
        Jp_contenidoLayout.setHorizontalGroup(
            Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
            .addGroup(Jp_contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jp_contenidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jp_contenidoLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(33, 33, 33)
                        .addComponent(t_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Jp_contenidoLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(109, 109, 109))
        );
        Jp_contenidoLayout.setVerticalGroup(
            Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jp_contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addGroup(Jp_contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(t_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );

        jTab_Usuarios.addTab("tab2", Jp_contenido);

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

    private void cb_horarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_horarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_horarioActionPerformed

    private void cb_horarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_horarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_horarioItemStateChanged

    private void t_controlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_controlKeyTyped
        // TODO add your handling code here:
        //variable de tipo char

        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
        }
        //

        //Revisa que solamente se escriban números
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorControl.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorControl.setText("");
            t_control.setBorder(null);

        }
    }//GEN-LAST:event_t_controlKeyTyped

    private void t_controlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_controlActionPerformed
        // TODO add your handling code here:
        t_control.setText("");
    }//GEN-LAST:event_t_controlActionPerformed

    private void t_controlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_controlMouseClicked
        // TODO add your handling code here:
        // t_control.setText("");
        if (!t_control.getText().equals("Ingresar Número de Control")) {

        } else {
            t_control.setText("");
        }
    }//GEN-LAST:event_t_controlMouseClicked

    private void t_controlFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_controlFocusLost
        // TODO add your handling code here:
        if (t_control.getText().trim().equals("")) {
            t_control.setText("Ingresar Numero de Control");
            t_control.setForeground(new Color(153, 153, 153));

            // TODO add your handling code here:
        }


    }//GEN-LAST:event_t_controlFocusLost

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        // TODO add your handling code here:
        ec.eliminar(id_empleado);
        cargarTabla();
        limpiarCampos();
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void t_gratificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_gratificacionKeyTyped
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
            lb_errorGratificacion.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorGratificacion.setText("");
            t_gratificacion.setBorder(null);

        }
    }//GEN-LAST:event_t_gratificacionKeyTyped

    private void t_gratificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_gratificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacionActionPerformed

    private void t_gratificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_gratificacionMouseClicked
        if (!t_gratificacion.getText().equals("Ingresar Gratificación")) {

        } else {
            t_gratificacion.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacionMouseClicked

    private void t_gratificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_gratificacionFocusLost
        if (t_gratificacion.getText().trim().equals("")) {
            t_gratificacion.setText("Ingresar Gratificación");
            t_gratificacion.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacionFocusLost

    private void t_curpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_curpKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (t_curp.getText().length() == limiteCurp) {
            evt.consume();
        }
        if (!Character.isLetter(tecla) && !Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorCurp.setText("Solo se admiten números y letras");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorCurp.setText("");
            t_curp.setBorder(null);

        }
    }//GEN-LAST:event_t_curpKeyTyped

    private void t_curpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_curpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curpActionPerformed

    private void t_curpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_curpMouseClicked
        if (!t_curp.getText().equals("Ingresar CURP")) {

        } else {
            t_curp.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curpMouseClicked

    private void t_curpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_curpFocusLost
        if (t_curp.getText().trim().equals("")) {
            t_curp.setText("Ingresar CURP");
            t_curp.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curpFocusLost

    private void t_salarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_salarioKeyTyped
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
            lb_errorSalario.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorSalario.setText("");
            t_salario.setBorder(null);

        }
    }//GEN-LAST:event_t_salarioKeyTyped

    private void t_salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salarioActionPerformed

    private void t_salarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_salarioMouseClicked
        if (!t_salario.getText().equals("Ingresar Salario")) {

        } else {
            t_salario.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salarioMouseClicked

    private void t_salarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_salarioFocusLost
        if (t_salario.getText().trim().equals("")) {
            t_salario.setText("Ingresar Salario");
            t_salario.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salarioFocusLost

    private void cb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_estatusActionPerformed

    private void cb_estatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_estatusItemStateChanged
        if (!(cb_estatus.getSelectedIndex() == 0)) {
            lb_errorEstatus.setText("");
        }
    }//GEN-LAST:event_cb_estatusItemStateChanged

    private void cb_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_puestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_puestoActionPerformed

    private void cb_puestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_puestoItemStateChanged
        if (!(cb_puesto.getSelectedIndex() == 0)) {
            lb_errorPuesto.setText("");
        }
    }//GEN-LAST:event_cb_puestoItemStateChanged

    private void t_apaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_apaternoKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorAPaterno.setText("Verificar escritura");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorAPaterno.setText("");
            t_apaterno.setBorder(null);

        }
    }//GEN-LAST:event_t_apaternoKeyTyped

    private void t_apaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_apaternoActionPerformed
        t_apaterno.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaternoActionPerformed

    private void t_apaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_apaternoMouseClicked
        if (!t_apaterno.getText().equals("Ingresar Apellido Paterno")) {

        } else {
            t_apaterno.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaternoMouseClicked

    private void t_apaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_apaternoFocusLost
        if (t_apaterno.getText().trim().equals("")) {
            t_apaterno.setText("Ingresar Apellido Paterno");
            t_apaterno.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
    }//GEN-LAST:event_t_apaternoFocusLost

    private void cb_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sexoActionPerformed

    private void cb_sexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_sexoItemStateChanged
        if (!(cb_sexo.getSelectedIndex() == 0)) {
            lb_errorSexo.setText("");
        }
    }//GEN-LAST:event_cb_sexoItemStateChanged

    private void t_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nombreKeyTyped
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
            lb_errorNombre.setText("No se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorNombre.setText("");
            t_nombre.setBorder(null);

        }

    }//GEN-LAST:event_t_nombreKeyTyped

    private void t_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombreActionPerformed
        t_nombre.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombreActionPerformed

    private void t_nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nombreMouseClicked
        // TODO add your handling code here:

        if (!t_nombre.getText().equals("Ingresar Nombre")) {

        } else {
            t_nombre.setText("");
        }
    }//GEN-LAST:event_t_nombreMouseClicked

    private void t_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nombreFocusLost
        if (t_nombre.getText().trim().equals("")) {
            t_nombre.setText("Ingresar Nombre");
            t_nombre.setForeground(new Color(153, 153, 153));

            // }else{
            //        t_nombre.setBorder(null);
            // lb_errorCampos.setText("");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombreFocusLost

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
         cbIndexInicial();
        limpiarCampos();
        limpiarErrores();
        quitarBordeError();
        bloquearComponentes();

        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelarMouseClicked

    private void cb_departamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_departamentoItemStateChanged
        if (!(cb_departamento.getSelectedIndex() == 0)) {
            lb_errorDepartamento.setText("");
        }
    }//GEN-LAST:event_cb_departamentoItemStateChanged

    private void bt_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarActionPerformed
        if (!validarEscritura() == true || !validarSeleccion() == true) {

            lb_errorCampos.setText("TODOS LOS CAMPOS SON OBLIGATORIOS");

        } else {

            id_empleado = t_control.getText();
            nombre = t_nombre.getText();
            a_paterno = t_apaterno.getText();
            a_materno = t_amaterno.getText();
            direccion = t_direccion.getText();

            if (cb_sexo.getSelectedItem().toString().equals("Masculino")) {
                sexo = "1";

            } else if (cb_sexo.getSelectedItem().toString().equals("Femenino")) {
                sexo = "2";

            } else if (cb_sexo.getSelectedItem().toString().equals("No especificar")) {
                sexo = "3";
            }

            //sexo = Integer.parseInt(cb_sexo.getSelectedItem().toString()); //Combo box
            if (cb_estatus.getSelectedItem().toString().equals("Activo")) {
                estatus = "1";
            } else if (cb_estatus.getSelectedItem().toString().equals("Inactivo")) {
                estatus = "2";
            } else if (cb_estatus.getSelectedItem().toString().equals("Lista Negra")) {
                estatus = "3";
            }

            //estatus = Integer.parseInt(cb_estatus.getSelectedItem().toString());
            curp = t_curp.getText();
           id_horario = hc.consultarTurnoHorarioController(cb_horario.getSelectedItem().toString());
            id_cargo = cc.consultarIdeCargoController(cb_puesto.getSelectedItem().toString());
            id_departamento = dc.consultarAreaDepartamentoController(cb_departamento.getSelectedItem().toString());
            gratificacion = t_gratificacion.getText();
            salario = t_salario.getText();
            num_seg_social = t_nss.getText();
            rfc = t_rfc.getText();
           fecha_nacimiento  = ec.getFecha(jDateNacimiento);
            fecha_entrada = ec.getFecha(jDateIngreso);
            ec.guardar(accion, id_empleado, id_horario, id_cargo, nombre, a_paterno, a_materno, curp, id_departamento, direccion, salario, sexo, estatus, num_seg_social, rfc, gratificacion, fecha_nacimiento, fecha_entrada);
            bt_agregar.setText("Guardar");
            cargarTabla();
            lb_errorCampos.setText("");
            limpiarCampos();
            bloquearComponentes();
            cbIndexInicial();

            bt_nuevo.setEnabled(true);

            //PROGRAMADOR AQUÍ ESCRIBE TU CÓDIGO
            //FIN DEL CÓDIGO DEL PROGRAMADOR
        }

    }//GEN-LAST:event_bt_agregarActionPerformed

    private void bt_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_agregarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_agregarMouseClicked

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        accion = "I";
        desbloquearComponentes();
        ComponenteEditable();
        limpiarCampos();
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevoMouseClicked
        // TODO add your handling code here: bt_nuevo.setEnabled(false);
        bt_nuevo.setEnabled(false);
    }//GEN-LAST:event_bt_nuevoMouseClicked

    private void bt_nuevoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusLost

    private void bt_nuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevoFocusGained

    private void t_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_direccionKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (!Character.isLetter(tecla) && !Character.isDigit(tecla) && tecla != KeyEvent.VK_SPACE && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER && tecla != KeyEvent.VK_PERIOD) {
            getToolkit().beep();
            lb_errorDomicilio.setText("Solo se admiten números y letras");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorDomicilio.setText("");
            t_direccion.setBorder(null);
        }
    }//GEN-LAST:event_t_direccionKeyTyped

    private void t_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_direccionActionPerformed
        t_direccion.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccionActionPerformed

    private void t_direccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_direccionMouseClicked
        if (!t_direccion.getText().equals("Ingresar Domicilio")) {

        } else {
            t_direccion.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccionMouseClicked

    private void t_direccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_direccionFocusLost
        if (t_direccion.getText().trim().equals("")) {
            t_direccion.setText("Ingresar Domicilio");
            t_direccion.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccionFocusLost

    private void t_amaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_amaternoKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (!Character.isLetter(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorAMaterno.setText("Verificar escritura");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorAMaterno.setText("");
            t_amaterno.setBorder(null);

        }
    }//GEN-LAST:event_t_amaternoKeyTyped

    private void t_amaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_amaternoActionPerformed
        t_amaterno.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaternoActionPerformed

    private void t_amaternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_amaternoMouseClicked
        if (!t_amaterno.getText().equals("Ingresar Apellido Materno")) {

        } else {
            t_amaterno.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaternoMouseClicked

    private void t_amaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_amaternoFocusLost
        if (t_amaterno.getText().trim().equals("")) {
            t_amaterno.setText("Ingresar Apellido Materno");
            t_amaterno.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaternoFocusLost

    private void t_nssKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nssKeyTyped
        //variable de tipo char

        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));
        }
        //
        //compara tamaño
        if (t_nss.getText().length() == limiteNSS) {
            evt.consume();
        }

        //Revisa que solamente se escriban números
        if (!Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorNSS.setText("Solo se admiten números");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorNSS.setText("");
            t_nss.setBorder(null);

        }
    }//GEN-LAST:event_t_nssKeyTyped

    private void t_nssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nssActionPerformed
        t_nss.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nssActionPerformed

    private void t_nssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nssMouseClicked
        if (!t_nss.getText().equals("Número de Seguridad Social")) {

        } else {
            t_nss.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nssMouseClicked

    private void t_nssFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nssFocusLost
        if (t_nss.getText().trim().equals("")) {
            t_nss.setText("Numero de Seguridad Social");
            t_nss.setForeground(new Color(153, 153, 153));
            // TODO add your handling code here:
        }
    }//GEN-LAST:event_t_nssFocusLost

    private void t_rfcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_rfcKeyTyped
        //variable de tipo char
        char tecla;
        tecla = evt.getKeyChar();
        //Convertir a letras mayusculas
        if (Character.isLetter(tecla)) {
            evt.setKeyChar(Character.toUpperCase(tecla));

        }
        //
        if (t_rfc.getText().length() == limiteRFC) {
            evt.consume();
        }
        if (!Character.isLetter(tecla) && !Character.isDigit(tecla) && tecla != KeyEvent.VK_BACK_SPACE && tecla != KeyEvent.VK_ENTER) {
            getToolkit().beep();
            lb_errorRFC.setText("Solo se admiten número y letras");
            evt.consume();
            //para borrar el texto
        } else {
            lb_errorRFC.setText("");
            t_rfc.setBorder(null);

        }
    }//GEN-LAST:event_t_rfcKeyTyped

    private void t_rfcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rfcActionPerformed
        t_rfc.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfcActionPerformed

    private void t_rfcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_rfcMouseClicked
        if (!t_rfc.getText().equals("Registro Federal de Contribuyentes")) {

        } else {
            t_rfc.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfcMouseClicked

    private void t_rfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_rfcFocusLost
        if (t_rfc.getText().trim().equals("")) {
            t_rfc.setText("Registro Federal de Contribuyentes");
            t_rfc.setForeground(new Color(153, 153, 153));
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfcFocusLost

    private void jt_empleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_empleadosMouseClicked
        //AQUI VA EL CODIGO PARA SELECCIONAR UN EMPLEADO Y EDITAR O BORRARLO
        ComponenteEditable();
        desbloquear_item();
        int filaSel = jt_empleados.getSelectedRow();
        id_empleado = jt_empleados.getValueAt(filaSel, 0).toString();
        consultarId(id_empleado);
        accion = "M";
        cargarTabla();
        lb_errorCampos.setText("");
        desbloquearComponentes();
    }//GEN-LAST:event_jt_empleadosMouseClicked

    private void t_empleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_empleadoFocusLost
        if (t_empleado.getText().trim().equals("")) {
            t_empleado.setText("Ingrese Nombre del Empleado");
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
        filtro(t_empleado.getText(), jt_empleados);
    }//GEN-LAST:event_t_empleadoKeyTyped

    private void t_rfc1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_rfc1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfc1FocusLost

    private void t_rfc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_rfc1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfc1MouseClicked

    private void t_rfc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_rfc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfc1ActionPerformed

    private void t_rfc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_rfc1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_rfc1KeyTyped

    private void t_nss1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nss1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nss1FocusLost

    private void t_nss1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nss1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nss1MouseClicked

    private void t_nss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nss1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nss1ActionPerformed

    private void t_nss1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nss1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nss1KeyTyped

    private void t_amaterno1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_amaterno1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaterno1FocusLost

    private void t_amaterno1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_amaterno1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaterno1MouseClicked

    private void t_amaterno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_amaterno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaterno1ActionPerformed

    private void t_amaterno1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_amaterno1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_amaterno1KeyTyped

    private void t_direccion1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_direccion1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccion1FocusLost

    private void t_direccion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_direccion1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccion1MouseClicked

    private void t_direccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_direccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccion1ActionPerformed

    private void t_direccion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_direccion1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_direccion1KeyTyped

    private void bt_nuevo1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevo1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevo1FocusGained

    private void bt_nuevo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bt_nuevo1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevo1FocusLost

    private void bt_nuevo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_nuevo1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevo1MouseClicked

    private void bt_nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_nuevo1ActionPerformed

    private void bt_agregar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_agregar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_agregar1MouseClicked

    private void bt_agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_agregar1ActionPerformed

    private void cb_departamento1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_departamento1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_departamento1ItemStateChanged

    private void bt_cancelar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelar1MouseClicked

    private void bt_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_cancelar1ActionPerformed

    private void t_nombre1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nombre1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombre1FocusLost

    private void t_nombre1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_nombre1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombre1MouseClicked

    private void t_nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombre1ActionPerformed

    private void t_nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nombre1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombre1KeyTyped

    private void cb_sexo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_sexo1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sexo1ItemStateChanged

    private void cb_sexo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sexo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_sexo1ActionPerformed

    private void t_apaterno1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_apaterno1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaterno1FocusLost

    private void t_apaterno1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_apaterno1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaterno1MouseClicked

    private void t_apaterno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_apaterno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaterno1ActionPerformed

    private void t_apaterno1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_apaterno1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_apaterno1KeyTyped

    private void cb_puesto1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_puesto1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_puesto1ItemStateChanged

    private void cb_puesto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_puesto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_puesto1ActionPerformed

    private void cb_estatus1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_estatus1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_estatus1ItemStateChanged

    private void cb_estatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_estatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_estatus1ActionPerformed

    private void t_salario1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_salario1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salario1FocusLost

    private void t_salario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_salario1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salario1MouseClicked

    private void t_salario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_salario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salario1ActionPerformed

    private void t_salario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_salario1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_salario1KeyTyped

    private void t_curp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_curp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curp1FocusLost

    private void t_curp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_curp1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curp1MouseClicked

    private void t_curp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_curp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curp1ActionPerformed

    private void t_curp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_curp1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_curp1KeyTyped

    private void t_gratificacion1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_gratificacion1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacion1FocusLost

    private void t_gratificacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_gratificacion1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacion1MouseClicked

    private void t_gratificacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_gratificacion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacion1ActionPerformed

    private void t_gratificacion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_gratificacion1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_gratificacion1KeyTyped

    private void bt_eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_eliminar1ActionPerformed

    private void t_control1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_control1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_t_control1FocusLost

    private void t_control1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_control1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_t_control1MouseClicked

    private void t_control1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_control1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_control1ActionPerformed

    private void t_control1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_control1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_t_control1KeyTyped

    private void cb_horario1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_horario1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_horario1ItemStateChanged

    private void cb_horario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_horario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_horario1ActionPerformed

    public void aparenciaTabs() {
        ImageIcon iconPestaña = new ImageIcon(this.getClass().getResource("../Imagenes/addusers.png"));
        jTab_Usuarios.addTab("usuarios", iconPestaña, Jp_usuarios);
        this.add(jTab_Usuarios, BorderLayout.CENTER);

        ImageIcon iconPestaña2 = new ImageIcon(this.getClass().getResource("../Imagenes/menu32.png"));
        jTab_Usuarios.addTab("Tabla de Contenido", iconPestaña2, Jp_contenido);
        this.add(jTab_Usuarios, BorderLayout.CENTER);

    }

    public void bloquearComponentes() {
        t_nombre.setEnabled(false);
        t_apaterno.setEnabled(false);
        t_amaterno.setEnabled(false);
        t_direccion.setEnabled(false);
        cb_sexo.setEnabled(false);
        cb_puesto.setEnabled(false);
        cb_departamento.setEnabled(false);
        cb_horario.setEnabled(false);
        t_gratificacion.setEnabled(false);
        t_salario.setEnabled(false);
        cb_estatus.setEnabled(false);
        cb_sexo.setEnabled(false);
        t_nss.setEnabled(false);
        t_rfc.setEnabled(false);
        t_curp.setEnabled(false);
        t_control.setEnabled(false);
        bt_nuevo.setEnabled(true);
        bt_agregar.setEnabled(false);
        bt_cancelar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        jDateIngreso.setEnabled(false);
        jDateNacimiento.setEnabled(false);
        bt_agregar.setText("Guardar");

    }
    
    

     public void desbloquear_item(){
         t_nombre.setEnabled(true);
        t_apaterno.setEnabled(true);
        t_amaterno.setEnabled(true);
        t_direccion.setEnabled(true);
        cb_sexo.setEnabled(true);
        cb_puesto.setEnabled(true);
        cb_departamento.setEnabled(true);
        cb_horario.setEnabled(true);
        t_gratificacion.setEnabled(true);
        t_salario.setEnabled(true);
        cb_estatus.setEnabled(true);
        cb_sexo.setEnabled(true);
        t_nss.setEnabled(true);
        t_rfc.setEnabled(true);
        t_curp.setEnabled(true);
        t_control.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        jDateIngreso.setEnabled(true);
        jDateNacimiento.setEnabled(true);
        bt_agregar.setText("Actualizar");
    }

    public void desbloquearComponentes() {
        t_nombre.setEnabled(true);
        t_apaterno.setEnabled(true);
        t_amaterno.setEnabled(true);
        t_direccion.setEnabled(true);
        cb_sexo.setEnabled(true);
        cb_puesto.setEnabled(true);
        cb_departamento.setEnabled(true);
        cb_horario.setEnabled(true);
        t_gratificacion.setEnabled(true);
        t_salario.setEnabled(true);
        cb_estatus.setEnabled(true);
        cb_sexo.setEnabled(true);
        t_nss.setEnabled(true);
        t_rfc.setEnabled(true);
        t_curp.setEnabled(true);
        t_control.setEnabled(true);
        bt_nuevo.setEnabled(false);
        bt_agregar.setEnabled(true);
        bt_cancelar.setEnabled(true);
        bt_eliminar.setEnabled(true);
        jDateIngreso.setEnabled(true);
        jDateNacimiento.setEnabled(true);
        jTab_Usuarios.setSelectedIndex(0);
    }

    public void ComponenteNoEditable() {
        t_nombre.setEditable(false);
        t_apaterno.setEditable(false);
        t_amaterno.setEditable(false);
        t_direccion.setEditable(false);
        t_nss.setEditable(false);
        t_rfc.setEditable(false);
        t_curp.setEditable(false);
        t_gratificacion.setEditable(false);
        t_salario.setEditable(false);
        t_control.setEditable(false);
    }

    public void ComponenteEditable() {
        t_nombre.setEditable(true);
        t_apaterno.setEditable(true);
        t_amaterno.setEditable(true);
        t_direccion.setEditable(true);
        t_nss.setEditable(true);
        t_rfc.setEditable(true);
        t_curp.setEditable(true);
        t_gratificacion.setEditable(true);
        t_salario.setEditable(true);
        t_control.setEditable(true);
    }

    public void cbIndexInicial() {
        cb_sexo.setSelectedIndex(0);
        cb_puesto.setSelectedIndex(0);
        cb_departamento.setSelectedIndex(0);
        cb_horario.setSelectedIndex(0);
        cb_sexo.setSelectedIndex(0);
        cb_estatus.setSelectedIndex(0);
        jDateNacimiento.setDate(null);
        jDateIngreso.setDate(null);

    }

    public void limpiarCampos() {
        t_nombre.setText("Ingresar Nombre");
        t_apaterno.setText("Ingresar Apellido Paterno");
        t_amaterno.setText("Ingresar Apellido Materno");
        t_direccion.setText("Ingresar Domicilio");
        t_nss.setText("Número de Seguridad Social");
        t_rfc.setText("Registro Federal de Contribuyentes");
        t_curp.setText("Ingresar CURP");
        t_gratificacion.setText("Ingresar Gratificación");
        t_salario.setText("Ingresar Salario");
        t_control.setText("Ingresar Número de Control");
    }

    public Boolean validarEscritura() {
        Boolean val = true;
        //si el textfield tiene algo diferente a Vacío aparecerá de color negro
        if (!(t_nombre.getText().equals("Ingresar Nombre")) && !(t_nombre.getText().equals(""))) {
            t_nombre.setBorder(null);
            lb_errorNombre.setText("");
        } else {

            t_nombre.setBorder(new LineBorder(Color.RED, 1));
            lb_errorNombre.setText("Ingrese un nombre válido");

            val = false;
        }
        if (!(t_apaterno.getText().equals("Ingresar Apellido Paterno")) && !(t_apaterno.getText().equals(""))) {
            t_apaterno.setBorder(null);
            lb_errorAPaterno.setText("");
        } else {

            t_apaterno.setBorder(new LineBorder(Color.RED, 1));
            lb_errorAPaterno.setText("Ingrese un apellido válido");

            val = false;
        }

        if (!(t_amaterno.getText().equals("Ingresar Apellido Materno")) && !(t_amaterno.getText().equals(""))) {
            t_amaterno.setBorder(null);
            lb_errorAMaterno.setText("");
        } else {

            t_amaterno.setBorder(new LineBorder(Color.RED, 1));
            lb_errorAMaterno.setText("Ingrese un apellido válido");

            val = false;
        }
        if (!(t_direccion.getText().equals("Ingresar Domicilio")) && !(t_direccion.getText().equals(""))) {
            t_direccion.setBorder(null);
            lb_errorDomicilio.setText("");
        } else {

            t_direccion.setBorder(new LineBorder(Color.RED, 1));
            lb_errorDomicilio.setText("Ingrese un domicilio válido");

            val = false;
        }

        if (!(t_curp.getText().equals("Ingresar CURP")) && !(t_curp.getText().equals("")) && !(t_curp.getText().length() < limiteCurp)) {
            t_curp.setBorder(null);
            lb_errorCurp.setText("");
        } else {

            t_curp.setBorder(new LineBorder(Color.RED, 1));
            lb_errorCurp.setText("Ingrese un CURP válido");

            val = false;
        }

        if (!(t_gratificacion.getText().equals("Ingresar Gratificación")) && !(t_gratificacion.getText().equals(""))) {
            t_gratificacion.setBorder(null);
            lb_errorGratificacion.setText("");
        } else {

            t_gratificacion.setBorder(new LineBorder(Color.RED, 1));
            lb_errorGratificacion.setText("Ingrese una Gratificación válida");

            val = false;
        }
        if (!(t_salario.getText().equals("Ingresar Salario")) && !(t_salario.getText().equals(""))) {
            t_salario.setBorder(null);
            lb_errorSalario.setText("");
        } else {

            t_salario.setBorder(new LineBorder(Color.RED, 1));
            lb_errorSalario.setText("Ingrese un salario válido");

            val = false;
        }

        if (!(t_nss.getText().equals("Número de Seguridad Social")) && !(t_nss.getText().equals("")) && !(t_nss.getText().length() < limiteNSS)) {
            t_nss.setBorder(null);
            lb_errorNSS.setText("");
        } else {

            t_nss.setBorder(new LineBorder(Color.RED, 1));
            lb_errorNSS.setText("Ingrese un número válido");

            val = false;
        }

        if (!(t_rfc.getText().equals("Registro Federal de Contribuyentes")) && !(t_rfc.getText().equals("")) && !(t_rfc.getText().length() < limiteRFC)) {
            t_rfc.setBorder(null);
            lb_errorRFC.setText("");
        } else {

            t_rfc.setBorder(new LineBorder(Color.RED, 1));
            lb_errorRFC.setText("Ingrese un RFC válido");

            val = false;
        }
        if (!(t_control.getText().equals("Ingresar Número de Control")) && !(t_control.getText().equals(""))) {
            t_control.setBorder(null);
            lb_errorControl.setText("");
        } else {

            t_control.setBorder(new LineBorder(Color.RED, 1));
            lb_errorControl.setText("Ingrese un número válido");

            val = false;
        }

        return val;
    }
//COMBO box

    public Boolean validarSeleccion() {
        Boolean val = true;
        if (!(cb_sexo.getSelectedIndex() == 0)) {

            lb_errorSexo.setText("");
        } else {

            lb_errorSexo.setText("Seleccione una opción válida");

            val = false;
        }

        if (!(cb_estatus.getSelectedIndex() == 0)) {

            lb_errorEstatus.setText("");
        } else {

            lb_errorEstatus.setText("Seleccione una opción válida");

            val = false;
        }

        if (!(cb_puesto.getSelectedIndex() == 0)) {

            lb_errorPuesto.setText("");
        } else {

            lb_errorPuesto.setText("Seleccione una opción válida");

            val = false;
        }
        if (!(cb_departamento.getSelectedIndex() == 0)) {

            lb_errorDepartamento.setText("");
        } else {

            lb_errorDepartamento.setText("Seleccione una opción válida");

            val = false;
        }

        return val;

    }

    public Boolean quitarBordeError() {
        Boolean val = true;

        if (!(t_nombre.getText().equals(""))) {
            t_nombre.setBorder(null);
            lb_errorNombre.setText("");
        } else {
            val = false;
        }

        if (!(t_apaterno.getText().equals(""))) {
            t_apaterno.setBorder(null);
            lb_errorAPaterno.setText("");
        } else {
            val = false;
        }
        if (!(t_amaterno.getText().equals(""))) {
            t_amaterno.setBorder(null);
            lb_errorAMaterno.setText("");
        } else {
            val = false;
        }
        
        if (!(t_direccion.getText().equals(""))) {
            t_direccion.setBorder(null);
            lb_errorDomicilio.setText("");
        } else {
            val = false;
        }
        if (!(t_curp.getText().equals(""))) {
            t_curp.setBorder(null);
            lb_errorCurp.setText("");
        } else {
            val = false;
        }
        if (!(t_gratificacion.getText().equals(""))) {
            t_gratificacion.setBorder(null);
            lb_errorGratificacion.setText("");
        } else {
            val = false;
        }
        if (!(t_salario.getText().equals(""))) {
            t_salario.setBorder(null);
            lb_errorSalario.setText("");
        } else {
            val = false;
        }
        if (!(t_nss.getText().equals(""))) {
            t_nss.setBorder(null);
            lb_errorNSS.setText("");
        } else {
            val = false;
        }
        if (!(t_rfc.getText().equals(""))) {
            t_rfc.setBorder(null);
            lb_errorRFC.setText("");
        } else {
            val = false;
        }
        if (!(t_control.getText().equals(""))) {
            t_control.setBorder(null);
            lb_errorControl.setText("");
        } else {
            val = false;
        }
        return val;
    }

    public void limpiarErrores() {
        lb_errorNombre.setText("");
        lb_errorAPaterno.setText("");
        lb_errorAMaterno.setText("");
        lb_errorDomicilio.setText("");
        lb_errorNSS.setText("");
        lb_errorRFC.setText("");
        lb_errorCurp.setText("");
        lb_errorGratificacion.setText("");
        lb_errorSalario.setText("");
        lb_errorControl.setText("");
        lb_errorSexo.setText("");
        lb_errorEstatus.setText("");
        lb_errorPuesto.setText("");
        lb_errorDepartamento.setText("");
        lb_errorCampos.setText("");
    }

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
    private javax.swing.JPanel Jp_usuarios1;
    private Utilerias.RSButtonMetro bt_agregar;
    private Utilerias.RSButtonMetro bt_agregar1;
    private Utilerias.RSButtonMetro bt_cancelar;
    private Utilerias.RSButtonMetro bt_cancelar1;
    private Utilerias.RSButtonMetro bt_eliminar;
    private Utilerias.RSButtonMetro bt_eliminar1;
    private Utilerias.RSButtonMetro bt_nuevo;
    private Utilerias.RSButtonMetro bt_nuevo1;
    private javax.swing.JComboBox<String> cb_departamento;
    private javax.swing.JComboBox<String> cb_departamento1;
    private javax.swing.JComboBox<String> cb_estatus;
    private javax.swing.JComboBox<String> cb_estatus1;
    private javax.swing.JComboBox<String> cb_horario;
    private javax.swing.JComboBox<String> cb_horario1;
    private javax.swing.JComboBox<String> cb_puesto;
    private javax.swing.JComboBox<String> cb_puesto1;
    private javax.swing.JComboBox<String> cb_sexo;
    private javax.swing.JComboBox<String> cb_sexo1;
    private com.toedter.calendar.JDateChooser jDateIngreso;
    private com.toedter.calendar.JDateChooser jDateNacimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator03;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTab_Usuarios;
    private javax.swing.JTable jt_empleados;
    private javax.swing.JLabel lb_errorAMaterno;
    private javax.swing.JLabel lb_errorAMaterno1;
    private javax.swing.JLabel lb_errorAPaterno;
    private javax.swing.JLabel lb_errorAPaterno1;
    private javax.swing.JLabel lb_errorCampos;
    private javax.swing.JLabel lb_errorCampos1;
    private javax.swing.JLabel lb_errorControl;
    private javax.swing.JLabel lb_errorControl1;
    private javax.swing.JLabel lb_errorCurp;
    private javax.swing.JLabel lb_errorCurp1;
    private javax.swing.JLabel lb_errorDepartamento;
    private javax.swing.JLabel lb_errorDepartamento1;
    private javax.swing.JLabel lb_errorDomicilio;
    private javax.swing.JLabel lb_errorDomicilio1;
    private javax.swing.JLabel lb_errorEstatus;
    private javax.swing.JLabel lb_errorEstatus1;
    private javax.swing.JLabel lb_errorGratificacion;
    private javax.swing.JLabel lb_errorGratificacion1;
    private javax.swing.JLabel lb_errorNSS;
    private javax.swing.JLabel lb_errorNSS1;
    private javax.swing.JLabel lb_errorNombre;
    private javax.swing.JLabel lb_errorNombre1;
    private javax.swing.JLabel lb_errorPuesto;
    private javax.swing.JLabel lb_errorPuesto1;
    private javax.swing.JLabel lb_errorRFC;
    private javax.swing.JLabel lb_errorRFC1;
    private javax.swing.JLabel lb_errorSalario;
    private javax.swing.JLabel lb_errorSalario1;
    private javax.swing.JLabel lb_errorSexo;
    private javax.swing.JLabel lb_errorSexo1;
    private javax.swing.JTextField t_amaterno;
    private javax.swing.JTextField t_amaterno1;
    private javax.swing.JTextField t_apaterno;
    private javax.swing.JTextField t_apaterno1;
    private javax.swing.JTextField t_control;
    private javax.swing.JTextField t_control1;
    private javax.swing.JTextField t_curp;
    private javax.swing.JTextField t_curp1;
    private javax.swing.JTextField t_direccion;
    private javax.swing.JTextField t_direccion1;
    private javax.swing.JTextField t_empleado;
    private javax.swing.JTextField t_gratificacion;
    private javax.swing.JTextField t_gratificacion1;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_nombre1;
    private javax.swing.JTextField t_nss;
    private javax.swing.JTextField t_nss1;
    private javax.swing.JTextField t_rfc;
    private javax.swing.JTextField t_rfc1;
    private javax.swing.JTextField t_salario;
    private javax.swing.JTextField t_salario1;
    // End of variables declaration//GEN-END:variables
}
