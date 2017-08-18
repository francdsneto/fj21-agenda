package br.com.caelum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
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


		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();
		try {
			dataNascimento.setTime(new  SimpleDateFormat("dd/MM/yyyy").parse(dataTexto));
		} catch (ParseException e) {
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
			return;
		}		

		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request,response);


	}



}
