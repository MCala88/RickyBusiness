package mcalafell.rickybusiness;

import java.util.ArrayList;

public class Receptivo implements GuestDispatcher {
	ArrayList<GuestDispatcher> guest = new ArrayList<GuestDispatcher>();
	
	public Receptivo() {};
	
	public void registra(GuestDispatcher despachador) {
		this.guest.add(despachador);
		
	}
	

	public void dispatch(CreditCard alien) {
		for (GuestDispatcher objeto: guest) {
			objeto.dispatch(alien);
		}
	}
	
}
