package controller;

import dao.AlunoDAO;
import dao.IdeiaDAO;
import dao.ProfessorDAO;
import dao.SolicitanteDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.CadastroAlunoView;
import view.CadastroIdeiaView;
import view.CadastroProfessorView;
import view.CadastroSolicitanteView;
import view.ConsultaAlunoView;
import view.ConsultaIdeiaView;
import view.ConsultaProfessorView;
import view.ConsultaSolicitanteView;
import view.TelaPrincipalView;

public class TelaPrincipalController implements ActionListener, MouseListener {

    TelaPrincipalView tpv;
    CadastroAlunoView cadastroAluno;
    ConsultaAlunoView consultaAluno;
    CadastroProfessorView cadastroProfessor;
    ConsultaProfessorView consultaProfessor;
    CadastroSolicitanteView cadastroSolicitante;
    ConsultaSolicitanteView consultaSolicitanteView;
    CadastroIdeiaView cadastroIdeia;
    ConsultaIdeiaView consultaIdeia;
    private JButton botao;
    private JButton botaoTeste;
    SolicitanteDAO solicitanteDao;
    SolicitanteController sc;
    ConsultaSolicitanteController csc;

    AlunoDAO alunoDao;
    AlunoController ac;
    
    
    ProfessorDAO professorDao;
    ProfessorController pc;

    IdeiaDAO ideiaDao;
//    IdeiaController ic;

    public TelaPrincipalController(TelaPrincipalView tpv) {
        this.tpv = tpv;
    }

    public void inciar() {
        montarEAssinar();

    }

    public void montarEAssinar() {
        tpv.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                acaoSair();
            }
        });
//        tpv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tpv.setVisible(true);
        tpv.getBtnCadastroAluno().addActionListener(this);
        tpv.getBtnConsultaAluno().addActionListener(this);
        tpv.getBtnCadastroProfessor().addActionListener(this);
        tpv.getBtnConsultaProfessor().addActionListener(this);
        tpv.getBtnCadastroSolicitante().addActionListener(this);
        tpv.getBtnConsultaSolicitante().addActionListener(this);
        tpv.getBtnCadastroIdeia().addActionListener(this);
        tpv.getBtnConsultaIdeias().addActionListener(this);
        tpv.getMenuCadastroAluno().addActionListener(this);
        tpv.getMenuConsultaAluno().addActionListener(this);
        tpv.getMenuCadastroProfessor().addActionListener(this);
        tpv.getMenuConsultaProfessor().addActionListener(this);
        tpv.getMenuCadastroSolicitante().addActionListener(this);
        tpv.getMenuConsultaSolicitante().addActionListener(this);
        tpv.getMenuCadastroIdeia().addActionListener(this);
        tpv.getMenuConsultaIdeia().addActionListener(this);
        tpv.getBtnSair().addActionListener(this);
        tpv.getMenuSair().addActionListener(this);

        tpv.getBtnSair().addMouseListener(this);
        tpv.getBtnCadastroAluno().addMouseListener(this);
        tpv.getBtnCadastroIdeia().addMouseListener(this);
        tpv.getBtnCadastroProfessor().addMouseListener(this);
        tpv.getBtnCadastroSolicitante().addMouseListener(this);
        tpv.getBtnConsultaAluno().addMouseListener(this);
        tpv.getBtnConsultaIdeias().addMouseListener(this);
        tpv.getBtnConsultaProfessor().addMouseListener(this);
        tpv.getBtnConsultaSolicitante().addMouseListener(this);

        tpv.getBgBotoesIniciar().add(tpv.getBtnCadastroAluno());
        tpv.getBgBotoesIniciar().add(tpv.getBtnCadastroIdeia());
        tpv.getBgBotoesIniciar().add(tpv.getBtnCadastroProfessor());
        tpv.getBgBotoesIniciar().add(tpv.getBtnCadastroSolicitante());
        tpv.getBgBotoesIniciar().add(tpv.getBtnConsultaAluno());
        tpv.getBgBotoesIniciar().add(tpv.getBtnConsultaIdeias());
        tpv.getBgBotoesIniciar().add(tpv.getBtnConsultaProfessor());
        tpv.getBgBotoesIniciar().add(tpv.getBtnConsultaSolicitante());
        tpv.getBgBotoesIniciar().add(tpv.getBtnSair());

        atualizarValores();
    }

    private void repintarTela() {
        tpv.repaint();
        tpv.revalidate();
    }

    public void atualizarValores() {
        solicitanteDao = new SolicitanteDAO();
        tpv.getLblValorQtdeSolicitante().setText(Integer.toString(solicitanteDao.listar().size()));
    }

    private void acaoSair() {
        String[] options = {" Sim ", " Não "};
        int i = JOptionPane.showOptionDialog(null,
                "Tem certeza que deseja sair?", "Saída",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (i == JOptionPane.YES_OPTION) {
            tpv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.exit(0);
        } else {
            tpv.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cadastroAluno")) {
            tpv.getJpfundo().removeAll();

            cadastroAluno = new CadastroAlunoView();
            ac = new AlunoController(cadastroAluno);
            ac.iniciar();
//            cadastroAluno.setTelaPrincipalController(this);            
            tpv.getJpfundo().add(cadastroAluno);
            cadastroAluno.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("consultaAluno")) {
            tpv.getJpfundo().removeAll();
            consultaAluno = new ConsultaAlunoView();
            tpv.getJpfundo().add(consultaAluno);
            consultaAluno.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuCadAluno")) {
            tpv.getJpfundo().removeAll();

            cadastroAluno = new CadastroAlunoView();
            ac = new AlunoController(cadastroAluno);
            ac.iniciar();
//            cadastroAluno.setTelaPrincipalController(this);  
            tpv.getJpfundo().add(cadastroAluno);
            cadastroAluno.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuConAluno")) {
            tpv.getJpfundo().removeAll();
            consultaAluno = new ConsultaAlunoView();
            tpv.getJpfundo().add(consultaAluno);
            consultaAluno.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("cadastroProfessor")) {
            tpv.getJpfundo().removeAll();

            cadastroProfessor = new CadastroProfessorView();
            pc = new ProfessorController(cadastroProfessor);
            pc.iniciar();
//            cadastroProfessor.setTelaPrincipalController(this);            
            tpv.getJpfundo().add(cadastroProfessor);
            cadastroProfessor.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("consultaProfessor")) {
            tpv.getJpfundo().removeAll();
            consultaProfessor = new ConsultaProfessorView();
            tpv.getJpfundo().add(consultaProfessor);
            consultaProfessor.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuCadProfessor")) {
            tpv.getJpfundo().removeAll();

            cadastroProfessor = new CadastroProfessorView();
            pc = new ProfessorController(cadastroProfessor);
            pc.iniciar();
//            cadastroProfessor.setTelaPrincipalController(this);   
            tpv.getJpfundo().add(cadastroProfessor);
            cadastroProfessor.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuConProfessor")) {
            tpv.getJpfundo().removeAll();
            consultaProfessor = new ConsultaProfessorView();
            tpv.getJpfundo().add(consultaProfessor);
            consultaProfessor.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("cadastroSolicitante")) {
            tpv.getJpfundo().removeAll();

            cadastroSolicitante = new CadastroSolicitanteView();
            sc = new SolicitanteController(cadastroSolicitante);
            sc.iniciar();
            cadastroSolicitante.setTelaPrincipalController(this);
            tpv.getJpfundo().add(cadastroSolicitante);
            cadastroSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("consultaSolicitante")) {
            System.out.println(e.getActionCommand());
            tpv.getJpfundo().removeAll();
            consultaSolicitanteView = new ConsultaSolicitanteView();
            csc = new ConsultaSolicitanteController(consultaSolicitanteView);
            csc.iniciar();
            tpv.getJpfundo().add(consultaSolicitanteView);
            consultaSolicitanteView.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuCadSolicitante")) {
            tpv.getJpfundo().removeAll();

            cadastroSolicitante = new CadastroSolicitanteView();
            sc = new SolicitanteController(cadastroSolicitante);
            sc.iniciar();
            cadastroSolicitante.setTelaPrincipalController(this);
            tpv.getJpfundo().add(cadastroSolicitante);
            cadastroSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuConSolicitante")) {
            tpv.getJpfundo().removeAll();
            consultaSolicitanteView = new ConsultaSolicitanteView();
            tpv.getJpfundo().add(consultaSolicitanteView);
            consultaSolicitanteView.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("cadastroIdeia")) {
            tpv.getJpfundo().removeAll();

            cadastroIdeia = new CadastroIdeiaView();
//            ic = new IdeiaController(cadastroIdeia);
//            ic.iniciar();
//            cadastroIdeia.setTelaPrincipalController(this);
            tpv.getJpfundo().add(cadastroIdeia);
            cadastroIdeia.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("consultaIdeias")) {
            tpv.getJpfundo().removeAll();
            consultaIdeia = new ConsultaIdeiaView();
            tpv.getJpfundo().add(consultaIdeia);
            consultaIdeia.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuCadIdeia")) {
            tpv.getJpfundo().removeAll();

            cadastroIdeia = new CadastroIdeiaView();
//            ic = new IdeiaController(cadastroIdeia);
//            ic.iniciar();
//            cadastroIdeia.setTelaPrincipalController(this);
            tpv.getJpfundo().add(cadastroIdeia);
            cadastroIdeia.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuConIdeia")) {
            tpv.getJpfundo().removeAll();
            consultaIdeia = new ConsultaIdeiaView();
            tpv.getJpfundo().add(consultaIdeia);
            consultaIdeia.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("sair")) {
            acaoSair();
        }
        if (e.getActionCommand().equals("menuSair")) {
            acaoSair();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        notSelectedAll();
        botao = (JButton) e.getSource();       
        botao.setBorderPainted(true);
        botao.setContentAreaFilled(true);
        botao.setSelected(true);

    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        botao = (JButton) e.getSource();
        botao.setBorderPainted(true);
        botao.setContentAreaFilled(true);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        botao = (JButton) e.getSource();

        if (botao.isSelected()) {

            botao.setBorderPainted(true);
            botao.setContentAreaFilled(true);

        } else {
            botao.setBorderPainted(false);
            botao.setContentAreaFilled(false);
        }
    }


    public void notSelectedAll() {
        tpv.getBtnSair().setBorderPainted(false);
        tpv.getBtnSair().setContentAreaFilled(false);
        tpv.getBtnSair().setSelected(false);

        tpv.getBtnCadastroAluno().setBorderPainted(false);
        tpv.getBtnCadastroAluno().setContentAreaFilled(false);
        tpv.getBtnCadastroAluno().setSelected(false);

        tpv.getBtnCadastroIdeia().setBorderPainted(false);
        tpv.getBtnCadastroIdeia().setContentAreaFilled(false);
        tpv.getBtnCadastroIdeia().setSelected(false);

        tpv.getBtnCadastroProfessor().setBorderPainted(false);
        tpv.getBtnCadastroProfessor().setContentAreaFilled(false);
        tpv.getBtnCadastroProfessor().setSelected(false);

        tpv.getBtnCadastroSolicitante().setBorderPainted(false);
        tpv.getBtnCadastroSolicitante().setContentAreaFilled(false);
        tpv.getBtnCadastroSolicitante().setSelected(false);

        tpv.getBtnConsultaAluno().setBorderPainted(false);
        tpv.getBtnConsultaAluno().setContentAreaFilled(false);
        tpv.getBtnConsultaAluno().setSelected(false);

        tpv.getBtnConsultaIdeias().setBorderPainted(false);
        tpv.getBtnConsultaIdeias().setContentAreaFilled(false);
        tpv.getBtnConsultaIdeias().setSelected(false);

        tpv.getBtnConsultaProfessor().setBorderPainted(false);
        tpv.getBtnConsultaProfessor().setContentAreaFilled(false);
        tpv.getBtnConsultaProfessor().setSelected(false);

        tpv.getBtnConsultaSolicitante().setBorderPainted(false);
        tpv.getBtnConsultaSolicitante().setContentAreaFilled(false);
        tpv.getBtnConsultaSolicitante().setSelected(false);
        tpv.repaint();
        tpv.revalidate();

    }


}
