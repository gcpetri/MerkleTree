package MerkelTree;

public class Driver {

	public static void main(String[] args) {
		
		
		MTree tree = new MTree();
		
		System.out.println(tree.getSize());
		
		tree.addLeaf("test");
		
		System.out.println(tree.getSize());
	}
}
