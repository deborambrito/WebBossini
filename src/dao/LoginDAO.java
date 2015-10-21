package dao;

import java.sql.Connection;
import java.sql.SQLException;

import to.LoginTO;


public abstract class LoginDAO {

	public abstract void desconectar(Connection conn) throws SQLException;
	public abstract LoginTO login(LoginTO to);
	public abstract Boolean register(LoginTO to);
}
