package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import to.CompanhiasTO;
import to.VooTO;


public abstract class VooDAO {

	public abstract void desconectar(Connection conn) throws SQLException;
	public abstract ArrayList<CompanhiasTO>ListaCompanhias();
	public abstract ArrayList<VooTO>ListaVoo();
	public abstract VooTO SelectVoo(int id);
	public abstract int salvarVoo(VooTO dados);
	public abstract int alterarVoo(VooTO dados);
	public abstract Boolean ExcluirVoo(int id);
	
}
