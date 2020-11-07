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

	private String seed;
	
	Transaction(String seed) {
		this.seed = seed;
	}
	protected String getTransaction() {
		return seed;
	}

	protected void setTransaction(String newSeed) {
		seed = newSeed;
	}
	public String ToString() {
		return this.seed;
	}
}
