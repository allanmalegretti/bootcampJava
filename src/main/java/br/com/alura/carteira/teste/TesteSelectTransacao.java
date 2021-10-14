package br.com.alura.carteira.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.modelo.Transacao;

public class TesteSelectTransacao {

	public static void main(String[] args) {
		
		try{
			String url = "jdbc:mysql://localhost:3306/carteira";
			//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
			// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
			String usuario = "root";
			String senha = "root";			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			TransacaoDao dao = new TransacaoDao(conexao);
			
			List<Transacao> transacoes = dao.listar();
			
			//transacoes.forEach(System.out::println);
			
			for (Transacao transacao : transacoes) {
				System.out.println(transacao);
			}
			
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro!");
		}
		


//		String url = "jdbc:mysql://localhost:3306/carteira";
//		//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
//		// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
//		String usuario = "root";
//		String senha = "q1w2e3r4"; //senha fake
//		
//		try {
//
//			Connection conexao = DriverManager.getConnection(url, usuario, senha);
//
//			String sql = "select * from transacoes";
//			
//			PreparedStatement ps = conexao.prepareStatement(sql);
//
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Transacao t = new Transacao();
//				t.setTicker(rs.getString("ticker"));
//				t.setData(rs.getDate("data").toLocalDate());
//				t.setPreco(rs.getBigDecimal("preco"));
//				t.setQuantidade(rs.getInt("quantidade"));
//				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
//						
//				System.out.println(t);
//				System.out.println("------------------");
//			}
//
//		} catch (SQLException e) {
//			System.out.println("Erro ao conectar no MySQL");
//		}
	}
}
