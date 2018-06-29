package threadPrograms.forkJoinPoolPrograms.forkJoinPoolAsync;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolAsyncApp {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		FolderProcessor system = new FolderProcessor("C:\\Windows","log");
		FolderProcessor apps = new FolderProcessor("C:\\Program Files","log");
		FolderProcessor documents = new FolderProcessor("C:\\Documents","log");
		
		pool.execute(system);
		pool.execute(apps);
		pool.execute(documents);
		
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
		}while(!system.isDone() || !apps.isDone() || !documents.isDone());
		
		pool.shutdown();
		try{
			pool.awaitTermination(1, TimeUnit.DAYS);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> results;
		results = system.join();
		System.out.printf("Main : %d files found.\n",results.size());
		results = apps.join();
		System.out.printf("Main : %d files found.\n",results.size());
		results = documents.join();
		System.out.printf("Main : %d files found.\n",results.size());

	}

}
