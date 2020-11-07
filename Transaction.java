/***********************************************
** File:    Transaction.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    11/07/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the Transaction class for
** the Merkle Tree.
************************************************/

package MerkleTree;



// CHANGED
public class Transaction {

	private String fromWallet;
	private String toWallet;
	private double amount;
	private int number; 
	
	
	
	Transaction(String fromWallet, String toWallet, double amount) {
		this.fromWallet = fromWallet;
		this.toWallet = toWallet;
		this.amount = amount;
	}
	
	protected String getTransaction() {
		String t = fromWallet + " -> $" + amount + " -> " + toWallet;
		return t;
	}

	
	public String ToString() {
		String t = fromWallet + " -> $" + amount + " -> " + toWallet;
		return t;
	}
}
