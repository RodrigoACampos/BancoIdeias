package controller;

import dao.SolicitanteDAO;
import entidade.Solicitante;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.SolicitanteTableModel;
import view.ConsultaSolicitanteView;

/**
 *
 * @author Pegasus
 */
public class ConsultaSolicitanteController implements ActionListener {

    Solicitante solicitante = new Solicitante();
    ConsultaSolicitanteView consultaSolicitanteView;
    SolicitanteDAO solicitanteDao = new SolicitanteDAO();
    List<Solicitante> solicitanteLista = new ArrayList();

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

    public ConsultaSolicitanteController(ConsultaSolicitanteView consultaSolicitanteView) {
        this.consultaSolicitanteView = consultaSolicitanteView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    public void montarEAssinar() {
        consultaSolicitanteView.getBtnConsultar().addActionListener(this);
        consultaSolicitanteView.getBtnAlterar().addActionListener(this);
        consultaSolicitanteView.getBtnExcluir().addActionListener(this);
        consultaSolicitanteView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarTabelaSolicitante();
    }

    public void selecionarDaTabelaSolicitantes() {
        int indice = consultaSolicitanteView.getTbPesquisa().getSelectedRow();
        SolicitanteTableModel model = (SolicitanteTableModel) consultaSolicitanteView.getTbPesquisa().getModel();
        solicitante = model.getListaSolicitantes().get(indice);
        System.out.println(solicitante.getId());
    }

    public void atualizarTabelaSolicitante() {

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        SolicitanteTableModel modelo = new SolicitanteTableModel();
        modelo.setListaSolicitantes(solicitanteDao.listar());
        consultaSolicitanteView.getTbPesquisa().setModel(modelo);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("consultar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("alterar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("Excluir")) {
            if (consultaSolicitanteView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Solicitante selecionado, tente novamente...");
            } else {
                selecionarDaTabelaSolicitantes();
                if (solicitanteDao.deletar(solicitante)) {
                    atualizarTabelaSolicitante();
                    consultaSolicitanteView.getTelaPrincipalController().atualizarValores();
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                }
            }
        }
    }
}
