/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProfessorDAO;
import entidade.Professor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.ProfessorTableModel;
import view.ConsultaProfessorView;

/**
 *
 * @author Gustavo
 */
public class ConsultaProfessorController implements ActionListener {

    Professor professor = new Professor();
    ConsultaProfessorView consultaProfessorView;
    ProfessorDAO professorDao = new ProfessorDAO();
    List<Professor> professorLista = new ArrayList();

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

    public ConsultaProfessorController(ConsultaProfessorView consultaProfessorView) {
        this.consultaProfessorView = consultaProfessorView;
    }

    public void iniciar() {
        montarEAssinar();
        atualizarTabelaProfessor(professorLista);
    }

    public void montarEAssinar() {
        consultaProfessorView.getBtnAlterar().addActionListener(this);
        consultaProfessorView.getBtnConsultar().addActionListener(this);
        consultaProfessorView.getBtnExcluir().addActionListener(this);
        consultaProfessorView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        atualizarTabelaProfessor(professorLista);
    }

    public void selecionarDaTabelaProfessores() {
        int indice = consultaProfessorView.getTbPesquisa().getSelectedRow();
        ProfessorTableModel model = (ProfessorTableModel) consultaProfessorView.getTbPesquisa().getModel();
        professor = model.getListaprofessores().get(indice);
        System.out.println(professor.getId());
    }

    public void atualizarTabelaProfessor(List<Professor> professores) {
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        ProfessorTableModel modelo = new ProfessorTableModel();
        modelo.setListaprofessores(professorDao.listar());
        consultaProfessorView.getTbPesquisa().setModel(modelo);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
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
