package mcalafell.rickybusiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UfosPark implements GuestDispatcher {
	private double fee = 500;
	static List<String> nombresFlotas = new ArrayList <String>();
	static List<String> flota = new ArrayList <String>();
	private Map<String, String> flotasReservadas = new HashMap <String, String>();
	
	public void add(String añadir) {
		flota.add(añadir);
		nombresFlotas.add(añadir);
	}
	
	public Map<String, String> getFlotasReservadas(){
		return flotasReservadas;
	}
	
	public List<String> getFlota(){
		return flota;
	}
	
	public void dispatch(CreditCard tarjeta) {
		if (this.getFlotasReservadas().containsKey(tarjeta.number())) {
			
		} else {
			if (tarjeta.credit() >= fee && flota.size() > 0 ) {
				tarjeta.pay(fee);
				this.flotasReservadas.put(tarjeta.number(), flota.remove(0));
			}
		}
	}
		

	public String getUfoOf(String propietario) {
		return flotasReservadas.get(propietario);
	}
	public String toString()  { 
        return nombresFlotas.toString(); 
    }
}