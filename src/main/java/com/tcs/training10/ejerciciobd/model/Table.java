package com.tcs.training10.ejerciciobd.model;

import javax.swing.table.DefaultTableModel;

public class Table extends DefaultTableModel {

    public boolean isCellEditable(int row, int column){
        return false;
    }
}