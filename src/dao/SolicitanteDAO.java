package dao;

import conexao.ConnectionManager;
import entidade.Solicitante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SolicitanteDAO {

    public int salvar(Solicitante solicitante) {
        
        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into solicitante (nome, email, telefone) values (?, ?, ?)";
            String QUERY_UPDATE = "update solicitante set nome = ?, email = ?, telefone = ? where idsolicitante = ? ";

            if (solicitante.getId() == null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getEmail());
                stmt.setString(3, solicitante.getTelefone());
                
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getEmail());
                stmt.setString(3, solicitante.getTelefone());
                stmt.setInt(4, solicitante.getId());

                stmt.executeUpdate();
                resultado = solicitante.getId();
                
            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Os dados do solicitante foram salvo com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o dados do solicitante!");

        }

        return resultado;
    }

    public boolean deletar(Solicitante solicitante) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from solicitante where idsolicitante = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, solicitante.getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;
            JOptionPane.showMessageDialog(null, "Solicitante excluído com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o solicitante selecionado!");

        }

        return resultado;
    }

    public Solicitante GetById(int id) {

        Solicitante solicitante = new Solicitante();
        
        try {

            String QUERY_DETALHE = "select * from solicitante where idsolicitante = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                solicitante = new Solicitante();
                solicitante.setId(rs.getInt("idSolicitante"));
                solicitante.setNome(rs.getString("nome"));
                solicitante.setEmail(rs.getString("email"));
                solicitante.setTelefone(rs.getString("telefone"));
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            solicitante = null;
            JOptionPane.showMessageDialog(null, "Não foi localizar os dados do solicitante selecionado!");
            
        }
        
        return solicitante;
    }

    public List<Solicitante> listar() {
        
        List<Solicitante> lista = new ArrayList<Solicitante>();
        
        try {
            
            String QUERY_DETALHE = "select * from solicitante";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Solicitante solicitante = new Solicitante();
                solicitante.setId(rs.getInt("idSolicitante"));
                solicitante.setNome(rs.getString("nome"));
                solicitante.setEmail(rs.getString("email"));
                solicitante.setTelefone(rs.getString("telefone"));
                lista.add(solicitante);
            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi localizar os solicitantes cadastrados!");
            
        } finally {
            
            return lista;
            
        }
    }
}
