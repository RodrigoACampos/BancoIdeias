/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Aluno;
import entidade.Ideia;
import entidade.InteresseDesenvolver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno_balan
 */
public class InteresseDesenvolverDAO {

    public boolean salvar(InteresseDesenvolver interesseDesenvolver) {

        boolean resultado = false;
        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into interesse_desenvolver (idideia, idaluno) values (?, ?)";
            String QUERY_UPDATE = "update aluno set idideia = ?, idaluno = ? where idideia = ? and idaluno = ?";

            if (GetById(interesseDesenvolver) == null) {
                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(2, interesseDesenvolver.getAluno().getId());
            } else {
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(2, interesseDesenvolver.getAluno().getId());
                stmt.setInt(3, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(4, interesseDesenvolver.getAluno().getId());
            }

            stmt.executeUpdate();
            conn.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

            resultado = true;

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public boolean deletar(InteresseDesenvolver interesseDesenvolver) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from interesse_desenvolver where idaluno = ? and idideia = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, interesseDesenvolver.getAluno().getId());
            stmt.setInt(2, interesseDesenvolver.getIdeia().getId());

            stmt.executeUpdate();
            conn.close();

            //JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public InteresseDesenvolver GetById(InteresseDesenvolver pInteresseDesenvolver) {

        InteresseDesenvolver interesseDesenvolver = null;

        try {
            String QUERY_DETALHE = "select * from interesse_desenvolver where idideia = ? and idaluno = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
            stmt.setInt(2, interesseDesenvolver.getAluno().getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                interesseDesenvolver = new InteresseDesenvolver();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseDesenvolver.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                AlunoDAO alunoDAO = new AlunoDAO();
                interesseDesenvolver.setAluno(alunoDAO.GetById(rs.getInt("IDALUNO")));
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            interesseDesenvolver = null;
        }

        return interesseDesenvolver;
    }

    public List<InteresseDesenvolver> listarByIdeia(int id) {

        List<InteresseDesenvolver> lista = new ArrayList<InteresseDesenvolver>();
        try {
            String QUERY_DETALHE = "select * from INTERESSE_DESENVOLVER where IDALUNO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                InteresseDesenvolver interesseDesenvolver = new InteresseDesenvolver();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseDesenvolver.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                AlunoDAO alunoDAO = new AlunoDAO();
                interesseDesenvolver.setAluno(alunoDAO.GetById(rs.getInt("IDALUNO")));
                lista.add(interesseDesenvolver);
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }
}
