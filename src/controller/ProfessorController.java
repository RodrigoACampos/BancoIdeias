package controller;

import dao.InteresseOrientarDAO;
import dao.ProfessorDAO;
import entidade.Ideia;
import entidade.InteresseOrientar;
import entidade.Professor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.IdeiaTableModel;
import model.InteresseOrientarTableModel;
import model.ProfessorTableModel;
import view.CadastroProfessorView;
import view.ConsultaProfessorView;
import view.IdeiaProfessorView;

/**
 *
 * @author Willyam
 */
public class ProfessorController implements ActionListener, FocusListener, MouseListener {

    //Declarando os objetos 
    private Professor professor = new Professor();
    private ProfessorDAO professorDAO = new ProfessorDAO();

    private InteresseOrientar interesseOrientar = new InteresseOrientar();
    private InteresseOrientarDAO interesseOrientarDAO = new InteresseOrientarDAO();

    //Declarando objeto de controle da tela principal
    private TelaPrincipalController telaPrincipalController;

    //Criando objetos das janelas
    private CadastroProfessorView cadastroProfessorView;
    private ConsultaProfessorView consultaProfessorView;
    private IdeiaProfessorView ideiaProfessorView;

    //Construtor do controller, ele instancia os objetos para acesso a qualquer momento
    public ProfessorController(TelaPrincipalController telaPrincipalController) {
        this.telaPrincipalController = telaPrincipalController;

        this.cadastroProfessorView = new CadastroProfessorView();
        this.consultaProfessorView = new ConsultaProfessorView();
        this.ideiaProfessorView = new IdeiaProfessorView(null, true);

        AssinarListener();
        ClearCadastroProfessor();
        ClearConsultaProfessor();
    }

    //retorna o objeto da tela de cadastrado do professor
    public CadastroProfessorView getCadastroProfessorView() {
        return this.cadastroProfessorView;
    }

    //retorna o objeto da tela de consulta do professor
    public ConsultaProfessorView GetConsultaProfessorView() {
        return this.consultaProfessorView;
    }

    //Implementando metodo para abrir janela de cadastro de professor
    public void AddCadastroProfessor() {
        ClearCadastroProfessor();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.cadastroProfessorView);
        this.cadastroProfessorView.setVisible(true);
        this.telaPrincipalController.repintarTela();
    }

    public void UpdateCadastroProfessor() {
        AddCadastroProfessor();
        //localizando o professor
        int indice = consultaProfessorView.getTbPesquisa().getSelectedRow();
        ProfessorTableModel model = (ProfessorTableModel) consultaProfessorView.getTbPesquisa().getModel();
        professor = model.getListaprofessores().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (professor != null) {
            // mostrando a tela de cadastro do professor
            IdeiaListar();
            //atualizando os valores da tela
            this.cadastroProfessorView.getTfNome().setText(professor.getNome());
            this.cadastroProfessorView.getTfEmail().setText(professor.getEmail());
            this.cadastroProfessorView.getFtfTelefone().setText(professor.getTelefone());
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel obter os dados do professor selecionado");
        }
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    //Implementando metodo para abrir janela de consulta de professor
    public void ShowConsultaProfessor() {
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.consultaProfessorView);
        this.consultaProfessorView.setVisible(true);
        ProfessorListar();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    public void ShowListasIdeiasDisponiveis() {
        if (this.professor.getId() == null) {
            if (this.telaPrincipalController.Perguntar("Para adicionar uma ideia é necessário salvar o professor antes. Deseja salvar agora?")) {
                //pegando os valores de cada campo da tela de cadastro
                this.professor.setNome(cadastroProfessorView.getTfNome().getText());
                this.professor.setEmail(cadastroProfessorView.getTfEmail().getText());
                this.professor.setTelefone(cadastroProfessorView.getFtfTelefone().getText());
                //passando os valores para o DAO
                int chave = this.professorDAO.salvar(this.professor);
                if (chave != -1) {
                    this.professor.setId(chave);
                    IdeiaDisponiveisListar();
                    this.ideiaProfessorView.setVisible(true);
                }
            }
        } else {
            IdeiaDisponiveisListar();
            this.ideiaProfessorView.setVisible(true);
        }
    }

    //Metodo de controle de eventos
    private void AssinarListener() {
        this.cadastroProfessorView.getBtnSalvar().addActionListener(this);
        this.cadastroProfessorView.getBtnCancelar().addActionListener(this);
        this.cadastroProfessorView.getBtnAdiconarIdeia().addActionListener(this);
        this.cadastroProfessorView.getBtnRemoverIdeia().addActionListener(this);
        this.cadastroProfessorView.getTfNome().addFocusListener(this);
        this.cadastroProfessorView.getTfEmail().addFocusListener(this);
        this.cadastroProfessorView.getFtfTelefone().addFocusListener(this);

        this.consultaProfessorView.getBtnAlterar().addActionListener(this);
        this.consultaProfessorView.getBtnConsultar().addActionListener(this);
        this.consultaProfessorView.getBtnExcluir().addActionListener(this);
        this.consultaProfessorView.getBtnCancelar().addActionListener(this);

        this.ideiaProfessorView.getTbPesquisa().addMouseListener(this);

        this.cadastroProfessorView.getTbIdeia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.consultaProfessorView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ideiaProfessorView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ideiaProfessorView.getBtnCancelar().addActionListener(this);
        this.ideiaProfessorView.getBtnEscolher().addActionListener(this);
        this.cadastroProfessorView.getLbObrigatorioInfo().setVisible(false);
    }

    //Limpar tela de cadastro do professor
    public void ClearCadastroProfessor() {
        professor = new Professor();
        this.cadastroProfessorView.getTfNome().setText("");
        this.cadastroProfessorView.getTfEmail().setText("");
        this.cadastroProfessorView.getFtfTelefone().setText("");

        List<InteresseOrientar> listatemp = new ArrayList<InteresseOrientar>();
        InteresseOrientarTableModel modelo = new InteresseOrientarTableModel();
        modelo.setListaInteresses(listatemp);
        this.cadastroProfessorView.getTbIdeia().setModel(modelo);
    }

    //Limpar tela de consulta do professor
    public void ClearConsultaProfessor() {
        this.consultaProfessorView.getTfConsulta().setText("");
    }

    private void ProfessorSalvar() {
        //pegando os valores de cada campo da tela de cadastro
        this.professor.setNome(cadastroProfessorView.getTfNome().getText());
        this.professor.setEmail(cadastroProfessorView.getTfEmail().getText());
        this.professor.setTelefone(cadastroProfessorView.getFtfTelefone().getText());
        //passando os valores para o DAO
        int chave = this.professorDAO.salvar(this.professor);

        if (chave != -1) {
            //Limpando a tela de cadastro
            ClearCadastroProfessor();
            //chamando a tela de consulta do professor
            ShowConsultaProfessor();
        }
    }

    private void ProfessorExcluir() {
        //localizando o professor
        int indice = consultaProfessorView.getTbPesquisa().getSelectedRow();
        ProfessorTableModel model = (ProfessorTableModel) consultaProfessorView.getTbPesquisa().getModel();
        professor = model.getListaprofessores().get(indice);
        System.out.println(professor.getId());

        //verificando se o dao conseguir localizar a partir do id
        if (professor != null) {
            // mostrando a tela de cadastro do professor
            professorDAO.deletar(professor);
        }
        //chamando a tela de consulta do professor
        ShowConsultaProfessor();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void InteresseOrientarSalvar() {
        //localizando o professor
        int indice = ideiaProfessorView.getTbPesquisa().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) ideiaProfessorView.getTbPesquisa().getModel();
        Ideia ideia = model.getListaideia().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (ideia != null) {
            interesseOrientar.setIdeia(ideia);
            interesseOrientar.setProfessor(professor);

            // mostrando a tela de cadastro do professor
            interesseOrientarDAO.salvar(interesseOrientar);
        }
        this.ideiaProfessorView.setVisible(false);
        //chamando a tela de consulta do professor
        IdeiaListar();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void ExcluirIdeiaSelecionada() {
        //localizando o professor
        int indice = cadastroProfessorView.getTbIdeia().getSelectedRow();
        InteresseOrientarTableModel model = (InteresseOrientarTableModel) cadastroProfessorView.getTbIdeia().getModel();
        InteresseOrientar interesseOrientar = model.getListaInteresses().get(indice);
        //verificando se o dao conseguir localizar a partir do id
        if (interesseOrientar != null) {
            // mostrando a tela de cadastro do professor
            interesseOrientarDAO.deletar(interesseOrientar);
        }
        this.ideiaProfessorView.setVisible(false);
        //chamando a tela de consulta do professor
        IdeiaListar();
        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
    }

    private void ProfessorListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        ProfessorTableModel modelo = new ProfessorTableModel();
        modelo.setListaprofessores(this.professorDAO.listar());
        this.consultaProfessorView.getTbPesquisa().setModel(modelo);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        this.consultaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }

    private void IdeiaListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        InteresseOrientarTableModel modelo = new InteresseOrientarTableModel();
        modelo.setListaInteresses(this.interesseOrientarDAO.listarByIdProfessor(this.professor.getId()));
        this.cadastroProfessorView.getTbIdeia().setModel(modelo);

        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(0).setCellRenderer(cellRender);

        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(1).setPreferredWidth(500);
        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.cadastroProfessorView.getTbIdeia().getColumnModel().getColumn(1).setCellRenderer(cellRender);
    }

    private void IdeiaDisponiveisListar() {
        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        IdeiaTableModel modelo = new IdeiaTableModel();
        modelo.setListaideias(this.interesseOrientarDAO.ListarIdeiasNaoSelecionadas(professor.getId()));
        this.ideiaProfessorView.getTbPesquisa().setModel(modelo);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        this.ideiaProfessorView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }

    public Boolean verificaCampo() {
        Boolean emBranco = null;
        String nome, email, telefone;
        nome = cadastroProfessorView.getTfNome().getText();
        email = cadastroProfessorView.getTfEmail().getText();
        telefone = cadastroProfessorView.getFtfTelefone().getText().replaceAll(" [ ()-]", "");
        if (nome.equals(null) || nome.equals("") || email.equals(null) || email.equals("")
                || telefone.equals(null) || telefone.equals("")) {
            emBranco = true;
            cadastroProfessorView.getLbObrigatorioInfo().setVisible(true);
        } else {
            cadastroProfessorView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ProfessorCadastroSalvar")) {
            if (verificaCampo()) {
                cadastroProfessorView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                ProfessorSalvar();
            }
        }

        if (e.getActionCommand().equals("ProfessorCancelar")) {
            this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
            this.telaPrincipalController.repintarTela();
        }

        if (e.getActionCommand().equals("ProfessorExcluir")) {
            ProfessorExcluir();
        }

        if (e.getActionCommand().equals("ProfessorCadastroAddIdeia")) {
            ideiaProfessorView.getTaDescricaoIdeia().setText(null);
            if (verificaCampo()) {
                cadastroProfessorView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em branco" + verificaCampo());
            } else {
                ShowListasIdeiasDisponiveis();
            }
        }

        if (e.getActionCommand().equals("ProfessorCadastroDelIdeia")) {
            if (cadastroProfessorView.getTbIdeia().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem ideia selecionada, tente novamente!");
            } else {
                ExcluirIdeiaSelecionada();
            }
        }

        if (e.getActionCommand().equals("ProfessorConsultaAlterar")) {
            UpdateCadastroProfessor();
        }

        if (e.getActionCommand().equals("EscolherIdeia")) {
            InteresseOrientarSalvar();
        }

        if (e.getActionCommand().equals("CancelarIdeia")) {
            this.ideiaProfessorView.setVisible(false);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int indice = ideiaProfessorView.getTbPesquisa().getSelectedRow();
            IdeiaTableModel model = (IdeiaTableModel) ideiaProfessorView.getTbPesquisa().getModel();
            Ideia ideia = model.getListaideia().get(indice);
            this.ideiaProfessorView.getTaDescricaoIdeia().setText(ideia.getDescricao());
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
