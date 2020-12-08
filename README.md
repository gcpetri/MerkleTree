# MerkleTree314
Cryptocurrency Security Implementation

Gregory Petri & Nicholas Saldana

Using Java via Eclipse IDE

__*Documentation*__

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
* Use the MTree member functions (shown in *Syntax*) to add and manipulate the merkle tree</br>


