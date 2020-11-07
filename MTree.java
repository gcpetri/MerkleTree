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
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 


public class MTree {
	
	private int size = 0;
	private String hash = "";
	
	private MTree leftTree = null;
	private MTree rightTree = null;
	
	// Child leaves
	//private Leaf leftLeaf = null;
	//private Leaf rightLeaf = null;
	
	
	//Leaf root = new Leaf("inp");
	
	public MTree() {
		
	}
	
	
	public int getSize() {
		int s = 0;
		if(leftTree != null) {s = s + leftTree.getSize();}
		if(rightTree != null) {s = s + rightTree.getSize();}
		return s;
	}
	
	public String getHash() {return hash;}
	
	public int numnodes() {
		int s = 0;
		if(leftTree != null) {s = s + 1 + leftTree.numnodes();}
		if(rightTree != null) {s = s + 1 + rightTree.numnodes();}
		return s;
	}
	
	public void addLeaf(Transaction t) {
		if(this.getSize() == 0) {
			MTree leaf = new Leaf(t);
			leftTree = new Leaf(t);
		}
		else if(this.getSize() == 1) {
			MTree leaf = new Leaf(t);
			rightTree = new Leaf(t);
		}
		else if(ispowoftwo(this.getSize())) {
			//add this trees children to a new left tree

			MTree m = new MTree();
			m.leftTree = this.leftTree;
			m.rightTree = this.rightTree;
			this.leftTree = m;
			
			//add log2(size) depth tree to the right side
			MTree r = new MTree();
			this.rightTree = r;

			this.rightTree.addnodes(log2(this.getSize())-1);
			rightTree.rippleAddLeaf(t);
			
		}
		else {
			//add leaf to ?
			//System.out.println("rippadd");
			rightTree.rippleAddLeaf(t);
		}
		this.updateHash();
	}
	
	
	private void rippleAddLeaf(Transaction t) {

		if(leftTree == null || !leftTree.ismaxed()) {
			if(leftTree == null) {

				MTree l = new Leaf(t);
				leftTree = l;
			}
			else { leftTree.rippleAddLeaf(t); }
		}
		
		else {
			
			if(rightTree == null) {
				MTree r = new Leaf(t);
				rightTree = r;
			}
			rightTree.rippleAddLeaf(t);
		}
		
	}
	
	
	private void addnodes(int depth) {
		if(depth <= 0) {return; }
		MTree l = new MTree();
		MTree r = new MTree();
		this.leftTree = l;
		this.rightTree = r;
		this.leftTree.addnodes(depth - 1);
		this.rightTree.addnodes(depth - 1);
	}
	
	public String updateHash() {
		//hash = hash(hash of right node + hash of left node)
		String h = "";
		if(leftTree != null) {h = h + leftTree.updateHash();}
		if(rightTree != null) {h = h + rightTree.updateHash();}
		String newhash = calcHash(h);
		this.hash = newhash;
		return newhash;
	}

	
	public boolean ismaxed() {
		if(leftTree != null) {if(!leftTree.ismaxed()) {return false;}}
		else {return false;}
		if(rightTree != null) {if(!rightTree.ismaxed()) {return false;}}
		else {return false;}
		return true;
	}
	
	
	public void printTree(int d) {
		 System.out.print(d);
		 System.out.print(" ");
		 if(leftTree != null) {leftTree.printTree(d+1);}
		 if(rightTree != null) {rightTree.printTree(d+1);}
	 }
	 
	 public void printLog() {
		 if(leftTree != null) {leftTree.printLog();}
		 if(rightTree != null) {rightTree.printLog();}
	 }
	
	public static boolean ispowoftwo(int x){
		if(x % 2 == 0) {return ispowoftwo(x / 2);}
		if(x == 1) {return true;}
		return false;
	}
	
	public static int log2(int x) {return (int) (Math.log(x) / Math.log(2));}
	
	
	 public static String calcHash(String input) { 
	        try { 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }  

	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        }
	 }
	 
	
}
