package spelling;

import java.util.TreeSet;
import spelling.TreeNode;

public class BinarySearchTree<E extends Comparable<? super E>> {
	
	private TreeNode<E> root;
	
	public BinarySearchTree() {
	}
	
	public boolean contains(E toFind) {
		TreeNode<E> cur = root;
		
		while(cur!=null) {
			if(cur.getValue().equals(toFind)) {
				return true;
			}
			if(cur.getValue().compareTo(toFind)>0) {
				cur = cur.getLeftChild();
			}
			else if(cur.getValue().compareTo(toFind)<0) {
				cur = cur.getRightChild();
			}
		}
		
		return false;
	}
	
	public boolean insert(E val) {
		TreeNode<E> cur = root;
		TreeNode<E> parent = root;
		if(!this.contains(val)) {
			while(cur!=null) {
				if(cur.getValue().compareTo(val)>0) {
					parent = cur;
					cur = cur.getLeftChild();
				}
				else if(cur.getValue().compareTo(val)<0) {
					parent = cur;
					cur = cur.getRightChild();
				}
			}
			if(parent.getValue().compareTo(val)>0) {
				parent.addLeftChild(val);
			}
			else {
				parent.addRightChild(val);
			}
		}
		return false;
	}
	
	public boolean delete() {
		// TODO: write this function
		return false;
	}

}
