package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import factory.ConnFactory;
import sun.security.action.GetIntegerAction;
import to.CompanhiasTO;
import to.VooTO;

public class VooDAOMySQL extends VooDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public Boolean ExcluirVoo(int id)
	{
		String delete = "delete from voo where idvoo = ?";
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(delete);

			// CONFIGURAR PARAMETROS
			pst.setInt(1, id);
			pst.execute();

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
	
	@Override
	public VooTO SelectVoo(int id)
	{
		String select = "SELECT V.idvoo, V.companhia, C.nome, V.origem, Ao.nome, V.destino, Ao.nome, V.horaorigem, V.horadestino, V.datadestino,V.dataorigem  FROM usjt_airline.voo as V inner join usjt_airline.companhias as C on (V.companhia = C.idCompanhias) inner join usjt_airline.aeroporto as Ad on (V.destino = Ad.idaeroporto) inner join usjt_airline.aeroporto as Ao on (V.origem = Ao.idaeroporto) where V.idvoo = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		VooTO c = new VooTO();

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(select);

			pst.setInt(1, id);
			rs = pst.executeQuery();
			
		
			if(rs.next()){
				
				c.IdVoo = rs.getInt(1);
				c.IdCompanhia = rs.getInt(2);
				c.Companhia = rs.getString(3);
				c.IdOrigem = rs.getInt(4);		
				c.Origem =rs.getString(5);
				c.IdDestino = rs.getInt(6);
				c.Destino = rs.getString(7);
				c.HoraOrigem = rs.getString(8);
				c.HoraDestino = rs.getString(9);
				c.DataDestino = rs.getDate(10);
				c.DataOrigem = rs.getDate(11);
				c.DataDestinoFormat = c.DataDestino.toString().split("-")[2] + "/" + c.DataDestino.toString().split("-")[1] + "/" + c.DataDestino.toString().split("-")[0];
				c.DataOrigemFormat = c.DataOrigem.toString().split("-")[2] + "/" + c.DataOrigem.toString().split("-")[1] + "/" + c.DataOrigem.toString().split("-")[0];
			}

			return c;
		} catch (Exception e) {
			// TODO: handle exception
			return c;
		}

	}
	
	@Override
	public ArrayList<VooTO> ListaVoo()
	{
		String select = "SELECT V.idvoo, V.companhia, C.nome, V.origem, Ao.nome, V.destino, Ad.nome, V.horaorigem, V.horadestino, V.datadestino,V.dataorigem  FROM usjt_airline.voo as V inner join usjt_airline.companhias as C on (V.companhia = C.idCompanhias) inner join usjt_airline.aeroporto as Ad on (V.destino = Ad.idaeroporto) inner join usjt_airline.aeroporto as Ao on (V.origem = Ao.idaeroporto)";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<VooTO> listaV = new ArrayList<VooTO>();
		VooTO c = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(select);

			rs = pst.executeQuery();


			while(rs.next()){
				c = new VooTO();
				c.IdVoo = rs.getInt(1);
				c.IdCompanhia = rs.getInt(2);
				c.Companhia = rs.getString(3);
				c.IdOrigem = rs.getInt(4);		
				c.Origem =rs.getString(5);
				c.IdDestino = rs.getInt(6);
				c.Destino = rs.getString(7);
				c.HoraOrigem = rs.getString(8);
				c.HoraDestino = rs.getString(9);
				c.DataDestino = rs.getDate(10);
				c.DataOrigem = rs.getDate(11);
				c.DataDestinoFormat = c.DataDestino.toString().split("-")[2] + "/" + c.DataDestino.toString().split("-")[1] + "/" + c.DataDestino.toString().split("-")[0];
				c.DataOrigemFormat = c.DataOrigem.toString().split("-")[2] + "/" + c.DataOrigem.toString().split("-")[1] + "/" + c.DataOrigem.toString().split("-")[0];
				listaV.add(c);
			}

			return listaV;
		} catch (Exception e) {
			// TODO: handle exception
			return listaV;
		}

	}

	@Override
	public ArrayList<CompanhiasTO> ListaCompanhias()
	{
		String select = "select * from companhias";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<CompanhiasTO> listaC = new ArrayList<CompanhiasTO>();
		CompanhiasTO c = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(select);

			rs = pst.executeQuery();


			while(rs.next()){
				c = new CompanhiasTO();
				c.id = rs.getInt(1);
				c.nome = rs.getString(2).toString();
				listaC.add(c);
			}

			return listaC;
		} catch (Exception e) {
			// TODO: handle exception
			return listaC;
		}

	}

	@Override
	public int salvarVoo(VooTO dados)
	{
		String inclusao = "insert into voo values (?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);

			// CONFIGURAR PARAMETROS
			pst.setNull(1, Types.INTEGER);
			pst.setString(2,  dados.Companhia);
			pst.setString(3,  dados.Origem);
			pst.setString(4, dados.Destino);
			pst.setString(5, dados.HoraDestino);
			pst.setString(6, dados.HoraOrigem);
			pst.setDate(7, dados.DataDestino);
			pst.setDate(8, dados.DataOrigem);

			//fim configurar parametros
			pst.execute();

			return 1;

		}catch(Exception e){

			return 0;
		}

	}


	@Override
	public int alterarVoo(VooTO dados)
	{
		String alteracao = "update chamado set companhia =?, origem=?,destino=?, horadestino=?,horaorigem=?,datadestino=?,dataorigem=? where idvoo=?";

		Connection conn = null;
		PreparedStatement pst = null;

		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);

			// CONFIGURAR PARAMETROS
			pst.setNull(8, Types.INTEGER);
			pst.setString(1,  dados.Companhia);
			pst.setString(2,  dados.Origem);
			pst.setString(3, dados.Destino);
			pst.setString(4, dados.HoraDestino);
			pst.setString(5, dados.HoraOrigem);
			pst.setDate(6, dados.DataDestino);
			pst.setDate(7, dados.DataOrigem);

			//fim configurar parametros
			pst.execute();

			return 1;

		}catch(Exception e){

			return 0;
		}

	}


}
