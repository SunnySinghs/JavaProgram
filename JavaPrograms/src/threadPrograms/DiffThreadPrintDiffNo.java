package threadPrograms;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Program to print in sequence with Threads in java Thread1 = 1 Thread2 = 2 Thread3 = 3 Thread1 = 4 Thread2 = 5 Thread3 = 6
 * @author Sourabh
 *
 */
public class DiffThreadPrintDiffNo implements Runnable {
	
	DiffThreadPrintDiffNo diff;
	
	LinkedBlockingQueue<Integer> queue;
	public DiffThreadPrintDiffNo() {
		queue = new LinkedBlockingQueue<>();
	}

	@Override
	public void run() {
		int i=0;
		while(i<10) {
			try {
				Thread.sleep(1000);
				i = queue.take();
			}catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : "+i);
			diff.accept(++i);
		}
		
	}
	
	void accept(int i) {
		try {
			queue.put(i);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
