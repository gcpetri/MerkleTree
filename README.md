# MerkleTree314
Cryptocurrency Security Implementation

Gregory Petri & Nicholas Saldana

Using Java via Eclipse IDE

Video: https://github.com/gcpetri/MerkleTree314 </br>
<hr></hr>
**Documentation**

__To use the interface:__

* Create a MTree class instance</br>
`MTree<Content> tree = new MTree<Content>();`</br>
* Create an InputForm class instance</br>
`InputForm i = new InputForm(tree);`</br>
* Run the program</br>


__To use the raw MTree class:__

* Create a MTree class instance</br>
`MTree<Content> tree = new MTree<Content>();`</br>
* Create (a) Transaction or Transfer class instance</br>
`Transaction tr = new Transaction("Greg", "Nick", 300.05);`</br>
`Transfer tf = new Transfer("Lupoli", 50);`</br>
* Use the MTree member functions (shown in below) to add and manipulate the merkle tree</br>

__MTree Member Function Syntax & Semantics:__
* returns (int) amount of leaf nodes in the tree</br>
`tree.getSize()`</br>
* returns the tree root hash (String)</br>
`tree.getHash()`</br>
* returns the tree number of nodes (int)</br>
`tree.numnodes()`</br>
* adds leaves (Transactions or Transfers in an ArrayList<T>) to the tree (void)</br>
`tree.addLeaves(ArrayList<T>)`</br>
* adds one leaf (Transaction or Transfer) to the tree (void) </br>
`tree.addLeaf(T t)`</br>
* returns (String) and updates the hash of the whole tree - use if hash is incorrect or lagging</br>
`tree.updateHash()`</br>
* returns (boolean) true if the tree is holding the maximum number of external nodes (leaves)</br>
`tree.isMaxed()`</br>
* prints the tree (pre-order) to System.out (void)</br>
`tree.printTree(0)`</br>
* prints a log of all leaves to System.out (void)</br>
`tree.printLog()`</br>
* returns (String) a log of all leaves</br>
`tree.getStringLog()`</br>
* returns (boolean) true if the integer parameter is a power of two</br>
`tree.ispowoftwo(int)`</br>
* returns (int) the log of the integer parameter</br>
`tree.log(int)`</br>
* returns (String) the hash of the String parameter - use to see an example of the hash function</br>
`tree.calcHash(String)`</br>

__UML:__</br>
</br>
![plot](MerkleTreeDesign.PNG)
</br>
__Tree Layout:__</br>
</br>
![plot](MerkleTreeInputExample.PNG)
</br>
