import javax.swing.*;
/**
 * Provides icons and text to update users on the status
 * of their transactions.
 * Image Icons used from openclipart.org freely available images by Antares42
 * @author Aaron Mahr
 */
public class Message
{
    /** signfiying a transaction as successful(#t)/failing(#f) */
    Boolean type;
    /** actual message to be displayed */
    String message;
    /** display image depending on Message.type*/
    String icon;
    /** the transaction the Message is being used for */
    Transaction tr;

    /**
     * Constructor for objects of class Message
     * @param code error message code to provide
     */
    public Message(int code){

        this.type = (code==1); //set type
        this.setIcon();

        switch(code){ //set message
            case 1:
            this.message="Transaction Successful!";
            break;
            case 2:
            this.message="Invalid PIN format";
            break;
            case 3:
            this.message="Invalid Amount format";
            break;
            case 4:
            this.message="Incorrect PIN";
            break;
            case 5:
            this.message="Illegal amount, see current and minimum balance";
            break;
        }

    }

    /**
     * Constructor for objects of type Message,
     * message determined by message code.
     * @param code error code to pass
     * @param t Transaction performed
     */
    public Message(int code, Transaction t){

        this.type = (code==1); //set type
        this.setIcon();
        this.tr=t;
        String name=this.tr.getClass().getSimpleName();
        this.message = name+ " Failed:\n";

        switch(code){ //set message
            case 1:
            this.tr=t;
            this.message=name+" Successful!\n"+this.tr.toString();
            break;
            case 2:
            this.message+="Invalid PIN format";
            break;
            case 3:
            this.message+="Invalid Amount format";
            break;
            case 4:
            this.message+="Incorrect PIN";
            break;
            case 5:
            this.message+="Illegal amount, see current and minimum balance";
            break;
        }

    }

    /**
     * Determines image to use based on message type.
     * Use image height of 90px
     */
    public void setIcon(){
        this.icon = this.type ? "GreenSuccessIcon.png" : "RedFailIcon.png";
    }

    /**
     * Displays message dialog box
     */
    public void display(){
        JOptionPane.showMessageDialog(
            null, 
            this.message,
            "Transaction Status",
            JOptionPane.INFORMATION_MESSAGE,
            new ImageIcon(this.icon));
    }

}


    


