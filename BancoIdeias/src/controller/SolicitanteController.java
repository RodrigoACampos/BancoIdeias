package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import model.IdeiaAlunoTableModel;
import model.IdeiaGeralTableModel;
import view.CadastroSolicitanteView;
import view.IdeiaSolicitanteView;

/**
 *
 * @author marceloP
 */
public class SolicitanteController implements ActionListener , FocusListener{

    Solicitante solicitante = new Solicitante();
    CadastroSolicitanteView cadSolicitanteView;
    IdeiaSolicitanteView ideiaSolicitanteView;
    SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
    IdeiaDAO ideiaDAO = new IdeiaDAO();
    Ideia ideia = new Ideia();
    List<Ideia> listaIdeia = new ArrayList();

    public SolicitanteController(CadastroSolicitanteView cadSolicitanteView) {
        this.cadSolicitanteView = cadSolicitanteView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadSolicitanteView.getBtnSalvar().addActionListener(this);
        cadSolicitanteView.getBtnCancelar().addActionListener(this);
        cadSolicitanteView.getBtnIdeia().addActionListener(this);
        cadSolicitanteView.getLbObrigatorioInfo().setVisible(false);
        cadSolicitanteView.getTfNome().addFocusListener(this);
        cadSolicitanteView.getTfEmail().addFocusListener(this);
        cadSolicitanteView.getFtfTelefone().addFocusListener(this);
        cadSolicitanteView.getTbIdeia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
               

        listaIdeia = ideiaDAO.listar();
        atualizarTabelaIdeiasSolicitadas(listaIdeia);
    }

    public void atualizarViewParaSolicitante() {

        solicitante.setNome(cadSolicitanteView.getTfNome().getText());
        solicitante.setEmail(cadSolicitanteView.getTfEmail().getText());
        solicitante.setTelefone(cadSolicitanteView.getFtfTelefone().getText());
    }

    public void atualizarSolicitannteParaView() {

        cadSolicitanteView.getTfNome().setText(solicitante.getNome());
        cadSolicitanteView.getTfEmail().setText(solicitante.getEmail());
        cadSolicitanteView.getFtfTelefone().setText(solicitante.getTelefone());

    }

    public void selecionarDaTabelaSolicitantes() {
        int indice = cadSolicitanteView.getTbIdeia().getSelectedRow();
        IdeiaGeralTableModel model = (IdeiaGeralTableModel) cadSolicitanteView.getTbIdeia().getModel();
        ideia = model.getListaIdeia().get(indice);
        System.out.println(ideia.getId());
    }

    public void atualizarTabelaIdeiasSolicitadas(List<Ideia> listaIdeias) {
        
        IdeiaGeralTableModel modelo = new IdeiaGeralTableModel();
        modelo.setListaIdeias(listaIdeias);
        cadSolicitanteView.getTbIdeia().setModel(modelo);
        
    }
    
     public void atualizarTabelaIdeias(List<Ideia> listaIdeias) {
//        
//        IdeiaSolicTableModel ideiaAlunoModelo = new IdeiaAlunoTableModel();
//        ideiaAlunoModelo.setListaIdeias(listaIdeias);
//        cadSolicitanteView.getTbIdeia().setModel(ideiaAlunoModelo);
        
    }

    public void clearAll() {
        cadSolicitanteView.getTfNome().setText("");
        cadSolicitanteView.getTfEmail().setText("");
        cadSolicitanteView.getFtfTelefone().setText("");
    }

    public Boolean verificaCampo() {
        
        Boolean emBranco = null;
        String nome, email, telefone;
        nome = cadSolicitanteView.getTfNome().getText();
        email = cadSolicitanteView.getTfEmail().getText();
        telefone = cadSolicitanteView.getFtfTelefone().getText().replaceAll("[ ()-]", "");       

        if (nome.equals(null) || nome.equals("") || email.equals(null) || 
                email.equals("") || telefone.equals(null) || telefone.equals("")) {
            emBranco = true;
            cadSolicitanteView.getLbObrigatorioInfo().setVisible(true);
        }else{
            cadSolicitanteView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }

        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("salvar")) {
            

            if (verificaCampo()) {
                
                cadSolicitanteView.getLbObrigatorioInfo().setVisible(true);
                
                System.out.println("Em Btanco? " + verificaCampo());
                
            } else {
                
                atualizarViewParaSolicitante();

                if (solicitanteDAO.salvar(solicitante) == true) {
                    System.out.println("Salvo Com Sucesso");
                    cadSolicitanteView.getTelaPrincipalController().atualizarValores();
                    clearAll();
                } else {
                    System.out.println(" NAO SALVO! ");
                }
                

            }
        }

        if (e.getActionCommand().equals("cancelar")) {
//            cadSolicitanteView.removeAll();
//            cadSolicitanteView.repaint();
//            cadSolicitanteView.revalidate();
            clearAll();
                   
            
        }

        if (e.getActionCommand().equals("ideia")) {
            System.out.println(e.getActionCommand());
//            ideiaSolicitanteView = new IdeiaSolicitanteView(null, true);
//            ideiaSolicitanteView.setVisible(true);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        verificaCampo();
    }

    @Override
    public void focusLost(FocusEvent e) {
        verificaCampo();
    }

}
