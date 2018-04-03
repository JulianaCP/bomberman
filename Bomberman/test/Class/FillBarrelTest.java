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
public class FillBarrelTest {
    
    public FillBarrelTest() {
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
     * Test of run method, of class FillBarrel.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FillBarrel instance = new FillBarrel();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of moveBarrel method, of class FillBarrel.
     */
    @Test
    public void testMoveBarrel() {
        System.out.println("moveBarrel");
        FillBarrel instance = new FillBarrel();
        instance.moveBarrel();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of verificateBarrelAndHeroPosition method, of class FillBarrel.
     */
    @Test
    public void testVerificateBarrelAndHeroPosition() {
        System.out.println("verificateBarrelAndHeroPosition");
        FillBarrel instance = new FillBarrel();
        instance.verificateBarrelAndHeroPosition();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of heroIsUpLeft method, of class FillBarrel.
     */
    @Test
    public void testHeroIsUpLeft() {
        System.out.println("heroIsUpLeft");
        FillBarrel instance = new FillBarrel();
        instance.heroIsUpLeft();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of heroIsDownRigth method, of class FillBarrel.
     */
    @Test
    public void testHeroIsDownRigth() {
        System.out.println("heroIsDownRigth");
        FillBarrel instance = new FillBarrel();
        instance.heroIsDownRigth();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of heroIsUpRigth method, of class FillBarrel.
     */
    @Test
    public void testHeroIsUpRigth() {
        System.out.println("heroIsUpRigth");
        FillBarrel instance = new FillBarrel();
        instance.heroIsUpRigth();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of heroIsDownLeft method, of class FillBarrel.
     */
    @Test
    public void testHeroIsDownLeft() {
        System.out.println("heroIsDownLeft");
        FillBarrel instance = new FillBarrel();
        instance.heroIsDownLeft();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of chancePosition method, of class FillBarrel.
     */
    @Test
    public void testChancePosition() {
        System.out.println("chancePosition");
        int positionRow = 1;
        int positionColumn = 1;
        int newPositionRow = 1;
        int newPositionColumn = 2;
        FillBarrel instance = new FillBarrel();
        instance.chancePosition(positionRow, positionColumn, newPositionRow, newPositionColumn);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verificateRigth method, of class FillBarrel.
     */
    @Test
    public void testVerificateRigth() {
        System.out.println("verificateRigth");
        int PositionRow = 5;
        int PositionColumn = 6;
        FillBarrel instance = new FillBarrel();
        instance.verificateRigth(PositionRow, PositionColumn);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of veificateUp method, of class FillBarrel.
     */
    @Test
    public void testVeificateUp() {
        System.out.println("veificateUp");
        int positionRow = 4;
        int positionColumn = 5;
        FillBarrel instance = new FillBarrel();
        instance.veificateUp(positionRow, positionColumn);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of veificateLeft method, of class FillBarrel.
     */
    @Test
    public void testVeificateLeft() {
        System.out.println("veificateLeft result");
        int positionRow = 5;
        int positionColumn = 6;
        FillBarrel instance = new FillBarrel();
        instance.veificateLeft(positionRow, positionColumn);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verificateDown method, of class FillBarrel.
     */
    @Test
    public void testVerificateDown() {
        System.out.println("verificateDown reuslt");
        int positionRow = 4;
        int positionColumn = 2;
        FillBarrel instance = new FillBarrel();
        instance.verificateDown(positionRow, positionColumn);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    
 //// test ///////////////////////////////////////////////////////////////////////////////////////   
     @Test
    public void testVerificateDownWithCeroCeroPosition() {
        System.out.println("verificate with cero cero position down");
        int positionRow = 0;
        int positionColumn = 0;
        FillBarrel instance = new FillBarrel();
        instance.verificateDown(positionRow, positionColumn);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Test of llamar method, of class FillBarrel.
     */
    @Test
    public void testLlamar() {
        System.out.println("llamar  result");
        FillBarrel instance = new FillBarrel();
        instance.llamar();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of refresh method, of class FillBarrel.
     */
    @Test
    public void testRefresh() {
        System.out.println("refresh result");
        FillBarrel instance = new FillBarrel();
        instance.refresh();
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
