/**
 * A class that deposits the amount entered by the user into an account
 * and adjusts the balance
 * 
 * @author Tracy Kwena
 * 
 */
public class Deposit extends Transaction{
    /**
     * Constructs a Deposit object
     * @param acc the account to deposit money into
     * @param inpin the input PIN number
     * @param inputamount the amount of money to be deposited
     */
    public Deposit(Account acc, String inpin, String inputdeposit){
        this.account = acc;
        this.inputpin = inpin;
        this.inputamt = inputdeposit;
    }

    /**
     * This method checks that the input pin is a 4-digit number
     * and that the input amount is an integer value
     * @return status code of which inputs were valid
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
        // Success: If none of these errors occur
        else
            return 1;
    }

    /**
     * Performs the transaction by adding the input deposit amount to the 
     * current account balance and returns a message confirming 
     * amount deposited and that it was successful
     * @return status message indicating if transaction succeeded.
     */
    public Message processTransaction(){
        int status = validateInputs();
        if(status==1)
            account.setBalance(account.addBalance(amount));

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
        int actno = this.account.getActNo();
        s+=this.amount + " deposited into Account #" + actno;
        return s;
    }

}
