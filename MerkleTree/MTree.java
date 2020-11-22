/***********************************************
** File:    MTree.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    11/07/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the MTree class for the
** Merkle Tree.
************************************************/
package MerkleTree;
import java.util.*;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 


public class MTree<T> {
	
	private String hash = "";
	
	private MTree<T> leftTree = null;
	private MTree<T> rightTree = null;
	
	// Child leaves
	//private Leaf leftLeaf = null;
	//private Leaf rightLeaf = null;
	
	
	//Leaf root = new Leaf("inp");
	
	public MTree() {
		
	}
	
	//returns amount of leaf nodes in the tree
	public int getSize() {
		int s = 0;
		if(leftTree != null) {s = s + leftTree.getSize();}
		if(rightTree != null) {s = s + rightTree.getSize();}
		return s;
	}
	
	//returns this nodes hash
	public String getHash() {return hash;}
	
	//returns the number of nodes under a node, not including itself
	public int numnodes() {
		int s = 0;
		if(leftTree != null) {s = s + 1 + leftTree.numnodes();}
		if(rightTree != null) {s = s + 1 + rightTree.numnodes();}
		return s;
	}
	
	public void addleaves(ArrayList<Transaction> transactions) {
		for(int i = 0; i < transactions.size(); i++) {
			this.addLeaf(transactions.get(i));
		}
		
	}
	
	
	//adds the new leaf with a transaction to the tree
	public void addLeaf(Transaction t) {
		if(this.getSize() == 0) {
			leftTree = new Leaf(t);
		}
		else if(this.getSize() == 1) {
			rightTree = new Leaf(t);
		}
		else if(ispowoftwo(this.getSize())) {
			//add this trees children to a new left tree
			MTree<T> m = new MTree<T>();
			m.leftTree = this.leftTree;
			m.rightTree = this.rightTree;
			this.leftTree = m;
			
			//add log2(size) depth tree to the right side
			MTree<T> r = new MTree<T>();
			this.rightTree = r;
			this.rightTree.addnodes(log2(this.getSize())-1);
			//add the node to the the new side of the tree
			rightTree.rippleAddLeaf(t);
		}
		else {
			//add leaf to ?
			//System.out.println("rippadd");
			rightTree.rippleAddLeaf(t);
		}
		//updates trees hash after adding the new node
		this.updateHash();
	}
	
	
	private void rippleAddLeaf(Transaction t) {
		
		//decides whether to traverse left or right tree
		if(leftTree == null || !leftTree.ismaxed()) {
			//if no children, end of the tree is reached, add node
			if(leftTree == null) {
				MTree<T> l = new Leaf(t);
				leftTree = l;
			}
			//if children, repeat to find end of tree
			else { leftTree.rippleAddLeaf(t); }
		}
		
		else {
			//if no children, end of the tree is reached, add node
			if(rightTree == null) {
				MTree<T> r = new Leaf(t);
				rightTree = r;
			}
			//if children, repeat to find end of tree
			rightTree.rippleAddLeaf(t);
		}
		
	}
	
	//recursively add nodes to create tree
	private void addnodes(int depth) {
		if(depth <= 0) {return; }
		MTree<T> l = new MTree<T>();
		MTree<T> r = new MTree<T>();
		this.leftTree = l;
		this.rightTree = r;
		this.leftTree.addnodes(depth - 1);
		this.rightTree.addnodes(depth - 1);
	}
	
	//recursively iterates through tree and calculates its hash values
	public String updateHash() {
		//hash = hash(hash of right node + hash of left node)
		String h = "";
		if(leftTree != null) {h = h + leftTree.updateHash();}
		if(rightTree != null) {h = h + rightTree.updateHash();}
		String newhash = calcHash(h);
		this.hash = newhash;
		return newhash;
	}

	//checks if all nodes below have the maximum amount of leaves
	public boolean ismaxed() {
		if(leftTree != null) {if(!leftTree.ismaxed()) {return false;}}
		else {return false;}
		if(rightTree != null) {if(!rightTree.ismaxed()) {return false;}}
		else {return false;}
		return true;
	}
	
	//prints tree in preorder traversal, leaves are indicated with an L
	public void printTree(int d) {
		 System.out.print(d);
		 System.out.print(" ");
		 if(leftTree != null) {leftTree.printTree(d+1);}
		 if(rightTree != null) {rightTree.printTree(d+1);}
	 }
	 
	//prints all contents of leaf nodes
	 public void printLog() {
		 if(leftTree != null) {leftTree.printLog();}
		 if(rightTree != null) {rightTree.printLog();}
	 }
	
	//returns true if x is a power of 2
	public static boolean ispowoftwo(int x){
		if(x % 2 == 0) {return ispowoftwo(x / 2);}
		if(x == 1) {return true;}
		return false;
	}
	
	//returns log2 of x
	public static int log2(int x) {return (int) (Math.log(x) / Math.log(2));}
	
	//returns MD5 hash of input
	public static String calcHash(String input) { 
	        try { 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            BigInteger bi = new BigInteger(1, messageDigest); 
	  
	            String hash = bi.toString(16); 
	            while (hash.length() < 32) { 
	                hash = "0" + hash; 
	            } 
	            return hash; 
	        }  

	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        }
	 }
	 
	
}
