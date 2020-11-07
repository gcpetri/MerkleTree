package MerkleTree;




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
