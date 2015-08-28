package model;

import entidade.Solicitante;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcelo
 */
public class SolicitanteTableModel extends AbstractTableModel{
    
    Solicitante solicitante;
    List<Solicitante> listaSolicitantes;    
    Solicitante teste;

    @Override
    public int getRowCount() {
        return listaSolicitantes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
     protected Solicitante getObjetoAt(int rowIndex) {  
        return listaSolicitantes.get(rowIndex);  
    }
     
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String valor = "";
        if (columnIndex == 0) {
            valor = String.valueOf(listaSolicitantes.get(rowIndex).getId());
        }
        
        if (columnIndex == 1) {
            valor = String.valueOf(listaSolicitantes.get(rowIndex).getNome());
        }
        
        if (columnIndex == 2) {
            valor = String.valueOf(listaSolicitantes.get(rowIndex).getEmail());
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
            valor = "Nome";            
        }        
        
        if (column == 2) {
            valor = "E-Mail";            
        }      
        
        return valor;
    }
        
    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public List<Solicitante> getListaSolicitantes() {
        return listaSolicitantes;
    }

    public void setListaSolicitantes(List<Solicitante> listaSolicitantes) {
        this.listaSolicitantes = listaSolicitantes;
    }
    
    
    
}
