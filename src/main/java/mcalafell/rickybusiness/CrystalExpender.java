package mcalafell.rickybusiness;

public class CrystalExpender {
	private int stock = 0;
	private double itemCost = 0d;
	
	public CrystalExpender(int stock, double itemCost) {
		this.stock = stock;
		this.itemCost = itemCost;
	}
	
	public void setStock(int almacenado) {
		this.stock = almacenado;
	}

	public int stock() {
		return this.stock;
	}

	public void dispatch(CreditCard abradolph) {
		// TODO Auto-generated method stub
		
	}
	
	
}
