package MerkleTree;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class MTree {
	
	private int size = 0;
	private String hash = "";
	
	private MTree leftTree = null;
	private MTree rightTree = null;
	
	// Child leaves
	//private Leaf leftLeaf = null;
	//private Leaf rightLeaf = null;
	
	
	//Leaf root = new Leaf("inp");
	
	public MTree() {
		
	}
	
	
	public int getSize() {
		int s = 0;
		if(leftTree != null) {s = s + leftTree.getSize();}
		if(rightTree != null) {s = s + rightTree.getSize();}
		return s;
	}
	
	public String getHash() {return hash;}
	
	public int numnodes() {
		int s = 0;
		if(leftTree != null) {s = s + 1 + leftTree.numnodes();}
		if(rightTree != null) {s = s + 1 + rightTree.numnodes();}
		return s;
	}
	
	public void addLeaf(String inp) {
		if(this.getSize() == 0) {
			MTree leaf = new Leaf(inp);
			leftTree = new Leaf(inp);
		}
		else if(this.getSize() == 1) {
			MTree leaf = new Leaf(inp);
			rightTree = new Leaf(inp);
		}
		else if(ispowoftwo(this.getSize())) {
			//add this trees children to a new left tree
			//System.out.println("t");
			MTree m = new MTree();
			m.leftTree = this.leftTree;
			m.rightTree = this.rightTree;
			this.leftTree = m;
			//System.out.println(this.leftTree.getSize());
			//add log2(size) depth tree to the right side
			MTree r = new MTree();
			this.rightTree = r;
			//System.out.println(log2(this.getSize())-1);
			this.rightTree.addnodes(log2(this.getSize())-1);
			rightTree.rippleAddLeaf(inp);
			
		}
		else {
			//add leaf to ?
			//System.out.println("rippadd");
			rightTree.rippleAddLeaf(inp);
		}
		this.updateHash();
	}
	
	
	private void rippleAddLeaf(String inp) {
		//System.out.println("t1");
		if(leftTree == null || !leftTree.ismaxed()) {
			//System.out.println("m");
			if(leftTree == null) {
				//System.out.println("t2");
				MTree l = new Leaf(inp);
				leftTree = l;
			}
			else {
				//System.out.println("t3");
				leftTree.rippleAddLeaf(inp);
			}
		}
		else {
			//System.out.println("r1");
			if(rightTree == null) {
				MTree r = new Leaf(inp);
				rightTree = r;
			}
			rightTree.rippleAddLeaf(inp);
		}
		
	}
	
	
	private void addnodes(int depth) {
		if(depth <= 0) {return; }
		MTree l = new MTree();
		MTree r = new MTree();
		this.leftTree = l;
		this.rightTree = r;
		//System.out.println("d:" + depth);
		this.leftTree.addnodes(depth - 1);
		this.rightTree.addnodes(depth - 1);
	}
	
	public String updateHash() {
		//hash = hash(hash of right node + hash of left node)
		String h = "";
		if(leftTree != null) {h = h + leftTree.updateHash();}
		if(rightTree != null) {h = h + rightTree.updateHash();}
		String newhash = getMd5(h);
		this.hash = newhash;
		return newhash;
	}
	
	
	public void crypto(String inp) {
		
	}
	
	public boolean ismaxed() {
		if(leftTree != null) {if(!leftTree.ismaxed()) {return false;}}
		else {return false;}
		if(rightTree != null) {if(!rightTree.ismaxed()) {return false;}}
		else {return false;}
		return true;
	}
	
	public static boolean ispowoftwo(int x){
		if(x % 2 == 0) {
			return ispowoftwo(x / 2);
		}
		if(x == 1) {
			return true;
		}
		return false;
	}
	
	public static int log2(int x) {
	    return (int) (Math.log(x) / Math.log(2));
	}
	
	
	 public void printTree(int d) {
		 System.out.print(d);
		 System.out.print(" ");
		 if(leftTree != null) {leftTree.printTree(d+1);}
		 if(rightTree != null) {rightTree.printTree(d+1);}
	 }
	
	 public static String getMd5(String input) { 
	        try { 
	  
	            // Static getInstance method is called with hashing MD5 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	  
	            // digest() method is called to calculate message digest 
	            //  of an input digest() return array of byte 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }  
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        }
	 }
	 
	
}
