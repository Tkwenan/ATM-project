/**
 * This abstract class provides attributes as well as methods that represent operations that 
 * are common among the four types of transaction
 *
 * @author Aaron Mahr
 */

public abstract class Transaction{
    /** account to perform transaction upon */
    protected Account account;
    /** user-inputted pin to validate transaction */
    protected String inputpin; //the values that the user gives to the textbox, which cannot be cast to int prior to verification
    /** user-inputted amount to perform transaction with */
    protected String inputamt;
    /** value generated from user-inputted string inputpin*/
    protected int pin;
    /** value generated from user-inputted string inputamt*/
    protected int amount;

    /**
     * Tests that the input string pin is a 4-digit number
     * Sets the actual pin to the input value if successful
     * @return whether pin is valid input
     */
    public boolean validatePin(){
        int testpin;
        try{
            testpin = Integer.parseInt(this.inputpin);
        } catch(NumberFormatException e){ //can be converted to int
            return false;}
        if(testpin/1000<1||testpin/1000>=10) //must be 4 digits
            return false;
        this.pin=testpin;
        return true;
    }

    /**
     * Tests that the input amount is an integer value
     * Sets the actual amount if successful
     * Inlcuding negatives
     * @return if amount is a legal integer
     */
    public boolean validateAmt(){
        int testamt;
        try{
            testamt = Integer.parseInt(this.inputamt);
        } catch(NumberFormatException e){ //can be converted to int
            return false;}
        this.amount=testamt;
        return true;
    }

     
    /**
     * Validates pin, amount strings  if successful,
     * and setting return message if unsuccesful
     * @return status code indicating if either inputs were valid
     */
    public int validateInputs(){
        if(!validatePin())
            return 2; 
        // Error code 3: PIN incorrect
        else if(!account.isPin(pin))
            return 4;
        // Error code 4: Amount incorrectly formatted (not an integer)
        else if(!validateAmt())
            return 3;
        // Success: If none of these errors occur
        else
            return 1;
    }

    /**
     * general structure for a transaction method of a Transaction class
     * @return status message
     */
    public Message processTransaction(){
        //Step 1: validate inputs for usage
        int inputcode = this.validateInputs();
        if(inputcode!=1) //invalid inputs -> notify user and exit transaction
            return new Message(inputcode);

        //Step 2: verify PIN correctness
        if(!this.account.isPin(this.pin))
            return new Message(4,this); 
                
        //Step 3: test legitimacy of and perform operation
        int newbal = this.account.addBalance(amount);
        if(newbal>=this.account.getMinBal()) //amount valid to set
            this.account.setBalance(newbal);

        else return new Message(5,this); 
        
        //Step 4: set successful message
        return new Message(inputcode); 

    }
    
    @Override
    public String toString(){
        return "";
    }
    
}
