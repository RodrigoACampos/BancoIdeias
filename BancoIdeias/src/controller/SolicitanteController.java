package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.SolicitanteIdeiaTableModel;
import view.CadastroSolicitanteView;

/**
 *
 * @author marceloP
 */
public class SolicitanteController implements ActionListener {

    Solicitante solicitante = new Solicitante();
    CadastroSolicitanteView cadSolicitanteView;
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("salvar")) {
            System.out.println(e.getActionCommand());

            atualizarViewParaSolicitante();

            if (solicitanteDAO.salvar(solicitante) == true) {
                System.out.println("Salvo");
                cadSolicitanteView.getTelaPrincipalController().atualizarValores();
            } else {
                System.out.println(" NAO SALVO! ");
            }
        }

        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("ideia")) {
            System.out.println(e.getActionCommand());
        }
    }

}
