package br.com.alura.carteira.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import java.util.Date;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"data", "quantidade", "tipo"})
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
	
	private String ticker;
	private LocalDate data;
	private BigDecimal preco;
	private int quantidade;
	private TipoTransacao tipo;
//	private Usuario usuario;

//	@Override
//	public String toString() {
//		return super.toString();
//		return "Java � chique";
//	}
//
//	public Transacao() {
//	}
//
//	@Override
//	public String toString() {
//		return "Transacao [ticker=" + ticker + ", data=" + data + ", preco=" + preco + ", quantidade=" + quantidade
//				+ ", tipo=" + tipo + "]";
//	}
//
//	public Transacao(String ticker, LocalDate data, BigDecimal preco, int quantidade, TipoTransacao tipo) {
//		super();
//		this.ticker = ticker;
//		this.data = data;
//		this.preco = preco;
//		this.quantidade = quantidade;
//		this.tipo = tipo;
//	}
//
//	public String getTicker() {
//		return ticker;
//	}
//
//	public void setTicker(String ticker) {
//		this.ticker = ticker;
//	}
//
//	public LocalDate getData() {
//		return data;
//	}
//
//	public void setData(LocalDate data) {
//		this.data = data;
//	}
//
//	public BigDecimal getPreco() {
//		return preco;
//	}
//
//	public void setPreco(BigDecimal preco) {
//		this.preco = preco;
//	}
//
//	public int getQuantidade() {
//		return quantidade;
//	}
//
//	public void setQuantidade(int quantidade) {
//		this.quantidade = quantidade;
//	}
//
//	public TipoTransacao getTipo() {
//		return tipo;
//	}
//
//	public void setTipo(TipoTransacao tipo) {
//		this.tipo = tipo;
//	}

}