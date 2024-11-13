BinaryNode<Integer> makeTree()
{
  BinaryNode<Integer> root = new BinaryNode(
  	38,
  	new BinaryNode(12),
  	new BinaryNode(
  		11,
  		null,
  		new BinaryNode(
  			91,
  			null,
  			new BinaryNode(98)
  		)
  	)
  );
  return root;
}