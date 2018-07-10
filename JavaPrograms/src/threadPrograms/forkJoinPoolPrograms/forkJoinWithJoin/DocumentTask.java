package threadPrograms.forkJoinPoolPrograms.forkJoinWithJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

public class DocumentTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	
	private String[][] document;
	private int start,end;
	private String word;
	
	public DocumentTask(String[][] document, int start, int end, String word) {
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}

	@Override
	protected Integer compute() {
		int result=0;
		if(end-start<10){
			result = processLines(document,start,end,word);
		}else{
			int mid = (start+end)/2;
			DocumentTask d1 = new DocumentTask(document, start, mid, word);
			DocumentTask d2 = new DocumentTask(document, mid+1, end, word);
			invokeAll(d1, d2);
			try{
				result = generateResult(d1.get(),d2.get());
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Integer processLines(String[][] document, int start, int end, String word) {
		List<LineTask> list = new ArrayList<>();
		for(int i=start;i<end;i++){
			LineTask lt1 = new LineTask(document[i], start, end, word);
			list.add(lt1);
		}
		invokeAll(list);
		int result = 0;
		for(int j=0; j<list.size();j++){
			try {
				result+=list.get(j).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}

	private int generateResult(Integer integer, Integer integer2) {
		return (integer+integer2);
	}

}
