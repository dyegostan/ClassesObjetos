package objetoExercicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Administracao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		int resp=0;
//		LocalDate dataHoje = LocalDate.now();
		
		System.out.println("Digite o ip da Rede de Computadores: ");
		String ipRede = ler.nextLine();
		RedeDeComputadores rede = new RedeDeComputadores(ipRede);
		
		do {
			
			System.out.println("Digite o ip do computador: ");
			String ip = ler.nextLine();
			System.out.println("Digite a marca do computador: ");
			String marca = ler.nextLine();
			System.out.println("Digite o modelo do computador: ");
			String modelo = ler.nextLine();
			System.out.println("Digite a data de aquisição do computador [dd/mm/yyyy]: ");
			String data = ler.nextLine();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataAquisicao = LocalDate.parse(data, formatador);
			
			Computador computador= new Computador(ip,marca,modelo,dataAquisicao);
			rede.adicionaComputadorNaLista(computador);
			
			System.out.println("Adicionar outro computador? [1=sim]");
			resp = ler.nextInt();
			ler.nextLine();
			
		} while(resp==1);
		
		System.out.println("Digite a marca que deseja pesquisar: ");
		String marca = ler.nextLine();
		rede.listaComputadoresPorMarca(marca);
		
		System.out.println("Digite o modelo que deseja pesquisar: ");
		String modelo = ler.nextLine();
		rede.listaComputadoresPorModelo(modelo);
		
		System.out.println("Computadores ordenados por data de aquisição: ");
		Computador[] lista = rede.ordenarComputadoresPorDataAquisicao();
		for(int i=0;i<rede.tamanhoDaLista();i++) {
			System.out.println(lista[i]);
		}
		
		System.out.println("Quantidade de computadores a partir de [dd/mm/yyyy]: ");
		String data = ler.nextLine();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate QtdData = LocalDate.parse(data, formatador);
		System.out.println(rede.qtdComputadoresAdquiridosAposData(QtdData));
		
		ler.close();
	
	}

}
