package controller;

import dao.IdeiaDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SolicitanteCBModel;
import view.CadastroIdeiaView;

/**
 *
 * @author Pegasus
 */

public class IdeiaController implements ActionListener{
       
        
    Ideia ideia = new Ideia();
    CadastroIdeiaView cadIdeiaView;
    IdeiaDAO ideiaDAO = new IdeiaDAO();
    List<Ideia> listaIdeia = new ArrayList();
    List<Solicitante> listaSolicitantes = new ArrayList();
    Solicitante solicitante;
    SolicitanteCBModel solicitanteCBModel;

    public IdeiaController(CadastroIdeiaView cadIdeiaView) {
        this.cadIdeiaView = cadIdeiaView;
    }
      
    public void iniciar() {
        //montarEAssinar();
    }
//
//    private void montarEAssinar() {
//        cadIdeiaView.getBtnSalvar().addActionListener(this);
//        cadIdeiaView.getBtnCancelar().addActionListener(this);
//        cadIdeiaView.getCbSolicitante().addActionListener(this);
//        cadIdeiaView.getFtfData().addActionListener(this);
//        
//        listaIdeia = ideiaDAO.listar();
//    }
//
//    public void atualizarViewParaIdeia() {
//
//        ideia.setTema(cadIdeiaView.getTfTema().getText());
//        ideia.setDtcadastro(Date.valueOf(cadIdeiaView.getFtfData().getText()));
//        ideia.setDescricao((cadIdeiaView.getTaDescricao().getText()));
//        //para teste
//        ideia.setSolicitante(null);
//        //ideia.setSolicitante(cadIdeiaView.getCbSolicitante().getSelectedObjects());
//    }
//
//    public void atualizarIdeiaParaView() {
//
//        cadIdeiaView.getTfTema().setText(ideia.getTema());
//        cadIdeiaView.getFtfData().setText(String.valueOf(ideia.getDtcadastro()));
//        cadIdeiaView.getTaDescricao().setText(ideia.getDescricao());
//        //para teste
//        cadIdeiaView.getCbSolicitante().setSelectedIndex(-1);
//        //cadIdeiaView.getCbSolicitante().setSelectedIndex(solicitante.getId());
//
//    }
//    
//    public void atualizarSolicitanteComboBox() {
//
//        solicitanteCBModel = new SolicitanteCBModel(listaSolicitantes);
//        cadIdeiaView.getCbSolicitante().setModel(solicitanteCBModel);
//
//    }
//
//    private void atualizarCBSolicitanteBanco() {
//
//        
//            model = new EmpresaComboBox(EmpresaDAO.getAll());
//            vagaView.getjComboBoxEmpresaVaga().setModel(model);
//        
//
//    }
//
//
    @Override
   public void actionPerformed(ActionEvent e) {
//        
//        if (e.getActionCommand().equals("Salvar")) {
//            System.out.println(e.getActionCommand());
//
//            atualizarViewParaIdeia();
//
//            if (ideiaDAO.salvar(ideia) == true) {
//                System.out.println("Salvo");
//                cadIdeiaView.getTelaPrincipalController().atualizarValores();
//            } else {
//                System.out.println(" NAO SALVO! ");
//            }
//        }
//
//        if (e.getActionCommand().equals("Cancelar")) {
//            System.out.println(e.getActionCommand());
//        }
//
//        if (e.getActionCommand().equals("i")) {
//            System.out.println(e.getActionCommand());
//        }
//        
    }

       
}
