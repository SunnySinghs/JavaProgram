package threadPrograms;

import java.util.concurrent.TimeUnit;

public class Partcipants implements Runnable {

	private VideoConference vc;
	private String name;
	public Partcipants(VideoConference vc, String name) {
		this.name = name;
		this.vc = vc;
	}
	@Override
	public void run() {
		long duration=(long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vc.arrive(name);
	}

}
