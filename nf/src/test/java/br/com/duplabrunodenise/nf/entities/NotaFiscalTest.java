package br.com.duplabrunodenise.nf.entities;

import org.junit.Assert;
import org.junit.Test;

import br.com.duplabrunodenise.nf.entities.NotaFiscal;

public class NotaFiscalTest {

	@Test
	public void test() {
		NotaFiscal notaFiscal = new NotaFiscal();
		
		notaFiscal.setValorImposto(10.0);
		notaFiscal.setValorBruto(100.0);
		
		Assert.assertEquals(110.0, notaFiscal.getValorTotal(), 0.001);
	}

}
