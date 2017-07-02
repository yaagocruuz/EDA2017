package br.ufc.quixada.eda.avl;

public class avlNode {
	private avlNode left, right;
	private int height, key;
	
	public avlNode(int key){
		this.left = null;
		this.right = null;
		this.height = 1;
		this.key = key;
	}

	public avlNode getLeft() {
		return left;
	}

	public void setLeft(avlNode left) {
		this.left = left;
	}

	public avlNode getRight() {
		return right;
	}

	public void setRight(avlNode right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
