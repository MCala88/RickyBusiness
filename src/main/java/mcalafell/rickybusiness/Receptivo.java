package mcalafell.rickybusiness;

import java.util.ArrayList;
import java.util.List;

public class Receptivo implements GuestDispatcher {
	List<GuestDispatcher> guest = new ArrayList<GuestDispatcher>();
	

	public void registra(GuestDispatcher despachado) {
		this.guest.add(despachado);
	}
	
	public void dispatch(CreditCard alien) {
		for (GuestDispatcher invitado: guest) {
			invitado.dispatch(alien);
		}
	}
	
}
