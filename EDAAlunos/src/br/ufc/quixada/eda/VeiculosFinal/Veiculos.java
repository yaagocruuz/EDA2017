package VeiculosFinal;

public class Veiculos implements Comparable<Veiculos>{
	private String marca;
	private String modelo;
	private String ano;
	private String renavam;
	private String placa;
	private String cor;
	
	public Veiculos (String marca, String modelo, String ano, String renavam, String placa, String cor){
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.renavam = renavam;
		this.placa = placa;
		this.cor = cor;
	}
	
	@Override
	public int compareTo(Veiculos o) {
		if (this.placa.compareTo(o.getPlaca()) < 0) return -1;
		else if(this.placa.compareTo(o.getPlaca()) > 0) return 1;
		else return 0;
		//if(this.chave > o.getChave()) return 1;
		//else if(this.chave < o.getChave()) return -1;
		//return 0;
}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public String toString() {
		return "Veiculos [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", renavam=" + renavam + ", placa="
				+ placa + ", cor=" + cor + "]";
	}
}