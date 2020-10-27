/**
 * Faciliatates transaction of the type Inquiry
 * @author Benj Prud'homme
 */
public class Inquiry extends Transaction
{
    /**
     * Constructor for object of type Inquiry
     * @param aAccount an account
     * @param aInputpin user-input value
     */
    public Inquiry(Account aAccount, String aInputpin){
        this.account = aAccount;
        this.inputpin = aInputpin;
    }

    /**
     * Validates that both inputs are legal
     * @return input status code of what if any inputs are legal
     */
    public int validateInputs(){
        // Error code 2: PIN incorrectly formatted (not 4 digits or not a number)
        if(!validatePin())
            return 2; 
        // Error code 4: PIN incorrect
        else if(!account.isPin(pin))
            return 4;
        // Success: If none of these errors occur // (errors 3 and 5 N/A since there's no amount)
        else
            return 1;
    }

    /**
     * Carries out the specified transation
     * @return message signifiying outcome of transaction
     */
    public Message processTransaction(){
        int status = validateInputs();

        Message msg = new Message(status,this);
        return msg;
    }

    @Override
    /**
     * Provides a string representation of the message to be printed out after the transaction
     * occurs
     * @return A string representation of the account associated with this inquiry.
     */
    public String toString(){
        String s=this.account.toString();
        return s;
    }
}

