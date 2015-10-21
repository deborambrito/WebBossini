package model;

import java.util.ArrayList;

import to.AeroportoTO;
import factory.DAOFactory;

public class Aeroporto {

	private int IdAeronave;
	private String Nome;
	
	public int getIdAeronave() {
		return IdAeronave;
	}
	public void setIdAeronave(int idAeronave) {
		IdAeronave = idAeronave;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	//METODOS
	
	public ArrayList<AeroportoTO> ListaAeroporto(){
		return DAOFactory.getAeroportoDAO().ListaAeroporto();
	}
}
