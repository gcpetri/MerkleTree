package MerkleTree;

public class Driver {

	public static void main(String[] args) {
		
		
		MTree tree = new MTree();
		
		System.out.println(tree.getSize());
		
		//tree.addLeaf("test");
		
		//System.out.println(tree.ismaxed());
		//System.out.println(tree.getSize());
		//System.out.println();
		
		//tree.addLeaf("test2");
	
		//System.out.println(tree.getSize());
		//System.out.println(tree.ismaxed());
		//System.out.println();
		
		for(int i = 1; i <= 256; i++) {
			System.out.print(i);
			System.out.println(": ");
			
			tree.addLeaf("L");
			
			System.out.println("size: " + tree.getSize());
			System.out.println("maxed? " + tree.ismaxed());
			System.out.println();
		}
		//tree.rightTree.addnodes(1);
		
		tree.printTree(0);
		
		//MTree tes = new MTree();
		//tes.addnodes(5);
		//tes.printTree(0);
	}
	

	
	
}
