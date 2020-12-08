/***********************************************
** File:    Driver.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    11/07/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the main driver program for Project 1.
** This is an implementation of a merkle tree to track
 * secure cryptocurrency transactions. Leafs are added 
 * to the tree when a transaction is proccessed. The 
 * hash of the new transaction is calculated and the 
 * hash calculations are updated going up the tree. 
 * Finally, the new hash of the root is updated uniquely, 
 * reflecting the transaction has been processed.
 * 
 * we referenced https://www.geeksforgeeks.org/md5-hash-in-java/ for use of MD5 hashing in Java.
************************************************/
package MerkleTree;
import java.util.*;

public class Driver {

	public static void main(String[] args){
		/*
		String[] names = {"Jeff", "Bob", "Tim", "Greg", "Nick", "Shawn"};
		
		
		MTree<Content> tree = new MTree<Content>();
		
		//System.out.println("size: " + tree.getSize());
		//System.out.println();
		
		// Testing with input file
		FileIO _f = new FileIO();
		_f.ReadFileContent(tree, "input_data.txt");
		System.out.println('\n');
		
		System.out.print("Tree with "+ tree.getSize() + " leaves:  ");
		tree.printTree(0);
		System.out.println();
		
		System.out.println("hash: " + tree.getHash());
		System.out.println();
		tree.printLog();
		
		
		ArrayList<Content> newcontent = new ArrayList<Content>();
		for(int i = 1; i <= 16; i++) {
			//System.out.println("Adding leaf " + i + ":");
			
			String from = names[(int)(Math.random()*(6))];
			
			String to = names[(int)(Math.random()*(6))];
			while(from.equals(to)) {
				to = names[(int)(Math.random()*(6))];
			}

			double amount = Math.round(Math.random() * 10000)/(double)100;
			
			Transaction t = new Transaction(from,to,amount);
			newcontent.add(t);
			//tree.addLeaf(t);
			//System.out.println("size: " + tree.getSize());
			//System.out.println("maxed? " + tree.ismaxed());
			//System.out.println();
		}
		tree.addLeaves(newcontent);
		
		
		System.out.print("Tree with "+ tree.getSize() + " leaves:  ");
		tree.printTree(0);
		System.out.println();
		
		System.out.println("hash: " + tree.getHash());
		System.out.println();
		
		Transaction t = new Transaction("from","to",10.0);
		tree.addLeaf(t);
		
		System.out.print("Tree with "+ tree.getSize() + " leaves:  ");
		tree.printTree(0);
		System.out.println();
		System.out.println("hash: " + tree.getHash());
		System.out.println();
		
		System.out.println("Log of all transactions: ");
		tree.printLog();

		
		_f.WriteFileContent(t, "Wallet.txt", true);
		*/
		MTree<Content> mt = new MTree<Content>();
		InputForm inp = new InputForm(mt);
	}
	
}
