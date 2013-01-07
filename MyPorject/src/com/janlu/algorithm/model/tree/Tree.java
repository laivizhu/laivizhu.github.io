/**
 * 
 */
package com.janlu.algorithm.model.tree;


/**
 * @author janlu
 *
 */
public class Tree<T> {
	protected TreeNode<T> root;

	public Tree(TreeNode<T> root) {
		this.root = root;
	}
	
	public Tree(){

	}
	
	protected TreeNode<T> midIterator(T value,TreeNode<T> root){
		if(value.equals(root.getValue())){
			return root;
		}else{
			if(root.getLeft()!=null){
				return midIterator(value,root.getLeft());
			}
			if(root.getRight()!=null){
				return midIterator(value,root.getRight());
			}
			return null;
		}
	}
	
	
	
}
