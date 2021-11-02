package br.com.alura.carteira.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import br.com.alura.carteira.modelo.TipoTransacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoFormDto {
	
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 6)
	private String ticker;
	
	@NotNull
	@DecimalMin("0.01")
	private BigDecimal preco;
	
	@PastOrPresent
	private LocalDate data;
	
	@NotNull
	private int quantidade;
	
	@NotNull
	private TipoTransacao tipo;

//	public String getTicker() {
//		return ticker;
//	}
//
//	public void setTicker(String ticker) {
//		this.ticker = ticker;
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
//	public LocalDate getData() {
//		return data;
//	}
//	
//	public void setData(LocalDate data) {
//		this.data = data;
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
