package MerkelTree;

public class MTree {
	
	private int size = 0;
	private String hash;
	
	private MTree leftTree = null;
	private MTree rightTree = null;
	
	// Child leaves
	private Leaf leftLeaf = null;
	private Leaf rightLeaf = null;
	
	
	//Leaf root = new Leaf("inp");
	
	public MTree() {
		
	}
	
	
	public int getSize() {
		int s = 0;
		if(leftLeaf != null) {s = s + 1;}
		if(rightLeaf != null) {s = s + 1;}
		if(leftTree != null) {s = s + leftTree.getSize();}
		if(rightTree != null) {s = s + rightTree.getSize();}
		return s;
	}
	
	
	
	public void addLeaf(String inp) {
		leftLeaf = new Leaf(inp);
	}
	
	
	public void updateHash() {
		
	}
	
	
	public void crypto(String inp) {
		
	}
	
}
