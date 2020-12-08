/***********************************************
** File:    InputForm.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    12/08/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the UI for user to input 
** and track crytocurrency exchanges
************************************************/
package MerkleTree;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
	private JTextArea history;
	private ButtonGroup bg;
	private JPanel p0; // panel for title
	private JPanel p1; // panel for type
	private JPanel p2; // panel for exchange
	private JPanel p3; // panel for buttons
	private JPanel p4; // panel for history
	private JTextField hashValue;

	public InputForm(MTree<Content> t) {
		this.tree = t;
		setTitle("Secure Crytocurrency Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 90, 900, 600); 
		setResizable(false);
		c = getContentPane(); 
		c.setLayout(new GridLayout(4,1));
		EmptyBorder innerBorder = new EmptyBorder(20,50,20,20);
		// p0 #################
		this.p0 = new JPanel();
		p0.setLayout(new GridLayout(1,0));
		JLabel LBLTitle = new JLabel("One-stop for your Cryptocurrency Exchanges");
		LBLTitle.setFont(new Font("Monospaced", Font.BOLD, 26)); 
		LBLTitle.setBorder(new EmptyBorder(30,110,0,30));
		p0.setBackground(new Color(83, 123, 245, 100));
		p0.add(LBLTitle);
		c.add(p0);
		// p1 #################
		this.p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBorder(new EmptyBorder(30,30,30,30));
		p1.setBackground(new Color(10,40,130,100));
		this.LBLtype = new JLabel(" Exchange Type"); // label for exchange type
		LBLtype.setFont(new Font("Monospaced", Font.PLAIN, 25)); 
		//LBLtype.setLocation(400,50);
		//LBLtype.setSize(200,30);
		//LBLtype.setBorder(innerBorder);
		p1.add(LBLtype, BorderLayout.NORTH);
		this.BTNtransaction = new JRadioButton("Transaction"); // transaction button
		BTNtransaction.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNtransaction.setLocation(400, 85);
		//BTNtransaction.setSize(200,30);
		BTNtransaction.setSelected(true);
		BTNtransaction.setBorder(new EmptyBorder(0,200,0,0));
		BTNtransaction.addActionListener(this);
		c.add(BTNtransaction);
		p1.add(BTNtransaction, BorderLayout.CENTER);
		this.BTNtransfer = new JRadioButton("Transfer"); // transfer button
		BTNtransfer.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNtransfer.setLocation(400, 85);
		//BTNtransfer.setSize(200,30);
		BTNtransfer.setSelected(false);
		BTNtransfer.setBorder(new EmptyBorder(0,0,0,200));
		BTNtransfer.addActionListener(this);
		p1.add(BTNtransfer, BorderLayout.EAST);
		this.bg = new ButtonGroup();
		bg.add(BTNtransaction);
		bg.add(BTNtransfer);
		c.add(p1);
		// p2 ################
		this.p2 = new JPanel();
		p2.setLayout(new GridLayout(3,2));
		p2.setBorder(new EmptyBorder(30,30,30,30));
		this.LBLTo = new JLabel("Send To"); // label for recipient
		LBLTo.setFont(new Font("Monospaced", Font.PLAIN, 20));
		LBLTo.setLocation(100,110);
		//LBLTo.setSize(200,30);
		LBLTo.setBorder(new EmptyBorder(0,250,0,20));
		this.LBLFrom = new JLabel("From"); // label for sender
		LBLFrom.setFont(new Font("Monospaced", Font.PLAIN, 20));
		LBLFrom.setLocation(400,110);
		//LBLFrom.setSize(200,30);
		LBLFrom.setBorder(new EmptyBorder(0,250,0,20));
		p2.add(LBLFrom);
		this.LBLAmount = new JLabel("Amount"); // label for amount to exchange
		LBLAmount.setFont(new Font("Monospaced", Font.PLAIN, 20));
		LBLAmount.setLocation(300,300);
		//LBLAmount.setSize(200,30);
		LBLAmount.setBorder(new EmptyBorder(0,250,0,20));
		this.TXTFromName = new JTextField(); // input for sender
		TXTFromName.setFont(new Font("Monospaced", Font.PLAIN, 15));
		TXTFromName.setLocation(400,145);
		TXTFromName.setSize(200,10);
		TXTFromName.addActionListener(this);
		//TXTFromName.setBackground(new Color(50,111,30,10));
		TXTFromName.setBorder(new EmptyBorder(0,20,0,20));
		TXTFromName.setForeground(new Color(10,10,10,150));
		p2.add(TXTFromName);
		p2.add(LBLTo);
		this.TXTToName = new JTextField(); // input for recipient
		TXTToName.setFont(new Font("Monospaced", Font.PLAIN, 15));
		TXTToName.setLocation(200, 145);
		//TXTToName.setSize(200,30);
		TXTToName.addActionListener(this);
		TXTToName.setBorder(new EmptyBorder(0,20,0,20));
		TXTToName.setForeground(new Color(10,10,10,150));
		p2.add(TXTToName);
		this.TXTamount = new JTextField(); // input for amount
		TXTamount.setFont(new Font("Monospaced", Font.PLAIN, 15));
		TXTamount.setLocation(300, 335);
		TXTamount.setForeground(new Color(10,10,10,150));
		TXTamount.addActionListener(this);
		//TXTamount.setSize(200,30);
		TXTamount.setBorder(new EmptyBorder(0,20,0,20));
		p2.add(LBLAmount);
		p2.add(TXTamount);
		c.add(p2);
		// p3 #####################
		this.p3 = new JPanel();
		p3.setLayout(new GridLayout(1,3));
		p3.setBorder(new EmptyBorder(30,30,30,30));
		p3.setBackground(new Color(100,40,110,100));
		this.BTNclear = new JButton("Clear"); // clear button
		BTNclear.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNclear.setLocation(125,400);
		BTNclear.setSize(10,10);
		BTNclear.setBorder(innerBorder);
		BTNclear.setOpaque(true);
		BTNclear.setBackground(Color.lightGray);
		BTNclear.setForeground(Color.WHITE);
		BTNclear.addActionListener(this);
		p3.add(BTNclear);
		//p3.add(space);
		this.BTNconfirm = new JButton("Confirm"); // confirm button
		BTNconfirm.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNconfirm.setLocation(150,400);
		BTNconfirm.setSize(10,10);
		BTNconfirm.setBorder(innerBorder);
		BTNconfirm.setOpaque(true);
		BTNconfirm.setBackground(Color.GRAY);
		BTNconfirm.setForeground(Color.WHITE);
		BTNconfirm.addActionListener(this);
		p3.add(BTNconfirm);
		//p3.add(space);
		// p4 ################
		this.p4 = new JPanel();
		p4.setLayout(new BorderLayout());
		this.history = new JTextArea(); // log history text
		history.setFont(new Font("Monospace", Font.PLAIN, 15));
		history.setSize(10,10);
		//history.setLocation(300,300);
		history.setEditable(false);
		p4.add(history, BorderLayout.CENTER);
		p4.setBackground(new Color(100,110,220,100));
		this.BTNshowLog = new JButton("Show Your Exchange Log"); // show log history button
		BTNshowLog.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNshowLog.setLocation(20, 40);
		BTNshowLog.setSize(10,10);
		BTNshowLog.setBorder(innerBorder);
		BTNshowLog.setOpaque(true);
		BTNshowLog.setBackground(Color.BLACK);
		BTNshowLog.setForeground(Color.WHITE);
		BTNshowLog.addActionListener(this);
		p3.add(BTNshowLog);
		c.add(p3);
		this.BTNcloseLog = new JButton("Close Log"); // close the log
		BTNcloseLog.setFont(new Font("Monospaced", Font.PLAIN, 15));
		//BTNcloseLog.setLocation(50,10);
		BTNcloseLog.setSize(100,30);
		BTNcloseLog.addActionListener(this);
		p4.add(BTNcloseLog, BorderLayout.EAST);
		this.hashValue = new JTextField();
		hashValue.setFont(new Font("Monospaced", Font.ITALIC, 14));
		p4.add(hashValue, BorderLayout.SOUTH);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BTNtransaction) {
			LBLFrom.setVisible(true);
			TXTFromName.setVisible(true);
		} else if (e.getSource() == BTNtransfer) {
			LBLFrom.setVisible(false);
			TXTFromName.setVisible(false);
		} else if (e.getSource() == BTNclear) {
			TXTFromName.setText("");
			TXTToName.setText("");
			TXTamount.setText("");
		} else if (e.getSource() == BTNconfirm) {
			if (TXTToName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Error", "Send to is a required field", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (BTNtransaction.isSelected()) {
				if (TXTFromName.getText().isEmpty()) {
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
			if (BTNtransaction.isSelected()) { TXTFromName.setText(TXTToName.getText()); }
			String submit = TXTFromName.getText() + " -> $" + TXTamount.getText() + " -> " + TXTToName.getText();
			JOptionPane.showMessageDialog(null, "Exchange Processed", submit, JOptionPane.INFORMATION_MESSAGE);
		    TXTFromName.setText("");
			TXTToName.setText("");
			TXTamount.setText("");
		} else if (e.getSource() == BTNshowLog) {
			setVisible(false);
			history.setText('\n'+ this.tree.getStringLog());
			hashValue.setText("  Root Hash  ::  " + this.tree.getHash());
			p4.setVisible(true);
			c.remove(p0);
			c.remove(p1);
			c.remove(p2);
			c.remove(p3);
			c.setLayout(new BorderLayout());
			c.add(p0, BorderLayout.NORTH);
			c.add(p4, BorderLayout.CENTER);
			setVisible(true);
		} else if (e.getSource() == BTNcloseLog) {
			setVisible(false);
			c.remove(p0);
			c.remove(p4);
			c.setLayout(new GridLayout(4,1));
			c.add(p0);
			c.add(p1);
			c.add(p2);
			c.add(p3);
			history.setText("");
			setVisible(true);
		} else if (e.getSource() == TXTFromName) {
			LBLFrom.setFont(new Font("Monospaced", Font.BOLD, 25));
			LBLTo.setFont(new Font("Monospaced", Font.PLAIN, 20));
			LBLAmount.setFont(new Font("Monospaced", Font.PLAIN, 20));
		} else if (e.getSource() == TXTToName) {
			LBLFrom.setFont(new Font("Monospaced", Font.PLAIN, 20));
			LBLTo.setFont(new Font("Monospaced", Font.BOLD, 25));
			LBLAmount.setFont(new Font("Monospaced", Font.PLAIN, 20));
		} else if (e.getSource() == TXTamount) {
			LBLFrom.setFont(new Font("Monospaced", Font.PLAIN, 20));
			LBLTo.setFont(new Font("Monospaced", Font.PLAIN, 20));
			LBLAmount.setFont(new Font("Monospaced", Font.BOLD, 25));
		}
	}
}