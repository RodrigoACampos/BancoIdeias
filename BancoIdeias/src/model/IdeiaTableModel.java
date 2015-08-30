package model;

import entidade.Ideia;
import entidade.Solicitante;
import java.util.List;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcelo
 */
public class IdeiaTableModel extends AbstractTableModel {

    private List<Ideia> listaIdeias;

    public IdeiaTableModel(List<Ideia> listaIdeias) {
        this.listaIdeias = listaIdeias;
    }

    public void setListaIdeias(List<Ideia> listaIdeias) {
        this.listaIdeias = listaIdeias;
    }

    public List<Ideia> getListaIdeias() {
        return listaIdeias;
    }

    @Override
    public int getRowCount() {
        return listaIdeias.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    protected Ideia getObjetoAt(int rowIndex) {
        return listaIdeias.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String valor = "";
        if (columnIndex == 0) {
            valor = String.valueOf(listaIdeias.get(rowIndex).getId());
        }

        if (columnIndex == 1) {
            //valor = listaIdeias.get(rowIndex).getTema();
            valor = listaIdeias.get(rowIndex).getSolicitante().getNome();
        }

        if (columnIndex == 2) {
            valor = listaIdeias.get(rowIndex).getTema();
        }
        return valor;
    }

    @Override
    public String getColumnName(int column) {
        String valor = "";
        if (column == 0) {
            valor = "Código";
        }
        if (column == 1) {
            valor = "Solicitante";
        }
        if (column == 2) {
            valor = "Tema";
        }

        return valor;
    }

}
