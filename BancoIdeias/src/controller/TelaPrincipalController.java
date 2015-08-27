package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.CadastroAlunoView;
import view.CadastroIdeiaView;
import view.IdeiaSolicitanteView;
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
    ConsultaSolicitanteView consultaSolicitante;
    CadastroIdeiaView cadastroIdeia;
    ConsultaIdeiaView consultaIdeia;
   
    SolicitanteCotroller sc;

    public TelaPrincipalController(TelaPrincipalView tpv) {
        this.tpv = tpv;
    }

    public void inciar() {
        montarEAssinar();

    }

    public void montarEAssinar() {
        tpv.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                    acaoSair();
            }
        });
        tpv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tpv.setVisible(true);
        tpv.getBtnCadastroAluno().addActionListener(this);
        tpv.getBtnCadastroAluno().addMouseListener(this);
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
    }

    private void repintarTela() {
        tpv.repaint();
        tpv.revalidate();
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
            sc = new SolicitanteCotroller(cadastroSolicitante);
            sc.iniciar();
            
            tpv.getJpfundo().add(cadastroSolicitante);
            cadastroSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("consultaSolicitante")) {
            tpv.getJpfundo().removeAll();
            consultaSolicitante = new ConsultaSolicitanteView();
            tpv.getJpfundo().add(consultaSolicitante);
            consultaSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuCadSolicitante")) {
            tpv.getJpfundo().removeAll();
            cadastroSolicitante = new CadastroSolicitanteView();
            tpv.getJpfundo().add(cadastroSolicitante);
            cadastroSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("menuConSolicitante")) {
            tpv.getJpfundo().removeAll();
            consultaSolicitante = new ConsultaSolicitanteView();
            tpv.getJpfundo().add(consultaSolicitante);
            consultaSolicitante.setVisible(true);
            repintarTela();
        }
        if (e.getActionCommand().equals("cadastroIdeia")) {
            tpv.getJpfundo().removeAll();
            cadastroIdeia = new CadastroIdeiaView();
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
        tpv.getBtnCadastroAluno().setBorderPainted(true);
        tpv.getBtnCadastroAluno().setContentAreaFilled(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        tpv.getBtnCadastroAluno().setBorderPainted(true);
        tpv.getBtnCadastroAluno().setContentAreaFilled(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        tpv.getBtnCadastroAluno().setBorderPainted(true);
        tpv.getBtnCadastroAluno().setContentAreaFilled(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        tpv.getBtnCadastroAluno().setBorderPainted(false);
        tpv.getBtnCadastroAluno().setContentAreaFilled(false);
    }

    
}
