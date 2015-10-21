package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import to.AeroportoTO;


public abstract class AeroportoDAO {

	public abstract void desconectar(Connection conn) throws SQLException;
	public abstract ArrayList<AeroportoTO>ListaAeroporto();
}
