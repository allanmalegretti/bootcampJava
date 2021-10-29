package br.com.alura.carteira.controller;

//import java.math.BigDecimal;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
//import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

//@Controller
@RestController
@RequestMapping ("/transacoes")
public class TransacaoController {
	
	private List<Transacao> transacoes = new ArrayList<>();
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping
//	@ResponseBody
	public List<TransacaoDto> listar() {
//		return new Transacao("DEVA11", LocalDate.now(), new BigDecimal("100.90"), 20, TipoTransacao.COMPRA);

//		List <TransacaoDto> transacoesDto = new ArrayList<>();
//		for (Transacao transacao : transacoes) {
//			TransacaoDto dto = new TransacaoDto();
//			dto.setTicker(transacao.getTicker());	
//			dto.setPreco(transacao.getPreco());
//			dto.setQuantidade(transacao.getQuantidade());
//			dto.setTipo(transacao.getTipo());
//			
//			transacoesDto.add(dto);
//			}
//		return transacoes.stream().map(TransacaoDto::new).collect(Collectors.toList());
		
//		return transacoesDto;
		
//		ModelMapper modelMapper = new ModelMapper();
		return transacoes.stream().map(t -> modelMapper.map(t, TransacaoDto.class)).collect(Collectors.toList());
	}
	
	@PostMapping
	public void cadastrar(@RequestBody TransacaoFormDto dto) {
//		ModelMapper modelMapper = new ModelMapper();
		Transacao transacao = modelMapper.map(dto, Transacao.class);
		
//		Transacao transacao = new Transacao(
//				dto.getTicker(),
//				dto.getData(),
//				dto.getPreco(),
//				dto.getQuantidade(),
//				dto.getTipo());
		
		transacoes.add(transacao);
	}
}
