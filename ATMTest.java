

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ATMTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ATMTest
{
    /**
     * Default constructor for test class ATMTest
     */
    public ATMTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tests the ATM.setTrType() and ATM.getTrType() methods.
     */
    @Test
    public void testSetAndGetTrType(){
        ATM myATM = new ATM();
        myATM.setTrType("Withdrawal");
        assertEquals("Withdrawal", myATM.getTrType());
    }
    
    /**
     * Tests the ATM.setCurAct() and ATM.getCurAct() methods.
     */
    @Test
    public void testSetAndGetCurAct(){
        ATM myATM = new ATM();
        myATM.setTrType("Withdrawal");
        assertEquals("Withdrawal", myATM.getTrType());
    }
    
    /**
     * Tests the ATM.getCheckingAct() and ATM.getSavingsAct() methods.
     */
    @Test
    public void testgetCheckingAndSavingsActs(){
        ATM myATM = new ATM();
        assertEquals(0734, myATM.getCheckingAct().getActNo());
        assertTrue(myATM.getCheckingAct().isPin(1234));
        assertEquals(5821, myATM.getSavingsAct().getActNo());
        assertTrue(myATM.getSavingsAct().isPin(1234));
    }
}
