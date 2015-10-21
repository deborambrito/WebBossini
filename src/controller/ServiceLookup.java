package controller;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import factory.ConnFactory;

public class ServiceLookup {
	
	public static void setupDB(){
		try {
			// Pega o contexto do JNDI
			Context env = (Context)new InitialContext().lookup("java:comp/env");

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}

}
