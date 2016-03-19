package br.com.caelum.leilao.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

	private double maiorQueTodos = Double.NEGATIVE_INFINITY;
	private double menorQueTodos = Double.POSITIVE_INFINITY;
	private double media = 0;
	private List<Lance> maiores;

	public void avalia(Leilao leilao){
		double total = 0;
		for(Lance lance : leilao.getLances()){
			if(lance.getValor() > maiorQueTodos) maiorQueTodos = lance.getValor();
			if(lance.getValor() < menorQueTodos)menorQueTodos  = lance.getValor();
			
			total += lance.getValor();
		}
		media = total / leilao.getLances().size();
	}
	
	public void pegaOsMaioresNo(Leilao leilao){
		maiores = new ArrayList<Lance>(leilao.getLances());
		Collections.sort(maiores,  new Comparator<Lance>(){

			public int compare(Lance lance1, Lance lance2) {
				if(lance1.getValor() < lance2.getValor()) return 1;
				if(lance1.getValor() > lance2.getValor()) return -1;
				return 0;
			}
		});
		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}
	
	public double getMaiorQueTodos() {
		return this.maiorQueTodos;
	}

	public double getMenorQueTodos() {
		return this.menorQueTodos;
	}

	public double getMedia() {
		return this.media;
	}

	public List<Lance> getTresMaiores() {
		return this.maiores;
	}
	
}
