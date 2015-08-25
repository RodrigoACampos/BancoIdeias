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

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            resultado = true;

        } catch (Exception ex) {
            ex.printStackTrace();
            resultado = false;
        }

        return resultado;
    }

}
