package controller;

import dao.SolicitanteDAO;
import entidade.Solicitante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroSolicitanteView;

/**
 *
 * @author marceloP
 */
public class SolicitanteCotroller implements ActionListener {

    Solicitante solicitante = new Solicitante();
    CadastroSolicitanteView cadSolicitanteView;
    SolicitanteDAO solicitanteDAO = new SolicitanteDAO();

    public SolicitanteCotroller(CadastroSolicitanteView cadSolicitanteView) {
        this.cadSolicitanteView = cadSolicitanteView;
    }

    public void iniciar() {
        montarEAssinar();
    }

    private void montarEAssinar() {
        cadSolicitanteView.getBtnSalvar().addActionListener(this);
        cadSolicitanteView.getBtnCancelar().addActionListener(this);
        cadSolicitanteView.getBtnIdeia().addActionListener(this);
    }

    public void atualizarViewParaSolicitante() {
        
        solicitante.setNome(cadSolicitanteView.getTfNome().getText());
        solicitante.setEmail(cadSolicitanteView.getTfEmail().getText());
        solicitante.setTelefone(cadSolicitanteView.getFtfTelefone().getText());

    }

    public void atualizarSolicitannteParaView() {
        
        cadSolicitanteView.getTfNome().setText(solicitante.getNome());
        cadSolicitanteView.getTfEmail().setText(solicitante.getEmail());
        cadSolicitanteView.getFtfTelefone().setText(solicitante.getTelefone());
        
    }
    
    
//    public void selecionarDaTabelaCandidatos() {
//        int indice = candidatoView.getJtCandidatoCadastrado().getSelectedRow();
//        CandidatosTableModel model = (CandidatosTableModel) candidatoView.getJtCandidatoCadastrado().getModel();
//        candidato = model.getLista().get(indice);
//        System.out.println(candidato.getIdCandidato());
//    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("salvar")) {
            System.out.println(e.getActionCommand());
            
            atualizarViewParaSolicitante();
            
            if(solicitanteDAO.salvar(solicitante) == true){
                System.out.println("Salvo");
                cadSolicitanteView.getTelaPrincipalController().atualizarValores();
            }else{
                System.out.println(" NAO SALVO! ");
            }
        }

        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("ideia")) {
            System.out.println(e.getActionCommand());
        }
    }

}
