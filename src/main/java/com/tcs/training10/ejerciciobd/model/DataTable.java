package com.tcs.training10.ejerciciobd.model;

import javax.swing.JTable;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;
import java.awt.BorderLayout;

public class DataTable extends JDialog {

  public JTable table;
  private Table modelo = new Table();

  public DataTable(JFrame parent, boolean modal, String[] columns) {

    super(parent, modal);
    startComponents(columns);
  }

  public static void cleanTable(DefaultTableModel model) {

    while (model.getRowCount() > 0) {
      model.removeRow(0);
    }
  }

  private void startComponents(String[] columns) {

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

      for (String column : columns) {
          modelo.addColumn(column.toUpperCase());
      }

    table = new JTable(modelo);
    table.getTableHeader().setReorderingAllowed(false);
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll, BorderLayout.CENTER);
    table.setRowHeight(33);

    pack();
    table.setRowSorter(new TableRowSorter<>(modelo));

    for (int i = 0; i < columns.length; i++) {
      DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
      defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
      table.getColumnModel().getColumn(i).setCellRenderer(defaultTableCellRenderer);
    }
  }
}