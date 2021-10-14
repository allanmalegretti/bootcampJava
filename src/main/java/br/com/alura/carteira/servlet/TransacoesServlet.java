package br.com.alura.carteira.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.carteira.dao.TransacaoDao;
import br.com.alura.carteira.factory.ConnectionFactory;
import br.com.alura.carteira.modelo.TipoTransacao;
import br.com.alura.carteira.modelo.Transacao;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {
	
	private TransacaoDao dao;
	
//	public TransacoesServlet(TransacaoDao dao) {
	public TransacoesServlet() {
		this.dao = new TransacaoDao(new ConnectionFactory().getConnection());
		
//		try{
//			String url = "jdbc:mysql://localhost:3306/carteira";
//			//String url = "jdbc:mysql://localhost:3306/carteira?useSSL=false&serverTimeZone=UTC";
//			// String url ="jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimeZone=UTC";
//			String usuario = "root";
//			String senha = "root";	
//			
////			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection conexao = DriverManager.getConnection(url, usuario, senha);
//			this.dao = new TransacaoDao(conexao);
//		} catch  (Exception e) {
//			System.out.println("Ocorreu um erro!");
//			e.printStackTrace();
//		}
	}

	private List<Transacao> transacoes = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Transacao t1 = new Transacao("ITSA4", LocalDate.of(2021, 2, 1), new BigDecimal("11.50"), 80, TipoTransacao.COMPRA);
		//Transacao t2 = new Transacao("BBSE3", LocalDate.of(2021, 2, 1), new BigDecimal("23.50"), 20, TipoTransacao.VENDA);
		//Transacao t3 = new Transacao("DEVA11", LocalDate.of(2021, 2, 1), new BigDecimal("102.50"), 10, TipoTransacao.COMPRA);
		//transacoes.add(t1);
		//transacoes.add(t2);
		//transacoes.add(t3);

		req.setAttribute("transacoes", dao.listar());

		req.getRequestDispatcher("WEB-INF/jsp/transacoes.jsp").forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String ticker = req.getParameter("ticker");
			LocalDate data = LocalDate.parse(
					req.getParameter("data"),
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));		
			BigDecimal preco = new BigDecimal (
					req.getParameter("preco").replace(",", "."));	
			int quantidade = Integer.parseInt(req.getParameter("quantidade"));
			TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));
			
			Transacao transacao = new Transacao(ticker, data, preco, quantidade, tipo);	
			
			dao.cadastrar(transacao);
			
			resp.sendRedirect("transacoes");
						
		} catch (NumberFormatException e) {
			resp.sendRedirect("transacoes?erro=campo invalido!");
			
		}
	}
}
