package entities;

public class ContaCorrente extends ContaBancaria {

		
	private Double TaxasMensais;

	public ContaCorrente(Pessoa titular, Banco banco, Integer nroConta,Double saldo, String senha) {
		super(titular, banco, nroConta,saldo, senha);
		
		TaxasMensais = 5.00;
	}

	public Double getTaxasMensais() {
		return TaxasMensais;
	}

	public void setTaxasMensais(Double taxasMensais) {
		TaxasMensais = taxasMensais;
	}
	@Override
	public void infoL() {
		System.out.println("Conta corrente\n");
		super.infoL();
		System.out.println("Saldo: "+getSaldo());
		System.out.println("Taxa Mensal: "+getTaxasMensais());
	}
	@Override
	public void NovoMes() {
		super.NovoMes();
		System.out.println("Novo Mes: "+(saldo = saldo - TaxasMensais)+"\n");
	}
}
