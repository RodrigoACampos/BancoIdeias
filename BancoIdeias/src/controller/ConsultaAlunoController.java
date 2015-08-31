/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlunoDAO;
import entidade.Aluno;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import model.AlunoTableModel;
import view.AlterarAlunoView;
import view.ConsultaAlunoView;

/**
 *
 * @author Gustavo
 */
public class ConsultaAlunoController implements ActionListener {

    Aluno aluno = new Aluno();
    ConsultaAlunoView consultaAlunoView;
    AlunoDAO alunoDao = new AlunoDAO();
    List<Aluno> alunoLista = new ArrayList();
    AlterarAlunoView alterarAlunoView;

    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    DefaultTableCellRenderer cellRenderTitle = new DefaultTableCellRenderer();

    public ConsultaAlunoController(ConsultaAlunoView consultaAlunoView, AlterarAlunoView alterarAluno) {
        this.consultaAlunoView = consultaAlunoView;
        this.alterarAlunoView = alterarAluno;
    }

    public void iniciar() {
        montarEAssinar();
    }

    public void montarEAssinar() {
        consultaAlunoView.getBtnAlterar().addActionListener(this);
        consultaAlunoView.getBtnConsultar().addActionListener(this);
        consultaAlunoView.getBtnExcluir().addActionListener(this);

        alterarAlunoView.getBtnSalvar().addActionListener(this);
        alterarAlunoView.getBtnCancelar().addActionListener(this);
        consultaAlunoView.getTbPesquisa().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        atualizarTabelaAluno();
    }

    public void selecionarDaTabelaAlunos() {
        int indice = consultaAlunoView.getTbPesquisa().getSelectedRow();
        AlunoTableModel model = (AlunoTableModel) consultaAlunoView.getTbPesquisa().getModel();
        aluno = model.getListaAlunos().get(indice);
        System.out.println(aluno.getId());
    }
   
    public void atualizarTabelaAluno() {
        cellRender.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderTitle.setFont(cellRenderTitle.getFont().deriveFont(Font.BOLD)); // Não Funciona, Deveria deixar os Nomes das Colunas em Negrito;

        AlunoTableModel modelo = new AlunoTableModel();
        modelo.setListaAlunos(alunoDao.listar());
        consultaAlunoView.getTbPesquisa().setModel(modelo);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setPreferredWidth(10);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setPreferredWidth(300);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setPreferredWidth(200);

        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(0).setCellRenderer(cellRender);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(1).setCellRenderer(cellRender);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setHeaderRenderer(cellRenderTitle);
        consultaAlunoView.getTbPesquisa().getColumnModel().getColumn(2).setCellRenderer(cellRender);
    }
    
     private void atualizarAlunoParaView() {
        alterarAlunoView.getTfNome().setText(aluno.getNome());
        alterarAlunoView.getTfEmail().setText(aluno.getEmail());
        alterarAlunoView.getFtfTelefone().setText(aluno.getTelefone());
    }
    
    public void atualizarViewParaAluno() {
        aluno.setNome(alterarAlunoView.getTfNome().getText());
        aluno.setEmail(alterarAlunoView.getTfEmail().getText());
        aluno.setTelefone(alterarAlunoView.getFtfTelefone().getText());        
    }   
    
    public Boolean verificaCampo() {
        Boolean emBranco = null;
        String nome, email, telefone;
        nome = alterarAlunoView.getTfNome().getText();
        email = alterarAlunoView.getTfEmail().getText();
        telefone = alterarAlunoView.getFtfTelefone().getText().replaceAll("[ ()-]", "");

        if (nome.equals(null) || nome.equals("") || email.equals(null)
                || email.equals("") || telefone.equals(null) || telefone.equals("")) {
            emBranco = true;
            alterarAlunoView.getLbObrigatorioInfo().setVisible(true);
        } else {
            alterarAlunoView.getLbObrigatorioInfo().setVisible(false);
            emBranco = false;
        }
        return emBranco;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("consultar")) {
            System.out.println(e.getActionCommand());
        }

        if (e.getActionCommand().equals("Alterar")) {
            if (consultaAlunoView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem aluno selecionado, tente novamente...");
            } else {
                selecionarDaTabelaAlunos();
                atualizarAlunoParaView();
                alterarAlunoView.setVisible(true);
            }
        }

        if (e.getActionCommand().equals("Excluir")) {
            if (consultaAlunoView.getTbPesquisa().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Sem Aluno selecionado, tente novamente...");
            } else {
                selecionarDaTabelaAlunos();
                if (alunoDao.deletar(aluno)) {
                    atualizarTabelaAluno();
                    consultaAlunoView.getTelaPrincipalController().atualizarValores();
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
                }
            }
        }
        if (e.getActionCommand().equals("Salvar")) {
            System.out.println(e.getActionCommand());
              if (verificaCampo()) {
                alterarAlunoView.getLbObrigatorioInfo().setVisible(true);
                System.out.println("Em Btanco? " + verificaCampo());
            } else {
                atualizarViewParaAluno();
                if (alunoDao.salvar(aluno) == true) {
                    System.out.println("Salvo");
                    atualizarTabelaAluno();
                    alterarAlunoView.setVisible(false);                    
                } else {
                    System.out.println(" NAO SALVO! ");
                }
            }
        }
        
        if (e.getActionCommand().equals("cancelar")) {
            System.out.println(e.getActionCommand());   
            alterarAlunoView.setVisible(false);
        }
    }
}
