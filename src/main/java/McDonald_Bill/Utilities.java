package McDonald_Bill;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Utilities {
	static List<String> productList;
	static List<String> itemsList;

	static Integer price;
	static FileWriter fw;
	static Scanner sc;

	static int sr;
	static int sum;
	static String burger 	= "BURGER";
	static String pepsi 	= "PEPSI";
	static String fries 	= "FRENCH_FRIES";
	static String catchup 	= "CATCHUP";

	static int burgerPrice 	= 80;
	static int pepsiPrice	= 30;
	static int catchupPrice = 10;
	static int friesPrice 	= 50;

	static Date date = new Date();
	static List<Integer> list = new ArrayList<>();

	static String fileName = System.getProperty("user.dir") + "/src/main/resources/Mini_Bill_" + date.getTime()
			+ ".txt";
	
	public static int Final_Amount() 
	{
		int dis = 0;
		int coastToPaid = 0;
		
		if(getTotalBill()<=500)
		{
			dis = getTotalBill() - dis;
			coastToPaid = dis;
			
		}else if(getTotalBill()>500 && getTotalBill()<=850)
		{
			dis = (getTotalBill() * 10 )/100;
			coastToPaid = getTotalBill() - dis ;
		
		}else if(getTotalBill()>850 && getTotalBill()<=1400)
		{
			dis = (getTotalBill() * 20)/100;
			coastToPaid = getTotalBill() - dis;
			
		}else if(getTotalBill()>1500)
		{
			dis = (getTotalBill() * 35)/100;
			coastToPaid = getTotalBill() - dis;
		}
		return coastToPaid;
	}

	static int getDiscount()
	{
		int rupees = 0;
		
		rupees = getTotalBill() - Final_Amount();
		return rupees;
	}
		
	static int getTotalBill() {
		int total = 0;
		for (int a = 0; a < list.size(); a++) {

			total = total + list.get(a);
		}

		return total;
	}

	static void selectProducts() {

		sc = new Scanner(System.in);

		System.out.println("Enter Product Name");

		String productNames = sc.nextLine();

		String[] str = productNames.split(" ", 5);

		productList = new ArrayList<>();

		for (String product : str) {
			productList.add(product);
		}
	}

	static int getBurgerItems() {
		List<String> loi = productList;

		for (int i = 0; i < loi.size(); i++) 
		{
			
			if (loi.get(i).equalsIgnoreCase("burger"))
			{
			
				sc = new Scanner(System.in);
				System.out.println("Enter No Of burgers");
			}

		}
		sr = sc.nextInt();
		return sr;
	}

	static int getPepsiItems() {
		List<String> loi = productList;
		
		for (int i = 0; i < loi.size(); i++) 
		{
			if (loi.get(i).equalsIgnoreCase("pepsi")) 
			{
			
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Pepsi");
			}

		}
		return sr = sc.nextInt();
	}

	static int getCatchupItems() {
		List<String> loi = productList;
		
		for (int i = 0; i < loi.size(); i++) {

			if (loi.get(i).equalsIgnoreCase("catchup")) {
		
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Catchup");
			}

		}
		sr = sc.nextInt();
		return sr;

	}

	static int getFriesItems() {
		List<String> loi = productList;
		
		for (int i = 0; i < loi.size(); i++) {
			if (loi.get(i).equalsIgnoreCase("fries")) {
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Fries");
			}
		}
		return sr = sc.nextInt();
	}

	static List<String> selectItems() {
		itemsList = new ArrayList<>();

		sc = new Scanner(System.in);
		System.out.println("Enter No Of items");

		String str = sc.nextLine();

		String[] arr = str.split(" ");

		for (String items : arr)
			itemsList.add(items);

		sc.close();
		return itemsList;

	}

	static int getBurgerTotal() {
		sum = burgerPrice * sr;
		list.add(sum);
		return sum;
	}

	static int getPepsiTotal() {
		sum = pepsiPrice * sr;
		list.add(sum);
		return sum;
	}

	static int getCatchupTotal() {
		sum = catchupPrice * sr;
		list.add(sum);
		return sum;
	}

	static int getFriesTotal() {

		sum = friesPrice * sr;
		list.add(sum);
		return sum;
	}

	static void createBill(List<String> pName) throws IOException {

		List<Integer> pPrice = new ArrayList<>(List.of(burgerPrice, pepsiPrice, catchupPrice, friesPrice));

		fw = new FileWriter(fileName);

		fw.write("Product Name    " + "Rate    " + "Items   " + "Total  " + "\n");
		fw.write("---".repeat(15) + "\n");
		
		for (int j = 0; j < pName.size(); j++) 
		{
			for (int k = 0; k < pPrice.size(); k++) 
			{
				String price = String.valueOf(pPrice.get(k));

				if (pName.get(j).equalsIgnoreCase("burger") && price.equals("80")) 
				{
					fw.write(pName.get(j) + "           " + price + "      " + getBurgerItems() + "       " + getBurgerTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase("pepsi") && price.equals("30")) 
				{
					fw.write(pName.get(j) + "            " + price + "      " + getPepsiItems() + "       " + getPepsiTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase("catchup") && price.equals("10")) 
				{
					fw.write(pName.get(j) + "          " + price + "      " + getCatchupItems() + "       " + getCatchupTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase("fries") && price.equals("50")) 
				{
					fw.write(pName.get(j) + "            " + price + "      " + getFriesItems()+ "       " + getFriesTotal() + "\n");
				}

			}
		}

		fw.write("---".repeat(15) + "\n");
		
		if(getDiscount()>0)
			fw.write("Congratulations you won " + getDiscount() + " discount!!! \n");
		
		fw.write("---".repeat(15) + "\n");
		
		fw.write("Total amount : " + Final_Amount() + "\n");
		fw.write("\n");
		fw.write("                Visit Again...!!");
		fw.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
	
	
}
