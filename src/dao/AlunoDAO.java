package dao;

import conexao.ConnectionManager;
import entidade.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO {

    public int salvar(Aluno aluno) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into aluno (nome, email, telefone) values (?, ?, ?)";
            String QUERY_UPDATE = "update aluno set nome = ?, email = ?, telefone = ? where idaluno = ? ";

            if (aluno.getId() == null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getEmail());
                stmt.setString(3, aluno.getTelefone());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }
                
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getEmail());
                stmt.setString(3, aluno.getTelefone());
                stmt.setInt(4, aluno.getId());

                stmt.executeUpdate();
                
            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Os dados do aluno foram salvo com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o dados do aluno!");
            
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

            resultado = true;
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");

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
            JOptionPane.showMessageDialog(null, "Não foi localizar os dados do aluno selecionado!");
            
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
            JOptionPane.showMessageDialog(null, "Não foi localizar os alunos cadastrados!");
            
        } finally {
            
            return lista;
            
        }
    }
}
