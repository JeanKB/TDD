package br.com.caelum.leilao.servico;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {

	@Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();
        boolean resultado = p.ehPalindromo("Socorram-me subi no onibus em Marrocos");
        
        Assert.assertTrue(resultado);
    }
	
	@Test
    public void deveIdentificarPalindromo() {
        Palindromo palindromo = new Palindromo();
        boolean resultado = palindromo.ehPalindromo("Anotaram a data da maratona");
        
        Assert.assertTrue(resultado);
    }
	
    @Test
    public void deveIdentificarSeNaoEhPalindromo() {
        Palindromo palindromo = new Palindromo();
        boolean resultado = palindromo.ehPalindromo("E preciso amar as pessoas como se nao houvesse amanha");
        
        Assert.assertFalse(resultado);
    }
}
