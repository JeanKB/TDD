package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		 assertEquals(maiorEsperado, leiloeiro.getMaiorQueTodos(), 0.0001);
		 assertEquals(menorEsperado, leiloeiro.getMenorQueTodos(), 0.0001);		
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
		assertEquals(400, leiloeiro.getMedia(), 0.0001);
		
	}
	
	@Test
    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
			
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Carteira de couro");
		
		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(maria, 500.0));
		leilao.propoe(new Lance(joao, 600.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		assertEquals(600.0, leiloeiro.getMaiorQueTodos(), 0.00001);
		assertEquals(200.0, leiloeiro.getMenorQueTodos(), 0.00001);
	}
	
	@Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.pegaOsMaioresNo(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
	
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	}
	
	@Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Usuario joao = new Usuario("João");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.pegaOsMaioresNo(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.pegaOsMaioresNo(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(0, maiores.size());
    }
}
