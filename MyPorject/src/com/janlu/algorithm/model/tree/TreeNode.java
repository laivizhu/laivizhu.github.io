/**
 * 
 */
package com.janlu.algorithm.model.tree;

/**
 * @author janlu
 *
 */
public class TreeNode<T> {
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected TreeNode<T> parent;
	
	protected T value;

	public TreeNode(T value) {
		this.value = value;
	}
	
	public TreeNode(){
		
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	
	public TreeNode<T> addLeftNode(TreeNode<T> node){
		this.left=node;
		return this;
	}
	
	public TreeNode<T> addRightNode(TreeNode<T> node){
		this.right=node;
		return this;
	}
	
	public TreeNode<T> addParentNode(TreeNode<T> node){
		this.parent=node;
		return this;
	}
	
}
