package model;

import entidade.Solicitante;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class SolicitanteCBModel extends AbstractListModel implements ComboBoxModel{
    
    private Solicitante solicitante;
    private List<Solicitante> listaSolicitante;
    
     public SolicitanteCBModel(List<Solicitante> listaSolicitante) {
        this.listaSolicitante = listaSolicitante;
    }

    public SolicitanteCBModel(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

       
    @Override
    public int getSize() {
        return listaSolicitante.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaSolicitante.get(index);
    }

    @Override
    public void setSelectedItem(Object object) {
       solicitante = (Solicitante) object;
    }

    @Override
    public Object getSelectedItem() {
        return solicitante;
    }
    
    @Override
    public String toString() {
        return solicitante.getNome();
    }
}
