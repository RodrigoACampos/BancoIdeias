package model;

import entidade.Ideia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcelo
 */
public class IdeiaTableModel extends AbstractTableModel {

    private Ideia ideia;
    private List<Ideia> listaIdeias;

    public Ideia getIdeia() {
        return ideia;
    }

    public void setIdeia(Ideia ideia) {
        this.ideia = ideia;
    }

    public List<Ideia> getListaideia() {
        return listaIdeias;
    }

    public void setListaideias(List<Ideia> listaideias) {
        this.listaIdeias = listaideias;
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
            valor = String.valueOf(listaIdeias.get(rowIndex).getTema());
        }

        if (columnIndex == 2) {
            valor = String.valueOf(listaIdeias.get(rowIndex).getDtcadastro().toString());
        }
        
        return valor;
        
    }

    public String getColumnName(int column) {
        
        String valor = "";

        if (column == 0) {
            valor = "Código";
        }

        if (column == 1) {
            valor = "Tema";
        }

        if (column == 2) {
            valor = "Dt. Caadastro";
        }

        return valor;
        
    }

}
