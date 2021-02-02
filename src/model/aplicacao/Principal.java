package model.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.AluguelCarro;
import model.entidades.Fatura;
import model.entidades.Veiculo;
import model.servicos.ServicoDeAluguel;
import model.servicos.ServicoImpostoBrasil;

public class Principal {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Dados Aluguel de Carro:");
		System.out.print("Carro: ");
		String carro = sc.nextLine();
		System.out.print("Data e Hora retirada (dd/MM/yyyy HH:mm): ");
		Date retirada = sdf.parse(sc.nextLine());
		System.out.print("Data e Hora devolução (dd/MM/yyyy HH:mm): ");
		Date devolucao = sdf.parse(sc.nextLine());
		
		AluguelCarro aluguel = new AluguelCarro(retirada, devolucao, new Veiculo(carro));
		
		System.out.print("Preço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Preço por dia: ");
		double precoDia = sc.nextDouble();
		
		ServicoDeAluguel servico = new ServicoDeAluguel(precoHora, precoDia, new ServicoImpostoBrasil());
		
		System.out.println("Fatura:");
		
		//processar a fatura
		servico.processarFatura(aluguel);
		
		System.out.println(aluguel.getFatura().toString());
	}

}
