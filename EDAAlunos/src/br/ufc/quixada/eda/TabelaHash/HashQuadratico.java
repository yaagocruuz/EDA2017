package br.ufc.quixada.eda.TabelaHash;

public class HashQuadratico<T> extends Hash<T>{
	private NoHash<T> tabela[];
	
	public HashQuadratico(Integer tamanho){
		super(tamanho);
		tabela = new NoHash[this.m];
	}

	private Integer fqHash(Integer x, Integer k){
		return (fqHash(x, (k - 1)) + k) % this.m;
	}
	
	@Override
	protected void inserir(Integer chave, T valor) {
		if (tabela[fHash(chave)] == null){
			tabela[fHash(chave)] = new NoHash<>(chave, valor);
		} else {
			for (int k = 1; k < tabela.length; k++){
				if (tabela[fqHash(chave, k)] == null){
					tabela[fqHash(chave, k)] = new NoHash<>(chave, valor);
					return;
				}
			}
		}
		
	}

	@Override
	protected T buscar(Integer chave) {
		if(tabela[fHash(chave)].getChave() == chave) {
			return tabela[fHash(chave)].getValor();
		}else {
			for(int k = 1; k < this.m; k++){
				if(tabela[fqHash(chave, k)].getChave() == chave) {
					return tabela[fqHash(chave, k)].getValor();			
				}
			}
		}
		return null;
	}

	@Override
	protected T remover(Integer chave) {
		if(tabela[fHash(chave)].getChave() == chave) {
			T aux = tabela[fHash(chave)].getValor();
			tabela[fHash(chave)].setChave(null);
			tabela[fHash(chave)].setValor(null);
			return aux;
		} else {
		for(int k = 1; k < this.m; k++){
			if(tabela[fqHash(chave, k)].getChave() == chave) {
				T aux = tabela[fqHash(chave, k)].getValor();
				tabela[fqHash(chave, k)].setChave(null);
				tabela[fqHash(chave, k)].setValor(null);
				return aux;
			}
			
		}
		}
		return null;
	}

}
