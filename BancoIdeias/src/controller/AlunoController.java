package controller;

import dao.AlunoDAO;
import dao.AlunoDAOMarceloTest;
import dao.IdeiaDAO;
import dao.InteresseDesenvolverDAO;
import entidade.Aluno;
import entidade.Ideia;
import entidade.InteresseDesenvolver;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class AlunoController implements ActionListener, FocusListener, MouseListener {

    //AlunoDAOMarceloTest alunoDaoTest;
    InteresseDesenvolver interesseDesenvolver;
    InteresseDesenvolverDAO interesseDesenvolverDAO = new InteresseDesenvolverDAO();
    Aluno aluno = new Aluno();
    CadastroAlunoView cadAlunoView;
    IdeiaAlunoView ideiaAlunoView;
    AlunoDAO alunoDAO = new AlunoDAO();
    IdeiaDAO ideiaDAO = new IdeiaDAO();
    Ideia ideia = new Ideia();
    List<Ideia> listaIdeia = new ArrayList();
    List<Ideia> listaIdeiasFavoritas = new ArrayList();
    List<Ideia> listaIdeiasEscolhidas = new ArrayList();
    Boolean trocarTela;
    //DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();

    public AlunoController(CadastroAlunoView cadAlunoView, IdeiaAlunoView ideiaAlunoView) {
        this.cadAlunoView = cadAlunoView;
        this.ideiaAlunoView = ideiaAlunoView;
    }

    public AlunoController(CadastroAlunoView cadAlunoView, IdeiaAlunoView ideiaAlunoView, Aluno aluno) {
        this.cadAlunoView = cadAlunoView;
        this.ideiaAlunoView = ideiaAlunoView;
        this.aluno = aluno;
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
        ideiaAlunoView.getTbPesquisa().addMouseListener(this);
        ideiaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listaIdeia = ideiaDAO.listar();
        //atualizarTabelaIdeiaFavoritas(listaIdeia);
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
//        listaIdeiasFavoritas = 
        for (int i = 0; i < interesseDesenvolverDAO.listarByAluno(aluno.getId()).size(); i++) {

            listaIdeiasEscolhidas.add(interesseDesenvolverDAO.listarByAluno(aluno.getId()).get(i).getIdeia());
        }
        
        atualizarTabelaIdeiaFavoritas(listaIdeiasEscolhidas);
    }

    public void selecionarDaTabelaProfessor() {
        int indice = cadAlunoView.getTbIdeia().getSelectedRow();
        IdeiaGeralTableModel model = (IdeiaGeralTableModel) cadAlunoView.getTbIdeia().getModel();
        ideia = model.getListaIdeia().get(indice);
    }

    public void atualizarTabelaIdeiaFavoritas(List<Ideia> listaIdeiasFavoritas) {
        IdeiaGeralTableModel modelo = new IdeiaGeralTableModel();
        modelo.setListaIdeias(listaIdeiasFavoritas);
        cadAlunoView.getTbIdeia().setModel(modelo);
        cadAlunoView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(300);
        cadAlunoView.getTbIdeia().setEnabled(false);
    }

    public void atualizarTabelaIdeias(List<Ideia> listaIdeias) {

        IdeiaAlunoTableModel ideiaAlunoModelo = new IdeiaAlunoTableModel();
        ideiaAlunoModelo.setListaIdeias(listaIdeias);
        ideiaAlunoView.getTbPesquisa().setModel(ideiaAlunoModelo);

        ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(5);
        ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(350);

    }

    private void atualizarDescricao() {
        ideiaAlunoView.getTaDescricaoIdeia().setText(ideia.getDescricao());
    }

    public void selecionarDaTabelaIdeias() {
        int indice = ideiaAlunoView.getTbPesquisa().getSelectedRow();
        IdeiaAlunoTableModel model = (IdeiaAlunoTableModel) ideiaAlunoView.getTbPesquisa().getModel();
        ideia = model.getListaIdeia().get(indice);
        System.out.println(ideia.getId());
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

        if (e.getActionCommand().equals("Salvar")) {
//            if (verificaCampo()) {
//                cadAlunoView.getLbObrigatorioInfo().setVisible(true);
//                System.out.println("Em Btanco? " + verificaCampo());
//            } else {
//                atualizarViewParaAluno();
//                if (alunoDAO.salvar(aluno) == true) {
//                    System.out.println("Salvo");
//                    cadAlunoView.getTelaPrincipalController().atualizarValores();
//                    clearAll();
//                    listaIdeiasFavoritas.clear();
//                    atualizarTabelaIdeiaFavoritas(listaIdeiasFavoritas);
//                } else {
//                    System.out.println(" NAO SALVO! ");
//                }
//            }

            if (verificaCampo()) {
                cadAlunoView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em Btanco? " + verificaCampo());
            } else {
                atualizarViewParaAluno();

                try {
                    AlunoDAOMarceloTest.salvar(aluno);
                } catch (SQLException ex) {
                    Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }

                //interesseDesenvolver.setAluno(aluno);
                //interesseDesenvolver.setIdeia(ideia);
                //System.out.println("idaluno "+interesseDesenvolver.getAluno().getId()+" "+ "idIdeia "+interesseDesenvolver.getIdeia().getId());
                for (int i = 0; i < listaIdeiasFavoritas.size(); i++) {
                    System.out.println("lista de ideias favoritas vazia? " + listaIdeiasFavoritas.isEmpty());
                    ideia = listaIdeiasFavoritas.get(i);
                    interesseDesenvolver.setAluno(aluno);
                    interesseDesenvolver.setIdeia(ideia);
                    System.out.println("idaluno " + interesseDesenvolver.getAluno().getId() + "\n "
                            + "idIdeia " + interesseDesenvolver.getIdeia().getId());
                    interesseDesenvolverDAO.salvar(interesseDesenvolver);
                }

                System.out.println("Salvo");
                cadAlunoView.getTelaPrincipalController().atualizarValores();
                clearAll();
                listaIdeiasFavoritas.clear();
                atualizarTabelaIdeiaFavoritas(listaIdeiasFavoritas);
                JOptionPane.showMessageDialog(null, "Salvo Aluno e suas Idéias Selecionadas com sucesso!");
                if (cadAlunoView.getTelaPrincipalController().getTrocarTela()){
                    
                    cadAlunoView.getTelaPrincipalController().trocarTela("ConsultaAlunoView", null, false);
                }
            }
        }

        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());
            //clearAll();             //podemos Limpar os campos da tela apenas ou
            cadAlunoView.removeAll(); //podemos Limpar a Tela (ela "sai" da tela Principal) 
            cadAlunoView.repaint();
            cadAlunoView.revalidate();
        }

        if (e.getActionCommand().equals("ideia")) {
            System.out.println(e.getActionCommand());
            atualizarTabelaIdeias(listaIdeia);
            ideiaAlunoView.setVisible(true);
        }

        if (e.getActionCommand().equals("escolher")) {
            System.out.println(e.getActionCommand());
            interesseDesenvolver = new InteresseDesenvolver(); // entidade instanciada;
            atualizarViewParaAluno();//metodo que pega os dados digitados nos campos e passa para os atributos da entidade Aluno;
            selecionarDaTabelaIdeias();//metodo que pega a linha e seus objetos ,selecionados na tabela do JDialog e atribui os objetos na entidade Aluno e Ideia.
            
            listaIdeiasFavoritas.clear();
            listaIdeiasFavoritas.add(ideia);//Array recebe ideia escolhida na jdialog;
            listaIdeiasEscolhidas.add(ideia);//Array recebe ideia escolhida na jdialog;
            atualizarTabelaIdeiaFavoritas(listaIdeiasEscolhidas);//meto que atualiza a tabela da viw de cadastro com a ideia selecionada pelo aluno;
            ideiaAlunoView.setVisible(false);
        }

        if (e.getActionCommand().equals("CancelarIdeiaAluno")) {
            System.out.println(e.getActionCommand());
            ideiaAlunoView.setVisible(false);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            selecionarDaTabelaIdeias();
            atualizarDescricao();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
