package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorQueTodos = Double.NEGATIVE_INFINITY;
	private double menorQueTodos = Double.POSITIVE_INFINITY;
	private double media = 0;

	public void avalia(Leilao leilao){
		double total = 0;
		for(Lance lance : leilao.getLances()){
			if(lance.getValor() > maiorQueTodos) maiorQueTodos = lance.getValor();
			if(lance.getValor() < menorQueTodos)menorQueTodos  = lance.getValor();
			
			total += lance.getValor();
		}
		media = total / leilao.getLances().size();
	}

	public double getMaiorQueTodos() {
		return maiorQueTodos;
	}

	public double getMenorQueTodos() {
		return menorQueTodos;
	}

	public double getMedia() {
		return media;
	}
}
