package threadPrograms;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PeriodicTaskApp {

	public static void main(String[] args) {
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
		NewTask nt1 = new NewTask("Demo Task 1");
		//NewTask nt2 = new NewTask("Demo Task 2");
		
		System.out.println("The time is : " + new Date());
		
		ScheduledFuture<?> result = exec.scheduleAtFixedRate(nt1, 2, 5, TimeUnit.SECONDS); //setContinueExistingPeriodicTasksAfterShutdownPolicy();
		//ScheduledFuture<?> result1 = exec.scheduleWithFixedDelay(nt1, 2, 5, TimeUnit.SECONDS);
		
		try {
			TimeUnit.SECONDS.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();
	}
}
