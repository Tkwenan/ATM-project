import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

/**
 * The test class AccountTest.
 *
 * @author  Tracy Kwena
 * @version 
 */
public class AccountTest extends TestCase
{
    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
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
     * Tests the Account.getActNo() method.
     */
    @Test
    public void testgetActNo(){
        Account acc = new Account (2534, 3434, "Checking"); 
        int actno = acc.getActNo();
        assertTrue (actno == 2534);

    }

    /**
     * Tests the Account.isPin() method.
     */
    @Test
    public void testisPin(){
        Account acc = new Account (2534, 3434, "Checking"); 
        int testpin = 3434;
        boolean value = acc.isPin(testpin); 
        assertTrue (value); 

    }

    /**
     * Tests the Account.getType() method.
     */
    @Test
    public void testgetType(){
        Account acc = new Account (2534, 3434, "Checking"); 
        String type = acc.getType();
        assertTrue (type.equals ("Checking"));

    }

    /**
     * Tests the Account.getMinBal() method.
     */
    @Test
    public void testgetMinBal(){
        Account acc = new Account (2534, 3434, "Checking"); 
        int minbal = acc.getMinBal();
        assertTrue (minbal == 100);  

    }

    /**
     * Tests the Account.getBal() method.
     */
    @Test
    public void testgetBal(){
        Account acc = new Account (2534, 3434, "Checking"); 
        int bal = acc.getBal();
        assertTrue (bal == 100);  

    }

    /**
     * Tests the Account.getIRate() method.
     */
    @Test
    public void testgetIRate(){
        Account acc = new Account (2534, 3434, "Checking"); 
        double rate = acc.getIRate();
        assertTrue (rate == 0.0); 

    }

    /**
     * Tests the Account.addBalance() method.
     */
    @Test
    public void testaddBalance(){
        Account acc = new Account (2534, 3434, "Checking"); 
        int newbal = acc.addBalance(200);
        assertTrue (newbal == acc.getBal()+200); 

    }

    /**
     * Tests the Account.setBalance() method.
     */
    @Test
    public void testsetBalance(){
        Account acc = new Account (2534, 3434, "Checking"); 
        acc.setBalance(200); 
        assertTrue (acc.getBal() == 200); 
    }
    
    /**
     * Tests the Account.toString() method.
     */
    @Test
    public void testToString(){
        Account acc = new Account(2534, 6823, "Savings");
        String expected = "Welcome to your Savings Account (#2534).\n";
        expected += "You currently have $500.00 (Minimum: $500).\n";
        expected += "You are earning 0.4% interest on your money!";
        assertEquals(expected, acc.toString());
    }

}
