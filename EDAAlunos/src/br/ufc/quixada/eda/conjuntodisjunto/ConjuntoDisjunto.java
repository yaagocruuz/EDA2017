package br.ufc.quixada.eda.conjuntodisjunto;

public class ConjuntoDisjunto {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;

	public ConjuntoDisjunto(int n) {
		this.n = n;
		pai = new int[n];
		ordem = new int[n];
	}
	
	public void make_set(int i) {
		pai[i] = i;
		ordem[i] = i;
	}
	
	public void make_set_all() {
		for (int i = 0; i < n; i++){
			make_set(i);
		}
	}
	
	public int find_set1(int v) { //versao desatualizada
		if (v == pai[v]){
			return v;
		}else
			return find_set1(pai[v]); 
	}
	
	public int find_set(int v) { //versao que deve ser utilizada
		if (v == pai[v]){
			return v;
		}else{
			int paiv = find_set(pai[v]);
			pai[v] = paiv;
			return paiv;
		}
	}
	
	public void link_set(int u, int v){
			if (ordem[u] > ordem[v]){
				pai[v] = u;
			}else{
				pai[u] = v;
			}
			if (ordem[u] == ordem[v])
				ordem[v]++;
	}
	
	public void union(int u, int v){
		link_set(find_set(u), find_set(v));
	}
	
}
