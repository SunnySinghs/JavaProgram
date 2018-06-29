package threadPrograms.forkJoinPoolPrograms.forkJoinWithJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class LineTask extends RecursiveTask<Integer> {

private static final long serialVersionUID = 1L;
	
	private String[] line;
	private int start,end;
	private String word;
	
	public LineTask(String[] line, int start, int end, String word) {
		this.line = line;
		this.start = start;
		this.end = end;
		this.word = word;
	}

	@Override
	protected Integer compute() {
		int result = 0;
		if(end-start<100){
			result = count(line,start,end,word);
		}else{
			int mid = (start+end)/2;
			LineTask t1 = new LineTask(line, start, mid, word);
			LineTask t2 = new LineTask(line, mid+1, end, word);
			invokeAll(t1, t2);;
			try{
				result = generateResult(t1.get(),t2.get());
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private int count(String[] line, int start, int end, String word) {
		int counter = 0;
		for(int i=start;i<end;i++){
			if(line[i].equals(word)){
				counter++;
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return counter;
	}

	private int generateResult(Integer integer, Integer integer2) {
		return (integer+integer2);
	}
}
