package threadPrograms;

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {

	private CountDownLatch count;
	
	public VideoConference(int n) {
		count = new CountDownLatch(n);
	}
	
	public void arrive(String name){
		System.out.printf("%s is arrived.\n",name);
		count.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n", count.getCount());
	}
	@Override
	public void run() {
		System.out.printf("VideoConference: %d participants.\n", count.getCount());
		try{
			count.await();
			System.out.printf("VideoConference: All the participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
