package model;

import entidade.Aluno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AlunoTableModel extends AbstractTableModel {

    Aluno aluno;
    List<Aluno> listaAlunos;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    protected Aluno getObjetoAt(int rowIndex) {
        return listaAlunos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return listaAlunos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        String valor = "";
        
        if (columnIndex == 0) {
            valor = String.valueOf(listaAlunos.get(rowIndex).getId());
        }

        if (columnIndex == 1) {
            valor = String.valueOf(listaAlunos.get(rowIndex).getNome());
        }

        if (columnIndex == 2) {
            valor = String.valueOf(listaAlunos.get(rowIndex).getEmail());
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
