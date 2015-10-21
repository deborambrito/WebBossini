package factory;

import dao.AeroportoDAO;
import dao.AeroportoDAOMySQL;
import dao.LoginDAO;
import dao.LoginDAOMySQL;
import dao.VooDAO;
import dao.VooDAOMySQL;

public class DAOFactory {


	public static LoginDAO getLoginDAO(){

		return new LoginDAOMySQL();
	}

	public static VooDAO getVooDAO(){

		return new VooDAOMySQL();
	}

	public static AeroportoDAO getAeroportoDAO(){

		return new AeroportoDAOMySQL();
	}
}
