package entities;

import java.util.ArrayList;

import java.util.List;
import java.util.Stack;

public class Pessoa {
	
	public String nome, sobrenome;
	private String cpf;
	public Integer idade;
	
	ArrayList<ContaBancaria> contas = new ArrayList();
	public Pessoa () {
	}
	
	public Pessoa (String nome, String sobrenome, Integer idade, String cpf ) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public List<ContaBancaria> getConta() {
		return contas;
	}

	public void addContas(ContaBancaria conta) {
		contas.add(conta);
		
	}
	public void info(int i) {
		System.out.println("\n== Cadastro "+i+"\n"
				+"Nome: " + getNome()+" "+getSobrenome()+"\n"
				+"Idade: "+ getIdade()+"\n"
				+"CPF: "+getCpf()+"\n");
	}
	Stack <Integer> stack = new Stack();
	
	public void listar() {
		for(int i = 0;i< contas.size(); i++) {
			contas.get(i).info();
		}
	}
	public Integer VerificaN(Integer log) {
		for(int i = 0;i< contas.size(); i++) {
			if (contas.get(i).getNroConta().equals(log)) {
				return log;
			}
		}
		return null;
	}
	public boolean verificaSenha(Integer log, String senha) {
		for(int i = 0;i< contas.size(); i++) {
			if (contas.get(i).getNroConta().equals(log)) {
				if(contas.get(i).getSenha().equals(senha)) {
					return true;
				}
			}
		}return false;
	}
	public void removeConta(int log) {
		contas.remove(log);
	}
	public void infoL(Integer log) {
		contas.get(log).infoL();
	}
	public void saque(Integer log) {
		contas.get(log).saque();
	}
	public void deposito(Integer log) {
		contas.get(log).deposito();
	}
	public void NovoMes(Integer log) {
		contas.get(log).NovoMes();
	}
}
