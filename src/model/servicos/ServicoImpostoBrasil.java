package model.servicos;

public class ServicoImpostoBrasil implements ServicoImposto {

	public double calcularImposto(Double valorReceita) {
		
		if (valorReceita <= 100) {
			return valorReceita * 0.2;
		}else {
			return valorReceita * 0.15;
		}
	}
	
}
