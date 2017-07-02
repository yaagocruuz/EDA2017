package br.ufc.quixada.eda.rubronegra;

public class TreeRubroNegra<T> {
	private NodeRubroNegra<T> root;
	
	private boolean isRed(NodeRubroNegra<T> node){
		if (node == null){
			return false;
		}else if (node.isColor() == NodeRubroNegra.VERMELHO){
			return true;
		}else
			return false;
	}

	private boolean isBlack(NodeRubroNegra<T> node){
		return !this.isRed(node);
	}
	
	private void Recolorir(NodeRubroNegra<T> node){
		node.setColor(NodeRubroNegra.VERMELHO);
		node.getLeft().setColor(NodeRubroNegra.PRETO);
		node.getRight().setColor(NodeRubroNegra.PRETO);
	}
	
	private NodeRubroNegra<T> leftRotation(NodeRubroNegra<T> node){
		NodeRubroNegra<T> aux = node.getRight();
		node.setRight(aux.getLeft());
		aux.setLeft(node);
		return aux;
	}
	
	private NodeRubroNegra<T> rightRotation(NodeRubroNegra<T> node){
		NodeRubroNegra<T> aux = node.getLeft();
		node.setLeft(aux.getRight());
		aux.setRight(node);
		return aux;
	}
	
	private NodeRubroNegra<T> r_insert(NodeRubroNegra<T> node, int key, T value){
		if(root == null)
			return new NodeRubroNegra<T>(key, value);
		if(root.getKey() > key){ 
			root.setLeft(r_insert(node.getLeft(), key, value));
		}else if(root.getKey() < key){ 
			root.setRight(r_insert(node.getRight(), key, value));
		}
		if(isRed(node.getLeft()) && isRed(node.getRight()) && isRed(node.getLeft().getLeft())){
			Recolorir(node);
		}else if(isRed(node) && isRed(node.getRight())){
			this.root = leftRotation(node);
		}else if(isRed(node.getLeft()) && isBlack(node.getRight()) && isRed(node)){
			this.root = rightRotation(node);
			root.setColor(NodeRubroNegra.PRETO);
			root.getRight().setColor(NodeRubroNegra.VERMELHO);
		}
		if(isRed(node.getLeft()) && isRed(node.getRight()) && isRed(node.getRight().getRight())){
			Recolorir(node);
		}else if(isRed(node) && isRed(node.getLeft())){
			this.root = rightRotation(node);
		}else if(isRed(node.getRight()) && isBlack(node.getLeft()) && isRed(node)){
			this.root = leftRotation(node);
			root.setColor(NodeRubroNegra.PRETO);
			root.getLeft().setColor(NodeRubroNegra.VERMELHO);
		}
		return node;
	}
	
	
}
