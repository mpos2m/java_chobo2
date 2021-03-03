package java_chobo2.ch14.ref;

import java.util.function.Function;

public class MethodRefEx {
	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("16"));
		
		Function<String, Integer> f2 = Integer :: parseInt;
		System.out.println(f2.apply("16"));
	}
}
