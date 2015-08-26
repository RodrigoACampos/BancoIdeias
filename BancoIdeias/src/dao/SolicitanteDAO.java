/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Solicitante;
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
public class SolicitanteDAO {

    public boolean salvar(Solicitante solicitante) {
        boolean resultado = false;
        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "inster into solicitante (nome,email,telefone)"
                    + " values (?,?,?)";
            String QUERY_UPDATE = "update into solicitante nome = ?, email = ?, "
                    + "telefone = ? where idsolicitante = ?";

            if (solicitante.getId() == null) {
                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getEmail());
                stmt.setString(3, solicitante.getTelefone());
            } else {
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, solicitante.getNome());
                stmt.setString(2, solicitante.getEmail());
                stmt.setString(3, solicitante.getTelefone());
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

            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
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
        } finally {
            return lista;
        }
    }
}
