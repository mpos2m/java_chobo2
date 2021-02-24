package java_chobo2.ch13;

class Account2{
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class RunnableEx13 implements Runnable{
	Account2 acc = new Account2();
	
	@Override
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int)(Math.random()*3 +1)*100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		}
		
		
	}
}

public class Ex13_13 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx13();
		
		new Thread(r).start();
		new Thread(r).start();
		
	}
}
