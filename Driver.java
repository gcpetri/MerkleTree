package MerkleTree;

/* Header:
 * 
 * Cryptocurrency Transaction Merkle Tree
 * 
 * This is an implementation of a merkle tree to track
 * secure cryptocurrency transactions. Leafs are added 
 * to the tree when a transaction is proccessed. The 
 * hash of the new transaction is calculated and the 
 * hash calculations are updated going up the tree. 
 * Finally, the new hash of the root is updated uniquely, 
 * reflecting the transaction has been processed.
 */


public class Driver {

	public static void main(String[] args) {
		
		
		MTree tree = new MTree();
		
		System.out.println(tree.getSize());

		
		for(int i = 1; i <= 32; i++) {
			System.out.print(i);
			System.out.println(": ");
			
			tree.addLeaf("L");
			
			System.out.println("size: " + tree.getSize());
			System.out.println("maxed? " + tree.ismaxed());
			System.out.println();
		}
		
		tree.printTree(0);
		System.out.println();
		
		System.out.println(tree.getHash());
		tree.addLeaf("L");
		System.out.println(tree.getHash());
		
	}


}
