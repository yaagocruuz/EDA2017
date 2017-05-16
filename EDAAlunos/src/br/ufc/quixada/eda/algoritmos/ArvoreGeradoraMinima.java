package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.conjuntodisjunto.ConjuntoDisjunto;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;

public class ArvoreGeradoraMinima {
	
	public List<Aresta> Kruskal (Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getQtdVertices());
		
		for (int i = 0; i < g.getQtdArestas(); i++){
			conj.make_set(i);
		}
		//ordenar a lista de arestas por peso
		g.quickSort(0, g.getListAresta().size() - 1);
		
		for (int i = 0; i < g.getQtdArestas(); i++){
			Aresta a = g.getListAresta().get(i);
			
			if(conj.find_set(a.getVertice1()) != conj.find_set(a.getVertice2())){
				solucao.add(a);
				conj.union(a.getVertice1(), a.getVertice2());
			}
		}
		return solucao;
	}
	

	public int custoArvore(List<Aresta> solucao){
		int custo = 0;
		for (Aresta aresta : solucao) {
			custo += aresta.getPeso();
		}
		return custo;
	}


}