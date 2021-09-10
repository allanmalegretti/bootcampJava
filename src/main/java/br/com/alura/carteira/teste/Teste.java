package br.com.alura.carteira.teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class Teste {

	public static void main(String[] args) {
		Transacao t = new Transacao();
		t.setTicker("ITSA4");
		t.setData(LocalDate.now());
		t.setPreco(new BigDecimal("10.50"));
		t.setQuantidade(100);	
		t.setTipo(TipoTransacao.COMPRA);

		System.out.println(t.getTicker());
		System.out.println(t.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(t.getPreco());
		System.out.println(t.getQuantidade());
		System.out.println(t.getTipo());

		Transacao t2 = new Transacao("BBSE3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);
		
//		System.out.println(t);
		System.out.println(t2);
	}

}
