/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import bean.UsuariosGvo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author carlo
 */
public class UsuariosControle extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public UsuariosGvo getBean(int row) {
        return (UsuariosGvo) lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        UsuariosGvo usuariosGvo = (UsuariosGvo) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuariosGvo.getIdUsuariosGvo();
        }
        if (columnIndex == 1) {
            return usuariosGvo.getNomeGvo();
        }
        if (columnIndex == 2) {
            return usuariosGvo.getApelidoGvo();
        }
        if (columnIndex == 3) {
            return usuariosGvo.getCpfGvo();
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
            return "apelido";
        }
        if (column == 3) {
            return "cpf";
        }

        return "";
    }
;
}
