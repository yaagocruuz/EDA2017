package br.ufc.quixada.eda.conjuntodisjunto;

public class ConjuntoDisjuntoListaEncadeada {
	private Node node;
	
	public void CriarLista(){
		node = null;
	}
	
	public void InserirComeço(int i){
		Node novo = new Node();
		novo.setValue(i);
		novo.setNext(node);
	}
	
	public boolean isEmpty(){
		if (node == null){
			return true;
		}else{
			return false;
		}
	}
	
	public Node search(int value){
		for (Node n = node; n != null; n = n.getNext()){
			if(n.getValue() == value){
				return n;
			}
		}
		return null;
	}
}
