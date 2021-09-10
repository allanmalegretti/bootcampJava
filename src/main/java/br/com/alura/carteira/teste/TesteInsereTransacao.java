package br.com.alura.carteira.teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteInsereTransacao {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/carteira";
		String usuario = "root";
		String senha = "q1w2e3r4";
		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			Transacao t = new Transacao("BBSE3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);
			
			String ql = "insert into transacoes (ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?)";
			
		} catch (SQLException e) {
			System.out.println("Erro ao conectar no MySQL");
		}
	}

}
