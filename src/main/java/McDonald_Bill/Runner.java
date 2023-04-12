package McDonald_Bill;

public class Runner{

	public static void main(String[] args) {

		Utilities ut = new Utilities();
		
		ut.selectProducts();
		ut.createBill(ut.productList);
		
	}

	
}