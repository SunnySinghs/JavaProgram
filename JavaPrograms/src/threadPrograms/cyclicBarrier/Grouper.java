package threadPrograms.cyclicBarrier;

public class Grouper implements Runnable {

	private Results result;
	
	public Grouper(Results result) {
		this.result = result;	
	}
	@Override
	public void run() {
		int finalResult = 0;
		System.out.printf("Grouper : Processing results...\n");
		int[] data = result.getData();
		for(int i=0; i<data.length; i++){
			finalResult+=data[i];
		}
		System.out.printf("Grouper : total results %d\n",finalResult);
	}

}
