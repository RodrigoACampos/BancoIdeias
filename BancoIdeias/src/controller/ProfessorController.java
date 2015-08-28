package controller;

import dao.IdeiaDAO;
import dao.ProfessorDAO;
import entidade.Ideia;
import entidade.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import view.CadastroProfessorView;


/**
 *
 * @author Willyam
 */
public class ProfessorController implements ActionListener {

    Professor professor = new Professor();
    CadastroProfessorView cadProfessorView;
    ProfessorDAO professorDAO = new ProfessorDAO();
//    IdeiaDAO ideiaDAO = new IdeiaDAO();
//    Ideia ideia = new Ideia();
//    List<Ideia> listaIdeia = new ArrayList();

    public ProfessorController(CadastroProfessorView cadProfessorView) {
        this.cadProfessorView = cadProfessorView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadProfessorView.getBtnSalvar().addActionListener(this);
        cadProfessorView.getBtnCancelar().addActionListener(this);
        cadProfessorView.getBtnIdeia().addActionListener(this);

//        listaIdeia = ideiaDAO.listar();
//        atualizarTabelaIdeia(listaIdeia);
    }

    public void atualizarViewParaProfessor() {

        professor.setNome(cadProfessorView.getTfNome().getText());
        professor.setEmail(cadProfessorView.getTfEmail().getText());
        professor.setTelefone(cadProfessorView.getFtfTelefone().getText());
    }

    public void atualizarProfessorParaView() {

        cadProfessorView.getTfNome().setText(professor.getNome());
        cadProfessorView.getTfEmail().setText(professor.getEmail());
        cadProfessorView.getFtfTelefone().setText(professor.getTelefone());

    }

//    public void selecionarDaTabelaProfessor() {
//        int indice = cadProfessorView.getTbIdeia().getSelectedRow();
//        ProfessorIdeiaTableModel model = (ProfessorIdeiaTableModel) cadProfessorView.getTbIdeia().getModel();
//        ideia = model.getListaIdeia().get(indice);
//        System.out.println(ideia.getId());
//    }

//    public void atualizarTabelaIdeia(List<Ideia> listaIdeias) {
//        SolicitanteIdeiaTableModel modelo = new SolicitanteIdeiaTableModel();
//        modelo.setListaIdeias(listaIdeias);
//        cadSolicitanteView.getTbIdeia().setModel(modelo);
////        cadSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(300);
////        cadSolicitanteView.getTbIdeia().getSelectedRows();
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("salvar")) {
            System.out.println(e.getActionCommand());

            atualizarViewParaProfessor();

            if (professorDAO.salvar(professor) == true) {
                System.out.println("Salvo");
                cadProfessorView.getTelaPrincipalController().atualizarValores();
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
