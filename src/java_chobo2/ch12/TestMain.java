package java_chobo2.ch12;

import java.util.ArrayList;

public class TestMain {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.add("abc");
		box.add("def");
		
		String item = box.get(0);
		System.out.println("item : " + item);
		
		ArrayList<String> list = box.getList();
		list.stream().forEach(System.out::println);
		System.out.println(box);
	}
}
