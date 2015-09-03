package dao;

import conexao.ConnectionManager;
import entidade.Ideia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class IdeiaDAO {

    public int salvar(Ideia ideia) {

        //inicializando o retorno da função, caso tenha algum problema deve ser retornar o valor -1
        int resultado = -1;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into ideia (tema, descricao, dt_cadastro, idsolicitante) values(?,?,?,?)";
            String QUERY_UPDATE = "update ideia set tema = ?, descricao = ?, dt_cadastro = ?, idsolicitante = ? where idideia = ?";

            if (ideia.getId() == null) {

                stmt = conn.prepareStatement(QUERY_INSERT, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ideia.getTema());
                stmt.setString(2, ideia.getDescricao());
                stmt.setDate(3, new java.sql.Date(ideia.getDtcadastro().getTime()));
                stmt.setInt(4, ideia.getSolicitante().getId());

                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    resultado = rs.getInt(1);
                }

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setString(1, ideia.getTema());
                stmt.setString(2, ideia.getDescricao());
                stmt.setDate(3, new java.sql.Date(ideia.getDtcadastro().getTime()));
                stmt.setInt(4, ideia.getSolicitante().getId());
                stmt.setInt(5, ideia.getId());

                stmt.executeUpdate();

            }

            conn.close();

            JOptionPane.showMessageDialog(null, "Os dados da ideia foram salvo com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = -1;
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o dados da ideia!");
            
        }

        return resultado;
    }

    public boolean deletar(Ideia ideia) {

        boolean resultado = false;

        try {
            
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from ideia where idideia = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, ideia.getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;
            JOptionPane.showMessageDialog(null, "Ideia excluída com sucesso!");

        } catch (Exception ex) {
            
            ex.printStackTrace();
            resultado = false;
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a ideia selecionada!");

        }

        return resultado;
    }

    public Ideia GetById(int id) {

        Ideia ideia = new Ideia();

        try {
            String QUERY_DETALHE = "select * from ideia where idideia = ?";

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ideia.setId(rs.getInt("idideia"));
                ideia.setTema(rs.getString("tema"));
                ideia.setDescricao(rs.getString("descricao"));
                ideia.setDtcadastro(rs.getDate("dt_cadastro"));
                SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
                ideia.setSolicitante(solicitanteDAO.GetById(rs.getInt("idsolicitante")));
            }

            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            ideia = null;
            JOptionPane.showMessageDialog(null, "Não foi localizar os dados da ideia selecionada!");
            
        }

        return ideia;

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
                ideia.setId(rs.getInt("idideia"));
                ideia.setTema(rs.getString("tema"));
                ideia.setDescricao(rs.getString("descricao"));
                ideia.setDtcadastro(rs.getDate("dt_cadastro"));
                SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
                ideia.setSolicitante(solicitanteDAO.GetById(rs.getInt("idsolicitante")));
                lista.add(ideia);
            }

            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi localizar as ideias cadastradas!");
            
        } finally {
            
            return lista;
            
        }
    }
}
