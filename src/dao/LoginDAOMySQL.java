package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.tomcat.util.security.MD5Encoder;

import model.Chamado;
import factory.ConnFactory;
import sun.security.krb5.internal.crypto.dk.AesDkCrypto;
import to.LoginTO;

public class LoginDAOMySQL extends LoginDAO{
	
	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}
	
	@Override
	public Boolean register(LoginTO to)
	{
		String inclusao = "insert into usuario values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);
			
			// CONFIGURAR PARAMETROS
			pst.setNull(1, Types.INTEGER);
			pst.setString(2,  to.Email);
			pst.setString(3,  to.Password);
			pst.setString(4, to.Tipo);
			
			//fim configurar parametros
			pst.execute();
			
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	@Override
	public LoginTO login(LoginTO to)
	{
		String select = "select * from usuario where email = ? and senha =?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Boolean value = false;
		
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(select);
			
			// CONFIGURAR PARAMETROS
			pst.setString(1, to.Email);
			pst.setString(2, to.Password);
			//fim configurar parametros
			rs = pst.executeQuery();
			
			if(rs.next()){
				
				to.PasswordCompara = true;
				to.Tipo = rs.getString(4);
				
			}else{
				to.PasswordCompara = false;
			}
			
				
			return to;
		} catch (Exception e) {
			// TODO: handle exception
			return to;
		}
		
	}

	
    
}
