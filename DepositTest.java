import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DepositTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DepositTest
{
    /**
     * Default constructor for test class DepositTest
     */
    public DepositTest()
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
     * Tests the Deposit.testValidateInputs() method.
     */
    @Test
    public void testValidateInputs()
    {
        Account account1 = new Account(0743, 1234, "Checking");
        Deposit d1 = new Deposit(account1, "1234", "50");
        assertEquals(1, d1.validateInputs());
        Deposit d2 = new Deposit(account1, "xxxx", "50");
        assertEquals(2, d2.validateInputs());
        Deposit d2b = new Deposit(account1, "12345", "50");
        assertEquals(2, d2b.validateInputs());
        Deposit d3 = new Deposit(account1, "1234", "$50");
        assertEquals(3, d3.validateInputs());
        Deposit d4 = new Deposit(account1, "1235", "50");
        assertEquals(4, d4.validateInputs());
    }
    
    /**
     * Tests the Deposit.processTransaction() method.
     */
    @Test
    public void testProcessTransaction(){
        Account account2 = new Account(0744, 5678, "Checking");
        assertEquals(100, account2.getBal());
        Deposit dx = new Deposit(account2, "5678", "50");
        Message msgx = dx.processTransaction();
        assertEquals(150, account2.getBal());
        Deposit dy = new Deposit(account2, "5678", "75");
        Message msgy = dy.processTransaction();
        assertEquals(225, account2.getBal());
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
}
