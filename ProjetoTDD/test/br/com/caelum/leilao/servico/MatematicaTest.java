package br.com.caelum.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTest {

	@Test
    public void deveMultiplicarNumerosMaioresQue30() {
        Matematica matematica = new Matematica();
        assertEquals(50*4, matematica.conta(50));
    }

    @Test
    public void deveMultiplicarNumerosMaioresQue10EMenoresQue30() {
        Matematica matematica = new Matematica();
        assertEquals(20*3, matematica.conta(20));
    }

    @Test
    public void deveMultiplicarNumerosMenoresQue10() {
        Matematica matematica = new Matematica();
        assertEquals(5*2, matematica.conta(5));
    }
}
