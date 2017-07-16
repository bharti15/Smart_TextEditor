package spelling;

import spelling.TreeNode;
import java.util.*;

public class BinaryTree<E> {
	
	private TreeNode<E> root;
	
	/*
	 * If we make this method public then whenever it is called it can traverse the tree from any node 
	 * which traverse only the children from that node.
	 * But by making it private and constructing another public preOrder() then traversal will always
	 * starts from the root node
	 * Likewise applies for postOrder and inOrder
	 */
	private void preOrder(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		System.out.println(node.getValue());
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void inOrder(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		inOrder(node.getLeftChild());
		System.out.println(node.getValue());
		inOrder(node.getRightChild());
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void postOrder(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		System.out.println(node.getValue());
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void levelOrder(TreeNode<E> node) {
		Queue<TreeNode<E>> q = new PriorityQueue<TreeNode<E>>();
		q.offer(node);
		while(!q.isEmpty()) {
			TreeNode<E> cur = q.poll();
			if(cur!=null) {
				System.out.println(node.getValue());
				q.offer(node.getLeftChild());
				q.offer(node.getRightChild());
			}
		}
	}

}
