/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Ideia;
import entidade.InteresseOrientar;
import entidade.Professor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author andre ulisses
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InteresseOrientarDAOTest {
    
    public InteresseOrientarDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class InteresseOrientarDAO.
     */
    @Test
    public void test01_Salvar() {
        System.out.println("salvar");
        InteresseOrientar interesseOrientar = new InteresseOrientar();
        IdeiaDAO ideiaDAO = new IdeiaDAO();        
        interesseOrientar.setIdeia(ideiaDAO.GetById(1));
        ProfessorDAO professorDAO = new ProfessorDAO();
        interesseOrientar.setProfessor(professorDAO.GetById(1));        
        InteresseOrientarDAO instance = new InteresseOrientarDAO();
        boolean expResult = true;
        boolean result = instance.salvar(interesseOrientar);
        assertEquals(expResult, result);
    }

    /**
     * Test of listarByIdProfessor method, of class InteresseOrientarDAO.
     */
    @Test
    public void test02_ListarByIdProfessor() {
        System.out.println("listarByIdProfessor");
        int id = 0;
        InteresseOrientarDAO instance = new InteresseOrientarDAO();
        List<InteresseOrientar> result = instance.listarByIdProfessor(1);
        assertNotNull(result);
    }

    /**
     * Test of GetById method, of class InteresseOrientarDAO.
     */
    @Test
    public void test03_GetById() {
        System.out.println("GetById");
        InteresseOrientar interesseOrientar = new InteresseOrientar();
        Ideia ideia = new Ideia();
        ideia.setId(1);
        interesseOrientar.setIdeia(ideia);
        Professor professor = new Professor();
        professor.setId(1);  
        interesseOrientar.setProfessor(professor);
        InteresseOrientarDAO instance = new InteresseOrientarDAO();
        InteresseOrientar result = instance.GetById(interesseOrientar);
        assertNotNull(result);
    }

    /**
     * Test of deletar method, of class InteresseOrientarDAO.
     */
    @Test
    public void test04_Deletar() {
        System.out.println("deletar");
        InteresseOrientar interesseOrientar = new InteresseOrientar();
        Ideia ideia = new Ideia();
        ideia.setId(1);
        interesseOrientar.setIdeia(ideia);
        Professor professor = new Professor();
        professor.setId(1);  
        interesseOrientar.setProfessor(professor);
        InteresseOrientarDAO instance = new InteresseOrientarDAO();
        boolean expResult = true;
        boolean result = instance.deletar(interesseOrientar);
        assertEquals(expResult, result);
    }
    
}
