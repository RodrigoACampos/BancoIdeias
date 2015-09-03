/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Ideia;
import entidade.InteresseDesenvolver;
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
public class InteresseDesenvolverDAO {

    public boolean salvar(InteresseDesenvolver interesseDesenvolver) {

        boolean resultado = false;

        try {

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into INTERESSE_DESENVOLVER (IDIDEIA, IDALUNO) values (?, ?)";
            String QUERY_UPDATE = "update INTERESSE_DESENVOLVER set IDIDEIA = ?, IDALUNO = ? where IDIDEIA = ? and IDALUNO = ? ";

            if (GetById(interesseDesenvolver) == null) {

                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(2, interesseDesenvolver.getAluno().getId());

            } else {

                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(2, interesseDesenvolver.getAluno().getId());
                stmt.setInt(3, interesseDesenvolver.getIdeia().getId());
                stmt.setInt(4, interesseDesenvolver.getAluno().getId());

            }

            stmt.executeUpdate();
            conn.close();

            JOptionPane.showMessageDialog(null, "Os dados selecionados foram salvo com sucesso!");

            resultado = true;

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o dados do informado!");

        }

        return resultado;
    }

    public boolean deletar(InteresseDesenvolver interesseDesenvolver) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from INTERESSE_DESENVOLVER where IDIDEIA = ? and IDALUNO = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, interesseDesenvolver.getIdeia().getId());
            stmt.setInt(2, interesseDesenvolver.getAluno().getId());

            stmt.executeUpdate();
            conn.close();

            resultado = true;
            JOptionPane.showMessageDialog(null, "Dados excluído com sucesso!");

        } catch (Exception ex) {

            ex.printStackTrace();
            resultado = false;
            JOptionPane.showMessageDialog(null, "Não foi possível excluir os dados selecionados!");

        }

        return resultado;
    }

    public InteresseDesenvolver GetById(InteresseDesenvolver pInteresseDesenvolver) {

        InteresseDesenvolver interesseDesenvolver = null;
        try {

            String QUERY_DETALHE = "select * from INTERESSE_DESENVOLVER where IDIDEIA = ? and IDALUNO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;
            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, pInteresseDesenvolver.getIdeia().getId());
            stmt.setInt(2, pInteresseDesenvolver.getAluno().getId());

            rs = stmt.executeQuery();

            while (rs.next()) {

                interesseDesenvolver = new InteresseDesenvolver();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseDesenvolver.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                AlunoDAO alunoDAO = new AlunoDAO();
                interesseDesenvolver.setAluno(alunoDAO.GetById(rs.getInt("IDALUNO")));

            }

            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os dados dos selecionados!");

        }

        return interesseDesenvolver;
    }

    public List<InteresseDesenvolver> listarByIdAluno(int id) {

        List<InteresseDesenvolver> lista = new ArrayList<InteresseDesenvolver>();
        try {

            String QUERY_DETALHE = "select * from INTERESSE_DESENVOLVER where IDALUNO = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                InteresseDesenvolver interesseDesenvolver = new InteresseDesenvolver();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseDesenvolver.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                AlunoDAO alunoDAO = new AlunoDAO();
                interesseDesenvolver.setAluno(alunoDAO.GetById(rs.getInt("IDALUNO")));
                lista.add(interesseDesenvolver);

            }
            conn.close();

        } catch (Exception ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os dados dos selecionados!");

        } finally {

            return lista;

        }
    }

    public List<Ideia> ListarIdeiasNaoSelecionadas(int id) {

        List<Ideia> lista = new ArrayList<Ideia>();

        try {

            String QUERY_DETALHE = "select * from ideia where idideia not in (select idideia from interesse_desenvolver where idaluno = ?)";

            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
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
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os dados dos selecionados!");

        } finally {

            return lista;

        }

    }
}
