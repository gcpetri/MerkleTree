package MerkleTree;

public class Leaf extends MTree{
	// CHANGED (String -> Transaction)
	private Transaction content;
	
	Leaf(String inp) {
		// CHANGED (Transaction(inp))
		this.content = Transaction(inp);
	}
	
	public int getSize() {return 1;}
	public int numnodes() {return 1;}
	
	public boolean ismaxed() {return true;}
	
	// CHANGED (ToString())
	public String getHash() {return content.ToString();}
	public String updateHash() {return content.ToString();}
	
	public void printTree(int d) {
		System.out.print(d);
		System.out.print("L ");
	 }
}