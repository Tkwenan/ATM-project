/**
 * Holds information about a specific account
 * @author Aaron Mahr
 */
public class Account{
    /** number of account/account identifier */
    private int actno;
    /** pin used to verify user */
    private int pin;
    /** type of account: Checking/Savings */
    private String type;
    /** current balance of the account */
    private int bal;
    /** minimum balance account is allowed to take */
    private int minbal;
    /** interest rate account earns */
    private double irate;
    
    /**
     * Constructor method for Account
     * sets values according to inputs and to account type
     * @param no the account number
     * @param pi the pin number
     * @param typ type of this account (checking or savings)
     */
    public Account(int no, int pi, String typ){ //add in Cust owner
        this.actno=no;
        this.pin=pi;
        this.type=typ;
        if(typ=="Checking"){
            this.minbal=CHECKING_MIN;
            this.irate=CHECKING_IRATE;
        } else{ //since not user input, can be certain it is either Ch/Sa act
            this.minbal=SAVINGS_MIN;
            this.irate=SAVINGS_IRATE;
        }
        this.bal=this.minbal;
    }
    
    /**
     * Getter for account # property
     * @return account number
     */
    public int getActNo(){
        return this.actno;
    }
    
    /**
     * Boolean to tell if passed pin matches account pin
     * @param pi the user-passed pin
     * @return if entered pin matched account pin
     */
    public Boolean isPin(int pi){
        return this.pin==pi;
    }
    
    /**
     * Getter for account type property
     * @return type of account (Ch/Sa)
     */
    public String getType(){
        return this.type;
    }
    
    /**
     * Getter for account minimum balance property
     * @return minimum balance field of Account
     */
    public int getMinBal(){
        return this.minbal;
    }
    
    /**
     * Getter for account balance property
     * @return current account balance
     */
    public int getBal(){
        return this.bal;
    }
    
    /**
     * Getter for account interest rate property
     * @return account interest rate
     */
    public double getIRate(){
        return this.irate;
    }
    
    /**
     * Calculates account balance according to delta
     * Can add a negative amount i.e. 10 + (-5) = 5
     * @param delta amount to change account bal by
     * @return balance account would hold if changed by delta
     */
    public int addBalance(int delta){
        return this.bal+delta;
    }
    
    /**
     * Sets account balance according to amt, which is calculated
     * by addBalance()
     */
    public void setBalance(int amt){
        this.bal=amt;
    }
    
    /**
     * displays pertinent account details.
     * @return A string representation of this account
     */
    @Override
    public String toString(){
        String s= "Welcome to your " + this.getType() + " Account (#" + this.getActNo() + ").\n";
        s+= "You currently have $" + this.getBal() + ".00 (Minimum: $" + this.getMinBal() + ").\n";
        double ir = this.getIRate();
        if(ir>0)
            s+= "You are earning " + ir + "% interest on your money!";
        return s;
    }
    
        
    /** minimum balance a checking account can holdd */
    final private int CHECKING_MIN = 100;
    /** interest rate of a checking account */
    final private double CHECKING_IRATE = 0.0;
    /** minimum balance of a savings account */
    final private int SAVINGS_MIN = 500;
    /** interest rate of a savings account */
    final private double SAVINGS_IRATE = 0.4;

}

