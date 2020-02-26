package mcalafell.rickybusiness;

import java.util.ArrayList;

public class UfosPark {
	private double fee = 500;
	static ArrayList<String> flota = new ArrayList <String>();
	
	public UfosPark() {
	}
	
	public void add(String añadir) {
		flota.add(añadir);
	}
	
	public void dispatch(CreditCard tarjeta) {
			for (String ovni: flota) {
				if (ovni == null) {
					flota.remove(ovni);
					/*CreditCard.credit-=500;*/
				}
				
			}
		}
		
	

	public String getUfoOf(String number) {
		
		for (String ovni: flota) {
			if (ovni != null) {
				
			}
		}
		return null;
	}
	
	public String toString()  { 
        return "Ovnis: " + flota ; 
    }
}