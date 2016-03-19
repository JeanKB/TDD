package br.com.caelum.leilao.servico;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente(){
		
		//Cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(joao, 400.0));
		
		//executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		/*Como double tem problemas de arredondamento, a versão mais nova do JUnit pede para passar o "tamanho do erro aceitável".
		  No caso, estou passando 0.00001. Ou seja, a diferença entre o esperado e o calculado pode ser de até 0.00001, 
		  que o JUnit entenderá como erro normal de arredondamento.*/
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorQueTodos(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorQueTodos(), 0.0001);		
	}
	
	@Test
	public void deveCalcularAMedia(){
		//Cenario: 3 lances em ordem crescente
		
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Play 4");
		
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(joao, 500.0));
		
		//executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
	    // comparando a saida com o esperado
		Assert.assertEquals(400, leiloeiro.getMedia(), 0.0001);
		
	}
}
