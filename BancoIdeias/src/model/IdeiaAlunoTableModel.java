package model;

import entidade.Ideia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pegasus
 */
public class IdeiaAlunoTableModel extends AbstractTableModel{

    private List<Ideia> listaIdeias;
//    private Solicitante solicitante;
    
    public List<Ideia> getListaIdeia() {
        return listaIdeias;
    }

    public void setListaIdeias(List<Ideia> listaIdeias) {
        this.listaIdeias = listaIdeias;
    }

    @Override
    public int getRowCount() {
       return listaIdeias.size();
    }

    @Override
    public int getColumnCount() {
        return 2;  
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
            valor = "Tema";            
        }        

        return valor;
    }
    
}
