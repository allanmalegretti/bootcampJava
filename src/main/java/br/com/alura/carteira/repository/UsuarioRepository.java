package br.com.alura.carteira.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.alura.carteira.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

	Optional<Usuario>  findByLogin(String login);
	
}