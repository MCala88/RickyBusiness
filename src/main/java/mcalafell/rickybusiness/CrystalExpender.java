package mcalafell.rickybusiness;

public class CrystalExpender {
	private int stock = 0;
	private double itemCost = 0d;
	
	public CrystalExpender(int stock, double itemCost) {
		this.stock = stock;
		this.itemCost = itemCost;
	}

	public int stock() {
		return this.stock;
	}

	public void dispatch(CreditCard tarjeta) {
		if (tarjeta.credit >= itemCost) {
			this.stock -= 1;

			if (this.stock > 0) {
			tarjeta.credit = tarjeta.credit - itemCost;
		
		}
		}
	}
	
	@Override
	public String toString() {
		return "Stock: " + stock + "\n" + "cost: " + itemCost;
	}
}
