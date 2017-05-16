package br.ufc.quixada.eda.testes;

import java.io.IOException;

import br.ufc.quixada.eda.algoritmos.ArvoreGeradoraMinima;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteConjuntoDisjunto {

	public static void main(String args[]){
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {
				for(int i = 0; i < 4; i++) {
					String arquivo = "tb8ch" + tamanho + "_" + i + ".txt";
					String path = EDAConstants.caminhoPasta + arquivo;
					
					Grafo g = EDAUtil.lerGrafo(path);
					
					long tempoInicial = System.currentTimeMillis();				
					ArvoreGeradoraMinima arvore = new ArvoreGeradoraMinima();

					int somaArestas = 0;
					for(Aresta a : arvore.Kruskal(g)){
						somaArestas += a.getPeso();
					}

					long tempo = System.currentTimeMillis() - tempoInicial;
					System.out.println(arquivo + " " + somaArestas + " " + tempo);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}