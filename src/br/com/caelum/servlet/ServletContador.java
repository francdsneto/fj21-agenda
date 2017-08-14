package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/contador")
public class ServletContador extends HttpServlet {

	private int contador = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6992869166294348265L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		log("Iniciando a servlet");
		super.init();
		
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador++; // a cada requisição a mesma variável é incrementada
		
		// recebe o writer
		PrintWriter out = response.getWriter();
		
		// escreve o texto
		out.println("<html>");
		out.println("<body>");
		out.println("Contador agora é: " + contador);
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log("Destruindo a servlet");
		super.destroy();	
		
	}
	
}
