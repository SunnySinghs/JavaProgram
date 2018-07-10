package threadPrograms.forkJoinPoolPrograms.forkJoinPoolCancelTask;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class SearchNumberTask extends RecursiveTask<Integer> {

	private int[] arr;
	private int start, end, number ;
	private TaskManager tm;
	
	public SearchNumberTask(int[] arr, int start, int end, int number, TaskManager tm) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.number = number;
		this.tm = tm;
	}

	@Override
	protected Integer compute() {
		int ret = 0;
		if(end-start>10) {
			ret = launchTasks();
		}else {
			ret = countForNumbers();
		}
		return ret;
	}

	private int launchTasks() {
		int medium = (start+end)/2;
		SearchNumberTask s1 = new SearchNumberTask(arr, start, medium, number, tm);
		SearchNumberTask s2 = new SearchNumberTask(arr, medium+1, end, number, tm);
		tm.addTask(s1);
		tm.addTask(s2);
		s1.fork();
		s2.fork();
		int returnValue;
		returnValue = s1.join();
		if(returnValue!=-1) {
			return returnValue;
		}
		
		returnValue=s2.join();
		return returnValue;
	}

	public void writeCancelMessage(){
		System.out.printf("Task: Canceled task from %d to %d\n",start,end);
	}
	
	private int countForNumbers() {
		for(int i=start; i<end; i++) {
			if(arr[i] == number) {
				System.out.printf("Task: Number %d found in position %d\n",number,i);
				tm.cancelTask(this);
				return i;
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

}
