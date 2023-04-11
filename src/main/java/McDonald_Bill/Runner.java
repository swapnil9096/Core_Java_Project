package McDonald_Bill;
import java.io.IOException;

public class Runner extends Utilities{

	public static void main(String[] args) throws IOException {

		selectProducts();
		createBill(productList);
		
	}

	
}