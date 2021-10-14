package br.com.alura.carteira.teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteInsereTransacao {

	public static void main(String[] args) {
		
		try{
			String url = "jdbc:mysql://localhost:3306/carteira";
			//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
			// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
			String usuario = "root";
			String senha = "root";			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			
			Transacao transacao = new Transacao("HCTR12", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);
			
			dao.cadastrar(transacao);
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro!");
		}

//		String url = "jdbc:mysql://localhost:3306/carteira";
//		//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
//		// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
//		String usuario = "root";
//		String senha = "q1w2e3r4";
//		
//		try {
//
//			Connection conexao = DriverManager.getConnection(url, usuario, senha);
//
//			Transacao t = new Transacao("PRIO3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);
//
//			String sql = "insert into transacoes (ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?)";
//
//			PreparedStatement ps = conexao.prepareStatement(sql);
//			ps.setString(1, t.getTicker());
//			ps.setBigDecimal(2, t.getPreco());
//			ps.setInt(3, t.getQuantidade());
//			ps.setDate(4, Date.valueOf(t.getData()));
//			ps.setString(5, t.getTipo().toString());
//
//			ps.execute();
//			//boolean deuCerto = ps.execute();
//			//System.out.println(deuCerto);
//
//		} catch (SQLException e) {
//			System.out.println("Erro ao conectar no MySQL");
//		}
	}
}