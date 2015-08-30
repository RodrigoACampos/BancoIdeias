package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
public class IdeiaController implements ActionListener, FocusListener {

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

        cadIdeiaView.getLbObrigatorioInfo().setVisible(false);
        cadIdeiaView.getCbSolicitante().addFocusListener(this);
        cadIdeiaView.getFtfData().addFocusListener(this);
        cadIdeiaView.getTfTema().addFocusListener(this);
        cadIdeiaView.getTaDescricao().addFocusListener(this);

        atualizarSolicitanteComboBox();
    }

    public void atualizarViewParaIdeia() {
        ideia = new Ideia();
        ideia.setTema(cadIdeiaView.getTfTema().getText());
        ideia.setDtcadastro(BRtoUSdate(cadIdeiaView.getFtfData().getText()));
        ideia.setDescricao((cadIdeiaView.getTaDescricao().getText()));
        ideia.setSolicitante((Solicitante) cadIdeiaView.getCbSolicitante().getSelectedItem());
    }
//    public void atualizarIdeiaParaView() {
//
//        cadIdeiaView.getTfTema().setText(ideia.getTema());
//        cadIdeiaView.getFtfData().setText(String.valueOf(ideia.getDtcadastro()));
//        cadIdeiaView.getTaDescricao().setText(ideia.getDescricao());//        
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

    public void clearAll() {
        cadIdeiaView.getCbSolicitante().setSelectedIndex(-1);
        cadIdeiaView.getTfTema().setText("");
        cadIdeiaView.getFtfData().setText("");
        cadIdeiaView.getTaDescricao().setText("");
    }

    public Boolean verificaCampo() {
        Boolean emBranco = null;
        String tema, data, descricao;
        Integer nome;
        nome = cadIdeiaView.getCbSolicitante().getSelectedIndex();
        tema = cadIdeiaView.getTfTema().getText();
        descricao = cadIdeiaView.getTaDescricao().getText();
        data = cadIdeiaView.getFtfData().getText().replaceAll("[ //]", "");

        if (nome == -1 || tema.equals(null) || tema.equals("")
                || descricao.equals(null) || descricao.equals("")
                || data.equals(null) || data.equals("")) {
            emBranco = true;
            cadIdeiaView.getLbObrigatorioInfo().setVisible(true);
        } else {
            cadIdeiaView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Salvar")) {
            if (verificaCampo()) {
                cadIdeiaView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em Btanco? " + verificaCampo());
            } else {
                atualizarViewParaIdeia();
                if (ideiaDAO.salvar(ideia) == true) {
                    System.out.println("Salvo");
                    cadIdeiaView.getTelaPrincipalController().atualizarValores();
                    clearAll();
                } else {
                    System.out.println(" NAO SALVO! ");
                }
            }
        }
        if (e.getActionCommand().equals("Cancelar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("i")) {
            System.out.println(e.getActionCommand());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        verificaCampo();
    }

    @Override
    public void focusLost(FocusEvent e) {
        verificaCampo();
    }

}
