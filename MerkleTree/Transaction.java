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



public class Transaction extends Content {
	
	Transaction(String fromWallet, String toWallet, double amount) {
		super.from = fromWallet;
		super.to = toWallet;
		super.amount = amount;
	}
	
	//NO SETTRANSACTION, because transactions should not be changed!
	
	protected String getContent() {
		String t = from + " -> $" + amount + " -> " + to;
		return t;
	}

	@Override
	public String toString() {
		String t = from + " -> $" + amount + " -> " + to;
		return t;
	}
}
