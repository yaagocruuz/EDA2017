package br.ufc.quixada.eda.TabelaHash;

public class EnderecamentoInternoAluno<T> extends Hash<T>{
	private NoHash<T> tabela[] = null;
	
	public EnderecamentoInternoAluno(Integer tam) {
		super(tam);
		tabela = new NoHash[m];
	}

	@Override
	public void inserir(Integer chave, T valor) { //precisa pensar em como dar a volta no vetor
		NoHash<T> hash = new NoHash<T>(chave, valor);
		Integer newChave = fHash(chave);
		if (tabela[newChave] == null){
			tabela[newChave] = hash;
			for (int i = newChave; i < tabela.length; i++){
				if (tabela[i] == null){
					tabela[newChave].setNext(i);
					return;
				}
			}
		}else if (tabela[newChave].getNext() != -1){ //dar a volta no vetor
			Integer auxChave = newChave;
			Integer posAnt = newChave;
			while(/*tabela[auxChave].getNext() != null ||*/ /*&&*/ tabela[auxChave].getNext() == -1){ // Ainda não sei como fazer um loop para ele dar a volta no vetor
				posAnt = auxChave;
				auxChave = tabela[auxChave].getNext();
			}
			tabela[posAnt].setNext(auxChave);
			tabela[auxChave] = hash;
			for (int i = auxChave; i < tabela.length; i++){ //voltar pro inicio
				if (tabela[i] == null){
					tabela[auxChave].setNext(i);
				}
			}
		}
	}

	@Override
	public T buscar(Integer chave) {
		Integer newChave = fHash(chave);
		if (tabela[newChave].getChave() == chave){
			return (T) tabela[newChave].getValor();
		}else{
			Integer prox = newChave;
			while (tabela[prox].getChave() != chave || /*tabela[prox].getNext() != null || */ tabela[prox].getNext() != -1){ 
				prox = tabela[prox].getNext();
			}
			if (/*tabela[prox].getNext() == null ||*/ tabela[prox].getNext() == -1){
				return null;
			}
			return (T) tabela[prox].getValor();
		}
	}

	@Override
	public T remover(Integer chave) {
		Integer newChave = fHash(chave);
		
		if(tabela[newChave].getChave() == chave){
			//NoHash aux = tabela[tabela[newChave].getNext()];
			tabela[newChave].setChave(null);
			tabela[newChave].setValor(null);
			tabela[newChave].setNext(-1);
		}
		return null;
	}

//	0 = 5, t3, 1
//	1 = 6, t2, 2
//	2 = null
//	3 = null
//	4 = null
// 
//	
//	
//remover 3
// aux = 3 = pont7
// 3 <- 7
}
