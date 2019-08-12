/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
//----------------------------------------------------------------------------------------------------------------------

public class PegarExcel implements ActionListener {

    private String rowstring, value;
    private Clipboard system;
    private StringSelection stringSelection, stsel;
    private JTable jTable1;
//----------------------------------------------------------------------------------------------------------------------

    public PegarExcel(JTable myJTable) {
        jTable1 = myJTable;

        KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK, false);

        jTable1.registerKeyboardAction(this, "Paste", paste, JComponent.WHEN_FOCUSED);

        system = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
//----------------------------------------------------------------------------------------------------------------------

    public JTable getJTable() {
        return jTable1;
    }
//----------------------------------------------------------------------------------------------------------------------

    public void setJTable(JTable jTable1) {
        this.jTable1 = jTable1;
    }
//----------------------------------------------------------------------------------------------------------------------

    void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg,
                msg,
                JOptionPane.ERROR_MESSAGE);
    }
//----------------------------------------------------------------------------------------------------------------------

    void pasteAction() {
        system = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            String data = (String) system.getData(DataFlavor.stringFlavor);
            if (data == null) {
                showErrorMessage("No data on clipboard");
                return;
            }

            int selectCol = jTable1.getSelectedColumn();
            int selectRow = jTable1.getSelectedRow();
            if (selectCol < 0 || selectRow < 0) {
                showErrorMessage("Please Select cell");
                return;
            }
//devuelve clipboard contenido

            StringTokenizer st, stTmp;
            st = new StringTokenizer(data, "\n");
            int pasteRows = st.countTokens();
            st = new StringTokenizer(st.nextToken().trim(), "\t");
            int pasteCols = st.countTokens();
            int marginCols = jTable1.getColumnCount() - selectCol;
            int marginRows = jTable1.getRowCount() - selectRow;
//revisa espacio disponible
            if (marginCols < pasteCols || marginRows < pasteRows) {
                showErrorMessage("La tabla no posee el espacio suficiente para pegar los datos");
                return;
            }
            st = new StringTokenizer(data, "\n");
            int rowCount = 0, colCount;
//copia a la tabla
            while (st.hasMoreTokens()) {
                stTmp = new StringTokenizer(st.nextToken(), "\t");
                colCount = 0;
                while (stTmp.hasMoreTokens()) {
                    jTable1.setValueAt(stTmp.nextToken(), rowCount + selectRow, colCount + selectCol);
                    colCount++;
                }

                rowCount++;
            }
        } catch (UnsupportedFlavorException uf) {
            System.out.println("uf=" + uf.getMessage());
        } catch (IOException io) {
            System.out.println("io=" + io.getMessage());
        }
        TableColumn tcol = jTable1.getColumnModel().getColumn(3);
        TableColumn tco2 = jTable1.getColumnModel().getColumn(4);
        TableColumn tco3 = jTable1.getColumnModel().getColumn(5);

        TableColumn tco4 = jTable1.getColumnModel().getColumn(6);
        TableColumn tco5 = jTable1.getColumnModel().getColumn(13);
        TableColumn tco6 = jTable1.getColumnModel().getColumn(14);
        TableColumn tco7 = jTable1.getColumnModel().getColumn(15);
        TableColumn tco8 = jTable1.getColumnModel().getColumn(16);
        TableColumn tco9 = jTable1.getColumnModel().getColumn(5);
        jTable1.getColumnModel().removeColumn(tcol);
        jTable1.getColumnModel().removeColumn(tco2);
        jTable1.getColumnModel().removeColumn(tco3);
        jTable1.getColumnModel().removeColumn(tco4);
        jTable1.getColumnModel().removeColumn(tco5);
        jTable1.getColumnModel().removeColumn(tco6);
        jTable1.getColumnModel().removeColumn(tco7);
        jTable1.getColumnModel().removeColumn(tco8);
        jTable1.getColumnModel().removeColumn(tco9);

        TableColumnModel colummodel = jTable1.getColumnModel();
        colummodel.getColumn(0).setPreferredWidth(3);
        colummodel.getColumn(1).setPreferredWidth(80);
        colummodel.getColumn(2).setPreferredWidth(200);
        colummodel.getColumn(3).setPreferredWidth(20);
        colummodel.getColumn(4).setPreferredWidth(20);
        colummodel.getColumn(5).setPreferredWidth(20);
        colummodel.getColumn(6).setPreferredWidth(20);
        colummodel.getColumn(7).setPreferredWidth(20);
        colummodel.getColumn(8).setPreferredWidth(20);
        colummodel.getColumn(9).setPreferredWidth(20);
        colummodel.getColumn(10).setPreferredWidth(20);
        colummodel.getColumn(11).setPreferredWidth(20);
        colummodel.getColumn(12).setPreferredWidth(20);
        colummodel.getColumn(13).setPreferredWidth(20);
        colummodel.getColumn(14).setPreferredWidth(20);
        colummodel.getColumn(15).setPreferredWidth(20);
        colummodel.getColumn(16).setPreferredWidth(20);
        colummodel.getColumn(17).setPreferredWidth(20);
        colummodel.getColumn(18).setPreferredWidth(20);
        colummodel.getColumn(19).setPreferredWidth(20);
        colummodel.getColumn(20).setPreferredWidth(40);
      
       
    }

//----------------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Paste") == 0) {
            pasteAction();
            return;
        }

    }
}
