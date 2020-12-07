package MerkleTree;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class InputForm extends JFrame implements ActionListener {
	
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
	private MTree tree;
	private JTextField history;

	public InputForm(MTree t) {
		this.tree = t;
		setTitle("Secure Crytocurrency Application");
		setBounds(300, 90, 900, 600); 
		setResizable(false);
		c = getContentPane(); 
		c.setLayout(null);
		this.LBLtype = new JLabel("Exchange Type"); // label for exchange type
		LBLtype.setLocation(300,50);
		c.add(LBLtype);
		this.BTNtransaction = new JRadioButton("Transaction"); // transaction button
		BTNtransaction.setLocation(200, 75);
		BTNtransaction.setSelected(true);
		c.add(BTNtransaction);
		this.BTNtransfer = new JRadioButton("Transfer"); // transfer button
		BTNtransfer.setLocation(400, 75);
		BTNtransfer.setSelection(false);
		c.add(BTNtransfer);
		this.LBLTo = new JLabel("Send To"); // label for recipient
		LBLTo.setLocation(200,100);
		c.add(LBLTo);
		this.LBLFrom = new JLabel("From"); // label for sender
		LBLFrom.setLocation(400,100);
		c.add(LBLFrom);
		this.LBLAmount = new JLabel("Amount"); // label for amount to exchange
		LBLAmount.setLocation(300,300);
		c.add(LBLAmount);
		this.TXTFromName = new JTextField(); // input for sender
		TXTFromName.setLocation(400,125);
		c.add(TXTFromName);
		this.TXTToName = new JTextField(); // input for recipient
		TXTToName.setLocation(200, 125);
		c.add(TXTToName);
		this.TXTamount = new JTextField(); // input for amount
		TXTamount.setLocation(300, 325);
		c.add(TXTamount);
		this.BTNclear = new JButton("Clear"); // clear button
		BTNclear.setLocation(125,400);
		BTNclear.addActionListener(this);
		c.add(BTNclear);
		this.BTNconfirm = new JButton("Confirm"); // confirm button
		BTNconfirm.setLocation(150,400);
		BTNconfirm.addActionListener(this);
		c.add(BTNconfirm);
		this.history = new JTextField(); // log history text
		history.setSize(400,500);
		history.setLocation(300,300);
		history.setEditable(false);
		history.setVisible(false);
		c.add(history);
		this.BTNshowLog = new JButton("Show Your Exchange Log"); // show log history button
		BTNshowLog.setLocation(200, 400);
		BTNshowLog.addActionListener(this);
		c.add(BTNshowLog);
		this.BTNcloseLog = new JButton("Close Log"); // close the log
		BTNcloseLog.setLocation(500,100);
		BTNcloseLog.addActionListener(this);
		BTNcloseLog.setVisible(false);
		c.add(BTNcloseLog);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BTNtransaction) {
			BTNtransaction.setSelected(true);
			BTNtransfer.setSelection(false);
			LBLFrom.setVisible(true);
			TXTFromName.setVisible(true);
		} else if (e.getSource() == BTNtransfer) {
			BTNtransaction.setSelected(false);
			BTNtransfer.setSelection(true);
			LBLFrom.setVisible(false);
			TXTFromName.setVisible(false);
		} else if (e.getSource() == BTNclear) {
			TXTFromName.setText("");
			TXTToNmae.setText("");
			TXTamount.setText("");
		} else if (e.getSource() == BTNconfirm) {
			if (BTNtransaction.isSelected()) {
				Transaction t = new Transaction(TXTFromName.getText(), TXTToName.getText(), TXTamount.getText());
				this.tree.addLeaf(t);
			} else {
				Transfer t = new Transfer(TXTToName.getText(), TXTamount.getText());
				this.tree.addLeaf(t);
			}
			String submit = TXTFromName.getText() + " -> $" + TXTamount.getText() + " -> " + TXTToName.getText();
			JOptionPane.showMessageDialog(null, "Exchange Processed", submit, JOptionPane.INFORMATION_MESSAGE);
		    TXTFromName.setText("");
			TXTToNmae.setText("");
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
			history.setText(this.tree.printLog());
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
		}
	}
}
