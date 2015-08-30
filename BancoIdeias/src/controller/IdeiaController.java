package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.IdeiaTableModel;
import model.SolicitanteCBModel;
import view.CadastroIdeiaView;

/**
 *
 * @author Pegasus
 */

public class IdeiaController implements ActionListener{
       
        
    Ideia ideia = new Ideia();
    IdeiaDAO ideiaDAO = new IdeiaDAO();
    //List<Ideia> listaIdeia = new ArrayList();
    SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
    CadastroIdeiaView cadIdeiaView;
    List<Solicitante> listaSolicitantes;
    Solicitante solicitante;
    SolicitanteCBModel solicitanteCBModel;

    public IdeiaController(CadastroIdeiaView cadIdeiaView) {
        this.cadIdeiaView = cadIdeiaView;
    }
      
    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadIdeiaView.getBtnSalvar().addActionListener(this);
        cadIdeiaView.getBtnCancelar().addActionListener(this);
        cadIdeiaView.getCbSolicitante().addActionListener(this);
        cadIdeiaView.getFtfData().addActionListener(this);
        
        atualizarSolicitanteComboBox();
    }

    public void atualizarViewParaIdeia() {
        ideia = new Ideia();

        ideia.setTema(cadIdeiaView.getTfTema().getText());
        ideia.setDtcadastro(BRtoUSdate(cadIdeiaView.getFtfData().getText())) ;
        ideia.setDescricao((cadIdeiaView.getTaDescricao().getText()));
        ideia.setSolicitante((Solicitante) cadIdeiaView.getCbSolicitante().getSelectedItem());
    }

//    public void atualizarIdeiaParaView() {
//
//        cadIdeiaView.getTfTema().setText(ideia.getTema());
//        cadIdeiaView.getFtfData().setText(String.valueOf(ideia.getDtcadastro()));
//        cadIdeiaView.getTaDescricao().setText(ideia.getDescricao());
//        
//    }
    
    
    public void atualizarSolicitanteComboBox() {
             
        solicitanteCBModel = new SolicitanteCBModel(solicitanteDAO.listar());
        cadIdeiaView.getCbSolicitante().setModel(solicitanteCBModel);

    }
    
//    public void atualizarListaSolicitantes(){
//        listaSolicitantes = new ArrayList();
//        listaSolicitantes = solicitanteDAO.listar();
//    }
    
    public String UStoBRdate(java.util.Date data) {
        String d = "";
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        try {
            d = out.format(in.parse(data.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(IdeiaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return d;
    }

    public java.util.Date BRtoUSdate(String data) {
        DateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = null;
        try {
            d = (java.util.Date) formatoBr.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(IdeiaController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return d;
        
    }
    
    public void clearAll(){
        
        ideia.setTema("");
        ideia.setDtcadastro(null) ;
        ideia.setDescricao("");
        ideia.setSolicitante(null);
        
    }


    @Override
   public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("Salvar")) {
            System.out.println(e.getActionCommand());

            atualizarViewParaIdeia();
           
            if (ideiaDAO.salvar(ideia) == true) {
                clearAll();
                System.out.println("Salvo");
                cadIdeiaView.getTelaPrincipalController().atualizarValores();
            } else {
                System.out.println(" NAO SALVO! ");
            }
        }

        if (e.getActionCommand().equals("Cancelar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("i")) {
            System.out.println(e.getActionCommand());
        }
        
    }

       
}
