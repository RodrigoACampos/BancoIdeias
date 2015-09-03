/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionManager;
import entidade.Ideia;
import entidade.InteresseOrientar;
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
public class InteresseOrientarDAO {

    public boolean salvar(InteresseOrientar interesseOrientar) {

        boolean resultado = false;
        
        try {
            
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_INSERT = "insert into INTERESSE_ORIENTAR (IDIDEIA, IDPROFESSOR) values (?, ?)";
            String QUERY_UPDATE = "update INTERESSE_ORIENTAR set IDIDEIA = ?, IDPROFESSOR = ? where IDIDEIA = ? and IDPROFESSOR = ? ";

            if (GetById(interesseOrientar) == null) {
                
                stmt = conn.prepareStatement(QUERY_INSERT);
                stmt.setInt(1, interesseOrientar.getIdeia().getId());
                stmt.setInt(2, interesseOrientar.getProfessor().getId());
                
            } else {
                
                stmt = conn.prepareStatement(QUERY_UPDATE);
                stmt.setInt(1, interesseOrientar.getIdeia().getId());
                stmt.setInt(2, interesseOrientar.getProfessor().getId());
                stmt.setInt(3, interesseOrientar.getIdeia().getId());
                stmt.setInt(4, interesseOrientar.getProfessor().getId());
                
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

    public boolean deletar(InteresseOrientar interesseOrientar) {

        boolean resultado = false;

        try {
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            String QUERY_DELETE = "delete from INTERESSE_ORIENTAR where IDIDEIA = ? and IDPROFESSOR = ?";

            stmt = conn.prepareStatement(QUERY_DELETE);
            stmt.setInt(1, interesseOrientar.getIdeia().getId());
            stmt.setInt(2, interesseOrientar.getProfessor().getId());

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

    public InteresseOrientar GetById(InteresseOrientar pInteresseOrientar) {

        InteresseOrientar interesseOrientar = null;
        try {

            String QUERY_DETALHE = "select * from INTERESSE_ORIENTAR where IDIDEIA = ? and IDPROFESSOR = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;
            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, pInteresseOrientar.getIdeia().getId());
            stmt.setInt(2, pInteresseOrientar.getProfessor().getId());

            rs = stmt.executeQuery();

            while (rs.next()) {

                interesseOrientar = new InteresseOrientar();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseOrientar.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                ProfessorDAO professorDAO = new ProfessorDAO();
                interesseOrientar.setProfessor(professorDAO.GetById(rs.getInt("IDPROFESSOR")));

            }
            
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os dados dos selecionados!");
            
        }
        
        return interesseOrientar;
    }

    public List<InteresseOrientar> listarByIdProfessor(int id) {

        List<InteresseOrientar> lista = new ArrayList<InteresseOrientar>();
        try {
            
            String QUERY_DETALHE = "select * from INTERESSE_ORIENTAR where IDPROFESSOR = ?";
            PreparedStatement stmt = null;
            Connection conn = ConnectionManager.getConnection();

            ResultSet rs = null;

            stmt = conn.prepareStatement(QUERY_DETALHE);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {

                InteresseOrientar interesseOrientar = new InteresseOrientar();
                IdeiaDAO ideiaDAO = new IdeiaDAO();
                interesseOrientar.setIdeia(ideiaDAO.GetById(rs.getInt("IDIDEIA")));
                ProfessorDAO professorDAO = new ProfessorDAO();
                interesseOrientar.setProfessor(professorDAO.GetById(rs.getInt("IDPROFESSOR")));
                lista.add(interesseOrientar);

            }
            conn.close();

        } catch (Exception ex) {
            
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os dados dos selecionados!");
            
        } finally {
            
            return lista;
            
        }
    }
    
    public List<Ideia> ListarIdeiasNaoSelecionadas(int id){
        
        List<Ideia> lista = new ArrayList<Ideia>();

        try {
            
            String QUERY_DETALHE = "select * from ideia where idideia not in (select idideia from interesse_orientar where idprofessor = ?)";

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
