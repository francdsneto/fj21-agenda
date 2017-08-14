package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
(
		name = "OlaMundo",
		urlPatterns = {
				"/ola"
		},
		initParams = {
				@WebInitParam(name="oque",value="Mundo")
		}
)
public class OiMundo2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7504125086379244260L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<HTML>");
		writer.println("<HEAD>");
		writer.println("<TITLE>Oi Mundo</TITLE>");
		writer.println("</HEAD>");
		writer.println("<BODY>");
		writer.println("<H1>Olá "+getServletConfig().getInitParameter("oque")+"!</H1>");
		writer.println("</BODY>");
		writer.println("</HTML>");
		
		writer.close();
		
	}
	
}
