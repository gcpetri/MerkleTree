package MerkleTree;



// CHANGED
public class Transaction {

	private String seed;
	
	Transaction(String seed) {
		this.seed = seed;
	}
	protected String getTransaction() {
		return seed;
	}

	protected void setTransaction(String newSeed) {
		seed = newSeed;
	}
	public String ToString() {
		return this.seed;
	}
}
