package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet(name="adicionaContato",
			urlPatterns = {"/adicionaContato"})
public class AdicionaContatoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2626463656813882677L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		try {
			dataNascimento.setTime(new  SimpleDateFormat("dd/MM/yyyy").parse(dataTexto));
		} catch (ParseException e) {
			out.println("Erro na conversão da data.");
			return;
		}		
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		ContatoDao dao;
		try {
			dao = new ContatoDao();
			dao.adiciona(contato);
		} catch (ClassNotFoundException e) {
			out.println("Erro na inserção do contato.");
			return;
		}		
		
		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() +
		" adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	
	
}
