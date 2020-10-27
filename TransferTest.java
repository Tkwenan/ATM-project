import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TransferTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TransferTest
{
    /**
     * Default constructor for test class TransferTest
     */
    public TransferTest()
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
     * Tests the Transfer.testValidateInputs() method.
     */
    @Test
    public void testValidateInputs()
    {

        Account account1 = new Account(1945, 1234, "Checking");
        Account account2 = new Account(0743, 5678, "Savings");
        account1.setBalance(150);

        Transfer t1 = new Transfer(account1, account2, "1234", "50");
        assertEquals(1, t1.validateInputs());
        Transfer t2 = new Transfer(account1, account2, "xxxx", "50");
        assertEquals(2, t2.validateInputs());
        Transfer t2b = new Transfer(account1, account2, "12345", "50");
        assertEquals(2, t2b.validateInputs());
        Transfer t3 = new Transfer(account1, account2, "1234", "$50");
        assertEquals(3, t3.validateInputs());
        Transfer t4 = new Transfer(account1, account2, "1235", "50");
        assertEquals(4, t4.validateInputs());
        Transfer t5 = new Transfer(account1, account2, "1234", "51");
        assertEquals(5, t5.validateInputs());
    }
    
    /**
     * Tests the Transfer.testProcessTransaction() method.
     */
    @Test
    public void testProcessTransaction(){
        Account account1 = new Account(0743, 1234, "Savings");
        Account account2 = new Account(1945, 5678, "Checking");
        account1.setBalance(525);
        assertEquals(525, account1.getBal());
        assertEquals(100, account2.getBal());
        
        Transfer tx = new Transfer(account1, account2, "1234", "25");
        Message msgx = tx.processTransaction();
        assertEquals(500, account1.getBal());
        assertEquals(125, account2.getBal());
        Transfer ty = new Transfer(account2, account1, "5678", "25");
        Message msgy = ty.processTransaction();
        assertEquals(525, account1.getBal());
        assertEquals(100, account2.getBal());
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
