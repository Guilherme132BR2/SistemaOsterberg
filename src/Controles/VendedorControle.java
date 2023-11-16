/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import bean.VendedorGvo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class VendedorControle extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public VendedorGvo getBean(int row) {
        return (VendedorGvo) lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        VendedorGvo vendedorGvo = (VendedorGvo) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendedorGvo.getIdVendedorGvo();
        }
        if (columnIndex == 1) {
            return vendedorGvo.getNomeGvo();
        }
        if (columnIndex == 2) {
            return vendedorGvo.getCpfGvo();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "id";
        }
        if (column == 1) {
            return "nome";
        }
        if (column == 2) {
            return "CPF";
        }

        return "";
    }
;
}
