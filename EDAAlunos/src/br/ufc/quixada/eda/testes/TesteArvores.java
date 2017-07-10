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

public class TesteArvores {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore Avl");
			String arquivoOperacao = "veiculosC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Veiculos> veiculos = EDAUtil.getOperacoes(path);
			List<Veiculos> buscados = new ArrayList<Veiculos>();
			avlTree<Veiculos, Veiculos> av = new avlTree<Veiculos, Veiculos>();
			
			long tempoInicial = System.currentTimeMillis();			
			for (Veiculos veiculo : veiculos) {
				av.inserir(veiculo);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;
			System.out.println("Tempo de insercao: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			int tam = veiculos.size();
			for (int i = 0; i < tam * 0.3; i++) {
				Random rand = new Random();
				Veiculos ve = veiculos.get(rand.nextInt(tam));
				buscados.add(ve);
				av.busca(ve);
			}
			tempo = System.currentTimeMillis() - tempoInicial;		  
			System.out.println("Tempo de busca: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			for (Veiculos veiculo : buscados) {
				av.remover(veiculo);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remocao: " + tempo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}