package threadPrograms.forkJoinPoolPrograms.forkJoinPoolCancelTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolCancelTaskApp {

	public static void main(String[] args) {
		ArrayGenerator ag = new ArrayGenerator();
		int[] arr = ag.generateArray(50);
		
		TaskManager manager = new TaskManager();
		ForkJoinPool pool = new ForkJoinPool();
		SearchNumberTask t1 = new SearchNumberTask(arr, 0, 50, 5, manager);
		pool.execute(t1);
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread has finished.");
	}

}
