package mcalafell.rickybusiness;

public class CreditCard {
	private String owner = null;
	private String number = null;
	double credit = 3000;
	private String symbol = "EZIS";
	
	String scredit = String.valueOf(credit);
	
	public CreditCard(String owner, String scredit) {
		
		this.owner = owner;
		this.scredit = scredit;
	}
	
	
	public void setNumber(String numero) {
		this.number = numero;
	}

	public String number() {
		return this.number;
	}

	public void setSymbol(String simbolo) {
		this.symbol = simbolo;
	}

	public String symbol() {
		return this.symbol;
	}

	public boolean pay(double pagar) {
		if (credit >= 500) {
				this.credit -= pagar;
				return true;
			} else {
				System.out.println("Pago no realizado");
				return false;
			}
		
		}

	
	public String toString() 
    { 
        return "El propietario " + owner + " tiene " + credit + symbol; 
    }


	public String credit() {
		
		return scredit;
	}
	
}
