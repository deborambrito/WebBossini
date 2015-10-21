package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import model.Chamado;
import to.ChamadoTO;
import factory.ConnFactory;

public class ChamadoDAOMySQL extends ChamadoDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public ChamadoTO incluir(ChamadoTO to){
		String inclusao = "insert into chamado values (?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.setNull(1, Types.INTEGER);
			pst.setString(2,  to.descricao);
			pst.setString(3, Chamado.ABERTO);
			to.status = Chamado.ABERTO;
			Date now = new Date(System.currentTimeMillis());
			to.dataAbertura = now;
			pst.setDate(4, now);
			pst.setNull(5, Types.DATE);
			pst.setInt(6, to.idFila);
			//fim configurar parametros
			pst.execute();
			//funcao do MySQL para pegar o ultimo id inserido nesta secao"
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			String selecao = "select LAST_INSERT_ID()";
			pst = conn.prepareStatement(selecao);
			rs = pst.executeQuery();
			if(rs.next()){
				to.numero = rs.getInt(1);
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			selecao = "select nm_fila from fila where id_fila = ?";
			pst = conn.prepareStatement(selecao);
			pst.setInt(1, to.idFila);
			rs = pst.executeQuery();
			if(rs.next()){
				to.nomeFila = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public void fechar(ChamadoTO to){
		String alteracao = "update chamado set dt_fechamento=?, status=? where id_chamado=?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			//configurar parametros
			pst.setInt(3, to.numero);
			pst.setString(2, Chamado.FECHADO);
			Date now = new Date(System.currentTimeMillis());
			pst.setDate(1, now);
			//fim configurar parametros
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public ChamadoTO selecionar(ChamadoTO to){
		String selecao = "select c.id_chamado, c.descricao, c.status, c.dt_abertura, c.dt_fechamento, c.id_fila, f.nm_fila "+
						 "from chamado c, fila f "+
						 "where c.id_fila = f.id_fila "+
						 "and c.id_chamado = ?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(selecao);
			pst.setInt(1, to.numero);
			rs = pst.executeQuery();
			if(rs.next()){
				to.descricao = rs.getString(2);
				to.status = rs.getString(3);
				to.dataAbertura = rs.getDate(4);
				to.dataFechamento = rs.getDate(5);
				to.idFila = rs.getInt(6);
				to.nomeFila = rs.getString(7);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

}
