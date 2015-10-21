package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory.ConnFactory;
import to.AeroportoTO;

public class AeroportoDAOMySQL extends AeroportoDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public ArrayList<AeroportoTO> ListaAeroporto()
	{
		String select = "select * from aeroporto";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<AeroportoTO> listaA = new ArrayList<AeroportoTO>();
		AeroportoTO c = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(select);

			rs = pst.executeQuery();


			while(rs.next()){
				c = new AeroportoTO();
				c.IdAeroporto = rs.getInt(1);
				c.Nome = rs.getString(2).toString();
				listaA.add(c);
			}

			return listaA;
		} catch (Exception e) {
			// TODO: handle exception
			return listaA;
		}

	}



}
