package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String Nome, CNPJ;
	private Integer nroBanco;
	ArrayList<ContaBancaria> contas = new ArrayList();
	
	public Banco() {
		
	}
	public Banco(String Nome, String CNPJ, Integer nroBanco) {
		this.Nome = Nome;
		this.CNPJ = CNPJ;
		this.nroBanco = nroBanco;
	}
	
	public String getNome() {
		return Nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public Integer getNroBanco() {
		return nroBanco;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public void setNroBanco(Integer nroBanco) {
		this.nroBanco = nroBanco;
	}
	
	public List<ContaBancaria> getConta() {
		return contas;
	}

	public void addContas(ContaBancaria conta) {
		contas.add(conta);
		
	}
	public void info(int i) {
		System.out.println("\n== Banco "+i+"\n"
				+"Nome: " + getNome()+" \n"
				+"CNPJ: "+ getCNPJ()+"\n"
				+"Numero do Banco: "+getNroBanco()+"\n");
	}
}
