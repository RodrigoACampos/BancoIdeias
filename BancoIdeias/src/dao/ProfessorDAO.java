package dao;

import conexao.ConnectionManager;
import entidade.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO {

    public boolean salvar(Professor professor) {
        
        boolean resultado = false;
        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into professor (nome, email, telefone) values (?, ?, ?)";
            String QUERY_UPDATE = "update professor set nome = ?, email = ?, telefone = ? where idprofessor = ? ";

            if (professor.getId() == null) {
                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getEmail());
                stmt.setString(3, professor.getTelefone());
            } else {
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getEmail());
                stmt.setString(3, professor.getTelefone());
                stmt.setInt(4, professor.getId());
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

    public boolean deletar(Professor professor) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from professor where idprofessor = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, professor.getId());

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

    public Professor GetById(int id) {

        Professor professor = new Professor();
        
        try {

            String QUERY_DETALHE = "select * from professor where idprofessor = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                professor = new Professor();
                professor.setId(rs.getInt("idProfessor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            professor = null;
        }
        
        return professor;
    }

    public List<Professor> listar() {
        List<Professor> lista = new ArrayList<Professor>();
        try {
            String QUERY_DETALHE = "select * from professor";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt("idProfessor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                lista.add(professor);
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }
    }
}