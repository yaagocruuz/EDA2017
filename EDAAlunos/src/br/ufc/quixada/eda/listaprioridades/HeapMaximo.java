package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = i/2;
		if(j >= 1){
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor[i];
				vetor[i] = aux;
				this.subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 2 * i;
		if(j <= n){
			if((j + 1 <= n) && (vetor[j + 1] > vetor[j])) j++;
			if(vetor[j] > vetor[i]){
				int aux = vetor[j];
				vetor[j] = vetor[i];
				vetor[i] = aux;
				this.descer(j);
			}
		}
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 1; i <= n; i++){
			vetor[i] = entrada.get(i - 1);
		}
		for(int i = n/2; i >= 1; i--){
			this.descer(i);
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[1];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[1];
			vetor[1] = vetor[n];
			n--;
			this.descer(1);
			return aux;
		}
		
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			n++;
			vetor[n] = prioridade;
			this.subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		if(n >= 1){
			for(int i = 1; i <= n; i++){
				if(vetor[i] == prioridade){
					if(prioridade < novaPrioridade){
						vetor[i] = novaPrioridade;
						this.subir(i);
					} else if(prioridade > novaPrioridade){
						vetor[i] = novaPrioridade;
						this.descer(i);
					}
				}
			}
		}
	}	
}