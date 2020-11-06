package MerkelTree;

public class Leaf {

	private String content;
	
	Leaf(String inp) {
		this.content = inp;
	}
	
	
	public String getHash() {return content;}
	
}
