package model;

import java.security.MessageDigest;

import to.ChamadoTO;
import to.LoginTO;
import factory.DAOFactory;

public class Login {

	private String email;
	private String password;
	
	//VARIAVEIS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			
			password = hexString.toString();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//METODOS
	public LoginTO login(LoginTO to){
		return DAOFactory.getLoginDAO().login(to);
	}
	
	public Boolean register(LoginTO to){
		return DAOFactory.getLoginDAO().register(to);
	}
	
	
	
}
