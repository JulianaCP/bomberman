/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johanna
 */
public class FillBombTest {
    
    public FillBombTest() {
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
     * Test of actualizeMatrixEliminateObjectWithFire method, of class FillBomb.
     */
    @Test
    public void testActualizeMatrixEliminateObjectWithFire() {
        System.out.println("actualizeMatrixEliminateObjectWithFire");
        FillBomb instance = new FillBomb();
        instance.actualizeMatrixEliminateObjectWithFire();
       
    }

    /**
     * Test of ExploteBomb method, of class FillBomb.
     */
    @Test
    public void testExploteBomb() {
        System.out.println("ExploteBomb");
        FillBomb instance = new FillBomb();
        instance.ExploteBomb();
        
    }

    /**
     * Test of lookCharacterWithBomb method, of class FillBomb.
     */
    @Test
    public void testLookCharacterWithBomb() {
        System.out.println("lookCharacterWithBomb");
        FillBomb instance = new FillBomb();
        instance.lookCharacterWithBomb();
        
    }


    /**
     * Test of putAnalysedThrBomb method, of class FillBomb.
     */
    @Test
    public void testPutAnalysedThrBomb() {
        System.out.println("putAnalysedThrBomb");
        FillBomb instance = new FillBomb();
        instance.putAnalysedThrBomb();
        
    }

    /**
     * Test of verificateHeroBomb method, of class FillBomb.
     */
    @Test
    public void testVerificateHeroBomb() {
        System.out.println("verificateHeroBomb");
        FillBomb instance = new FillBomb();
        instance.verificateHeroBomb();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of obtainPositionOfTheBombToExplote method, of class FillBomb.
     */
    @Test
    public void testObtainPositionOfTheBombToExplote() {
        System.out.println("obtainPositionOfTheBombToExplote");
        FillBomb instance = new FillBomb();
        instance.obtainPositionOfTheBombToExplote();
       
    }

    /**
     * Test of putFireInRangeOfBomb method, of class FillBomb.
     */
    @Test
    public void testPutFireInRangeOfBomb() {
        System.out.println("putFireInRangeOfBomb");
        FillBomb instance = new FillBomb();
        instance.putFireInRangeOfBomb();
        
    }

    /**
     * Test of putFire method, of class FillBomb.
     */
    @Test
    public void testPutFire() {
        System.out.println("putFire");

        int firePositionRow = 2;
        int firePositionColumn = 0;
        FillBomb instance = new FillBomb();
        boolean expResult = false;
        boolean result = instance.putFire(firePositionRow, firePositionColumn);
        assertEquals(expResult, result);
        
        
    }

   
    
}
