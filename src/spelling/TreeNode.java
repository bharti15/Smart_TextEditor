package spelling;

public class TreeNode<E> {
	
	private E value;
	private TreeNode<E> parent;
	private TreeNode<E> leftChild;
	private TreeNode<E> rightChild;
	
	public TreeNode(E val, TreeNode<E> parent){
		this.value = val;
		this.parent = parent;
		this.rightChild = null;
		this.leftChild = null;
	}
	
	public E getValue() {
		return this.value;
	}
	
	public TreeNode<E> addLeftChild(E val){
		this.leftChild = new TreeNode<E>(val, this);
		return this.leftChild;
	}
	
	public TreeNode<E> addRightChild(E val){
		this.rightChild = new TreeNode<E>(val, this);
		return this.rightChild;
	}
	
	public TreeNode<E> getLeftChild(){
		return this.leftChild;
	}
	
	public TreeNode<E> getRightChild(){
		return this.rightChild;
	}

}
