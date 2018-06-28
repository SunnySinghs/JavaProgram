package threadPrograms.ForkJoinPoolPrograms.ForkJoinPoolCancelTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

public class TaskManager {

	List<ForkJoinTask<Integer>> list;
	public TaskManager() {
		list = new ArrayList<>();
	}
	
	public void addTask(ForkJoinTask<Integer> task) {
		list.add(task);
	}
	
	public void cancelTask(ForkJoinTask<Integer> cancelTask) {
		for(ForkJoinTask<Integer> task : list) {
			if(task!=cancelTask) {
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}
}
