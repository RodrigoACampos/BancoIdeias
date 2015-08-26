/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entidade.Aluno;
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
 * @author vdisoo0046
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoDAOTest {
    
    public AlunoDAOTest() {
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
     * Test of salvar method, of class AlunoDAO.
     */
    @Test
    public void test01_Salvar() {
        System.out.println("Teste - Salvar novo Aluno");
        Aluno aluno = new Aluno();
        aluno.setId(null);
        aluno.setNome("Mario");
        aluno.setEmail("mario@hotmail.com");
        aluno.setTelefone("48 88888888");
        AlunoDAO instance = new AlunoDAO();
        boolean expResult = true;
        boolean result = instance.salvar(aluno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        System.out.println("Teste - Salvar novo Aluno");
        aluno = new Aluno();
        aluno.setId(null);
        aluno.setNome("Ana");
        aluno.setTelefone("21 99887766");
        aluno.setEmail("ana@contato.com");
        instance = new AlunoDAO();
        expResult = true;
        result = instance.salvar(aluno);
        assertEquals(expResult, result); 
        
        System.out.println("Teste - Salvar um Aluno já existente");
        aluno = new Aluno();
        aluno.setId(2);
        aluno.setNome("Maria");
        aluno.setTelefone("47 99887766");
        aluno.setEmail("maria@contato.com");
        instance = new AlunoDAO();
        expResult = true;
        result = instance.salvar(aluno);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetById method, of class AlunoDAO.
     */
    @Test
    public void test02_GetById() {
        System.out.println("GetById");
        int id = 1;
        AlunoDAO instance = new AlunoDAO();
        Aluno result = instance.GetById(id);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class AlunoDAO.
     */
    @Test
    public void test03_Listar() {
        System.out.println("listar");
        AlunoDAO instance = new AlunoDAO();
        List<Aluno> result = instance.listar();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }  
    
     /**
     * Test of deletar method, of class AlunoDAO.
     */
    @Test
    public void test04_Deletar() {
        System.out.println("deletar");
        Aluno aluno = new Aluno();
        AlunoDAO instance = new AlunoDAO();
        aluno.setId(1);
        boolean result = instance.deletar(aluno);
        boolean expResult = true;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
