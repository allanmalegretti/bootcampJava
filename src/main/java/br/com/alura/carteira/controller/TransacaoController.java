package br.com.alura.carteira.controller;

//import java.math.BigDecimal;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

//@Controller
@RestController
@RequestMapping ("/transacoes")
public class TransacaoController {
	
	private List<Transacao> transacoes = new ArrayList<>();
	
	@GetMapping
//	@ResponseBody
	public List<Transacao> listar() {
//		return new Transacao("DEVA11", LocalDate.now(), new BigDecimal("100.90"), 20, TipoTransacao.COMPRA);
		return transacoes;
	}
	
	@PostMapping
	public void cadastrar(@RequestBody Transacao transacao) {
		transacoes.add(transacao);
	}
}
