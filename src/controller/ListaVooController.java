package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Voo;
import to.VooTO;

@WebServlet("/voolista.do")
public class ListaVooController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Voo vm = new Voo();

		ArrayList<VooTO> vto  = vm.ListaVoo();

		HttpSession session = request.getSession(true);
		String optionVoo = "";

		for (VooTO voos : vto) { 

			String[] dtdestinoAr = voos.DataDestino.toString().split("-");
			String dtDestino = dtdestinoAr[2] + "/" +dtdestinoAr[1]+ "/" +dtdestinoAr[0];
			String[] dtorigemAr = voos.DataOrigem.toString().split("-");
			String dtOrigem = dtorigemAr[2] + "/" +dtorigemAr[1]+ "/" +dtorigemAr[0];
			
			optionVoo += "<tr>"+
					"<td>"+voos.IdVoo+"</td>"+
					"<td>"+voos.Companhia+"</td>"+
					"<td>"+voos.Origem+"</td>"+
					"<td>"+dtOrigem+" - "+voos.HoraOrigem+"</td>"+
					"<td>"+voos.Destino+"</td>"+
					"<td>"+dtDestino+" - "+voos.HoraDestino+"</td>"+
					"<td>"+
					"<button type=\"button\" class=\"btn btn-info btn-sm btn-alterarvoo\" data-idvoo="+voos.IdVoo+" data-toggle=\"modal\" data-target=\"#AlterarModal\">"+
					"<span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\">"+
					"</span>"+
					"</button>"+
					"</td>"+
					"<td>"+
					"<button type=\"button\" class=\"btn btn-danger btn-sm btn-excluirvoo\" data-toggle=\"modal\" data-idvoo="+voos.IdVoo+" data-target=\"#ExcluirModal\">"+
					"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\">"+
					"</span>"+
					"</button>"+
					"</td>"+
					"</tr>";

		}


		session.setAttribute("listaVoos", optionVoo);
		response.sendRedirect("Supervisor/voolista.jsp");
		//RequestDispatcher view = request.getRequestDispatcher("Supervisor/voo.jsp");
		//view.forward(request, response);
	}

	@Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
