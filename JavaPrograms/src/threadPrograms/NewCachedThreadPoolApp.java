package threadPrograms;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NewCachedThreadPoolApp {

	public static void main(String[] args) {
		ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for(int i=0; i<5; i++) {
			NewTask t1 =  new NewTask("Thread"+i);
			System.out.println("A new task has been added : " + t1.getName());
			exec.execute(t1);
			System.out.println(i+" Pool size count "+exec.getPoolSize());
			System.out.println(i+" Completed task count "+exec.getCompletedTaskCount());
			System.out.println(i+" Actice task count "+exec.getActiveCount());
		}
		System.out.println("Pool size count "+exec.getPoolSize());
		System.out.println("Completed task count "+exec.getCompletedTaskCount());
		System.out.println("Actice task count "+exec.getActiveCount());
		exec.shutdown();
	}

}
