package McDonald_Bill;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Utilities {
	List<String> productList;
	List<String> itemsList;
	List<String> listOfProducts;
	
	FileWriter fw;
	Scanner sc;

	int items;
	int sum;
	int discount 	= 0;

	int burgerPrice 	= 80;
	int pepsiPrice		= 30;
	int catchupPrice 	= 10;
	int friesPrice 		= 50;
	
	String burger 	= "BURGER";
	String pepsi 	= "PEPSI";
	String fries 	= "FRIES"; 
	String catchup 	= "CATCHUP";


	Date date = new Date();
	
	List<Integer> list = new ArrayList<>();
	List<Integer> productPriceList = new ArrayList<>(List.of(burgerPrice, pepsiPrice, catchupPrice, friesPrice));
	
	String fileName = System.getProperty("user.dir") + "/src/main/resources/Mini_Bill_" + date.getTime()+ ".txt";
	
	 int Final_Amount() 
	{
		int coastToPaid = 0;
		
		if(getProductsTotal()<=500)
		{
			discount = getProductsTotal() - discount;
			coastToPaid = discount;
			
		}else if(getProductsTotal()>500 && getProductsTotal()<=850)
		{
			discount = (getProductsTotal() * 10 )/100;
			coastToPaid = getProductsTotal() - discount ;
		
		}else if(getProductsTotal()>850 && getProductsTotal()<=1400)
		{
			discount = (getProductsTotal() * 20)/100;
			coastToPaid = getProductsTotal() - discount;
			
		}else if(getProductsTotal()>1500)
		{
			discount = (getProductsTotal() * 35)/100;
			coastToPaid = getProductsTotal() - discount;
		}
		return coastToPaid;
	}

	 int getProductsTotal() {
		int total = 0;
		for (int a = 0; a < list.size(); a++) {

			total = total + list.get(a);
		}
		return total;
	}
	 
	 int getDiscount()
	 {
		 discount = getProductsTotal() - Final_Amount();
		 return discount;
	 }
	 

	 void selectProducts() {

		sc = new Scanner(System.in);

		System.out.println("Enter Product Names");

		String productNames = sc.nextLine();

		String[] str = productNames.split(" ", 5);

		productList = new ArrayList<>();

		for (String product : str) {
			productList.add(product);
		}
	}

	 int getBurgerItems() {

		for (int i = 0; i < productList.size(); i++) 
		{
			if (productList.get(i).equalsIgnoreCase("burger"))
			{
			
				sc = new Scanner(System.in);
				System.out.println("Enter No Of burgers");
			}
		}
		items = sc.nextInt();
		return items;
	}

	 int getPepsiItems() {
		
		for (int i = 0; i < productList.size(); i++) 
		{
			if (productList.get(i).equalsIgnoreCase(pepsi)) 
			{
			
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Pepsi");
			}
		}
		return items = sc.nextInt();
	}

	 int getCatchupItems() {
		
		for (int i = 0; i < productList.size(); i++) {

			if (productList.get(i).equalsIgnoreCase(catchup)) {
		
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Catchup");
			}
		}
		items = sc.nextInt();
		return items;

	}

	 int getFriesItems() {
		 
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).equalsIgnoreCase(fries)) {
				sc = new Scanner(System.in);
				System.out.println("Enter No Of Fries");
			}
		}
		return items = sc.nextInt();
	}

	 int getBurgerTotal() {
		sum = burgerPrice * items;
		list.add(sum);
		return sum;
	}

	 int getPepsiTotal() {
		sum = pepsiPrice * items;
		list.add(sum);
		return sum;
	}

	 int getCatchupTotal() {
		sum = catchupPrice * items;
		list.add(sum);
		return sum;
	}

	 int getFriesTotal() {

		sum = friesPrice * items;
		list.add(sum);
		return sum;
	}

	 void createBill(List<String> pName) {

		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error in filepath...!!");
		}

		try {
			
			fw.write("Product Name    " + "Rate    " + "Items   " + "Total  " + "\n");
		
			fw.write("---".repeat(15) + "\n");
		
		for (int j = 0; j < pName.size(); j++) 
		{
			for (int k = 0; k < productPriceList.size(); k++) 
			{

				if (pName.get(j).equalsIgnoreCase(burger) && productPriceList.get(k).equals(burgerPrice)) 
				{
					fw.write(pName.get(j) + "           " + productPriceList.get(k) + "      " + getBurgerItems() + "       " + getBurgerTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase(pepsi) && productPriceList.get(k).equals(pepsiPrice)) 
				{
					fw.write(pName.get(j) + "            " + productPriceList.get(k) + "      " + getPepsiItems() + "       " + getPepsiTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase(catchup) && productPriceList.get(k).equals(catchupPrice)) 
				{
					fw.write(pName.get(j) + "          " + productPriceList.get(k) + "      " + getCatchupItems() + "       " + getCatchupTotal() + "\n");

				} else if (pName.get(j).equalsIgnoreCase(fries) && productPriceList.get(k).equals(friesPrice)) 
				{
					fw.write(pName.get(j) + "            " + productPriceList.get(k) + "      " + getFriesItems()+ "       " + getFriesTotal() + "\n");
				}

			}
		}

		fw.write("---".repeat(15) + "\n");
		
		if(getDiscount()>0)
			fw.write("Congratulations you won " + discount + " discount!!! \n");
		
		fw.write("---".repeat(15) + "\n");
		
		fw.write("Total Amount To Paid : " + Final_Amount() + "\n");
		fw.write("\n");
		fw.write("              Visit Again...!!");
		fw.close();
				
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("Error in file writing...!!");
	}
}
	 
}
