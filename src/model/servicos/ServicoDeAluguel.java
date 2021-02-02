package model.servicos;

import model.entidades.AluguelCarro;
import model.entidades.Fatura;

public class ServicoDeAluguel {

	private Double precoPorHora;
	private Double precoPorDia;
	private ServicoImpostoBrasil imposto;
	
	public ServicoDeAluguel() {
	}

	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, ServicoImpostoBrasil imposto) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.imposto = imposto;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public ServicoImpostoBrasil getImposto() {
		return imposto;
	}

	public void setImposto(ServicoImpostoBrasil imposto) {
		this.imposto = imposto;
	}
	
	public void processarFatura(AluguelCarro aluguelCarro) {
		//Descobrir a duracao do aluguel
		long dataRetirada = aluguelCarro.getRetirada().getTime();
		long dataDevolucao = aluguelCarro.getDevolucao().getTime();
		double horasDuracao = (double)(dataDevolucao - dataRetirada) / 1000 / 60 / 60;
		// horas duracao = Devolucao - retirada (resultado em milesegundos)
		//divide por 1000 para ter o resultado em segundos
		// divide por 60 para resultado em minutos
		//divide por 60 para resultado em horas.
				
		//Se der <12 hrs, calcular por hora, senao calcular por dia
		double valorAluguel;
		if (horasDuracao < 12.00) {
			valorAluguel = Math.ceil(horasDuracao) * this.precoPorHora;
		}else {
			valorAluguel = Math.ceil(horasDuracao / 24) * this.precoPorDia;
		}
		
		//Calcular o imposto
		double imposto = this.imposto.calcularImposto(valorAluguel);
		
		aluguelCarro.setFatura(new Fatura(valorAluguel,imposto));
	}
	
}
