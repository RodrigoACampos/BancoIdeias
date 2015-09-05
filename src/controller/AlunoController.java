package controller;

import dao.InteresseDesenvolverDAO;
import dao.AlunoDAO;
import entidade.Ideia;
import entidade.InteresseDesenvolver;
import entidade.Aluno;
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
import model.InteresseDesenvolverTableModel;
import model.AlunoTableModel;
import view.CadastroAlunoView;
import view.ConsultaAlunoView;
import view.IdeiaAlunoView;

/**
 *
 * @author Willyam
 */
public class AlunoController implements ActionListener, FocusListener, MouseListener {

    //Declarando os objetos 
    private Aluno aluno = new Aluno();
    private AlunoDAO alunoDAO = new AlunoDAO();

    private InteresseDesenvolver interesseDesenvolver = new InteresseDesenvolver();
    private InteresseDesenvolverDAO interesseDesenvolverDAO = new InteresseDesenvolverDAO();

    //Declarando objeto de controle da tela principal
    private TelaPrincipalController telaPrincipalController;

    //Criando objetos das janelas
    private CadastroAlunoView cadastroAlunoView;
    private ConsultaAlunoView consultaAlunoView;
    private IdeiaAlunoView ideiaAlunoView;

    //Construtor do controller, ele instancia os objetos para acesso a qualquer momento
    public AlunoController(TelaPrincipalController telaPrincipalController) {

        this.telaPrincipalController = telaPrincipalController;

        this.cadastroAlunoView = new CadastroAlunoView();
        this.consultaAlunoView = new ConsultaAlunoView();
        this.ideiaAlunoView = new IdeiaAlunoView(null, true);

        AssinarListener();
        ClearCadastroAluno();
        ClearConsultaAluno();

    }

    //retorna o objeto da tela de cadastrado do aluno
    public CadastroAlunoView getCadastroAlunoView() {

        return this.cadastroAlunoView;

    }

    //retorna o objeto da tela de consulta do aluno
    public ConsultaAlunoView GetConsultaAlunoView() {

        return this.consultaAlunoView;

    }

    //Implementando metodo para abrir janela de cadastro de aluno
    public void AddCadastroAluno() {

        ClearCadastroAluno();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.cadastroAlunoView);
        this.cadastroAlunoView.setVisible(true);
        this.telaPrincipalController.repintarTela();

    }

    public void UpdateCadastroAluno() {

        AddCadastroAluno();
        //localizando o aluno
        int indice = consultaAlunoView.getTbPesquisa().getSelectedRow();
        AlunoTableModel model = (AlunoTableModel) consultaAlunoView.getTbPesquisa().getModel();
        aluno = model.getListaAlunos().get(indice);

        //verificando se o dao conseguir localizar a partir do id
        if (aluno != null) {

            // mostrando a tela de cadastro do aluno
            IdeiaListar();

            //atualizando os valores da tela
            this.cadastroAlunoView.getTfNome().setText(aluno.getNome());
            this.cadastroAlunoView.getTfEmail().setText(aluno.getEmail());
            this.cadastroAlunoView.getFtfTelefone().setText(aluno.getTelefone());

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel obter os dados do aluno selecionado");
        }

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();

    }

    //Implementando metodo para abrir janela de consulta de aluno
    public void ShowConsultaAluno() {

        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
        this.telaPrincipalController.GetTelaPrincipal().getJpfundo().add(this.consultaAlunoView);
        this.consultaAlunoView.setVisible(true);

        AlunoListar();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();

    }

    public void ShowListasIdeiasDisponiveis() {

        if (this.aluno.getId() == null) {

            if (this.telaPrincipalController.Perguntar("Para adicionar uma ideia é necessário salvar o aluno antes. Deseja salvar agora?")) {

                //pegando os valores de cada campo da tela de cadastro
                this.aluno.setNome(cadastroAlunoView.getTfNome().getText());
                this.aluno.setEmail(cadastroAlunoView.getTfEmail().getText());
                this.aluno.setTelefone(cadastroAlunoView.getFtfTelefone().getText());

                //passando os valores para o DAO
                int chave = this.alunoDAO.salvar(this.aluno);
                if (chave != -1) {

                    this.aluno.setId(chave);
                    IdeiaDisponiveisListar();
                    this.ideiaAlunoView.setVisible(true);
                }
                
            }

        } else {

            IdeiaDisponiveisListar();
            this.ideiaAlunoView.setVisible(true);

        }

    }

    //Metodo de controle de eventos
    private void AssinarListener() {

        this.cadastroAlunoView.getBtnSalvar().addActionListener(this);
        this.cadastroAlunoView.getBtnCancelar().addActionListener(this);
        this.cadastroAlunoView.getBtnAdiconarIdeia().addActionListener(this);
        this.cadastroAlunoView.getBtnRemoverIdeia().addActionListener(this);
        this.cadastroAlunoView.getTfNome().addFocusListener(this);
        this.cadastroAlunoView.getTfEmail().addFocusListener(this);
        this.cadastroAlunoView.getFtfTelefone().addFocusListener(this);

        this.consultaAlunoView.getBtnAlterar().addActionListener(this);
        this.consultaAlunoView.getBtnConsultar().addActionListener(this);
        this.consultaAlunoView.getBtnExcluir().addActionListener(this);
        this.consultaAlunoView.getBtnCancelar().addActionListener(this);

        this.cadastroAlunoView.getTbIdeia().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.consultaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ideiaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ideiaAlunoView.getBtnCancelar().addActionListener(this);
        this.ideiaAlunoView.getBtnEscolher().addActionListener(this);

    }

    //Limpar tela de cadastro do aluno
    public void ClearCadastroAluno() {

        aluno = new Aluno();
        this.cadastroAlunoView.getTfNome().setText("");
        this.cadastroAlunoView.getTfEmail().setText("");
        this.cadastroAlunoView.getFtfTelefone().setText("");
        
        
        List<InteresseDesenvolver> listatemp = new ArrayList<InteresseDesenvolver>();
        InteresseDesenvolverTableModel modelo = new InteresseDesenvolverTableModel();
        modelo.setListaInteresses(listatemp);
        this.cadastroAlunoView.getTbIdeia().setModel(modelo);
    
    }

    //Limpar tela de consulta do aluno
    public void ClearConsultaAluno() {

        this.consultaAlunoView.getTfConsulta().setText("");

    }

    private void AlunoSalvar() {

        //pegando os valores de cada campo da tela de cadastro
        this.aluno.setNome(cadastroAlunoView.getTfNome().getText());
        this.aluno.setEmail(cadastroAlunoView.getTfEmail().getText());
        this.aluno.setTelefone(cadastroAlunoView.getFtfTelefone().getText());

        //passando os valores para o DAO
        int chave = this.alunoDAO.salvar(this.aluno);

        if (chave != -1) {
            //Limpando a tela de cadastro
            ClearCadastroAluno();
            //chamando a tela de consulta do aluno
            ShowConsultaAluno();
        }

    }

    private void AlunoExcluir() {
        
        //localizando o aluno
        int indice = consultaAlunoView.getTbPesquisa().getSelectedRow();
        AlunoTableModel model = (AlunoTableModel) consultaAlunoView.getTbPesquisa().getModel();
        aluno = model.getListaAlunos().get(indice);
        System.out.println(aluno.getId());

        //verificando se o dao conseguir localizar a partir do id
        if (aluno != null) {

            // mostrando a tela de cadastro do aluno
            alunoDAO.deletar(aluno);

        }

        //chamando a tela de consulta do aluno
        ShowConsultaAluno();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();
        
    }

    private void InteresseDesenvolverSalvar() {

        //localizando o aluno
        int indice = ideiaAlunoView.getTbPesquisa().getSelectedRow();
        IdeiaTableModel model = (IdeiaTableModel) ideiaAlunoView.getTbPesquisa().getModel();
        Ideia ideia = model.getListaideia().get(indice);

        //verificando se o dao conseguir localizar a partir do id
        if (ideia != null) {
            interesseDesenvolver.setIdeia(ideia);
            interesseDesenvolver.setAluno(aluno);

            // mostrando a tela de cadastro do aluno
            interesseDesenvolverDAO.salvar(interesseDesenvolver);

        }

        this.ideiaAlunoView.setVisible(false);
        //chamando a tela de consulta do aluno
        IdeiaListar();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();

    }

    private void ExcluirIdeiaSelecionada() {

        //localizando o aluno
        int indice = cadastroAlunoView.getTbIdeia().getSelectedRow();
        InteresseDesenvolverTableModel model = (InteresseDesenvolverTableModel) cadastroAlunoView.getTbIdeia().getModel();
        InteresseDesenvolver interesseDesenvolver = model.getListaInteresses().get(indice);

        //verificando se o dao conseguir localizar a partir do id
        if (interesseDesenvolver != null) {

            // mostrando a tela de cadastro do aluno
            interesseDesenvolverDAO.deletar(interesseDesenvolver);

        }

        this.ideiaAlunoView.setVisible(false);
        //chamando a tela de consulta do aluno
        IdeiaListar();

        //Atualizando a tela principal
        telaPrincipalController.repintarTela();

    }

    private void AlunoListar() {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        AlunoTableModel modelo = new AlunoTableModel();
        modelo.setListaAlunos(this.alunoDAO.listar());
        this.consultaAlunoView.getTbPesquisa().setModel(modelo);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        this.consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);

    }

    private void IdeiaListar() {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        InteresseDesenvolverTableModel modelo = new InteresseDesenvolverTableModel();
        modelo.setListaInteresses(this.interesseDesenvolverDAO.listarByIdAluno(this.aluno.getId()));
        this.cadastroAlunoView.getTbIdeia().setModel(modelo);

        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(0).setCellRenderer(cellRender);

        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(1).setPreferredWidth(500);
        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.cadastroAlunoView.getTbIdeia().getColumnModel().getColumn(1).setCellRenderer(cellRender);

    }

    private void IdeiaDisponiveisListar() {

        DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        IdeiaTableModel modelo = new IdeiaTableModel();
        modelo.setListaideias(this.interesseDesenvolverDAO.ListarIdeiasNaoSelecionadas(aluno.getId()));
        this.ideiaAlunoView.getTbPesquisa().setModel(modelo);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        this.ideiaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("AlunoCadastroSalvar")) {
            AlunoSalvar();
        }

        if (e.getActionCommand().equals("AlunoCancelar")) {
            this.telaPrincipalController.GetTelaPrincipal().getJpfundo().removeAll();
            this.telaPrincipalController.repintarTela();
        }

        if (e.getActionCommand().equals("AlunoExcluir")) {
            AlunoExcluir();
        }

        if (e.getActionCommand().equals("AlunoCadastroAddIdeia")) {
            ShowListasIdeiasDisponiveis();
        }

        if (e.getActionCommand().equals("AlunoCadastroDelIdeia")) {
            ExcluirIdeiaSelecionada();
        }

        if (e.getActionCommand().equals("AlunoConsultaAlterar")) {
            UpdateCadastroAluno();
        }

        if (e.getActionCommand().equals("EscolherIdeia")) {
            InteresseDesenvolverSalvar();
        }

        if (e.getActionCommand().equals("CancelarIdeia")) {
            this.ideiaAlunoView.setVisible(false);
            //chamando a tela de consulta do aluno
            IdeiaListar();

            //Atualizando a tela principal
            telaPrincipalController.repintarTela();
        }

    }

    @Override
    public void focusGained(FocusEvent e) {
//        verificaCampo();
    }

    @Override
    public void focusLost(FocusEvent e) {
//        verificaCampo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getClickCount() == 1) {
            int indice = ideiaAlunoView.getTbPesquisa().getSelectedRow();
            IdeiaTableModel model = (IdeiaTableModel) ideiaAlunoView.getTbPesquisa().getModel();
            Ideia ideia = model.getListaideia().get(indice);
            this.ideiaAlunoView.getTaDescricaoIdeia().setText(ideia.getDescricao());
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
