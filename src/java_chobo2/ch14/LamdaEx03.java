package java_chobo2.ch14;

@FunctionalInterface
interface MyFunction{
	void myMethod();
}

public class LamdaEx03 {
	public static void main(String[] args) {
		MyFunction f = () -> System.out.println("myMethod()");
		aMethod(f);
		
		aMethod(()-> System.out.println("myTwomethod()"));
	}
	public static void aMethod(MyFunction f) {
		f.myMethod();
	}
}
