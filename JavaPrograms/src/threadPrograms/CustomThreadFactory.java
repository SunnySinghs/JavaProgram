package threadPrograms;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory{

	private int counter;
	private String name;
	private List<String> stats;
	
	public CustomThreadFactory(String name) {
		counter = 1;
		this.name = name;
		stats = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_"+counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date()));
		return t;
	}
	public String getStats() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = stats.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CustomThreadFactory factory = new CustomThreadFactory("CustomThreadFactory");
		Task task = new Task();
		Thread t;
		System.out.println("Starting the thread");
		for(int i=0; i<5; i++) {
			t = factory.newThread(task);
			t.start();
		}
		System.out.printf("All Threads are created now\n\n");
		  System.out.printf("Give me CustomThreadFactory stats:\n\n" + factory.getStats());
	}
}
