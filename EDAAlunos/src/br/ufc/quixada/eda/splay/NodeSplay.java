package br.ufc.quixada.eda.splay;

public class NodeSplay <T, Info> {
	
	private T chave;
	private NodeSplay<T, Info> esq;
	private NodeSplay<T, Info> dir;
	private Info info;
	
	public NodeSplay(T chave){
		this.chave = chave;
		this.esq = null;
		this.dir = null;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NodeSplay<T, Info> getEsq() {
		return esq;
	}

	public void setEsq(NodeSplay<T, Info> esq) {
		this.esq = esq;
	}

	public NodeSplay<T, Info> getDir() {
		return dir;
	}

	public void setDir(NodeSplay<T, Info> dir) {
		this.dir = dir;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
}
