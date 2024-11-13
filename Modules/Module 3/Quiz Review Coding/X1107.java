BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode(
  	13,
  	new BinaryNode<Integer>(
  		18,
  		new BinaryNode<Integer>(19),
  		new BinaryNode<Integer>(17)
  	),
  	new BinaryNode<Integer>(10,null,new BinaryNode<Integer>(48))
);
  return root;
}
