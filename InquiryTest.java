

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InquiryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InquiryTest
{
    /**
     * Default constructor for test class InquiryTest
     */
    public InquiryTest()
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
     * Tests the Inquiry.testValidateInputs() method.
     */
    @Test
    public void testValidateInputs()
    {
        Account account1 = new Account(0743, 1234, "Checking");
        Inquiry i1 = new Inquiry(account1, "1234");
        assertEquals(1, i1.validateInputs());
        Inquiry i2 = new Inquiry(account1, "xxxx");
        assertEquals(2, i2.validateInputs());
        Inquiry i2b = new Inquiry(account1, "12345");
        assertEquals(2, i2b.validateInputs());
        Inquiry i4 = new Inquiry(account1, "1235");
        assertEquals(4, i4.validateInputs());
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
