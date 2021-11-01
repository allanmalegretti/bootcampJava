package br.com.alura.carteira;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TestandoLombok {
	
	public static void main(String[] args) {
		Transacao t = new Transacao ("DEVA11", LocalDate.now(), new BigDecimal("103.50"), 20, TipoTransacao.COMPRA);

//		Transacao t = new Transacao();
//		t.setPreco(new BigDecimal( "100.99"));
		
		System.out.println(t);
	}
}
