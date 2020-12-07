package MerkleTree;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class InputForm extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private Container c;
	private JLabel LBLTo;
	private JLabel LBLFrom;
	private JLabel LBLAmount;
	private JTextField TXTToName;
	private JTextField TXTFromName;
	private JTextField TXTamount;
	private JButton BTNconfirm;
	private JButton BTNclear;
	private JButton BTNshowLog;
	private JButton BTNcloseLog;
	private JLabel LBLtype;
	private JRadioButton BTNtransaction;
	private JRadioButton BTNtransfer;
	private MTree<Content> tree;
	private JTextField history;
	private ButtonGroup bg;

	public InputForm(MTree<Content> t) {
		this.tree = t;
		setTitle("Secure Crytocurrency Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 90, 900, 600); 
		setResizable(false);
		c = getContentPane(); 
		//c.setLayout(null);
		
		this.LBLtype = new JLabel("Exchange Type"); // label for exchange type
		LBLtype.setFont(new Font("Arial", Font.PLAIN, 15)); 
		LBLtype.setLocation(400,50);
		LBLtype.setSize(200,30);
		c.add(LBLtype);
		this.BTNtransaction = new JRadioButton("Transaction"); // transaction button
		BTNtransaction.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNtransaction.setLocation(400, 85);
		LBLtype.setSize(200,30);
		BTNtransaction.setSelected(true);
		c.add(BTNtransaction);
		this.BTNtransfer = new JRadioButton("Transfer"); // transfer button
		BTNtransfer.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNtransfer.setLocation(400, 85);
		LBLtype.setSize(200,30);
		BTNtransfer.setSelected(false);
		c.add(BTNtransfer);
		this.bg = new ButtonGroup();
		bg.add(BTNtransaction);
		bg.add(BTNtransfer);
		this.LBLTo = new JLabel("Send To"); // label for recipient
		LBLTo.setFont(new Font("Arial", Font.PLAIN, 15));
		LBLTo.setLocation(200,110);
		LBLtype.setSize(200,30);
		c.add(LBLTo);
		this.LBLFrom = new JLabel("From"); // label for sender
		LBLFrom.setFont(new Font("Arial", Font.PLAIN, 15));
		LBLFrom.setLocation(400,110);
		LBLtype.setSize(200,30);
		c.add(LBLFrom);
		this.LBLAmount = new JLabel("Amount"); // label for amount to exchange
		LBLAmount.setFont(new Font("Arial", Font.PLAIN, 15));
		LBLAmount.setLocation(300,300);
		LBLtype.setSize(200,30);
		c.add(LBLAmount);
		this.TXTFromName = new JTextField(); // input for sender
		TXTFromName.setFont(new Font("Arial", Font.PLAIN, 15));
		TXTFromName.setLocation(400,145);
		LBLtype.setSize(200,30);
		c.add(TXTFromName);
		this.TXTToName = new JTextField(); // input for recipient
		TXTToName.setFont(new Font("Arial", Font.PLAIN, 15));
		TXTToName.setLocation(200, 145);
		LBLtype.setSize(200,30);
		c.add(TXTToName);
		this.TXTamount = new JTextField(); // input for amount
		TXTamount.setFont(new Font("Arial", Font.PLAIN, 15));
		TXTamount.setLocation(300, 335);
		LBLtype.setSize(200,30);
		c.add(TXTamount);
		this.BTNclear = new JButton("Clear"); // clear button
		BTNclear.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNclear.setLocation(125,400);
		LBLtype.setSize(200,30);
		BTNclear.addActionListener(this);
		c.add(BTNclear);
		this.BTNconfirm = new JButton("Confirm"); // confirm button
		BTNconfirm.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNconfirm.setLocation(150,400);
		LBLtype.setSize(200,30);
		BTNconfirm.addActionListener(this);
		c.add(BTNconfirm);
		this.history = new JTextField(); // log history text
		history.setFont(new Font("Arial", Font.PLAIN, 15));
		history.setSize(400,500);
		history.setLocation(300,300);
		history.setEditable(false);
		history.setVisible(false);
		c.add(history);
		this.BTNshowLog = new JButton("Show Your Exchange Log"); // show log history button
		BTNshowLog.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNshowLog.setLocation(20, 40);
		LBLtype.setSize(200,30);
		BTNshowLog.addActionListener(this);
		c.add(BTNshowLog);
		this.BTNcloseLog = new JButton("Close Log"); // close the log
		BTNcloseLog.setFont(new Font("Arial", Font.PLAIN, 15));
		BTNcloseLog.setLocation(50,10);
		LBLtype.setSize(200,30);
		BTNcloseLog.addActionListener(this);
		BTNcloseLog.setVisible(false);
		c.add(BTNcloseLog);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getSource() == BTNtransaction) {
			BTNtransaction.setSelected(true);
			BTNtransfer.setSelected(false);
			LBLFrom.setVisible(true);
			TXTFromName.setVisible(true);
		} else if (e.getSource() == BTNtransfer) {
			BTNtransaction.setSelected(false);
			BTNtransfer.setSelected(true);
			LBLFrom.setVisible(false);
			TXTFromName.setVisible(false);
		} else if (e.getSource() == BTNclear) {
			TXTFromName.setText("");
			TXTToName.setText("");
			TXTamount.setText("");
		} else if (e.getSource() == BTNconfirm) {
			if (TXTToName.getText() == "") {
				JOptionPane.showMessageDialog(null, "Error", "Send to is a required field", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (BTNtransaction.isSelected()) {
				if (TXTFromName.getText() == "") {
					JOptionPane.showMessageDialog(null, "Error", "From is a required field", JOptionPane.ERROR_MESSAGE);
					return;
				}
				double amt;
				try {
					amt = Double.parseDouble(TXTamount.getText());
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error", "Amount is not a number", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Transaction t = new Transaction(TXTFromName.getText(), TXTToName.getText(), amt);
				this.tree.addLeaf(t);

			} else {
				double amt;
				try {
					amt = Double.parseDouble(TXTamount.getText());
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Error", "Amount is not a number", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Transfer t = new Transfer(TXTToName.getText(), amt);
				this.tree.addLeaf(t);
			}
			String submit = TXTFromName.getText() + " -> $" + TXTamount.getText() + " -> " + TXTToName.getText();
			JOptionPane.showMessageDialog(null, "Exchange Processed", submit, JOptionPane.INFORMATION_MESSAGE);
		    TXTFromName.setText("");
			TXTToName.setText("");
			TXTamount.setText("");
		} else if (e.getSource() == BTNshowLog) {
			TXTFromName.setVisible(false);
			TXTToName.setVisible(false);
			TXTamount.setVisible(false);
			LBLTo.setVisible(false);
			LBLFrom.setVisible(false);
			LBLAmount.setVisible(false);
			BTNtransaction.setVisible(false);
			BTNtransfer.setVisible(false);
			LBLtype.setVisible(false);
			BTNclear.setVisible(false);
			BTNconfirm.setVisible(false);
			history.setText(this.tree.getStringLog());
			history.setVisible(true);
			BTNcloseLog.setVisible(true);
		} else if (e.getSource() == BTNcloseLog) {
			TXTFromName.setVisible(true);
			TXTToName.setVisible(true);
			TXTamount.setVisible(true);
			LBLTo.setVisible(true);
			LBLFrom.setVisible(true);
			LBLAmount.setVisible(true);
			BTNtransaction.setVisible(true);
			BTNtransfer.setVisible(true);
			LBLtype.setVisible(true);
			BTNclear.setVisible(true);
			BTNconfirm.setVisible(true);
			history.setText("");
			history.setVisible(false);
			BTNcloseLog.setVisible(false);
		}*/
	}
}
