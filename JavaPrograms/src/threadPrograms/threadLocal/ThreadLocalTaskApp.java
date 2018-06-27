package threadPrograms.threadLocal;

public class ThreadLocalTaskApp {

	public static void main(String[] args) {
		
		ThreadLocalTask t = new ThreadLocalTask();
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
