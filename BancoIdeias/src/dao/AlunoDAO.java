/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Aluno;
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
public class AlunoDAO {

    public boolean salvar(Aluno aluno) {
        
        boolean resultado = false;
        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into aluno (nome, email, telefone) values (?, ?, ?)";
            String QUERY_UPDATE = "update aluno set nome = ?, email = ?, telefone = ? where idaluno = ? ";

            if (aluno.getId() == null) {
                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getEmail());
                stmt.setString(3, aluno.getTelefone());
            } else {
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getEmail());
                stmt.setString(3, aluno.getTelefone());
                stmt.setInt(4, aluno.getId());
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

    public boolean deletar(Aluno aluno) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from aluno where idaluno = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, aluno.getId());

            stmt.executeUpdate();
            conn.close();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

    public Aluno GetById(int id) {

        Aluno aluno = new Aluno();
        
        try {

            String QUERY_DETALHE = "select * from aluno where idaluno = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            aluno = null;
        }
        
        return aluno;
    }

    public List<Aluno> listar() {
        List<Aluno> lista = new ArrayList<Aluno>();
        try {
            String QUERY_DETALHE = "select * from aluno";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setTelefone(rs.getString("telefone"));
                lista.add(aluno);
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }
}
