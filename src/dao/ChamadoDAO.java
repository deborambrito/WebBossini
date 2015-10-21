package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.ChamadoTO;

public abstract class ChamadoDAO {
	
	public abstract void desconectar(Connection conn) throws SQLException;
	
	public abstract ChamadoTO incluir(ChamadoTO to);

	public abstract void fechar(ChamadoTO to);
	
	public abstract ChamadoTO selecionar(ChamadoTO to);
}
