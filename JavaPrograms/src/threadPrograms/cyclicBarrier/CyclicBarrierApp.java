package threadPrograms.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {

	public static void main(String[] args) {
		 int rows = 200;
		 int columns = 100;
		 int search_no = 5;
		 int participants = 5;
		 int line_participants = 40;
		 
		 MatrixMock mock = new MatrixMock(rows, columns, search_no);
		 Results result = new Results(rows);
		 Grouper group = new Grouper(result);
		 CyclicBarrier barrier = new CyclicBarrier(participants, group);
		 Searcher[] search = new Searcher[participants];
		 for(int i=0; i<participants; i++){
			 search[i] = new Searcher(i*line_participants, (i*line_participants)+line_participants, mock, search_no, result, barrier);
			 Thread t1 = new Thread(search[i]);
			 t1.start();
		 }
		 System.out.println("Main Thread has finished.");

	}

}
