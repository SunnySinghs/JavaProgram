package threadPrograms;

import java.util.Date;

public class ThreadLocalTaskIntialVal implements Runnable {

	private static final ThreadLocal<String> tl = new ThreadLocal<String>(){
		protected String initialValue() {
			return (new Date()).toString();
		};
	};
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is started at "+tl.get());
	}
	
	public static void main(String...args) {
		ThreadLocalTaskIntialVal t = new ThreadLocalTaskIntialVal();
		Thread t1 = new Thread(t, "Thread1");
		Thread t2 = new Thread(t, "Thread1");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}

}
