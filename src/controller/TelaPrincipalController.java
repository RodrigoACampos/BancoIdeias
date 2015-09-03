package controller;

import dao.AlunoDAO;
import dao.IdeiaDAO;
import dao.ProfessorDAO;
import dao.SolicitanteDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.TelaPrincipalView;

public class TelaPrincipalController implements ActionListener, MouseListener {

    //declarando os controller
    private ProfessorController professorcontroller;
    private AlunoController alunocontroller;
    private SolicitanteController solicitantecontroller;
    //private IdeiaController ideiacontroller;

    //declarando a tela principal
    TelaPrincipalView telaPrincipalView;

    public TelaPrincipalView GetTelaPrincipal() {
        return this.telaPrincipalView;
    }

    //Construtor do Controller principal
    public TelaPrincipalController(TelaPrincipalView telaPrincipalView) {
        this.telaPrincipalView = telaPrincipalView;
        //criando objeto de controle para o professor
        this.professorcontroller = new ProfessorController(this);
        this.alunocontroller = new AlunoController(this);
        this.solicitantecontroller = new SolicitanteController(this);
        //this.ideiacontroller = new IdeiaController(this);

        Assinar();
    }

    public ProfessorController getProfessorController() {
        return this.professorcontroller;
    }

    public AlunoController getAlunoController() {
        return this.alunocontroller;
    }

    public SolicitanteController getSolicitanteController() {
        return this.solicitantecontroller;
    }

/*
    public IdeiaController getIdeiaController() {
        return this.ideiacontroller;
    }
*/
    public void Assinar() {
        
        telaPrincipalView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                acaoSair();
            }
        });

        telaPrincipalView.setVisible(true);

        //adicionando ação no botão
        telaPrincipalView.getBtnCadastroAluno().addActionListener(this);
        telaPrincipalView.getBtnConsultaAluno().addActionListener(this);
        telaPrincipalView.getBtnCadastroProfessor().addActionListener(this);
        telaPrincipalView.getBtnConsultaProfessor().addActionListener(this);
        telaPrincipalView.getBtnCadastroSolicitante().addActionListener(this);
        telaPrincipalView.getBtnConsultaSolicitante().addActionListener(this);
        telaPrincipalView.getBtnCadastroIdeia().addActionListener(this);
        telaPrincipalView.getBtnConsultaIdeias().addActionListener(this);

        //adicionando ação nos menus 
        telaPrincipalView.getMenuCadastroAluno().addActionListener(this);
        telaPrincipalView.getMenuConsultaAluno().addActionListener(this);
        telaPrincipalView.getMenuCadastroProfessor().addActionListener(this);
        telaPrincipalView.getMenuConsultaProfessor().addActionListener(this);
        telaPrincipalView.getMenuCadastroSolicitante().addActionListener(this);
        telaPrincipalView.getMenuConsultaSolicitante().addActionListener(this);
        telaPrincipalView.getMenuCadastroIdeia().addActionListener(this);
        telaPrincipalView.getMenuConsultaIdeia().addActionListener(this);
        telaPrincipalView.getBtnSair().addActionListener(this);
        telaPrincipalView.getMenuSair().addActionListener(this);

        //adicionando ação de mouse nos botões
        telaPrincipalView.getBtnSair().addMouseListener(this);
        telaPrincipalView.getBtnCadastroAluno().addMouseListener(this);
        telaPrincipalView.getBtnCadastroIdeia().addMouseListener(this);
        telaPrincipalView.getBtnCadastroProfessor().addMouseListener(this);
        telaPrincipalView.getBtnCadastroSolicitante().addMouseListener(this);
        telaPrincipalView.getBtnConsultaAluno().addMouseListener(this);
        telaPrincipalView.getBtnConsultaIdeias().addMouseListener(this);
        telaPrincipalView.getBtnConsultaProfessor().addMouseListener(this);
        telaPrincipalView.getBtnConsultaSolicitante().addMouseListener(this);

        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnCadastroAluno());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnCadastroIdeia());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnCadastroProfessor());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnCadastroSolicitante());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnConsultaAluno());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnConsultaIdeias());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnConsultaProfessor());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnConsultaSolicitante());
        telaPrincipalView.getBgBotoesIniciar().add(telaPrincipalView.getBtnSair());

        atualizarValores();
        
    }

    public void repintarTela() {
        atualizarValores();
        
        telaPrincipalView.repaint();
        telaPrincipalView.revalidate();
    }

    public void atualizarValores() {
        
        //atualizando contato da tela com a quantidade de solicitante cadastrados
        SolicitanteDAO solicitanteDao = new SolicitanteDAO();
        telaPrincipalView.getLblValorQtdeSolicitante().setText(Integer.toString(solicitanteDao.listar().size()));

        //atualizando contato da tela com a quantidade de aluno cadastrados
        AlunoDAO alunoDao = new AlunoDAO();
        telaPrincipalView.getLblValorQtdeAluno().setText(Integer.toString(alunoDao.listar().size()));

        //atualizando contato da tela com a quantidade de professor cadastrados
        ProfessorDAO professorDao = new ProfessorDAO();
        telaPrincipalView.getLblValorQtdeProfessor().setText(Integer.toString(professorDao.listar().size()));

        //atualizando contato da tela com a quantidade de ideia cadastradas
        IdeiaDAO ideiaDao = new IdeiaDAO();
        telaPrincipalView.getLblValorQtdeIdeia().setText(Integer.toString(ideiaDao.listar().size()));

    }

    private void acaoSair() {
        if (Perguntar("Tem certeza que deseja sair?")) {
            telaPrincipalView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        } else {
            telaPrincipalView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
    
    public boolean Perguntar(String texto){
        String[] options = {" Sim ", " Não "};
        int i = JOptionPane.showOptionDialog(null,
                texto, "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (i == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ProfessorConsulta")) {

            //pedindo para o controller do professor mostrar a janela de consulta
            professorcontroller.ShowConsultaProfessor();

        }

        if (e.getActionCommand().equals("ProfessorCadastrar")) {

            //pedindo para o controller do professor mostrar a janela de cadastro
            professorcontroller.AddCadastroProfessor();

        }

        if (e.getActionCommand().equals("AlunoCadastrar")) {

            //pedindo para o controller do professor mostrar a janela de cadastro
            alunocontroller.AddCadastroAluno();

        }

        if (e.getActionCommand().equals("SolicitanteConsulta")) {

            //pedindo para o controller do professor mostrar a janela de consulta
            solicitantecontroller.ShowConsultaSolicitante();

        }

        if (e.getActionCommand().equals("SolicitanteCadastrar")) {

            //pedindo para o controller do professor mostrar a janela de cadastro
            solicitantecontroller.AddCadastroSolicitante();

        }

        if (e.getActionCommand().equals("PrincipalSair")) {
            acaoSair();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //limpando todas as seleções dos botões da barra de ferramentas
        notSelectedAll();
        
        //alterando o botão selecionado da barra de ferramentas
        JButton botao = (JButton) e.getSource();
        botao.setSelected(true);
        botao.setBorderPainted(true);
        botao.setContentAreaFilled(true);
        repintarTela();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        JButton botao = (JButton) e.getSource();
        botao.setBorderPainted(true);
        botao.setContentAreaFilled(true);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton botao = (JButton) e.getSource();

        if (botao.isSelected()) {
            botao.setBorderPainted(true);
            botao.setContentAreaFilled(true);
        } else {
            botao.setBorderPainted(false);
            botao.setContentAreaFilled(false);
        }
        repintarTela();
    }

    public void notSelectedAll() {

        Component[] listaObjetos = telaPrincipalView.getPnlBarraFerramenta().getComponents();
        
        for (Component component : listaObjetos) {
            if (component instanceof JButton) {
                ((JButton)component).setBorderPainted(false);
                ((JButton)component).setContentAreaFilled(false);
                ((JButton)component).setSelected(false);
            }
        }

        repintarTela();

    }

}
