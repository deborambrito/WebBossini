package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.LoginTO;
import model.Login;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//save message in session
		session.setAttribute("visivel", "hidden");
		
		response.sendRedirect("Supervisor/register.jsp");
		
		//getServletConfig().getServletContext().getRequestDispatcher("/Supervisor/register.jsp").forward(request, response);
		//RequestDispatcher view = request.getRequestDispatcher("/Supervisor/register.jsp");
		//view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
	
		LoginTO lto = new LoginTO();
		Login lmodel = new Login();
		
		lto.Email = request.getParameter("email").toString();
		lmodel.setPassword(request.getParameter("senha").toString());
		lto.Password = lmodel.getPassword();
		lto.Nome = request.getParameter("nome").toString();
		lto.Tipo = request.getParameter("tipo");
		
		Boolean reg = lmodel.register(lto);
		
		if(reg){
			session.setAttribute("retorno", "alert alert-success alert-dismissible");
			session.setAttribute("visivel", "");
			session.setAttribute("msg", "Usuário criado com sucesso!");
			response.sendRedirect("Supervisor/register.jsp");
		}
		else{
			session.setAttribute("retorno", "alert alert-danger alert-dismissible");
			session.setAttribute("visivel", "");
			session.setAttribute("msg", "Ocorreu um problema ao tentar salvar o usuário, por favor tente mais tarde!");
			response.sendRedirect("Supervisor/register.jsp");
		}
		
	}
	
	@Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
