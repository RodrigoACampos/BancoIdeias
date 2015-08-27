package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.CadastroSolicitanteView;

public class SolicitanteControllerP {

    public SolicitanteDAO daoSolicitante = new SolicitanteDAO();
    IdeiaDAO daoIdeia = new IdeiaDAO();
    Solicitante entidadeSolicitante = new Solicitante();
    CadastroSolicitanteView cadSolicitanteView = new CadastroSolicitanteView();
    ArrayList<Ideia> listaIdeia = new ArrayList<>();
//------------------------------------------------------------------------------
    //--------------------------SALVAR DADOS------------------------------------

    public boolean salvarSolicitanteController(Solicitante solicitante) {
        return this.daoSolicitante.salvar(solicitante);
    }

    public boolean salvarSolicitante() {
        entidadeSolicitante.setNome(cadSolicitanteView.getTfNome().getText());
        entidadeSolicitante.setEmail(cadSolicitanteView.getTfEmail().getText());
        entidadeSolicitante.setTelefone(cadSolicitanteView.getFtfTelefone().getText());

        //salvar 
        if (this.salvarSolicitanteController(entidadeSolicitante)) {
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
            this.carregarIdeias();
            //this.desabilitarCampos();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //--------------------------------------------------------------------------
    //-----------------------LISTAR DADOS NA JTABLE-----------------------------
    public List<Ideia> getListaSolicitanteController() {
        return daoIdeia.listar();
    }

    public void carregarIdeias() {
        listaIdeia = (ArrayList<Ideia>) daoIdeia.listar();
        DefaultTableModel modelo = (DefaultTableModel) cadSolicitanteView.getTbIdeia().getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaIdeia.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaIdeia.get(i).getTema()
            //listaIdeia.get(i).getId(),
            //listaIdeia.get(i).getSolicitante(),
            //listaIdeia.get(i).getDescricao()
            });
        }
    }

    //--------------------------------------------------------------------------
    //---------------------------FFFFFFFFFFF------------------------------------
}
