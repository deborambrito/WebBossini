package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnFactory {


	public static Connection conectar() throws SQLException {
		
			return ConnFactoryMySQL.conectar();
		
	}
}
