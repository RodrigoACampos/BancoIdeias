package controller;

import dao.AlunoDAO;
import dao.IdeiaDAO;
import entidade.Aluno;
import entidade.Ideia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import model.IdeiaAlunoTableModel;
import model.IdeiaGeralTableModel;
import view.CadastroAlunoView;
import view.IdeiaAlunoView;

/**
 *
 * @author willyam_evangelista
 * @author marcelo_t
 */
public class AlunoController implements ActionListener, FocusListener {

    Aluno aluno = new Aluno();
    CadastroAlunoView cadAlunoView;
    IdeiaAlunoView ideiaAlunoView;
    AlunoDAO alunoDAO = new AlunoDAO();
    IdeiaDAO ideiaDAO = new IdeiaDAO();
    Ideia ideia = new Ideia();
    List<Ideia> listaIdeia = new ArrayList();

    public AlunoController(CadastroAlunoView cadAlunoView, IdeiaAlunoView ideiaAlunoView) {
        this.cadAlunoView = cadAlunoView;
        this.ideiaAlunoView = ideiaAlunoView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadAlunoView.getBtnSalvar().addActionListener(this);
        cadAlunoView.getBtnCancelar().addActionListener(this);
        cadAlunoView.getBtnIdeia().addActionListener(this);
        cadAlunoView.getLbObrigatorioInfo().setVisible(false);
        cadAlunoView.getTfNome().addFocusListener(this);
        cadAlunoView.getTfEmail().addFocusListener(this);
        cadAlunoView.getFtfTelefone().addFocusListener(this);
        cadAlunoView.getTbIdeia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        ideiaAlunoView.getBtnEscolher().addActionListener(this);
        ideiaAlunoView.getBtnCancelar().addActionListener(this);
        ideiaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listaIdeia = ideiaDAO.listar();
        atualizarTabelaIdeiaFavoritas(listaIdeia);
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

    public void selecionarDaTabelaProfessor() {
        int indice = cadAlunoView.getTbIdeia().getSelectedRow();
        IdeiaGeralTableModel model = (IdeiaGeralTableModel) cadAlunoView.getTbIdeia().getModel();
        ideia = model.getListaIdeia().get(indice);
    }

    public void atualizarTabelaIdeiaFavoritas(List<Ideia> listaIdeias) {
        IdeiaGeralTableModel modelo = new IdeiaGeralTableModel();
        modelo.setListaIdeias(listaIdeias);
        cadAlunoView.getTbIdeia().setModel(modelo);
        cadAlunoView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(300);
    }
    
     public void atualizarTabelaIdeias(List<Ideia> listaIdeias) {
        
        IdeiaAlunoTableModel ideiaAlunoModelo = new IdeiaAlunoTableModel();
        ideiaAlunoModelo.setListaIdeias(listaIdeias);
        ideiaAlunoView.getTbPesquisa().setModel(ideiaAlunoModelo);
        ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(150);
                
        
    }

    public void clearAll() {
        cadAlunoView.getTfNome().setText("");
        cadAlunoView.getTfEmail().setText("");
        cadAlunoView.getFtfTelefone().setText("");
    }

    public Boolean verificaCampo() {

        Boolean emBranco = null;
        String nome, email, telefone;
        nome = cadAlunoView.getTfNome().getText();
        email = cadAlunoView.getTfEmail().getText();
        telefone = cadAlunoView.getFtfTelefone().getText().replaceAll("[ ()-]", "");

        if (nome.equals(null) || nome.equals("") || email.equals(null)
                || email.equals("") || telefone.equals(null) || telefone.equals("")) {
            emBranco = true;
            cadAlunoView.getLbObrigatorioInfo().setVisible(true);
        } else {
            cadAlunoView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }

        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("salvar")) {
            if (verificaCampo()) {
                cadAlunoView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em Btanco? " + verificaCampo());
            } else {
                atualizarViewParaAluno();
                if (alunoDAO.salvar(aluno) == true) {
                    System.out.println("Salvo");
                    cadAlunoView.getTelaPrincipalController().atualizarValores();
                    clearAll();
                } else {
                    System.out.println(" NAO SALVO! ");
                }
            }
        }

        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("ideia")) {
            System.out.println(e.getActionCommand());
            atualizarTabelaIdeias(listaIdeia);
            ideiaAlunoView.setVisible(true);
        }
        
        if (e.getActionCommand().equals("i")) {
            System.out.println(e.getActionCommand());
        }
        
        if (e.getActionCommand().equals("id")) {
            System.out.println(e.getActionCommand());
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
