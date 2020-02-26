package mcalafell.rickybusiness;

public class CreditCard {
	private String owner = null;
	private String number = null;
	double credit = 3000;
	private final String symbol = "EZIS";
	
	
	public CreditCard(String owner, String number) {
		this.owner = owner;
		this.number = number;
	}
	
	
	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double credit() {
		return this.credit;
	}
	
	public String number() {
		return this.number;
	}

	public String symbol() {
		return this.symbol;
	}

	public boolean pay(double pagar) {
		if (credit >= 500) {
				credit -= pagar;
				return true;
			} else {
				System.out.println("Pago no realizado");
				return false;
			}
		}

	@Override
	public String toString() { 
        return "Owner: " + owner + "\n" + "number: " + number + "\n" + "credit: " + credit + symbol; 
    }


	
}
