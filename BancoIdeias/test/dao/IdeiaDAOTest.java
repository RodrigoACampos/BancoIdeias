/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Ideia;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Programação
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IdeiaDAOTest {

    public IdeiaDAOTest() {
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
     * Test of salvar method, of class IdeiaDAO.
     */
    @Test
    public void test01_Salvar() throws ParseException {

        System.out.println("salvar");
        Ideia ideia = new Ideia();
        ideia.setId(null);
        ideia.setTema("O Leão Dourado");
        ideia.setDescricao("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ideia.setDtcadastro(new java.sql.Date(formato.parse("26/08/2015").getTime()));
        SolicitanteDAO solicitanteDAO = new SolicitanteDAO();
        ideia.setSolicitante(solicitanteDAO.GetById(3));
        IdeiaDAO instance = new IdeiaDAO();
        boolean expResult = true;
        boolean result = instance.salvar(ideia);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetById method, of class IdeiaDAO.
     */
    @Test
    public void test02_GetById() {
        System.out.println("GetById");
        int id = 2;
        IdeiaDAO instance = new IdeiaDAO();
        Ideia result = instance.GetById(id);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of listar method, of class IdeiaDAO.
     */
    @Test
    public void test03_Listar() {
        System.out.println("listar");
        IdeiaDAO instance = new IdeiaDAO();
        List<Ideia> result = instance.listar();
        assertEquals(result, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of deletar method, of class IdeiaDAO.
     */
    @Test
    public void test04_Deletar() {
        System.out.println("deletar");
        Ideia ideia = new Ideia();
        ideia.setId(2);
        IdeiaDAO instance = new IdeiaDAO();
        boolean expResult = true;
        boolean result = instance.deletar(ideia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
