package controller;

import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.SolicitanteTableModel;
import view.ConsultaSolicitanteView;

/**
 *
 * @author Pegasus
 */
public class ConsultaSolicitanteController implements ActionListener{
    
    Solicitante solicitante = new Solicitante();
    ConsultaSolicitanteView consultaSolicitanteView;
    SolicitanteDAO solicitanteDAO = new SolicitanteDAO();    
    List<Solicitante> solicitanteLista = new ArrayList();

    public ConsultaSolicitanteController(ConsultaSolicitanteView consultaSolicitanteView) {
        this.consultaSolicitanteView = consultaSolicitanteView;
    }
    
    public void iniciar(){
        montarEAssinar();
        atualizarTabelaSolicitante(solicitanteLista);
    }
    
    public void montarEAssinar(){
        consultaSolicitanteView.getBtnConsultar().addActionListener(this);
        consultaSolicitanteView.getBtnAlterar().addActionListener(this);
        consultaSolicitanteView.getBtnExcluir().addActionListener(this);
        
        solicitanteLista = solicitanteDAO.listar();
    }  
    
    public void selecionarDaTabelaSolicitantes() {
        int indice = consultaSolicitanteView.getTbPesquisa().getSelectedRow();
        SolicitanteTableModel model = (SolicitanteTableModel) consultaSolicitanteView.getTbPesquisa().getModel();
        solicitante = model.getListaSolicitantes().get(indice);
        System.out.println(solicitante.getId());
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setMaxWidth(30);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setMaxWidth(300);
        consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setMaxWidth(100);
        consultaSolicitanteView.getTbPesquisa().getSelectedRows();
    }

    public void atualizarTabelaSolicitante(List<Solicitante> solicitantes) {
        SolicitanteTableModel modelo = new SolicitanteTableModel();
        modelo.setListaSolicitantes(solicitanteLista);
        consultaSolicitanteView.getTbPesquisa().setModel(modelo);
//        cadSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(300);
//        cadSolicitanteView.getTbIdeia().getSelectedRows();

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
