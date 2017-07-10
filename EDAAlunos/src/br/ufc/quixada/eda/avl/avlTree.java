package br.ufc.quixada.eda.avl;

public class avlTree <T extends Comparable<T>, Info> {
	
	private avlNode<T, Info> raiz;
	
	public void inserir(T value){
		raiz = inserir_r(raiz, value);
	}
	
	public avlTree(){
		raiz = null;
	}
	
	avlNode<T, Info> inserir_r(avlNode<T, Info> no, T value){
		if(no == null){
			avlNode<T, Info> aux = new avlNode<T, Info>(value);
			return aux;
		}
		int comp = value.compareTo(no.getValor());
		if(comp < 0){
			no.setEsquerdo(inserir_r(no.getEsquerdo(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rsDireita(no);
				}else{
					no = rdDireita(no);
				}
			}
		}else if(comp > 1){
			no.setDireito(inserir_r(no.getDireito(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rsEsquerda(no);
				}else{
					no = rdEsquerda(no);
				}
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	int altura(avlNode<T, Info> no){
		return (no != null ? no.getAltura() : 0);
	}
	
	avlNode<T, Info> rsDireita(avlNode<T, Info> no){
		avlNode<T, Info> aux = no.getEsquerdo();
		no.setEsquerdo(no.getEsquerdo().getDireito());
		aux.setDireito(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	avlNode<T, Info> rsEsquerda(avlNode<T, Info> no){
		avlNode<T, Info> aux = no.getDireito();
		no.setDireito(no.getDireito().getEsquerdo());
		aux.setEsquerdo(no);
		no.setAltura((altura(no.getDireito()) > altura(no.getDireito()) ? altura(no.getDireito()) : (altura(no.getEsquerdo())) + 1));
		aux.setAltura((altura(aux.getDireito()) > altura(aux.getDireito()) ? altura(aux.getDireito()) : (altura(aux.getEsquerdo())) + 1));
		return aux;
	}
	
	avlNode<T, Info> rdDireita(avlNode<T, Info> no){
		no.setEsquerdo(rsEsquerda(no.getEsquerdo()));
		no = rsDireita(no);
		return no;
	}
	
	avlNode<T, Info> rdEsquerda(avlNode<T, Info> no){
		no.setDireito(rsDireita(no.getDireito()));
		no = rsEsquerda(no);
		return no;
	}
	
	private avlNode<T, Info> busca_r(avlNode<T, Info> no, T value){
		if(no == null) return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp > 0){
			return busca_r(no.getDireito(), value);
		}else if(cmp < 0){
			return busca_r(no.getEsquerdo(), value);
		}
		return no;
	}
	
	public avlNode<T, Info> busca(T value){
		return busca_r(raiz, value);
	}
	
	public void remover(T value){
		raiz = remover_r(raiz, value);
	}
	
	avlNode<T, Info> remover_r(avlNode<T, Info> no, T value){
		if(no == null)
			return null;
		int cmp = value.compareTo(no.getValor());
		if(cmp == 1){
			no.setDireito(remover_r(no.getDireito(), value));
			if((altura(no.getEsquerdo()) - altura(no.getDireito())) == 2){
				if(altura(no.getEsquerdo().getEsquerdo()) > altura(no.getEsquerdo().getDireito())){
					no = rsDireita(no);
				}else{
					no = rdDireita(no);
				}
			}
		}else if(cmp == -1){
			no.setEsquerdo(remover_r(no.getEsquerdo(), value));
			if((altura(no.getDireito()) - altura(no.getEsquerdo())) == 2){
				if(altura(no.getDireito().getDireito()) > altura(no.getDireito().getEsquerdo())){
					no = rsEsquerda(no);
				}else{
					no = rdEsquerda(no);
				}
			}
		}else{
			if(no.getDireito() == null || no.getEsquerdo() == null){
				if(no.getDireito() == null && no.getDireito() == null)
					return null;
				if(no.getDireito() == null){
					no = no.getEsquerdo();
				}else{
					no = no.getDireito();
				}
			}else{
				avlNode<T, Info> aux = pegar_menor(no.getDireito());
				no.setValor(aux.getValor());
				no.setDireito(remover_r(no.getDireito(), aux.getValor()));
			}
		}
		no.setAltura(((altura(no.getDireito()) > altura(no.getEsquerdo())) ? altura(no.getDireito()) : (altura(no.getEsquerdo()))) + 1);
		return no;
	}
	
	avlNode<T, Info> pegar_menor(avlNode<T, Info> no){
		avlNode<T, Info> aux = no;
		while(aux.getEsquerdo() != null)
			aux = aux.getEsquerdo();
		return aux;
	}

}
