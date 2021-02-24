package java_chobo2.ch12;

import java.util.ArrayList;
import java.util.Iterator;

class Product {

}

class Tv extends Product {

}

class Audio extends Product {

}

public class TestMain2 {
	public static void main(String[] args) {
		ArrayList<Tv> listTv = new ArrayList<Tv>();
//		ArrayList<Product> listProduct = new ArrayList<Tv>();
		ArrayList<Product> listProduct = new ArrayList<Product>();
		
		listTv.add(new Tv());
		
		listProduct.add(new Product());
		listProduct.add(new Tv());
		listProduct.add(new Audio());
		
		Iterator<Product> it = listProduct.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		

	}
}
