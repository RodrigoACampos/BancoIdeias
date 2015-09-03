package model;

import entidade.Solicitante;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class SolicitanteCBModel extends AbstractListModel implements ComboBoxModel{
    
    Solicitante solicitante;
    List<Solicitante> listaSolicitantes;

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

    @Override
    public int getSize() {
        return listaSolicitantes.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listaSolicitantes.get(index);
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
