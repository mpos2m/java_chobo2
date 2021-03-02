package java_chobo2.ch14;

@FunctionalInterface
interface MyFunction2{
	void run();
}

public class LamdaEx04 {
	public static void execute(MyFunction2 f) {
		f.run();
	}
	public static MyFunction2 getMyFunction2() {
		MyFunction2 f = () -> System.out.println("f3.run()");
		return f;
	}
	public static void main(String[] args) {
		MyFunction2 f1 = () ->System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() {
			
			@Override
			public void run() {
				System.out.println("f2.run()");
				
			}
		};
		
		MyFunction2 f3 = getMyFunction2();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		
		execute(()-> System.out.println("run()") );
	}
}
