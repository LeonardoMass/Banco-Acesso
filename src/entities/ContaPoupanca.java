package entities;

public class ContaPoupanca extends ContaBancaria{

	private Double rendimento;
	private Integer saqueMensais;
	
	
	public ContaPoupanca(Pessoa titular, Banco banco, Integer nroConta,Double saldo, String senha) {
		super(titular, banco, nroConta,saldo, senha);
		this.rendimento = 0.02;
		this.saqueMensais = 3;
	}


	public Double getRendimento() {
		return rendimento;
	}


	public Integer getSaqueMensais() {
		return saqueMensais;
	}


	public void setRendimento(Double rendimento) {
		this.rendimento = rendimento;
	}


	public void setSaqueMensais(Integer saqueMensais) {
		this.saqueMensais = saqueMensais;
	}
	
	@Override
	public void saque() {
		if (saqueMensais <= 0) {
			System.out.println("Limite de saques alcançado.");
		}	else {
				super.saque();
				saqueMensais = saqueMensais -1;
				System.out.println("Saques Totais: "+getSaqueMensais());
			}
	}
	@Override
	public void infoL() {
		System.out.println("Conta poupança \n");
		super.infoL();
		System.out.println("Saldo: "+getSaldo());
		System.out.println("Rendimento: "+getRendimento()+"%");
		System.out.println("Saques total esse mês: "+getSaqueMensais());
	}
	@Override
	public void NovoMes() {
		super.NovoMes();
		System.out.println("Rendimento: "+getRendimento());
		System.out.println("Novo Mes: "+(this.saldo = this.saldo+(this.saldo * getRendimento()))+"\n");
		saqueMensais = 3;
	}
}
	

