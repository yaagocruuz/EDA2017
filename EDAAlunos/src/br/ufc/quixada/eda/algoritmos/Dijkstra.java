package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int antecessor[] = null;
	private double custo[] = null;
	
	public void executar(Grafo grafo, int raiz){

		List<Integer> vert = new ArrayList<>();

		this.antecessor = new int[grafo.getQtdVertices() + 1];
		this.custo = new double[grafo.getQtdVertices() + 1];
		
		for(int i = 1; i <= grafo.getQtdVertices(); i++){
			this.antecessor[i] = -1;
			this.custo[i] = Double.MAX_VALUE;
			vert.add(i);
		}	
		
		this.custo[raiz] = 0;
		
		HeapMinimo heap = new HeapMinimo(grafo.getQtdVertices());
		heap.contruir(vert);
		
		while(!heap.isEmpty()){
			int u = heap.remove();
			ListaAdjacencia adj = grafo.getAdj()[u];
			
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta aresta = adj.next();
				int v = (aresta.getVertice1() == u ? aresta.getVertice2() : aresta.getVertice1());
				if(this.custo[v] > (this.custo[u] + aresta.getPeso())){
					this.antecessor[v] = u;
					this.custo[v] = aresta.getPeso() + this.custo[u];
				}
			}
		}
	}
	
	public void imprimeCaminho(int origem, int v){
		if(origem == v) 
			System.out.println(origem);
		else if(this.antecessor[v] == -1) 
			System.out.println("Nao existe caminho de " + origem + "ate" +v);
		else {
			imprimeCaminho(origem, this.antecessor[v]);
			System.out.println(v);
		}
	}
	
}