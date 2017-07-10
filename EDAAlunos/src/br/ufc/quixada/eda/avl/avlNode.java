package br.ufc.quixada.eda.avl;

public class avlNode <T, Info> {
	
	private T valor;
	private int altura;
	private avlNode<T, Info> direito;
	private avlNode<T, Info> esquerdo;
	private Info infor;
	
	public avlNode(T valor) {
		this.valor = valor;
		this.setAltura(1);
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public avlNode<T, Info> getDireito() {
		return direito;
	}

	public void setDireito(avlNode<T, Info> direito) {
		this.direito = direito;
	}

	public avlNode<T, Info> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(avlNode<T, Info> esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Info getInfor() {
		return infor;
	}

	public void setInfor(Info infor) {
		this.infor = infor;
	}
		
}
