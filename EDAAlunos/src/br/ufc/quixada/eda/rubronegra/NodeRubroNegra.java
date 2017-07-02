package br.ufc.quixada.eda.rubronegra;

public class NodeRubroNegra<T> {
	public static final boolean PRETO = false;
	public static final boolean VERMELHO = true;
	
	private NodeRubroNegra<T> left, right;
	private boolean color;
	private int key;
	private T value;
	
	public NodeRubroNegra(int key, T value){
		this.key = key;
		this.value = value;
		this.color = VERMELHO;
		this.left = null;
		this.right = null;
	}

	public NodeRubroNegra<T> getLeft() {
		return left;
	}

	public void setLeft(NodeRubroNegra<T> left) {
		this.left = left;
	}

	public NodeRubroNegra<T> getRight() {
		return right;
	}

	public void setRight(NodeRubroNegra<T> right) {
		this.right = right;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
