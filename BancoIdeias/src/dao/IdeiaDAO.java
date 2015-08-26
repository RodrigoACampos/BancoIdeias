/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Ideia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Programação
 */
public class IdeiaDAO {

    public boolean salvar(Ideia ideia) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into ideia (tema, descricao, dt_cadastro) values(?,?,?)";
            String QUERY_UPDATE = "update ideia set tema = ?, descricao = ?, dt_cadastro = ? where id = ?";

            if (ideia.getId() == null) {

                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setString(1, ideia.getTema());
                stmt.setString(2, ideia.getDescricao());
                stmt.setDate(3, ideia.getDtcadastro());

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, ideia.getTema());
                stmt.setString(2, ideia.getDescricao());
                stmt.setDate(3, ideia.getDtcadastro());
                //stmt.setInt(4, usuario.getIdUsuario());

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

    public boolean deletar(Ideia ideia) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from ideia where idIdeia = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, ideia.getId());

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

    public List<Ideia> listar() {

        List<Ideia> lista = new ArrayList<Ideia>();

        try {
            String QUERY_DETALHE = "select * from ideia";

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Ideia ideia = new Ideia();
                ideia.setId(rs.getInt("idIdeia"));
                ideia.setTema(rs.getString("tema"));
                ideia.setDescricao(rs.getString("descricao"));
                ideia.setDtcadastro(rs.getDate("dt_cadastro"));
                lista.add(ideia);
            }
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return lista;
        }

    }

}
