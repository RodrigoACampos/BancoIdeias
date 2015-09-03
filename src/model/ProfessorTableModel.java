package model;

import entidade.Professor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {

    Professor professor;
    List<Professor> listaProfessores;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getListaprofessores() {
        return listaProfessores;
    }

    public void setListaprofessores(List<Professor> listaprofessores) {
        this.listaProfessores = listaprofessores;
    }

    protected Professor getObjetoAt(int rowIndex) {  
        return listaProfessores.get(rowIndex);  
    }

    @Override
    public int getRowCount() {
        return listaProfessores.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        String valor = "";
        
        if (columnIndex == 0) {
            valor = String.valueOf(listaProfessores.get(rowIndex).getId());
        }

        if (columnIndex == 1) {
            valor = String.valueOf(listaProfessores.get(rowIndex).getNome());
        }

        if (columnIndex == 2) {
            valor = String.valueOf(listaProfessores.get(rowIndex).getEmail());
        }
        
        return valor;
        
    }

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

}
