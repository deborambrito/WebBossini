package to;

import java.io.Serializable;
import java.sql.Date;

public class VooTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public int IdVoo;
	public int IdCompanhia;
	public int IdOrigem;
	public int IdDestino;
	public String Origem;
	public String Destino;
	public String HoraOrigem;
	public String HoraDestino;
	public Date DataOrigem;
	public Date DataDestino;
	public String DataOrigemFormat;
	public String DataDestinoFormat;
	public String Companhia;
	
	
}


