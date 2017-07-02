package br.ufc.quixada.eda.avl;

public class avlTree {
	private avlNode root = null;

	private int height(avlNode node){
		return (node != null ? node.getHeight() : 0);
	}

	private avlNode leftRotation(avlNode node){
		avlNode aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return aux;
	}

	private avlNode rightRotation(avlNode node){
		avlNode aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return aux;
	}

	private avlNode doubleLeftRotation(avlNode node){
		node.setRight(rightRotation(node.getRight()));
		return leftRotation(node);
	}

	private avlNode doubleRightRotation(avlNode node){
		node.setLeft(leftRotation(node.getLeft()));
		return rightRotation(node);
	}

	private avlNode insert_r(avlNode node, int key){
		if(node == null){
			avlNode aux = new avlNode(key);
			return aux;
		}else if(node.getKey() > key){
			node.setLeft(insert_r(node.getLeft(), key));
			if(height(node.getLeft()) - height(node.getRight()) == 2){
				if(height(node.getLeft().getLeft()) > height(node.getLeft().getRight()))
					node = rightRotation(node);
				else
					node = doubleRightRotation(node);
			}
		}else if(node.getKey() < key){
			node.setRight(insert_r(node.getRight(), key));
			if(height(node.getRight()) - height(node.getLeft()) == 2){
				if(height(node.getRight().getRight()) > height(node.getRight().getLeft()))
					node = leftRotation(node);
				else
					node = doubleLeftRotation(node);
			}
		}
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		return node;
	}

	public void insert(int key){
		this.root = insert_r(this.root, key);
	}


}