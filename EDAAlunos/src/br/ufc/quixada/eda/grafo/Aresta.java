package br.ufc.quixada.eda.grafo;

public class Aresta {
	private int vertice1;
	private int vertice2;
	private int peso;
	
	public Aresta(int v1, int v2, int peso) {
		this.vertice1 = v1;
		this.vertice2 = v2;
		this.peso = peso;
	}

	public int getVertice1() {
		return vertice1;
	}

	public void setVertice1(int vertice1) {
		this.vertice1 = vertice1;
	}

	public int getVertice2() {
		return vertice2;
	}

	public void setVertice2(int vertice2) {
		this.vertice2 = vertice2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
