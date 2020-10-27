import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Driver method of program overseeing execution flow
 * @author Benj Prud'homme, Aaron Mahr
 */
public class ATMDriver
{
    /**
     * Driver class for the program.
     * @param args Command-line arguments
     */
    public static void main(String[] args){
        //Main Execution Flow:
        //construct object ATM
        //construct windows for user
        //await input
        //

        ATM myATM = new ATM();

        JFrame window = new JFrame("ATM Account Services");
        window.setSize(400,170);
        window.setLocationRelativeTo(null);

        JPanel content = new JPanel();

        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); //to manage properties
                                                    //of gridbag items

        JButton savButton = new JButton("Savings");
        JButton checkButton = new JButton("Checking");

        ActionListener accountSelector = new ActionListener(){ //turns off selected button, sets curAct

                public void actionPerformed(ActionEvent e) {
                    savButton.setEnabled(!savButton.isEnabled());
                    checkButton.setEnabled(!checkButton.isEnabled());

                    if(savButton.isEnabled())
                        myATM.setCurAct(myATM.getCheckingAct());
                    else myATM.setCurAct(myATM.getSavingsAct());
                }
            };

        savButton.setActionCommand("Savings");
        checkButton.setActionCommand("Checking");
        savButton.addActionListener(accountSelector);
        checkButton.addActionListener(accountSelector);

        checkButton.setEnabled(false); //start with checking selected

        //c.fill=GridBagConstraints.HORIZONTAL;
        c.weightx=1;
        c.ipady=50; //element height
        c.ipadx=110; //element width
        c.gridy=0;  //element coordinate y
        c.gridx=0;  //element coordinate x
        c.gridwidth=2; //coordinates taken up
        content.add(savButton,c);
        c.gridx=2; //reset coord x
        content.add(checkButton,c);

        ActionListener al = new ActionListener(){ //sets transac type and performs selected transac
                public void actionPerformed(ActionEvent e){
                    final String name = e.getActionCommand();
                    myATM.setTrType(name);
                    TrPrompt promptDialog = new TrPrompt(myATM, myATM.getCurAct(), myATM.getTrType());
                }
            };

        JButton depButton = new JButton("Deposit");
        depButton.addActionListener(al);
        depButton.setActionCommand("Deposit");
        c.gridwidth=1; //reset coords taken
        c.ipady=25; //reset button size
        c.ipadx=50;
        c.gridy=1; //set button coords
        c.gridx=0;
        content.add(depButton,c);

        JButton witButton = new JButton("Withdrawal");
        witButton.addActionListener(al);
        witButton.setActionCommand("Withdrawal");
        c.gridx=1; //set coords
        content.add(witButton,c);

        JButton traButton = new JButton("Transfer");
        traButton.addActionListener(al);
        traButton.setActionCommand("Transfer");
        c.gridx=2;
        content.add(traButton,c);

        JButton inqButton = new JButton("Inquiry");
        inqButton.addActionListener(al);
        inqButton.setActionCommand("Inquiry");
        c.gridx=3;
        content.add(inqButton,c);  

        window.setContentPane(content);
        window.setVisible(true);
        window.toFront();

    }
}
