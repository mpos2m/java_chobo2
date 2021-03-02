package java_chobo2.ch14;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionEx {
	public static void main(String[] args) {
		// Supplier
		Supplier<Integer> f = () -> (int) (Math.random() * 100) + 1;
		System.out.println("f : " + f.get());
		
		// Supplier2
		Supplier<Integer> f01 = new Supplier<Integer>() {
			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1;
			}
		};
		System.out.println("f01 : " + f01.get());
		
		// Supplier class
		class MySupplier implements Supplier<Integer>{
			@Override
			public Integer get() {
				return (int) (Math.random() * 10) + 1;
			}	
		}
		MySupplier ms = new MySupplier();
		System.out.println("Class MySupplier() : " + ms.get());
		
		//Consumer
		Consumer<Integer> f1 = i -> System.out.println("Consumer : " + i + ", ");
		f1.accept(12);
		
		//Consumer2
		Consumer<Integer> f101 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println("Consumer2 : " + t + ",");
				
			}
		};
		f101.accept(5);
		
		// Predicate
		Predicate<Integer> f2 = i -> i%2 ==0;
		System.out.println("Predicate : " + f2.test(13) + ", " + f2.test(4));
		
		// Predicate2
		Predicate<Integer> f201 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				
				return t%2 ==0;
			}
		};
		System.out.println("Predicate 2 : " + f201.test(5));
		
		// Function
		Function<Integer, Integer> f3 = i -> i/10*10;
		System.out.println("Function : " + f3.apply(40));
		
		// Function2
		Function<Integer, Integer> f301 = new Function<Integer, Integer>() {			
			@Override
			public Integer apply(Integer t) {
				
				return t*t;
			}
		};
		System.out.println("Function2 : " + f301.apply(5));
		
	}
}
