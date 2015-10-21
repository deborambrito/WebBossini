package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.glass.events.ViewEvent;

import to.LoginTO;
import model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("visivel", "hidden");
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginTO lto = new LoginTO();
		Login lmodel = new Login();
		
		lto.Email = request.getParameter("Email").toString();
		lmodel.setPassword(request.getParameter("Password").toString());
		lto.Password = lmodel.getPassword();
		
		//Boolean reg = lmodel.register(lto);
		
		LoginTO log = lmodel.login(lto);
		
		
		if(log.PasswordCompara){
			if(log.Tipo.equals("Supervisor"))
			{
				response.sendRedirect("Supervisor/index.html");
				
			}else if (log.Tipo.equals("Atendente")){
				
				response.sendRedirect("Atendente/index.html");
			}
		}
		else if (!log.PasswordCompara){
			request.setAttribute("erro", "E-mail ou senha incorreto!");
			request.setAttribute("visivel", "");
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
		}
		
	}
	
	@Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
