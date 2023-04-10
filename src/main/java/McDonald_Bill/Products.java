package McDonald_Bill;
import java.io.IOException;

public class Products extends Utilities{

	public static void main(String[] args) throws IOException {

		selectProduct();
		createBill(productList, totalPrice(productList));

	}

	
}