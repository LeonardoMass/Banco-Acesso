package entities;
import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class ContaBancaria {
	
	protected Pessoa titular;
	protected Banco banco;
	protected Integer NroConta;
	protected Double saldo;
	protected String senha;
	Scanner tec = new Scanner(System.in);
	
	public ContaBancaria() {
		
	}

	public ContaBancaria(Pessoa titular, Banco banco, Integer nroConta,Double saldo, String senha) {
		this.titular = titular;
		this.banco = banco;
		this.saldo = saldo;
		NroConta = nroConta;
		this.senha = senha;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public Banco getBanco() {
		return banco;
	}

	public Integer getNroConta() {
		return NroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public String getSenha() {
		return senha;
	}
	public void saque(Double saque) {
		
		if(saque > this.saldo) {
			System.out.println("Saque invalido");
			}else {
				this.saldo = this.saldo - saque;
				System.out.println("Novo saldo: "+this.saldo);
		}
	}

	public void saque() {
		System.out.println("Saldo: "+this.saldo);
		String saqueD = JOptionPane.showInputDialog("Digite um valor para saque:");
        double saque = Double.parseDouble(saqueD);
		if(saque > this.saldo) {
			System.out.println("Saque invalido");
			}else {
				this.saldo = this.saldo - saque;
				System.out.println("Novo saldo: "+this.saldo);
		}

	}
	public void deposito() {
		System.out.println("Saldo: "+this.saldo);
		String depositoD = JOptionPane.showInputDialog("Digite o valor a ser depositado:");
        double deposito = Double.parseDouble(depositoD);
		this.saldo = this.saldo + deposito;
	}
	
	public void deposito(Double deposito) {
		System.out.println("Saldo: "+this.saldo);
		this.saldo = this.saldo + deposito;
	}

	public void infoL() {
		System.out.println("== conta numero "+getNroConta()+"\n"
				+"Nome: " + getTitular().getNome()+" "+getTitular().getSobrenome()+"\n"
				+"Banco: "+ getBanco().getNome()+"\n"
				+"CPF: "+getTitular().getCpf()+"\n"
				+"Numero do Banco: "+getBanco().getNroBanco()+"\n");
	}
	
	public void info() {
		System.out.println("\n== conta numero "+getNroConta()+"\n"
				+"Nome: " + getTitular().getNome()+" "+getTitular().getSobrenome()+"\n"
				+"Banco: "+ getBanco().getNome()+"\n"
				+"CPF: "+getTitular().getCpf()+"\n"
				+"Numero do Banco: "+getBanco().getNroBanco()+"\n");
	}
	

	public void NovoMes() {
		System.out.println("=== Simulação ====");
	
		
	}
	
	public boolean VerificaSenha(String senha) {
		if (senha.equals(this.senha)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean VerificaSenha() {
		String senha = JOptionPane.showInputDialog("Qual a senha?");
		if (senha.equals(this.senha)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}
