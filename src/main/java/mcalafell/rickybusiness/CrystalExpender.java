package mcalafell.rickybusiness;

public class CrystalExpender implements GuestDispatcher {
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
		if (tarjeta.credit >= itemCost && stock() > 0) {
			this.stock -= 1;
			tarjeta.credit -= itemCost;
		}
	}
	
	@Override
	public String toString() {
		return "Stock: " + stock + "\n" + "cost: " + itemCost;
	}
}
