package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import to.AeroportoTO;
import to.CompanhiasTO;
import to.VooTO;
import model.Aeroporto;
import model.Voo;

@WebServlet("/voo.do")
public class VooController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Voo vm = new Voo();
		Aeroporto am = new Aeroporto();

		ArrayList<CompanhiasTO> vto  = vm.ListaCompanhias();
		ArrayList<AeroportoTO> ato  = am.ListaAeroporto();

		HttpSession session = request.getSession(false);
		String optionCompanhias = "";
		String optionAeroporto = "";

		for (CompanhiasTO companhias : vto) { 

			optionCompanhias += "<option value=\""+companhias.id+"\">"+companhias.nome+"</option>";

		}

		for (AeroportoTO aeroportos : ato) { 

			optionAeroporto += "<option value=\""+aeroportos.IdAeroporto+"\">"+aeroportos.Nome+"</option>";

		}
		session.setAttribute("visivel", "hidden");
		session.setAttribute("lista", optionCompanhias);
		session.setAttribute("listaAeroporto", optionAeroporto);
		response.sendRedirect("Supervisor/voo.jsp");
		//RequestDispatcher view = request.getRequestDispatcher("Supervisor/voo.jsp");
		//view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VooTO vto = new VooTO();
		Voo vm = new Voo();
		HttpSession session = request.getSession(true);

		vto.Companhia = request.getParameter("companhiaVoo").toString();
		vto.DataDestino = Date.valueOf(request.getParameter("dataChegadaVoo"));
		vto.DataOrigem = Date.valueOf(request.getParameter("dataChegadaVoo"));
		vto.Destino = request.getParameter("chegadaVoo");
		vto.HoraDestino = request.getParameter("horaChegadaVoo");
		vto.HoraOrigem = request.getParameter("horaOrigemVoo");
		vto.Origem = request.getParameter("origemVoo");

		int msg = vm.salvarVoo(vto);

		if(msg == 1){
			session.setAttribute("retorno", "alert alert-success alert-dismissible");
			session.setAttribute("visivel", "");
			session.setAttribute("msg", "Voo criado com sucesso!");
			response.sendRedirect("Supervisor/voo.jsp");
		}
		else{
			session.setAttribute("retorno", "alert alert-danger alert-dismissible");
			session.setAttribute("visivel", "");
			session.setAttribute("msg", "Ocorreu um problema ao tentar salvar o voo, por favor tente mais tarde!");
			response.sendRedirect("Supervisor/voo.jsp");
		}


	}
	
	
	@Override
	public void init(ServletConfig config){
		//todos os servlets do menu devem conter este metodo
		ServiceLookup.setupDB();
	}

}
