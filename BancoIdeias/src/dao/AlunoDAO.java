
package dao;

import conexao.ConnectionManager;
import entidade.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlunoDAO {
    
    public static Aluno inserirCandidato(Aluno aluno) throws SQLException, ClassNotFoundException {
        Aluno retornoAluno = aluno;
        try {
            Connection conn = ConnectionManager.getConnection();

            if (aluno.getId()== null) {
                PreparedStatement pState = conn.prepareStatement(
                        "insert into aluno (nome,telefone,email) values (?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                
                pState.setString(1, aluno.getNome());
                pState.setString(2, aluno.getTelefone());
                pState.setString(3, aluno.getEmail());

                pState.executeUpdate();
                ResultSet rs = pState.getGeneratedKeys();
                
                if (rs.next()) {
                    aluno.setId(rs.getInt(1));
                }
                retornoAluno = aluno;
            } else {

                PreparedStatement pState = conn.prepareStatement(
                        "update aluno set nome = ?, telefone = ?,  email = ? where idaluno = ?");
                pState.setString(1, aluno.getNome());
                pState.setString(2, aluno.getTelefone());
                pState.setString(3, aluno.getEmail());
                pState.setInt(4, aluno.getId());
                pState.executeUpdate();
                retornoAluno = aluno;
            }

            conn.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao Cadastrar Novo Aluno: " + se);
        }
        return aluno;
    }
    
}
