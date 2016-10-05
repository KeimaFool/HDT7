/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt7;

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Shin
 */
public class HuffmanTest {
    
    public HuffmanTest() {
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
     * Test of decode method, of class Huffman.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");
        Huffman instance = new Huffman("a");
        char expResult = 'a';
        Vector<Arbol> result = instance.decode();
        assertEquals(expResult, result.elementAt(0).getChara());
        
    }

    /**
     * Test of construct method, of class Huffman.
     */
    @Test
    public void testConstruct() {
        System.out.println("construct");
        Huffman instance = new Huffman("ab");
        Vector<Arbol> result = instance.decode();
        instance.construct();
        char expResult = 'a';
        assertEquals(expResult, instance.getQueue().elementAt(0).getLeft().getChara());
        
    }

    /**
     * Test of Cdatos method, of class Huffman.
     */
    @Test
    public void testCdatos() {
        System.out.println("construct");
        Huffman instance = new Huffman("ab");
        Vector<Arbol> result = instance.decode();
        instance.construct();
        instance.Cdatos(instance.getQueue().elementAt(0));
        String expResult = "0";
        assertEquals(expResult, instance.getQueue().elementAt(1).getCodigo());
        
    }


    
}
