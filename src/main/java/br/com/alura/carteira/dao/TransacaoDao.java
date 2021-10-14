package br.com.alura.carteira.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

public class TransacaoDao {
	
	private Connection conexao;

	public TransacaoDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Transacao transacao) {
		//String url = "jdbc:mysql://localhost:3306/carteira";
		//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
		// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
		//String usuario = "root";
		//String senha = "q1w2e3r4";
		
		try {

			//Connection conexao = DriverManager.getConnection(url, usuario, senha);

			//Transacao t = new Transacao("PRIO3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.COMPRA);

			String sql = "insert into transacoes (ticker, preco, quantidade, data, tipo) values(?, ?, ?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, transacao.getTicker());
			ps.setBigDecimal(2, transacao.getPreco());
			ps.setInt(3, transacao.getQuantidade());
			ps.setDate(4, Date.valueOf(transacao.getData()));
			ps.setString(5, transacao.getTipo().toString());

			ps.execute();
			//boolean deuCerto = ps.execute();
			//System.out.println(deuCerto);

		} catch (SQLException e) {
			throw new RuntimeException(e);
			//System.out.println("Erro ao conectar no MySQL");
		}
	}
	
	public List<Transacao> listar() {
		//String url = "jdbc:mysql://localhost:3306/carteira";
		//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
		// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
		//String usuario = "root";
		//String senha = "root";
		
		try {

			//Connection conexao = DriverManager.getConnection(url, usuario, senha);

			String sql = "select * from transacoes";
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List <Transacao> transacoes = new ArrayList<>();
			
			while(rs.next()) {
				Transacao t = new Transacao();
				t.setTicker(rs.getString("ticker"));
				t.setData(rs.getDate("data").toLocalDate());
				t.setPreco(rs.getBigDecimal("preco"));
				t.setQuantidade(rs.getInt("quantidade"));
				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
						
				transacoes.add(t);
				
				//System.out.println(t);
				//System.out.println("------------------");
			}
			return transacoes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
			//System.out.println("Erro ao conectar no MySQL");
		}
	}
}