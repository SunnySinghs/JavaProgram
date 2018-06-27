package threadPrograms.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {

	private int firstRow;
	private int lastRow;
	
	MatrixMock matrix;
	int number;
	Results result;
	private final CyclicBarrier barrier;
	
	public Searcher(int firstRow, int lastRow, MatrixMock matrix, int number, Results result, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.matrix = matrix;
		this.number = number;
		this.result = result;
		this.barrier = barrier;
	}
	

	@Override
	public void run() {
		int counter;
		System.out.printf("%s : Processing line from %d to %d.\n",Thread.currentThread().getName(),firstRow, lastRow);
		for(int i=firstRow; i<lastRow; i++){
			int[] data = matrix.getRow(i);
			counter = 0;
			for(int j=i; j<data.length; j++){
				if(number == data[j]){
					counter++; 
				}
			}
			result.setData(i, counter);
		}
		System.out.printf("%s, Lines Processed.\n",Thread.currentThread().getName());
		try{
			barrier.await();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
