package threadPrograms;

import java.util.concurrent.TimeUnit;

public class NewTask implements Runnable {

	private String name = "";
	public NewTask(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		try {
			long duration = (long) (Math.random() * 10);
			System.out.println("Doing a task during : "+ name);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
