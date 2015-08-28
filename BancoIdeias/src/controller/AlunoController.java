package controller;

import dao.AlunoDAO;
import dao.ProfessorDAO;
import entidade.Aluno;
import entidade.Professor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroAlunoView;
import view.CadastroProfessorView;

/**
 *
 * @author willyam_evangelista
 */

    public class AlunoController implements ActionListener {

    Aluno aluno = new Aluno();
    CadastroAlunoView cadAlunoView;
    AlunoDAO alunoDAO = new AlunoDAO();
//    IdeiaDAO ideiaDAO = new IdeiaDAO();
//    Ideia ideia = new Ideia();
//    List<Ideia> listaIdeia = new ArrayList();

    public AlunoController(CadastroAlunoView cadAlunoView) {
        this.cadAlunoView = cadAlunoView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadAlunoView.getBtnSalvar().addActionListener(this);
        cadAlunoView.getBtnCancelar().addActionListener(this);
        cadAlunoView.getBtnIdeia().addActionListener(this);

//        listaIdeia = ideiaDAO.listar();
//        atualizarTabelaIdeia(listaIdeia);
    }

    public void atualizarViewParaAluno() {

        aluno.setNome(cadAlunoView.getTfNome().getText());
        aluno.setEmail(cadAlunoView.getTfEmail().getText());
        aluno.setTelefone(cadAlunoView.getFtfTelefone().getText());
    }

    public void atualizarAlunoParaView() {

        cadAlunoView.getTfNome().setText(aluno.getNome());
        cadAlunoView.getTfEmail().setText(aluno.getEmail());
        cadAlunoView.getFtfTelefone().setText(aluno.getTelefone());

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

            atualizarViewParaAluno();

            if (alunoDAO.salvar(aluno) == true) {
                System.out.println("Salvo");
                cadAlunoView.getTelaPrincipalController().atualizarValores();
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
    

