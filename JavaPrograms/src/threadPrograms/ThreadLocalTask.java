package threadPrograms;

import java.util.Date;

public class ThreadLocalTask implements Runnable {
	private static final ThreadLocal<String> tl = new ThreadLocal<>();
	@Override
	public void run() {
		tl.set(new Date().toString());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" start time is "+tl.get());
	}

}
