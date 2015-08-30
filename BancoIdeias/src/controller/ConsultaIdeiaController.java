/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IdeiaDAO;
import entidade.Ideia;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.IdeiaTableModel;
import view.ConsultaIdeiaView;

/**
 *
 * @author Gustavo
 */
public class ConsultaIdeiaController implements ActionListener, MouseListener {

    Ideia ideia = new Ideia();
    ConsultaIdeiaView consultaIdeiaView;
    IdeiaDAO listaDao = new IdeiaDAO();
    List<Ideia> ideiaLista = new ArrayList();

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

    public ConsultaIdeiaController(ConsultaIdeiaView consultaIdeiaView) {
        this.consultaIdeiaView = consultaIdeiaView;
    }

    public void iniciar() {
        montarEAssinar();
        atualizarTabelaIdeia(ideiaLista);
    }

    public void montarEAssinar() {
        consultaIdeiaView.getBtnAlterar().addActionListener(this);
        consultaIdeiaView.getBtnConsultar().addActionListener(this);
        consultaIdeiaView.getBtnExcluir().addActionListener(this);
        consultaIdeiaView.getTbPesquisa().addMouseListener(this);
        consultaIdeiaView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ideiaLista = listaDao.listar();
    }

    public void selecionarDaTabelaIdeias() {
        int indice = consultaIdeiaView.getTbPesquisa().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) consultaIdeiaView.getTbPesquisa().getModel();
        ideia = model.getListaIdeias().get(indice);
        System.out.println(ideia.getId());
    }

    public void atualizarTabelaIdeia(List<Ideia> ideias) {
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        IdeiaTableModel modelo = new IdeiaTableModel(ideias);
        modelo.setListaIdeias(ideiaLista);
        consultaIdeiaView.getTbPesquisa().setModel(modelo);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(200);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(300);

        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }
    
     private void atualizarDescricao() {
         consultaIdeiaView.getTaDescricao().setText(ideia.getDescricao());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
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
