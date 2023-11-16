/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import bean.ProdutosGvo;
import bean.VendedorGvo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author carlo
 */
public class ProdutosControle extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    ;
    public ProdutosGvo getBean(int row) {
        return (ProdutosGvo) lista.get(row);
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

        ProdutosGvo produtosGvo = (ProdutosGvo) lista.get(rowIndex);
        if (columnIndex == 0) {
            return produtosGvo.getIdProdutosGvo();
        }
        if (columnIndex == 1) {
            return produtosGvo.getNomeGvo();
        }
        if (columnIndex == 2) {
            return produtosGvo.getPrecoGvo();
        }
        if (columnIndex == 3) {
            return produtosGvo.getPlataformaGvo();
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
            return "Preco";
        }
        if (column == 3) {
            return "Plataforma";
        }

        return "";
    }
;
}
