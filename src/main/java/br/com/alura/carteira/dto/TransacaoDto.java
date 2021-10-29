package br.com.alura.carteira.dto;

import java.math.BigDecimal;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TransacaoDto {
	
	private String ticker;
	private BigDecimal preco;
	private int quantidade;
	private TipoTransacao tipo;
	
//	public TransacaoDto(Transacao transacao) {
//		this.ticker = transacao.getTicker();
//		this.preco = transacao.getPreco();
//		this.quantidade = transacao.getQuantidade();
//		this.tipo = transacao.getTipo();	
//	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

}
