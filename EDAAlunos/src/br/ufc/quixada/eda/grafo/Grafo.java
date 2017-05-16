package br.ufc.quixada.eda.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Vector;

public class Grafo {
	private int qtdVertices = 0;
	private List<Aresta> listAresta = new ArrayList<Aresta>();
	private int qtdArestas = 0;
	private ListaAdjacencia adj[];
	
	public Grafo (int qtdVert, int qtdArest){
		this.qtdArestas = qtdArest;
		this.qtdVertices = qtdVert;
		this.adj = new ListaAdjacencia[qtdArest];
	}
	
	public Grafo(){}
//	public Grafo(List<Aresta> lista){
//		this.qtdVertices = lista.size()*2;
//		this.qtdArestas = lista.size();
//		this.listAresta = lista;
//	}

	public int getQtdVertices() {
		return qtdVertices;
	}

	public void setQtdVertices(int qtdVertices) {
		this.qtdVertices = qtdVertices;
	}

	public List<Aresta> getListAresta() {
		return listAresta;
	}

	public void setListAresta(List<Aresta> listAresta) {
		this.listAresta = listAresta;
	}

	public int getQtdArestas() {
		return qtdArestas;
	}

	public void setQtdArestas(int qtdArestas) {
		this.qtdArestas = qtdArestas;
	}
	
	public void quickSort(int ini, int fim){
		if(ini < fim){
			int meio = particiona(ini, fim);
			quickSort(ini, meio - 1);
			quickSort(meio + 1, fim);
		}
}

	
	private int particiona(int p, int r){
		//int pivo = vetor[p];
		Aresta pivo = listAresta.get(p);
		int i = p + 1;
		int f = r;
		while (i <= f){
			if ( listAresta.get(i).getPeso() <= pivo.getPeso())
				i++;
			else if (pivo.getPeso() < listAresta.get(f).getPeso())
				f--;
			else{
				//Aresta troca = listAresta.get(i);
				//listAresta.add(i, listAresta.get(f));
				//listAresta.add(f, troca);
				
				Collections.swap(listAresta, i, f);
				
				//int troca = vetor[i];
				//vetor[i] = vetor[f];
				//vetor[f] = troca;
				i++;
				f--;
			}
		}
		Collections.swap(listAresta, p, f);
		listAresta.remove(f);
		listAresta.add(f, pivo);
		
		//listAresta.add(p, listAresta.get(f)); // colocar o objeto f na posicao p
		//listAresta.add(f, pivo); // colocar na posicao f o pivo
		
		//vetor[p] = vetor[f];
		//vetor[f] = pivo;
		return f;
	}

	@Override
	public String toString() {
		return "Grafo [listAresta=" + listAresta + "]";
	}
	
	public ListaAdjacencia[] getAdj() {
		return adj;
	}

	public void setAdj(ListaAdjacencia[] adj) {
		this.adj = adj;
}
	
}
