package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import to.VooTO;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@WebServlet("/vooexcluir.do")
public class ExcluirVooController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String idVoo = req.getParameter("idvoo");
		Gson gson = new Gson(); 
		JsonObject listVoos = new JsonObject();
		JsonElement elem = null;
		
		Voo vm = new Voo();
		Boolean retorno = vm.ExcluirVoo(Integer.parseInt(idVoo));
		
		if(retorno)
		{
			ArrayList<VooTO> vto  = vm.ListaVoo();
			
			elem = gson.toJsonTree(vto);
			
		    listVoos.add("Voos", elem);			
			
		}
		
		out.println(listVoos.toString());

		out.close();

	}



}
