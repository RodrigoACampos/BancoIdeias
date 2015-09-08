package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.Solicitante;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.IdeiaTableModel;
import model.SolicitanteCBModel;
import view.CadastroIdeiaView;
import view.ConsultaIdeiaView;

/**
 *
 * @author Gustavo
 */
public class IdeiaController implements ActionListener, FocusListener, MouseListener {

    //Declarando os objetos 
    private Ideia ideia = new Ideia();
    private IdeiaDAO ideiaDao = new IdeiaDAO();
    private Solicitante solicitante = new Solicitante();
    private SolicitanteDAO solicitanteDao = new SolicitanteDAO();

    //Declarando objeto de controle da tela principal
    private TelaPrincipalController telaPrincipalController;

    //Criando objetos das janelas
    private CadastroIdeiaView cadastroIdeiaView;
    private ConsultaIdeiaView consultaIdeiaView;

    SolicitanteCBModel solicitanteCBModel;

    public IdeiaController(TelaPrincipalController telaPrincipalController) {
        this.telaPrincipalController = telaPrincipalController;

        this.cadastroIdeiaView = new CadastroIdeiaView();
        this.consultaIdeiaView = new ConsultaIdeiaView();

        AssinarListener();
        ClearCadastroIdeia();
        ClearConsultaIdeia();
        atualizarSolicitanteComboBox();
    }

    private void AssinarListener() {
        this.cadastroIdeiaView.getBtnSalvar().addActionListener(this);
        this.cadastroIdeiaView.getBtnCancelar().addActionListener(this);
        this.cadastroIdeiaView.getTfTema().addFocusListener(this);
        this.cadastroIdeiaView.getTaDescricao().addFocusListener(this);
        this.cadastroIdeiaView.getFtfData().addFocusListener(this);

        this.consultaIdeiaView.getBtnAlterar().addActionListener(this);
        this.consultaIdeiaView.getBtnConsultar().addActionListener(this);
        this.consultaIdeiaView.getBtnExcluir().addActionListener(this);
        this.consultaIdeiaView.getBtnCancelar().addActionListener(this);

        this.consultaIdeiaView.getTbPesquisa().addMouseListener(this);

        this.consultaIdeiaView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.cadastroIdeiaView.getLbObrigatorioInfo().setVisible(false);

        atualizarSolicitanteComboBox();
        solicitanteDao.listar();

    }

    public void ShowConsultaIdeia() {
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.consultaIdeiaView);
        this.consultaIdeiaView.setVisible(true);

        IdeiaListar();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void IdeiaListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        IdeiaTableModel modelo = new IdeiaTableModel();

        modelo.setListaideias(this.ideiaDao.listar());
        this.consultaIdeiaView.getTbPesquisa().setModel(modelo);

        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);

        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(500);
        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.consultaIdeiaView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
    }

    private void ClearCadastroIdeia() {
        ideia = new Ideia();
        this.cadastroIdeiaView.getCbSolicitante().setSelectedIndex(-1);
        this.cadastroIdeiaView.getTfTema().setText("");
        this.cadastroIdeiaView.getFtfData().setText("");
        this.cadastroIdeiaView.getTaDescricao().setText("");
    }

    private void ClearConsultaIdeia() {
        this.consultaIdeiaView.getTfConsulta().setText("");
    }

    private void SalvarIdeia() {
        //ideia = new Ideia();
        //pegando os valores de cada campo da tela de cadastro
        this.ideia.setTema(cadastroIdeiaView.getTfTema().getText());
        this.ideia.setDtcadastro(BRtoUSdate(cadastroIdeiaView.getFtfData().getText()));
        this.ideia.setDescricao((cadastroIdeiaView.getTaDescricao().getText()));
        this.ideia.setSolicitante((Solicitante) cadastroIdeiaView.getCbSolicitante().getSelectedItem());
        //passando os valores para o DAO
        int chave = this.ideiaDao.salvar(this.ideia);

        if (chave != -1) {
            //Limpando a tela de cadastro
            ClearCadastroIdeia();
            ShowConsultaIdeia();
        } else {
            ClearCadastroIdeia();
            ShowConsultaIdeia();
        }

    }

    private void ExcluirIdeia() {
        //localizando o solicitante
        int indice = consultaIdeiaView.getTbPesquisa().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) consultaIdeiaView.getTbPesquisa().getModel();
        ideia = model.getListaideia().get(indice);
        System.out.println(ideia.getId());
        //verificando se o dao conseguir localizar a partir do id
        if (ideia != null) {
            // mostrando a tela de cadastro do solicitante
            ideiaDao.deletar(ideia);
        }
        //chamando a tela de consulta do solicitante
        ShowConsultaIdeia();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    public void AddCadastroSolicitante() {
        ClearCadastroIdeia();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.cadastroIdeiaView);
        this.cadastroIdeiaView.setVisible(true);
        this.telaPrincipalController.repintarTela();
    }

    public void atualizarSolicitanteComboBox() {
        List<Solicitante> lista;
        lista = solicitanteDao.listar();
        SolicitanteCBModel solicitanteCBModel = new SolicitanteCBModel(lista);
        this.cadastroIdeiaView.getCbSolicitante().setModel(solicitanteCBModel);
    }

//    public void atualizarSolicitanteAlterarCombobox(){
//        solicitanteDao.GetById(solicitante.getSolicitante());
//        
//    }
    public void UpdateCadastroIdeia() {
        AddCadastroSolicitante();
        //localizando o solicitante
        int indice = consultaIdeiaView.getTbPesquisa().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) consultaIdeiaView.getTbPesquisa().getModel();
        ideia = model.getListaideia().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (ideia != null) {
            // mostrando a tela de cadastro da ideia
            //IdeiaListar();
            //atualizando os valores da tela
            this.cadastroIdeiaView.getTfTema().setText(ideia.getTema());
            this.cadastroIdeiaView.getTaDescricao().setText(ideia.getDescricao());
            this.cadastroIdeiaView.getFtfData().setText((UStoBRdate(ideia.getDtcadastro())));
//             this.ideia.setSolicitante((Solicitante) cadastroIdeiaView.getCbSolicitante().getSelectedItem());
//             this.cadastroIdeiaView.getCbSolicitante().setSelectedItem();
            solicitante = ideia.getSolicitante();
            List<Solicitante> lista =  new ArrayList();
            lista = solicitanteDao.listar();
            int indiceCB = -1;
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getId() == solicitante.getId());
                if (lista.get(i).getId() == solicitante.getId()){
                    indiceCB = i;
                }
            }
            this.cadastroIdeiaView.getCbSolicitante().setSelectedIndex(indiceCB);
//             this.cadastroIdeiaView.getCbSolicitante().setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel obter os dados da ideia selecionada");
        }
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    public String UStoBRdate(java.util.Date data) {
        String d = "";
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

        try {
            d = out.format(in.parse(data.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(SolicitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public java.util.Date BRtoUSdate(String data) {
        DateFormat formatoBr = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = null;
        try {
            d = (java.util.Date) formatoBr.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(SolicitanteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public void ClearDescricao() {
        this.consultaIdeiaView.getTaDescricao().setText(null);
    }

    public Boolean verificaCampo() {
        Boolean emBranco = null;
        String tema, data, descricao;
        Integer nome;
        nome = cadastroIdeiaView.getCbSolicitante().getSelectedIndex();
        tema = cadastroIdeiaView.getTfTema().getText();
        descricao = cadastroIdeiaView.getTaDescricao().getText();
        data = cadastroIdeiaView.getFtfData().getText().replaceAll("[ //]", "");

        if (nome == -1 || tema.equals(null) || tema.equals("")
                || descricao.equals(null) || descricao.equals("")
                || data.equals(null) || data.equals("")) {
            emBranco = true;
            cadastroIdeiaView.getLbObrigatorioInfo().setVisible(true);
        } else {
            cadastroIdeiaView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SalvarIdeia")) {
            if (verificaCampo()) {
                cadastroIdeiaView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                SalvarIdeia();
            }
        }

        if (e.getActionCommand().equals("CancelarIdeia")) {
            this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
            this.telaPrincipalController.repintarTela();
        }

        if (e.getActionCommand().equals("ExcluirIdeia")) {
            if (consultaIdeiaView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Ideia selecionada, tente novamente!");
            } else {
                ExcluirIdeia();
            }
        }

        if (e.getActionCommand().equals("AlterarIdeia")) {
            ClearDescricao();
            if (consultaIdeiaView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Ideia selecionada, tente novamente!");
            } else {
                UpdateCadastroIdeia();
            }
        }

        if (e.getActionCommand().equals("ConsultaCancelar")) {
            this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
            this.telaPrincipalController.repintarTela();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int indice = consultaIdeiaView.getTbPesquisa().getSelectedRow();
            IdeiaTableModel model = (IdeiaTableModel) consultaIdeiaView.getTbPesquisa().getModel();
            Ideia ideia = model.getListaideia().get(indice);
            this.consultaIdeiaView.getTaDescricao().setText(ideia.getDescricao());
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
