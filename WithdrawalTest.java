

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WithdrawalTest.
 *
 * @author Benj Prud'homme
 */
public class WithdrawalTest
{
    /**
     * Default constructor for test class WithdrawalTest
     */
    public WithdrawalTest()
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
     * Tests the Withdrawal.testValidateInputs() method.
     */
    @Test
    public void testValidateInputs()
    {
        Account account1 = new Account(0743, 1234, "Checking");
        account1.setBalance(200);
        Withdrawal w1 = new Withdrawal(account1, "1234", "50");
        assertEquals(1, w1.validateInputs());
        Withdrawal w2 = new Withdrawal(account1, "xxxx", "50");
        assertEquals(2, w2.validateInputs());
        Withdrawal w2b = new Withdrawal(account1, "12345", "50");
        assertEquals(2, w2b.validateInputs());
        Withdrawal w3 = new Withdrawal(account1, "1234", "$50");
        assertEquals(3, w3.validateInputs());
        Withdrawal w4 = new Withdrawal(account1, "1235", "50");
        assertEquals(4, w4.validateInputs());
        Withdrawal w5 = new Withdrawal(account1, "1234", "101");
        assertEquals(5, w5.validateInputs());
    }
    
    /**
     * Tests the Withdrawal.processTransaction() method.
     */
    @Test
    public void testProcessTransaction(){
        Account account2 = new Account(0744, 5678, "Checking");
        account2.setBalance(200);
        assertEquals(200, account2.getBal());
        Withdrawal wx = new Withdrawal(account2, "5678", "50");
        Message msgx = wx.processTransaction();
        assertEquals(150, account2.getBal());
        Withdrawal wy = new Withdrawal(account2, "5678", "75");
        Message msgy = wy.processTransaction();
        assertEquals(150, account2.getBal());
    }
   
}

