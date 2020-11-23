package MerkleTree;

public class Transfer extends Content {
	
	Transfer(String toWallet, double amount) {
		super.from = "Transfer";
		super.to = toWallet;
		super.amount = amount;
	}
	
	//NO SETTRANSFER, because transactions should not be changed!
	
	protected String getContent() {
		
		String t = from + " -> $" + amount + " -> " + to;
		return t;
	}

	@Override
	public String toString() {
		String t = from + " -> $" + amount + " -> " + to;
		return t;
	}
	
	
}
