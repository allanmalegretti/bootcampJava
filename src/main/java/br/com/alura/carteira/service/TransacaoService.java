package br.com.alura.carteira.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.carteira.dto.TransacaoDto;
import br.com.alura.carteira.dto.TransacaoFormDto;
import br.com.alura.carteira.modelo.Transacao;
import br.com.alura.carteira.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	private ModelMapper modelMapper = new ModelMapper();

	public List<TransacaoDto> Listar() {
		List<Transacao> transacoes = transacaoRepository.findAll();
		return transacoes.stream().map(t -> modelMapper.map(t, TransacaoDto.class)).collect(Collectors.toList());
	}

	public void cadastrar(TransacaoFormDto dto) {
		Transacao transacao = modelMapper.map(dto, Transacao.class);	
		transacaoRepository.save(transacao);
	}
}
