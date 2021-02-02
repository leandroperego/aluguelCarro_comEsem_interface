package model.entidades;

public class Fatura {

	private Double pagamentoBasico;
	private Double imposto;
	
	public Fatura() {
	}
	
	public Fatura(Double pagamentoBasico, Double imposto) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	public Double pagamentoTotal() {
		return this.pagamentoBasico + this.imposto;
	}
	
	@Override
	public String toString() {
		return String.format("Valor Aluguel: %.2f%n"
							+ "Valor Imposto: %.2f%n"
							+ "Valor Total a Pagar: %.2f", this.pagamentoBasico, this.imposto, this.pagamentoTotal());
	}
}