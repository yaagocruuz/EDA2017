package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SpringLayout;

import VeiculosFinal.Veiculos;
import br.ufc.quixada.eda.avl.avlTree;
import br.ufc.quixada.eda.rubronegra.RubroNegra;
import br.ufc.quixada.eda.splay.TreeSplay;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

public class TesteArvoresMesclado {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore RubroNegra");
			String arquivoOperacao = "veiculosC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Veiculos> veiculos = EDAUtil.getOperacoes(path);
			List<Veiculos> buscados = new ArrayList<Veiculos>();
			RubroNegra<Veiculos, Veiculos> rn = new RubroNegra<Veiculos, Veiculos>();
			long tempoInicial = System.currentTimeMillis();				
			int taxa = (int) (veiculos.size() * 0.2);
			for (int i = 1; i <= veiculos.size(); i++) {
				rn.inserir(veiculos.get(i - 1), veiculos.get(i - 1));
				if(i % taxa == 0){
					for (int j = 0; j < i * 0.3; j++) {
						Random rand = new Random();
						Veiculos e = veiculos.get(rand.nextInt(i));
						buscados.add(e);
						rn.busca(e);
					}
					for (int j = 0; j < i * 0.1; j++) {
						Random rand = new Random();
						rn.remover(buscados.remove(rand.nextInt(buscados.size())));
					}
				}
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo total: " + tempo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}