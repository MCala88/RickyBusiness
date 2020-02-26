package mcalafell.rickybusiness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UfosPark {
	private double fee = 500;
	static ArrayList<String> nombresFlotas = new ArrayList <String>();
	static ArrayList<String> flota = new ArrayList <String>();
	private Map<String, String> flotaReservada = new HashMap <String, String>();
	
	public UfosPark() {
	}
	
	public void add(String añadir) {
		flota.add(añadir);
		nombresFlotas.add(añadir);
	}
	
	public Map<String, String> getFlotaReserva(){
		return flotaReservada;
	}
	
	public ArrayList<String> getFlota(){
		return flota;
	}
	
	public void dispatch(CreditCard tarjeta) {
		if (this.getFlotaReserva().containsKey(tarjeta.number())) {
			
		}
		else {
			if (tarjeta.credit() >= fee & flota.size() > 0 ) {
				tarjeta.pay(fee);
				this.flotaReservada.put(tarjeta.number(), flota.remove(0));
			}
		}
		
	}
		
	

	public String getUfoOf(String propietario) {
		return flotaReservada.get(propietario);
	}
	public String toString()  { 
        return nombresFlotas.toString() ; 
    }
}