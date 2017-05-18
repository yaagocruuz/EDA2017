package br.ufc.quixada.eda.TabelaHash;

public class EnderecamentoAbertoLinear<T> extends Hash<T>{
	private NoHash<T> tabela[];
	
	protected EnderecamentoAbertoLinear(int tam) {
		super(tam);
		this.tabela = new NoHash[this.m];
	}
	
	protected Integer ffHash(Integer x, Integer k){
		return (fHash(x) + k) % m;
	}

	@Override
	protected void inserir(Integer chave, T valor) {
		for (int k = 0; k < tabela.length; k++){
			if (tabela[ffHash(chave, k)] == null){
				tabela[ffHash(chave, k)] = new NoHash<>(chave, valor);
				return;
			}
		}
	}

	@Override
	protected T buscar(Integer chave) {
		for (int k = 0; k < m; k++){
			if(tabela[ffHash(chave, k)].getChave() == chave){
				return tabela[ffHash(chave, k)].getValor();
			}
		}
		return null;
	}

	@Override
	protected T remover(Integer chave) {
		for (int k = 0; k < m; k++){
			if (tabela[ffHash(chave, k)].getChave() == chave){
				T aux = tabela[ffHash(chave, k)].getValor();
				tabela[ffHash(chave, k)].setChave(null);
				tabela[ffHash(chave, k)].setValor(null);
				return aux;
			}
		}
		return null;
	}
	

}
