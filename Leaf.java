/***********************************************
** File:    Leaf.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    11/07/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the Leaf class for the
** Merkle Tree. 
************************************************/

package MerkleTree;

public class Leaf extends MTree{
	// CHANGED (String -> Transaction)
	private Transaction content;
	
	Leaf(Transaction t) {
		// CHANGED (Transaction(inp))
		
		this.content = t;
	}
	
	public int getSize() {return 1;}
	public int numnodes() {return 1;}
	
	public boolean ismaxed() {return true;}
	
	// CHANGED (ToString())
	public String getHash() {return content.ToString();}
	public String updateHash() {return content.ToString();}
	public void printLog() {System.out.println(this.content.ToString());}
	
	public void printTree(int d) {
		System.out.print(d);
		System.out.print("L ");
	 }
}