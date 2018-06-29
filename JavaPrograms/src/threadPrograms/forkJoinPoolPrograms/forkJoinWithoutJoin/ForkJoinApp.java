package threadPrograms.forkJoinPoolPrograms.forkJoinWithoutJoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinApp {
	public static void main(String[] args) {
		ProductListGenerator plg = new ProductListGenerator();
		List<Products> pro = plg.generate(100);
		Task t = new Task(0, pro.size(), 0.20, pro);
		ForkJoinPool fjp = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		fjp.execute(t);
		
		do {
			System.out.printf("Main :  Thread Pool %s\n", fjp.getActiveThreadCount());
			System.out.printf("Main :  Thread Steal %s\n", fjp.getStealCount());
			System.out.printf("Main :  Thread Parallelism %s\n", fjp.getParallelism());
			try {
				TimeUnit.SECONDS.sleep(5);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!t.isDone());
		
		fjp.shutdown();
		
		if(t.isCompletedNormally()) {
			System.out.printf("Main :  Task has completed normally\n");
		}
		
		for(int i = 0; i<pro.size();i++) {
			Products p = pro.get(i);
			if(p.getPrice()!=12){
				System.out.printf("Product %s: %f\n",p.getName(),p.getPrice());
			}
		}
		System.out.println("Main: End of the program.\n");
	}
}
