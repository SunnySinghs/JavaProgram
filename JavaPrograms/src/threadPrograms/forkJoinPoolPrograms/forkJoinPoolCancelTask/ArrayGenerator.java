package threadPrograms.forkJoinPoolPrograms.forkJoinPoolCancelTask;

import java.util.Random;

public class ArrayGenerator {
	public int[] generateArray(int size) {
		int []arr = new int[size];
		Random r = new Random();
		for(int i=0; i<size; i++) {
			arr[i] = r.nextInt(10);
		}
		return arr;
	}
}
