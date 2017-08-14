package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426823051573616673L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("<TITLE>Oi Mundo</TITLE>");
		writer.println("</HEAD>");
		writer.println("<BODY>");
		writer.println("<H1>Olá Mundo!</H1>");
		writer.println("</BODY>");
		writer.println("</HTML>");
		
	}
	
}
