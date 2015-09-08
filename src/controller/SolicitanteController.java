package controller;

import dao.IdeiaDAO;
import dao.SolicitanteDAO;
import entidade.Ideia;
import entidade.InteresseDesenvolver;
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
import model.InteresseDesenvolverTableModel;
import model.SolicitanteTableModel;
import view.CadastroSolicitanteView;
import view.CadastroSolicitanteView2;
import view.ConsultaSolicitanteView;
import view.IdeiaSolicitanteView;

/**
 *
 * @author Willyam
 */
public class SolicitanteController implements ActionListener, FocusListener {

    //Declarando os objetos 
    private Solicitante solicitante = new Solicitante();
    private SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
    private Ideia ideia = new Ideia();
    private IdeiaDAO ideiaDao = new IdeiaDAO();

    //Declarando objeto de controle da tela principal
    private TelaPrincipalController telaPrincipalController;

    //Criando objetos das janelas
    private CadastroSolicitanteView2 cadastroSolicitanteView;
    private ConsultaSolicitanteView consultaSolicitanteView;
    private IdeiaSolicitanteView ideiaSolicitanteView;

    //Construtor do controller, ele instancia os objetos para acesso a qualquer momento
    public SolicitanteController(TelaPrincipalController telaPrincipalController) {
        this.telaPrincipalController = telaPrincipalController;

        this.cadastroSolicitanteView = new CadastroSolicitanteView2();
        this.consultaSolicitanteView = new ConsultaSolicitanteView();
        this.ideiaSolicitanteView = new IdeiaSolicitanteView(null, true);

        AssinarListener();
        ClearCadastroSolicitante();
        ClearConsultaSolicitante();
    }

    //retorna o objeto da tela de cadastrado do solicitante
    public CadastroSolicitanteView2 getCadastroSolicitanteView() {
        return this.cadastroSolicitanteView;
    }

    //retorna o objeto da tela de consulta do solicitante
    public ConsultaSolicitanteView GetConsultaSolicitanteView() {
        return this.consultaSolicitanteView;
    }

    //Implementando metodo para abrir janela de cadastro de solicitante
    public void AddCadastroSolicitante() {
        ClearCadastroSolicitante();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.cadastroSolicitanteView);
        this.cadastroSolicitanteView.setVisible(true);
        this.telaPrincipalController.repintarTela();
    }

    public void UpdateCadastroSolicitante() {
        AddCadastroSolicitante();
        //localizando o solicitante
        int indice = consultaSolicitanteView.getTbPesquisa().getSelectedRow();
        SolicitanteTableModel model = (SolicitanteTableModel) consultaSolicitanteView.getTbPesquisa().getModel();
        solicitante = model.getListaSolicitantes().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (solicitante != null) {
            // mostrando a tela de cadastro do solicitante
            IdeiaListar();
            //atualizando os valores da tela
            this.cadastroSolicitanteView.getTfNome().setText(solicitante.getNome());
            this.cadastroSolicitanteView.getTfEmail().setText(solicitante.getEmail());
            this.cadastroSolicitanteView.getFtfTelefone().setText(solicitante.getTelefone());

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel obter os dados do solicitante selecionado");
        }
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    //Implementando metodo para abrir janela de consulta de solicitante
    public void ShowConsultaSolicitante() {
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.consultaSolicitanteView);
        this.consultaSolicitanteView.setVisible(true);

        SolicitanteListar();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    public void ShowListasIdeiasDisponiveis() {
        if (this.solicitante.getId() == null) {
            if (this.telaPrincipalController.Perguntar("Para adicionar uma ideia é necessário salvar o solicitante antes. Deseja salvar agora?")) {
                //pegando os valores de cada campo da tela de cadastro
                this.solicitante.setNome(cadastroSolicitanteView.getTfNome().getText());
                this.solicitante.setEmail(cadastroSolicitanteView.getTfEmail().getText());
                this.solicitante.setTelefone(cadastroSolicitanteView.getFtfTelefone().getText());
                //passando os valores para o DAO
                int chave = this.solicitanteDAO.salvar(this.solicitante);
                if (chave != -1) {
                    this.solicitante.setId(chave);
                    this.ideiaSolicitanteView.setVisible(true);
                }
            }
        } else {
            this.ideiaSolicitanteView.setVisible(true);
        }
    }

    //Metodo de controle de eventos
    private void AssinarListener() {
        this.cadastroSolicitanteView.getBtnSalvar().addActionListener(this);
        this.cadastroSolicitanteView.getBtnCancelar().addActionListener(this);
        this.cadastroSolicitanteView.getBtnAdiconarIdeia().addActionListener(this);
        this.cadastroSolicitanteView.getBtnRemoverIdeia().addActionListener(this);
        this.cadastroSolicitanteView.getTfNome().addFocusListener(this);
        this.cadastroSolicitanteView.getTfEmail().addFocusListener(this);
        this.cadastroSolicitanteView.getFtfTelefone().addFocusListener(this);       

        this.consultaSolicitanteView.getBtnAlterar().addActionListener(this);
        this.consultaSolicitanteView.getBtnConsultar().addActionListener(this);
        this.consultaSolicitanteView.getBtnExcluir().addActionListener(this);
        this.consultaSolicitanteView.getBtnCancelar().addActionListener(this);

        this.ideiaSolicitanteView.getBtnSalvar().addActionListener(this);
        this.ideiaSolicitanteView.getBtnCancelar().addActionListener(this);
        this.cadastroSolicitanteView.getTbIdeia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.consultaSolicitanteView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.cadastroSolicitanteView.getLbObrigatorioInfo().setVisible(false);       
    }

    //Limpar tela de cadastro do solicitante
    public void ClearCadastroSolicitante() {
        solicitante = new Solicitante();
        this.cadastroSolicitanteView.getTfNome().setText("");
        this.cadastroSolicitanteView.getTfEmail().setText("");
        this.cadastroSolicitanteView.getFtfTelefone().setText("");

        List<Ideia> listatemp = new ArrayList<Ideia>();
        IdeiaTableModel modelo = new IdeiaTableModel();
        modelo.setListaideias(listatemp);
        this.cadastroSolicitanteView.getTbIdeia().setModel(modelo);
    }
    //Limpar tela de ideia
    private void ClearIdeiaSolicitante() {
        this.ideiaSolicitanteView.getTfTema().setText("");
        this.ideiaSolicitanteView.getTaDescricao().setText("");
        this.ideiaSolicitanteView.getFtfData().setText("");
    }
    //Limpar tela de consulta do solicitante
    public void ClearConsultaSolicitante() {
        this.consultaSolicitanteView.getTfConsulta().setText("");
    }

    private void SolicitanteSalvar() {
        //pegando os valores de cada campo da tela de cadastro
        this.solicitante.setNome(cadastroSolicitanteView.getTfNome().getText());
        this.solicitante.setEmail(cadastroSolicitanteView.getTfEmail().getText());
        this.solicitante.setTelefone(cadastroSolicitanteView.getFtfTelefone().getText());
        //passando os valores para o DAO
        int chave = this.solicitanteDAO.salvar(this.solicitante);

        if (chave != -1) {
            //Limpando a tela de cadastro
            ClearCadastroSolicitante();
            //chamando a tela de consulta do solicitante
            ShowConsultaSolicitante();            
        }
    }

    private void SolicitanteExcluir() {
        //localizando o solicitante
        int indice = consultaSolicitanteView.getTbPesquisa().getSelectedRow();
        SolicitanteTableModel model = (SolicitanteTableModel) consultaSolicitanteView.getTbPesquisa().getModel();
        solicitante = model.getListaSolicitantes().get(indice);
        System.out.println(solicitante.getId());
        //verificando se o dao conseguir localizar a partir do id
        if (solicitante != null) {
            // mostrando a tela de cadastro do solicitante
            solicitanteDAO.deletar(solicitante);
        }
        //chamando a tela de consulta do solicitante
        ShowConsultaSolicitante();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void ExcluirIdeiaSelecionada() {
        //localizando o solicitante
        int indice = cadastroSolicitanteView.getTbIdeia().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) cadastroSolicitanteView.getTbIdeia().getModel();
        Ideia ideia = model.getListaideia().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (ideia != null) {
            // mostrando a tela de cadastro do solicitante
//            solicitanteDAO.deletar(solicitante);
            ideiaDao.deletar(ideia);
        }
        this.ideiaSolicitanteView.setVisible(false);
        //chamando a tela de consulta do solicitante
        IdeiaListar();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void SolicitanteListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        SolicitanteTableModel modelo = new SolicitanteTableModel();
        modelo.setListaSolicitantes(this.solicitanteDAO.listar());
        this.consultaSolicitanteView.getTbPesquisa().setModel(modelo);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        this.consultaSolicitanteView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
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

    private void IdeiaSalvar() {
        //pegando os valores de cada campo da tela de cadastro
        this.ideia.setTema(ideiaSolicitanteView.getTfTema().getText());
        this.ideia.setDtcadastro(BRtoUSdate(ideiaSolicitanteView.getFtfData().getText()));
        this.ideia.setDescricao((ideiaSolicitanteView.getTaDescricao().getText()));
        this.ideia.setSolicitante(solicitante);
        //passando os valores para o DAO
        int chave = this.ideiaDao.salvar(this.ideia);

        if (chave != -1) {
            //Limpando a tela de cadastro
            ClearIdeiaSolicitante();
            IdeiaListar();
            this.ideiaSolicitanteView.setVisible(false);
        }
    }

    private void IdeiaListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;
        IdeiaTableModel modelo = new IdeiaTableModel();

        modelo.setListaideias(this.ideiaDao.GetByIdSolicitante(this.solicitante.getId()));
        this.cadastroSolicitanteView.getTbIdeia().setModel(modelo);

        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(0).setCellRenderer(cellRender);

        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(1).setPreferredWidth(500);
        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.cadastroSolicitanteView.getTbIdeia().getColumnModel().getColumn(1).setCellRenderer(cellRender);
    }

    public Boolean verificaCampo() {
        Boolean emBranco = null;
        String nome, email, telefone;
        nome = cadastroSolicitanteView.getTfNome().getText();
        email = cadastroSolicitanteView.getTfEmail().getText();
        telefone = cadastroSolicitanteView.getFtfTelefone().getText().replaceAll("[ ()-]", "");
        System.out.println(telefone);
        if (nome.equals(null) || nome.equals("") || email.equals(null) || email.equals("")
                || telefone.equals(null) || telefone.equals("")) {
            emBranco = true;
            cadastroSolicitanteView.getLbObrigatorioInfo().setVisible(true);
        } else {
            cadastroSolicitanteView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    public Boolean verificaCampoIdeia() {
        Boolean emBranco = null;
        String tema, descricao, data;
        tema = ideiaSolicitanteView.getTfTema().getText();
        descricao = ideiaSolicitanteView.getTaDescricao().getText();
        data = ideiaSolicitanteView.getFtfData().getText().replaceAll("[ //]", "");
        System.out.println(data);
        if (tema.equals(null) || tema.equals("") || descricao.equals(null) || descricao.equals("")
                || data.equals(null) || data.equals("")) {
            emBranco = true;
            ideiaSolicitanteView.getLbObrigatorioInfo().setVisible(true);
        } else {
            ideiaSolicitanteView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SolicitanteCadastroSalvar")) {
            if (verificaCampo()) {
                cadastroSolicitanteView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                SolicitanteSalvar();
            }
        }

        if (e.getActionCommand().equals("SolicitanteCancelar")) {
            this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
            this.telaPrincipalController.repintarTela();
        }

        if (e.getActionCommand().equals("SolicitanteExcluir")) {
            if (consultaSolicitanteView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Solicitante selecionado, tente novamente!");
            } else {
                SolicitanteExcluir();
            }
        }

        if (e.getActionCommand().equals("SolicitanteCadastroAddIdeia")) {            
            if (verificaCampo()) {
                cadastroSolicitanteView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                ShowListasIdeiasDisponiveis();
                telaPrincipalController.repintarTela();
            }
        }

        if (e.getActionCommand().equals("SolicitanteCadastroDelIdeia")) {
            if (cadastroSolicitanteView.getTbIdeia().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem ideia selecionada, tente novamente!");
            } else {
                ExcluirIdeiaSelecionada();
            }
        }

        if (e.getActionCommand().equals("SolicitanteConsultaAlterar")) {
            if (consultaSolicitanteView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Solicitante selecionado, tente novamente!");
            } else {
                UpdateCadastroSolicitante();
            }
        }

        if (e.getActionCommand().equals("SalvarIdeia")) {            
            if (verificaCampoIdeia()) {
                ideiaSolicitanteView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                IdeiaSalvar();                
            }
            telaPrincipalController.repintarTela();
        }
        if (e.getActionCommand().equals("CancelarIdeia")) {
            this.ideiaSolicitanteView.setVisible(false);
            //chamando a tela de consulta do professor
            IdeiaListar();
            //Atualizando a tela principal
            telaPrincipalController.repintarTela();
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
