package MerkleTree;

public class Leaf extends MTree{

	private String content;
	
	Leaf(String inp) {
		this.content = inp;
	}
	
	public int getSize() {return 1;}
	public int numnodes() {return 1;}
	
	public boolean ismaxed() {return true;}
	
	public String getHash() {return content;}
	
	public void printTree(int d) {
		System.out.print(d);
		System.out.print("L ");
	 }
}