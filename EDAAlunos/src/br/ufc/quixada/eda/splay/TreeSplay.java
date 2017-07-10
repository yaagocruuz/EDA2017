package br.ufc.quixada.eda.splay;

public class TreeSplay <T extends Comparable<T>, Info>{
	private NodeSplay<T, Info> raiz = null;
	
	private NodeSplay<T, Info> splay(NodeSplay<T, Info> raiz, T chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.getChave());
		if(cmp == 0) return raiz;
		else if(cmp == 1){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rsDireita(raiz);
			}
			return raiz;
		}else{
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rsEsquerda(raiz);
			}
			return raiz;
		}
	}
	
	public NodeSplay<T, Info> busca(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz != null && this.raiz.getChave() == chave) return this.raiz;
		return null;
	}

	public void inserir(T chave){
		raiz = splay(raiz, chave);
		if(raiz != null && chave.compareTo(raiz.getChave()) == 0) return;
		if(raiz == null){
			raiz = new NodeSplay<T, Info>(chave);
		}else{
			int cmp = chave.compareTo(raiz.getChave());
			if(cmp > 0){
				NodeSplay<T, Info> aux = new NodeSplay<T, Info>(chave);
				aux.setDir(raiz);
				aux.getDir().setEsq(null);
				aux.setEsq(raiz.getEsq());
				raiz = aux;
			}else{
				NodeSplay<T, Info> aux = new NodeSplay<T, Info>(chave);
				aux.setEsq(raiz);
				aux.getEsq().setDir(null);
				aux.setDir(raiz.getDir());
				raiz = aux;
			}
		}
	}
	
	NodeSplay<T, Info> insert_r(NodeSplay<T, Info> no, T chave){
		if(no == null)
			return new NodeSplay<T, Info>(chave);
		int cmp = chave.compareTo(no.getChave());
		if(cmp == 1){
			no.setDir(insert_r(no.getDir(), chave));
		}else if(cmp == -1){
			no.setEsq(insert_r(no.getEsq(), chave));
		}
		return no;
	}
	
	
	public void remover(T chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.getChave() != chave) return;
		NodeSplay<T, Info> aux = splay(this.raiz.getEsq(), chave);
		if(raiz.getDir() != null && aux != null) aux.setDir(raiz.getDir());
		raiz = aux;
	}
	
	NodeSplay<T, Info> rsDireita(NodeSplay<T, Info> no){
		NodeSplay<T, Info> aux = no.getEsq();
		no.setEsq(no.getEsq().getDir());
		aux.setDir(no);
		return aux;
	}
	
	NodeSplay<T, Info> rsEsquerda(NodeSplay<T, Info> no){
		NodeSplay<T, Info> aux = no.getDir();
		no.setDir(no.getDir().getEsq());
		aux.setEsq(no);
		return aux;
	}
		
}
