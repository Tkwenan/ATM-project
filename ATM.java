/**
 * Allows user to access and navigate their account
 * @author Benj Prud'homme
 */

public class ATM{
/**
* The transaction type
*/
private String trType; 
    

/** A checking account*/
private Account checkingAct;
 
/**
* A savings account
*/
private Account savingsAct;
    
/**
* The current account. Set to checking account by default
*/
private Account curAct;

/**
* Constructor for objects of class ATM
* Assumes user has a preexisting checking and savings account
* Sets pins by default to 1234
*/
    public ATM(){
        this.checkingAct = new Account(0734, 1234, "Checking");
        this.savingsAct = new Account(5821, 1234, "Savings");
        this.curAct = checkingAct; // default to checking account
        this.trType = "";
    }

    /**
     * setter for transaction type
     * @param nam String of transaction type ie "Withdrawal"
     */
    public void setTrType(String nam){
        this.trType=nam;
    }

    /**
     * Setter for current account
     * Called by accountSelector listener in main()
     * @param act the account of the ATM object to move to being active
     */
    public void setCurAct(Account act){
        this.curAct=act;
    }
    
    /**
     * Getter for current account
     * @return account user has selected in GUI prompt
     */
    public Account getCurAct(){
        return curAct;
    }
    
    /**
     * Getter for checkings account
     * @return current user checking acct
     */
    public Account getCheckingAct(){
        return checkingAct;
    }
    
    /**
     * Getter for savings account
     * @return current user savings acct
     */
    public Account getSavingsAct(){
        return savingsAct;
    }
    
    /**
     * Getter for transaction type
     * @return type of transaction currently being performed
     */
    public String getTrType(){
        return trType;
    }

}