package threadPrograms.forkJoinPoolPrograms.forkJoinWithJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinWithjoinApp {

	public static void main(String[] args) {
		Document doc = new Document();
		String[][] document = doc.generate(100, 1000, "the");
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		do{
			System.out.println("********************");
			System.out.printf("Main : Steal count %d\n",pool.getStealCount());
			System.out.printf("Main : Active count %d\n",pool.getActiveThreadCount());
			System.out.printf("Main : Queued count %d\n",pool.getQueuedTaskCount());
			System.out.printf("Main : Parrallelism %d\n",pool.getParallelism());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!task.isDone());
		
		pool.shutdown();
		try{
			pool.awaitTermination(1, TimeUnit.DAYS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("Main : Total number of words is %d\n",task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}
