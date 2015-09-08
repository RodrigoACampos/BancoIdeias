package dao;

import conexao.ConnectionManager;
import entidade.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO {

    public int salvar(Professor professor) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into PROFESSOR (nome, email, telefone) values (?, ?, ?)";
            String QUERY_UPDATE = "update PROFESSOR set nome = ?, email = ?, telefone = ? where idprofessor = ? ";

            if (professor.getId() == null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getEmail());
                stmt.setString(3, professor.getTelefone());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, professor.getNome());
                stmt.setString(2, professor.getEmail());
                stmt.setString(3, professor.getTelefone());
                stmt.setInt(4, professor.getId());

                stmt.executeUpdate();
                resultado = professor.getId();

            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Os dados do professor foram salvo com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o dados do professor!");

        }

        return resultado;
    }

    public boolean deletar(Professor professor) {

        boolean resultado = false;

        try {

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from PROFESSOR where idprofessor = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, professor.getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;
            JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o professor selecionado!");

        }

        return resultado;
    }

    public Professor GetById(int id) {

        Professor professor = new Professor();

        try {

            String QUERY_DETALHE = "select * from PROFESSOR where idprofessor = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                professor = new Professor();
                professor.setId(rs.getInt("idprofessor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            professor = null;
            JOptionPane.showMessageDialog(null, "Não foi localizar os dados do professor selecionado!");

        }

        return professor;
    }

    public List<Professor> listar() {
        
        List<Professor> lista = new ArrayList<Professor>();
        
        try {
            
            String QUERY_DETALHE = "select * from PROFESSOR";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Professor professor = new Professor();
                professor.setId(rs.getInt("idprofessor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setTelefone(rs.getString("telefone"));
                lista.add(professor);
            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi localizar os professores cadastrados!");
            
        } finally {
            
            return lista;
            
        }
    }
}
