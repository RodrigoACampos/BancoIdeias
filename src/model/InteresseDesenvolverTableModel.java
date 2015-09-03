/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entidade.InteresseDesenvolver;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gustavo
 */
public class InteresseDesenvolverTableModel extends AbstractTableModel {

    InteresseDesenvolver interesseDesenvolver;
    List<InteresseDesenvolver> listaInteresses;

    public InteresseDesenvolver getInteresseDesenvolver() {
        return interesseDesenvolver;
    }

    public void setInteresseDesenvolver(InteresseDesenvolver interesseDesenvolver) {
        this.interesseDesenvolver = interesseDesenvolver;
    }

    public List<InteresseDesenvolver> getListaInteresses() {
        return listaInteresses;
    }

    public void setListaInteresses(List<InteresseDesenvolver> listaInteresses) {
        this.listaInteresses = listaInteresses;
    }

    @Override
    public int getRowCount() {
        return listaInteresses.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    
    protected InteresseDesenvolver getObjetoAt(int rowIndex) {  
        return listaInteresses.get(rowIndex);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        String valor = "";
        
        if (columnIndex == 0) {
            valor = String.valueOf(listaInteresses.get(rowIndex).getIdeia().getId());
        }

        if (columnIndex == 1) {
            valor = String.valueOf(listaInteresses.get(rowIndex).getIdeia().getTema());
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
        return valor;
        
    }

}
