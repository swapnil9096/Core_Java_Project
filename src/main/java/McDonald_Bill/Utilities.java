package McDonald_Bill;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utilities {
	static List<Integer> list;
	static List<String> productList;
	static Integer price;
	static String Product;
	static Set<String> pNames;
	static FileWriter fw;

	static String burger = "BURGER";
	static String pepsi = "PEPSI";
	static String fries = "FRENCH_FRIES";
	static String catchup = "CATCHUP";

	static int burgerPrice = 80;
	static int pepsiPrice = 30;
	static int catchupPrice = 10;
	static int friesPrice = 50;

	static Date date = new Date();

	static String fileName = System.getProperty("user.dir") + "/src/main/resources/Mini_Bill_" + date.getTime()
			+ ".txt";

	static Integer totalPrice(List<String> productss) {
		Integer total = 0;
		for (String pNames : productss) {

			if (pNames.equalsIgnoreCase("BURGER")) {
				price = 80;
			} else if (pNames.equalsIgnoreCase("PEPSI")) {
				price = 30;
			} else if (pNames.equalsIgnoreCase("FRIES")) {
				price = 50;
			} else if (pNames.equalsIgnoreCase("CATCHUP")) {
				price = 10;
			} else

				System.out.println("Sorry...Product is Not available...!!" + pNames);

			total = total + price;
		}
		return total;
	}

	public static void selectProduct() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productNames = sc.nextLine();

		String[] str = productNames.split(" ", 5);

		productList = new ArrayList<>();
		
		for (String product : str)
		{
			productList.add(product);
		}
		
		sc.close();
	}
	static void createBill(List<String> pName, Integer total) throws IOException {
		
		List<Integer> pPrice = new ArrayList<>(List.of(burgerPrice, pepsiPrice, catchupPrice, friesPrice));
		String a = String.valueOf(total);
		fw = new FileWriter(fileName);

		for (String p : pName) {
			for (int rs : pPrice) {
				String price = String.valueOf(rs);

				if (p.equalsIgnoreCase("burger") && price.equals("80")) {
					fw.write(p + "          " + price + "\n");

				} else if (p.equalsIgnoreCase("pepsi") && price.equals("30")) {
					fw.write(p + "           " + price + "\n");

				} else if (p.equalsIgnoreCase("catchup") && price.equals("10")) {
					fw.write(p + "         " + price + "\n");

				} else if (p.equalsIgnoreCase("fries") && price.equals("50")) {
					fw.write(p + "           " + price + "\n");
				}
			}
		}

		fw.write("---".repeat(30) + "\n");
		fw.write("Total amount : " + a.trim());
		fw.close();
	}

}
