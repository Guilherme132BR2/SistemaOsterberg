/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import bean.ClienteGvo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Guilherme132BR
 */
public class ClienteControle extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public ClienteGvo getBean(int row) {
        return (ClienteGvo) lista.get(row);
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

        ClienteGvo clienteGvo = (ClienteGvo) lista.get(rowIndex);
        if (columnIndex == 0) {
            return clienteGvo.getIdClienteGvo();
        }
        if (columnIndex == 1) {
            return clienteGvo.getNomeGvo();
        }
        if (columnIndex == 2) {
            return clienteGvo.getSobreNomeGvo();
        }
        if (columnIndex == 3) {
            return clienteGvo.getCpfGvo();
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
            return "Sobrenome";
        }
        if (column == 2) {
            return "CPF";
        }

        return "";
    }
;
}
