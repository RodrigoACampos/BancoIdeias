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
import model.SolicitanteIdeiaTableModel;
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

        listaIdeia = ideiaDAO.listar();
        atualizarTabelaIdeia(listaIdeia);
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
        SolicitanteIdeiaTableModel model = (SolicitanteIdeiaTableModel) cadSolicitanteView.getTbIdeia().getModel();
        ideia = model.getListaIdeia().get(indice);
        System.out.println(ideia.getId());
    }

    public void atualizarTabelaIdeia(List<Ideia> listaIdeias) {
        SolicitanteIdeiaTableModel modelo = new SolicitanteIdeiaTableModel();
        modelo.setListaIdeias(listaIdeias);
        cadSolicitanteView.getTbIdeia().setModel(modelo);
//        cadSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(300);
//        cadSolicitanteView.getTbIdeia().getSelectedRows();

    }

    public void clearAll() {
        cadSolicitanteView.getTfNome().setText(null);
        cadSolicitanteView.getTfEmail().setText(null);
        cadSolicitanteView.getFtfTelefone().setText(null);
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

                if (solicitanteDAO.salvar(solicitante) == true) {
                    System.out.println("Salvo Com Sucesso");
                    cadSolicitanteView.getTelaPrincipalController().atualizarValores();
                    clearAll();
                } else {
                    System.out.println(" NAO SALVO! ");
                }
                
                atualizarViewParaSolicitante();

            }
        }

        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());
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
