package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import VeiculosFinal.Veiculos;
import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;

public class EDAUtil {
	/**
	 * Ler o arquivo que cont�m as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    
    /**
     * Ler as opera��es que ser�o realizadas na lista de prioridades ap�s a sua cria��o.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Veiculos> getOperacoes(String path) throws IOException {
        List<Veiculos> operacoes = new ArrayList<Veiculos>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");
        int k = 0;
		while (scanner.hasNext()){
			try{
				k++;
				operacoes.add(new Veiculos(scanner.next().substring(6), scanner.next().substring(7), scanner.next().substring(4), scanner.next().substring(8), scanner.next().substring(6), scanner.next().substring(4)));
			}catch(Exception e){
				e.printStackTrace();
			    System.out.println(k);
			}
		}
		scanner.close();
        return operacoes;
    }
    
    public static void ordenarListaAresta(List<Aresta> arestas){
    	Collections.sort(arestas, new Comparator<Aresta>(){
    		@Override
    		public int compare (Aresta o1, Aresta o2){
    			if(o1.getPeso() < o2.getPeso()){
    				return -1;
    			}else if (o1.getPeso() > o2.getPeso()){
    				return 1;
    			}else
    			return 0;
    		}
    	});
    }
    
    public static Grafo lerGrafo(String path) throws IOException{
    	Grafo g = null;

    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	
    	if(scanner.hasNext()){
	  //  	g.setQtd_vertices(scanner.nextInt());
	    //	g.setQtd_arestas(scanner.nextInt());
    //	}
    		g = new Grafo(scanner.nextInt(), scanner.nextInt());
    		//Aresta aresta[] = new Aresta[g.getQtd_arestas()];
    	   ListaAdjacencia adj[] = new ListaAdjacencia[g.getQtdVertices() + 1];
    	   for(int i = 0; i < adj.length; i++){
    		   adj[i] = new ListaAdjacencia();
    	   }
	    	int i = 0;
	
	    	while(scanner.hasNext()){
	    		int u = scanner.nextInt();
	    		int v = scanner.nextInt();
	    		Aresta a = new Aresta(u, v, scanner.nextInt());
	    		adj[u].add(a);
	    		adj[v].add(a);
	    		
	    		
	    		//aresta[i] = new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
	    		//i++;
	    		//listaAresta.add(new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
	    	}
	    	scanner.close();
	    	g.setAdj(adj);
	    	return g;
    	}
    	return null;
}
    
    
}
