package dao;

import entidade.Solicitante;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andre ulisses
 */
public class SolicitanteDAOTest {
    
    public SolicitanteDAOTest() {
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
     * Test of salvar method, of class SolicitanteDAO.
     */
    @Test
    public void testSalvar() {
        
        System.out.println("Teste - Salvar novo Solicitante");
        Solicitante solicitante = new Solicitante();
        solicitante.setId(null);
        solicitante.setNome("Mario");
        solicitante.setTelefone("48 99887766");
        solicitante.setEmail("mario@contato.com");
        SolicitanteDAO instance = new SolicitanteDAO();
        boolean expResult = true;
        boolean result = instance.salvar(solicitante);
        assertEquals(expResult, result);

        System.out.println("Teste - Salvar um Solicitante já existente");
        solicitante = new Solicitante();
        solicitante.setId(1);
        solicitante.setNome("Maria");
        solicitante.setTelefone("47 99887766");
        solicitante.setEmail("maria@contato.com");
        instance = new SolicitanteDAO();
        expResult = true;
        result = instance.salvar(solicitante);
        assertEquals(expResult, result);

    }

    /**
     * Test of GetById method, of class SolicitanteDAO.
     */
    @Test
    public void testGetById() {
        System.out.println("Teste - GetById solicitante");
        int id = 1;
        SolicitanteDAO instance = new SolicitanteDAO();
        Solicitante result = instance.GetById(id);
        assertNotNull(result);
    }

    /**
     * Test of listar method, of class SolicitanteDAO.
     */
    @Test
    public void testListar() {
        System.out.println("Teste - listar solicitante");
        SolicitanteDAO instance = new SolicitanteDAO();
        List<Solicitante> result = instance.listar();
        assertNotNull(result);
    }
    
    /**
     * Test of deletar method, of class SolicitanteDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("Teste - deletar solicitante");
        Solicitante solicitante = new Solicitante();
        solicitante.setId(1);
        SolicitanteDAO instance = new SolicitanteDAO();
        boolean expResult = true;
        boolean result = instance.deletar(solicitante);
        assertEquals(expResult, result);
    }
    
}
