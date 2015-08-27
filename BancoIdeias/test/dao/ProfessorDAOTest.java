package dao;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProfessorDAOTest {
    
    public ProfessorDAOTest() {
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
     * Test of salvar method, of class ProfessorDAO.
     */
    @Test
    public void test01_Salvar() {
        
        System.out.println("Teste - Salvar novo Professor");
        Professor professor = new Professor();
        professor.setId(null);
        professor.setNome("Mario");
        professor.setTelefone("48 99887766");
        professor.setEmail("mario@contato.com");
        ProfessorDAO instance = new ProfessorDAO();
        boolean expResult = true;
        boolean result = instance.salvar(professor);
        assertEquals(expResult, result);
        
        System.out.println("Teste - Salvar novo Professor");
        professor = new Professor();
        professor.setId(null);
        professor.setNome("Ana");
        professor.setTelefone("21 99887766");
        professor.setEmail("ana@contato.com");
        instance = new ProfessorDAO();
        expResult = true;
        result = instance.salvar(professor);
        assertEquals(expResult, result);        

        System.out.println("Teste - Salvar um Professor já existente");
        professor = new Professor();
        professor.setId(2);
        professor.setNome("Maria");
        professor.setTelefone("47 99887766");
        professor.setEmail("maria@contato.com");
        instance = new ProfessorDAO();
        expResult = true;
        result = instance.salvar(professor);
        assertEquals(expResult, result);
    }
    /**
     * Test of GetById method, of class ProfessorDAO.
     */
    @Test
    public void test02_GetById() {
        System.out.println("Teste - GetById professor");
        int id = 2;
        ProfessorDAO instance = new ProfessorDAO();
        Professor result = instance.GetById(id);
        assertNotNull(result);
    }
    /**
     * Test of listar method, of class ProfessorDAO.
     */
    @Test
    public void test03_Listar() {
        System.out.println("Teste - listar professor");
        ProfessorDAO instance = new ProfessorDAO();
        List<Professor> result = instance.listar();
        assertNotNull(result);
    }
    /**
     * Test of deletar method, of class ProfessorDAO.
     */
    @Test
    public void test04_Deletar() {
        System.out.println("Teste - deletar professor");
        Professor professor = new Professor();
        professor.setId(1);
        ProfessorDAO instance = new ProfessorDAO();
        boolean expResult = true;
        boolean result = instance.deletar(professor);
        assertEquals(expResult, result);
    }
}