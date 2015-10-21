package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aeroporto;
import model.Voo;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import to.AeroportoTO;
import to.CompanhiasTO;
import to.VooTO;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@WebServlet("/vooalterar.do")
public class AlterarVooController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		session.setAttribute("visivelL", "hidden");
		
		PrintWriter out = resp.getWriter();
		String idVoo = req.getParameter("idvoo");
		Gson gson = new Gson(); 
		JsonObject listJson = new JsonObject();
		JsonElement eCompanhia = null;
		JsonElement eAeroporto = null;
		JsonElement eSelect = null;


		Voo vm = new Voo();
		Aeroporto am = new Aeroporto();

		ArrayList<CompanhiasTO> cto = vm.ListaCompanhias();
		ArrayList<AeroportoTO> ato = am.ListaAeroporto();
		VooTO sto = vm.SelectVoo(Integer.parseInt(idVoo));

		eCompanhia = gson.toJsonTree(cto);
		eAeroporto = gson.toJsonTree(ato);
		eSelect = gson.toJsonTree(sto);

		listJson.add("Companhia", eCompanhia);	
		listJson.add("Aeroporto", eAeroporto);
		listJson.add("Select", eSelect);


		out.println(listJson.toString());

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VooTO vto = new VooTO();
		Voo vm = new Voo();
		HttpSession session = request.getSession(false);

		vto.IdVoo = Integer.parseInt(request.getParameter("idvooName"));
		vto.Companhia = request.getParameter("companhiaVoo").toString();
		vto.DataDestino = Date.valueOf(request.getParameter("dataChegadaVoo"));
		vto.DataOrigem = Date.valueOf(request.getParameter("dataChegadaVoo"));
		vto.Destino = request.getParameter("chegadaVoo");
		vto.HoraDestino = request.getParameter("horaChegadaVoo");
		vto.HoraOrigem = request.getParameter("horaOrigemVoo");
		vto.Origem = request.getParameter("origemVoo");

		int msg = vm.alterarVoo(vto);

		if(msg == 1){
			session.setAttribute("retornoL", "alert alert-success alert-dismissible");
			session.setAttribute("visivelL", "");
			session.setAttribute("msgL", "Voo alterado com sucesso!");
		}
		else{
			session.setAttribute("retornoL", "alert alert-danger alert-dismissible");
			session.setAttribute("visivelL", "");
			session.setAttribute("msgL", "Ocorreu um problema ao tentar alterar o voo, por favor tente mais tarde!");
		}
		
		

	}



}
