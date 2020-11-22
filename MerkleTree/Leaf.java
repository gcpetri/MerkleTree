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

public class Leaf<T> extends MTree{
	
	private T content;
	
	Leaf(T t) {
		
		this.content = t;
	}
	
	public int getSize() {return 1;}
	public int numnodes() {return 1;}
	
	public boolean ismaxed() {return true;}
	
	public String getHash() {return content.toString();}
	public String updateHash() {return content.toString();}
	public void printLog() {System.out.println(this.content.toString());}
	
	public void printTree(int d) {
		System.out.print(d);
		System.out.print("L ");
	 }
}