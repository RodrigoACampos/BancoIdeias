/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlunoDAO;
import entidade.Aluno;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.AlunoTableModel;
import view.ConsultaAlunoView;

/**
 *
 * @author Gustavo
 */
public class ConsultaAlunoController implements ActionListener {

    Aluno aluno = new Aluno();
    ConsultaAlunoView consultaAlunoView;
    AlunoDAO alunoDao = new AlunoDAO();
    List<Aluno> alunoLista = new ArrayList();

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

    public ConsultaAlunoController(ConsultaAlunoView consultaAlunoView) {
        this.consultaAlunoView = consultaAlunoView;
    }

    public void iniciar() {
        montarEAssinar();
        atualizarTabelaAluno(alunoLista);
    }

    public void montarEAssinar() {
        consultaAlunoView.getBtnAlterar().addActionListener(this);
        consultaAlunoView.getBtnConsultar().addActionListener(this);
        consultaAlunoView.getBtnExcluir().addActionListener(this);
        consultaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        alunoLista = alunoDao.listar();
    }

    public void selecionarDaTabelaAlunos() {
        int indice = consultaAlunoView.getTbPesquisa().getSelectedRow();
        AlunoTableModel model = (AlunoTableModel) consultaAlunoView.getTbPesquisa().getModel();
        aluno = model.getListaAlunos().get(indice);
        System.out.println(aluno.getId());
    }

    public void atualizarTabelaAluno(List<Aluno> alunos) {
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        AlunoTableModel modelo = new AlunoTableModel();
        modelo.setListaAlunos(alunoLista);
        consultaAlunoView.getTbPesquisa().setModel(modelo);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("consultar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("alterar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("excluir")) {
            //solicitanteDAO.deletar(solicitante);
        }
    }

}
