/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.CadastroAlunoView;
import view.ConsultaAlunoView;
import view.TelaPrincipalView;

/**
 *
 * @author Gustavo
 */
public class TelaPrincipalController implements ActionListener {

    TelaPrincipalView tpv;
    CadastroAlunoView cadastroAluno;
    ConsultaAlunoView consultaAluno;

    public TelaPrincipalController(TelaPrincipalView tpv) {
        this.tpv = tpv;
    }

    public void inciar() {
        montarEAssinar();

    }

    public void montarEAssinar() {
        tpv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tpv.setVisible(true);
        tpv.getBtnCadastroAluno().addActionListener(this);
        tpv.getBtnConsultaAluno().addActionListener(this);
        tpv.getMenuCadastroAluno().addActionListener(this);
        tpv.getMenuConsultaAluno().addActionListener(this);
        tpv.getBtnSair().addActionListener(this);

    }

    private void repintarTela() {
        tpv.repaint();
        tpv.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+aluno")) {
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

        if (e.getActionCommand().equals("sair")) {
            JOptionPane.showMessageDialog(null, "Você saiu do WEG Software!");
            System.exit(0);
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
       

    }

}
