package application;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import entities.Banco;
import entities.ContaBancaria;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.Pessoa;


public class main {

	public static void main(String[] args) {
		Integer n=-1;
		String nome, sobrenome, cpf;
		Integer idade;
		Pessoa titular;
		Banco banco;
		Integer NroConta = 0,nroBanco;
		Double saldo;
		String senha,CNPJ;
		Scanner tec = new Scanner(System.in);
		ArrayList<Pessoa> Pessoas = new ArrayList<>(); 
		ArrayList<Banco> Bancos = new ArrayList<>();
		
		
		Pessoas.add(new Pessoa("Leonardo","Massena",22,"023456" ));
		Pessoas.add(new Pessoa("Carol","Cardoso",23,"065432" ));
		Bancos.add(new Banco("Nubank","123456",0));
		Bancos.add(new Banco("Banrisul","654321",1));
		do {
			if(n == 1) {
				System.out.print("Nome: ");
				tec.nextLine();
				nome = tec.nextLine();
				System.out.print("Sobrenome: ");
				sobrenome = tec.nextLine();
				System.out.print("Idade: ");idade = tec.nextInt();
				tec.nextLine();
				System.out.print("CPF: ");cpf = tec.nextLine();
				
				titular = new Pessoa(nome,sobrenome,idade,cpf);
				Pessoas.add(titular);
				System.out.println("Cadastro completo\n");
				
			}
			
			if(n==2) {
				for(int i = 0;i< Pessoas.size(); i++) {
					Pessoas.get(i).info(i);
				}
			}
			if(n==3) {
					System.out.print("Nome: ");
					tec.nextLine();
					nome = tec.nextLine();
					System.out.print("CNPJ: ");
					CNPJ = tec.nextLine();
					System.out.println("\n");
					nroBanco = Bancos.size() ;			
					banco = new Banco(nome,CNPJ,nroBanco);
					Bancos.add(banco);
			}
			if(n==4) {
				for(int i = 0;i< Bancos.size(); i++) {
					Bancos.get(i).info(i);
				}
			}
			if (n==5) {
				System.out.print("Digite seu CPF: ");
				tec.nextLine();
				cpf = tec.nextLine();
				int d = 0; int c=0;
				for(int i = 0;i<Pessoas.size();i++) {
					if (cpf.equals(Pessoas.get(i).getCpf())){
						Pessoas.get(i).info(i);
						d++;
						c = i;
					}
				}
				if (d==1) {
					
					System.out.print("Tipo de conta que deseja criar: \n"
									+"1 - Conta corrente\n"
									+"2 - Conta poupança\n"
									+"Digite: ");
					int s = tec.nextInt();
					if(s == 1) {
						
						System.out.print("Numero do banco que quer sua conta: ");
						nroBanco = tec.nextInt();
						System.out.print("Saldo: ");
						saldo = tec.nextDouble();
						System.out.print("Senha: ");
						tec.nextLine();
						senha = tec.nextLine();
						
					
						ContaBancaria conta = new ContaCorrente(Pessoas.get(c),Bancos.get(nroBanco),NroConta++,saldo,senha);
						Pessoas.get(c).addContas(conta);
						Bancos.get(nroBanco).addContas(conta);
						System.out.println("Conta criada!\n");
					}
					
					if(s == 2) {
						
						System.out.print("Numero do banco que quer sua conta: ");
						nroBanco = tec.nextInt();
						System.out.print("Saldo: ");
						saldo = tec.nextDouble();
						System.out.print("Senha: ");
						tec.nextLine();
						senha = tec.nextLine();
						
					
						ContaBancaria conta = new ContaPoupanca(Pessoas.get(c),Bancos.get(nroBanco),NroConta++,saldo,senha);
						Pessoas.get(c).addContas(conta);
						Bancos.get(nroBanco).addContas(conta);
						System.out.println("Conta criada!\n");
					}
					
				}
			}
			if (n == 6) {
				System.out.print("Digite seu CPF: ");
				tec.nextLine();
				cpf = tec.nextLine();
				int d = 0;int c =0 ;
				for(int i = 0;i<Pessoas.size();i++) {
					if (cpf.equals(Pessoas.get(i).getCpf())){
						Pessoas.get(i).info(i);
						d++;
						c = i;
					}
				}
				if (d == 1) {
					Pessoas.get(c).listar();
					System.out.print("Digite o numero da conta que deseja logar: ");
					
					int log = tec.nextInt();
					tec.nextInt();
					
					int op =10;
					if(log == Pessoas.get(c).VerificaN(log)) {
						while (log == log) {
							senha = JOptionPane.showInputDialog("Digite a senha da conta:");
							if (senha.equals("0")) {
								break;
							}
							
							if (Pessoas.get(c).verificaSenha(log, senha)) {	
								System.out.println("Acesso permitido\n");
								do {
									Pessoas.get(c).infoL(log);
									System.out.println("Digite o numero da Operação que deseja \n"
										+"1 - Saque\n"
										+"2 - Deposito\n"
										+"3 - Novo Mês\n"
										+"4 - Excluir conta\n"
										+"0 - Sair");
									System.out.print("Digite o número da operaçao: ");
									op = tec.nextInt();
									if(op == 1) {
										Pessoas.get(c).saque(log);
									}
									if (op == 2) {
										Pessoas.get(c).deposito(log);
									}
									if (op == 3) {
										Pessoas.get(c).NovoMes(log);
									}
									if(op ==4) {
										Pessoas.get(c).removeConta(log);
										System.out.println("\nConta Fechada! \n");
										break;
										
									}
								
								}while (op !=0);
							}else {
								System.out.print("Senha invalida!\n"
										+"Tente novamente ou digite 0 para deslogar\n");
							}
							if (op == 4|| op == 0) {
								break;
							}
						}
					}
					
				}
				
			}
			
			
			System.out.println("\n1 – Cadastrar pessoa\r\n"
					+ "2 – Listar pessoas\r\n"
					+ "3 – Cadastrar banco\r\n"
					+ "4 – Lista bancos\r\n"
					+ "5 – Cadastrar Conta bancaria\r\n"
					+ "6 – Acessar Contas bancarias\r\n"
					+ "0 – Encerrar atividades");
			System.out.print("Nª ");n = tec.nextInt();
			
		}while (n != 0);
		
		tec.close();
	}

}
