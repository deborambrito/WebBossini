package model;


import java.util.ArrayList;

import to.CompanhiasTO;
import to.VooTO;
import factory.DAOFactory;

public class Voo {

	private String Nome;
	private int Id;



	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	//METODOS
	public ArrayList<CompanhiasTO> ListaCompanhias(){
		return DAOFactory.getVooDAO().ListaCompanhias();
	}
	
	public ArrayList<VooTO> ListaVoo(){
		return DAOFactory.getVooDAO().ListaVoo();
	}
	
	public VooTO SelectVoo(int id){
		return DAOFactory.getVooDAO().SelectVoo(id);
	}
	
	public int salvarVoo(VooTO dados){
		return DAOFactory.getVooDAO().salvarVoo(dados);
	}
	
	public int alterarVoo(VooTO dados){
		return DAOFactory.getVooDAO().alterarVoo(dados);
	}
	
	public Boolean ExcluirVoo(int id){
		return DAOFactory.getVooDAO().ExcluirVoo(id);
	}

}
