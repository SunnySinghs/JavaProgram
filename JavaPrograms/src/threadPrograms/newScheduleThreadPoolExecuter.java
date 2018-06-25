package threadPrograms;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class newScheduleThreadPoolExecuter {

	public static void main(String[] args) {
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
		NewTask nt1 = new NewTask("Demo Task 1");
		NewTask nt2 = new NewTask("Demo Task 2");
		
		System.out.println("The time is : " + new Date());
		
		exec.schedule(nt1, 2, TimeUnit.SECONDS);
		exec.schedule(nt2, 2, TimeUnit.SECONDS);  //setExecuteExistingDelayedTasksAfterShutdownPolicy()
		
		try {
			exec.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();
	}

}
