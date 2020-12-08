# MerkleTree314
Cryptocurrency Security Implementation

Gregory Petri & Nicholas Saldana

Using Java via Eclipse IDE

__*Documentation*__

__To use the interface:__

* Create a MTree class instance
`MTree<Content> tree = new MTree<Content>();`
* Create an InputForm class instance
`InputForm i = new InputForm(tree);`
* Run the program


__To use the raw MTree class:__

* Create a MTree class instance
`MTree<Content> tree = new MTree<Content>();`
* Create (a) Transaction or Transfer class instance
`Transaction tr = new Transaction("Greg", "Nick", 300.05);`
`Transfer tf = new Transfer("Lupoli", 50);`
* Use the MTree member functions (shown in *Syntax*) to add and manipulate the merkle tree


