package objetoExercicio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class RedeDeComputadores {
	private String ip;
	private int n=0;
	private Computador[] listaComputadores;
	Scanner ler = new Scanner(System.in);
	
	public RedeDeComputadores(String ip) {
		
		this.ip = ip;
		this.listaComputadores = new Computador[50];
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Computador[] getListaComputadores() {
		return listaComputadores;
	}

	public void setListaComputadores(Computador[] listaComputadores) {
		this.listaComputadores = listaComputadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + Arrays.hashCode(listaComputadores);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedeDeComputadores other = (RedeDeComputadores) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (!Arrays.equals(listaComputadores, other.listaComputadores))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RedeDeComputadores [ip=" + ip + ", listaComputadores=" + Arrays.toString(listaComputadores) + "]";
	}	
	
	public int tamanhoDaLista(){
		return n;
	}
	
	public void adicionaComputadorNaLista(Computador c) {
		
		listaComputadores[n] = c;
		n++;
		System.out.println("Computador adicionado.");
	}
	
	public void listaComputadoresPorMarca(String marca) {
		for(int i=0;i<tamanhoDaLista();i++) {
			if(listaComputadores[i].getMarca().equals(marca)) {
				System.out.println(listaComputadores[i]);
			}
		}
	}
	
	public void listaComputadoresPorModelo(String modelo) {
		for(int i=0;i<tamanhoDaLista();i++) {
			if(listaComputadores[i].getModelo().equals(modelo)) {
				System.out.println(listaComputadores[i]);
			}
		}
	}
	
	public int qtdComputadoresAdquiridosAposData(LocalDate data) {
		int qtd=0;
		for(int i=0;i<n;i++) {
			if(listaComputadores[i].getDataAquisicao().isAfter(data)) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public Computador[] ordenarComputadoresPorDataAquisicao() {
		Computador aux;
		for(int i=0;i<n ;i++) {
			for(int k=0;k<n-1;k++) {
				if(listaComputadores[k+1].getDataAquisicao().isBefore(listaComputadores[k].getDataAquisicao())) {
					aux=listaComputadores[k];
					listaComputadores[k]=listaComputadores[k+1];
					listaComputadores[k+1]=aux;
				}
			}
		}
		return listaComputadores;
	}
	
}
