package br.com.alura.carteira.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.alura.carteira.dao.TransacaoDao;

public class ConnectionFactory {

	public Connection getConnection () {
		try{
			String url = "jdbc:mysql://localhost:3306/carteira";
			//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
			// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
			String usuario = "root";
			String senha = "root"; //senha fake	
			
//			Class.forName("com.mysql.cj.jdbc.Driver"); mysql versão 8
			Class.forName("com.mysql.jdbc.Driver"); //mysql versão 5
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			return conexao;
		} catch  (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
