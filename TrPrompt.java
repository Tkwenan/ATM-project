import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Handles prompting user for transaction inputs to process and perform
 * transactions
 * @author Benj Prud'homme
 */
public class TrPrompt extends JFrame
{
    /**
     * The ATM object containing the account to perform a transaction on.
     */
    private ATM atmMachine;
    /**
     * The account to perform a transaction on.
     */
    private Account curAct;
    /**
     * The type of transaction to perform.
     */
    private String trType;
    
    // Window components
    /**
     * Panel containing the prompt "Enter PIN:" followed by a text box.
     */
    private JPanel pinPanel;
    /**
     * Label for the PIN prompt.
     */
    private JLabel pinLabel;
    /**
     * Input field for the user to enter their PIN.
     */
    private JTextField pinTextBox;

    /**
     * Panel containing the prompt "Enter transaction amount:" followed by a text box.
     */
    private JPanel amtPanel;
    /**
     * Label for the amount prompt.
     */
    private JLabel amtLabel;
    /**
     * Input field for the user to enter the transaction amount.
     */
    private JTextField amtTextBox;

    /**
     * Panel for the OK and Cancel buttons.
     */
    private JPanel buttonPanel;
    /**
     * Cancel button: closes window and performs no action
     */
    private JButton trCancelButton;
    /**
     * OK button: closes window and performs transaction with the provided PIN and amount 
     */
    private JButton trOKButton;
    
    /**
     * Constructor for objects of class TrPrompt
     * @param atmMchn The ATM object containing the account the user selected.
     * @param aAct The account to perform a transaction on.
     * @param trTypex The type of this transaction.
     */
    public TrPrompt(ATM atmMchn, Account aAct, String trTypex)
    {
        atmMachine = atmMchn;
        curAct = aAct;
        trType = trTypex;
        
        // Initialize window
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        pinPanel = new JPanel();
        pinLabel = new JLabel("Enter your account PIN:");
        pinTextBox = new JTextField(15);
        pinPanel.add(pinLabel);
        pinPanel.add(pinTextBox);
        getContentPane().add(pinPanel);
        
        amtPanel = new JPanel();
        amtLabel = new JLabel("Enter transaction amount:");
        amtTextBox = new JTextField(15);

        // Inquiry prompts don't need an amount field
        if(!trTypex.equals("Inquiry")){
            amtPanel.add(amtLabel);
            amtPanel.add(amtTextBox);
            getContentPane().add(amtPanel);
        }
        
        buttonPanel = new JPanel();

        trCancelButton = new JButton("Cancel");
        trOKButton = new JButton("OK");

        trCancelButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent event){
                    setVisible(false);
                }
            });

        trOKButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    setVisible(false);
                    performTransaction();
                }
            
            });

        buttonPanel.add(trCancelButton);
        buttonPanel.add(trOKButton);
        getContentPane().add(buttonPanel);

        pack();
        setVisible(true);
    }
    
    
    /**
     * Carries out the transaction which the user has provided.
     */
    public void performTransaction(){
        Transaction tr = new Withdrawal(null, "", "");
        String inputpin = pinTextBox.getText();
        String inputamt = amtTextBox.getText();

        switch(trType){
            case "Withdrawal":
                tr = new Withdrawal(curAct, inputpin, inputamt);
                break;
            case "Deposit":
                tr = new Deposit(curAct, inputpin, inputamt);
                break;
            case "Inquiry":
                tr = new Inquiry(curAct, inputpin);
                break;
            case "Transfer":
                if(this.curAct.equals(atmMachine.getCheckingAct()))
                    tr = new Transfer(atmMachine.getCurAct(), atmMachine.getSavingsAct(), inputpin, inputamt);
                else
                    tr = new Transfer(atmMachine.getCurAct(), atmMachine.getCheckingAct(), inputpin, inputamt);
                break;
        }
        tr.processTransaction().display();
    }
}
