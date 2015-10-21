package factory;


import to.AeroportoTO;
import to.LoginTO;
import to.VooTO;

public class TOFactory {

		//MY PROJECT 
		
		public static LoginTO getLoginTO(){
			
			return new LoginTO();
		}

		public static VooTO getVooTO(){
			
			return new VooTO();
		}
		
		public static AeroportoTO getAeroportoTO()
		{
			return new AeroportoTO();
		}
	

}
