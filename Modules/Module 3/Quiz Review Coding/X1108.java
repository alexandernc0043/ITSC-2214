BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode(
  	15,
  	new BinaryNode(
  		10,
  		new BinaryNode(12),
  		new BinaryNode(23)
  ),
  	new BinaryNode(
  		21,
  		new BinaryNode(20),
  		new BinaryNode(19)
  	)
  );
  return root;
}