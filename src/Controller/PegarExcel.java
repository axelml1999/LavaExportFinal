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

        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
       String va = null;
        int total = 0;
        for (int i = 0; i < 398; i++) {
            if (jTable1.getValueAt(i, 0) == null) {
                total = i;
                break;
            }        }
        System.out.print(total);
       
        int[] rows = jTable1.getSelectedRows(); // En plural el rows.
        Arrays.sort(rows);   // Ordena los indices ascendente, el mayor al final.

// Recorremos el array rows (ya ordenado) empezando por el último.
        for (int i = rows.length - 1; i >= total; i--) {
            dtm.removeRow(rows[i]);
        }

        jTable1.setModel(dtm);
    }

//----------------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Paste") == 0) {
            pasteAction();
            return;
        }

    }
}
