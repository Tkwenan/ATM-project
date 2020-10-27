/**
 * Oversees withdrawal-type transactions
 * @author Benj Prud'homme
 */
public class Withdrawal extends Transaction
{
    /**
     * Constructor for objects of type Withdrawal
     * @param aAccount an account to withdraw from
     * @param aInputpin user-provided text
     * @param aInputamt user-provided text
     */
    public Withdrawal(Account aAccount, String aInputpin, String aInputamt){
        this.account = aAccount;
        this.inputpin = aInputpin;
        this.inputamt = aInputamt;
        this.validateInputs();
    }
    
    /**
     * ensures that the user has entered valid strings
     * @return status code indicating if inputs were valid
     */
    public int validateInputs(){
        // Error code 2: PIN incorrectly formatted (not 4 digits or not a number)
        if(!validatePin())
            return 2; 
        // Error code 4: PIN incorrect
        else if(!account.isPin(pin))
            return 4;
        // Error code 3: Amount incorrectly formatted (not an integer)
        else if(!validateAmt())
            return 3;
        // Error code 5: Amount would take account below min balance
        else if(account.addBalance(-amount)<account.getMinBal())
            return 5;
        // Success: If none of these errors occur
        else
            return 1;
 
    }
    
    /**
     * Carries out the specified transaction if
     * it is legal to perform
     * @return status message of transaction
     */
    public Message processTransaction(){
        int status = validateInputs();
        if(status==1)
            account.setBalance(account.addBalance(-amount));
            
        Message msg = new Message(status,this);
        return msg;
    }
    
    @Override
    /**
     * Provides a string representation of the message to be printed out after the transaction
     * occurs
     * @return A string representation of this transaction.
     */
    public String toString(){
        String s = "$";
        s+=this.amount + " withdrawn from Account #" + this.account.getActNo()+".";
        return s;
    }
}
