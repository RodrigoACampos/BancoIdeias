package model;

import controller.SolicitanteController;
import entidade.Ideia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            valor = UStoBRdate(listaIdeias.get(rowIndex).getDtcadastro());
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
            valor = "Dt. Cadastro";
        }

        return valor;
        
    }
    public String UStoBRdate(java.util.Date data) {
        String d = "";
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        try {
            d = out.format(in.parse(data.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(SolicitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

}
