package threadPrograms.forkJoinPoolPrograms.forkJoinPoolAsync;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = 1L;
	private String path,extension;
	
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {
		List<String> list = new ArrayList<>();
		List<FolderProcessor> tasks = new ArrayList<>();
		File file = new File(path);
		File[] contents = file.listFiles();
		if(contents!=null){
			for(int i=0; i<contents.length; i++){
				if(contents[i].isDirectory()){
					FolderProcessor f1 = new FolderProcessor(contents[i].getAbsolutePath(), extension);
					f1.fork();
					tasks.add(f1);
				}else{
					if(checkFile(contents[i].getAbsolutePath(), extension)){
						list.add(contents[i].getAbsolutePath());
					}
				}
			}
		}
		if (tasks.size()>50) {
			System.out.printf("%s: %d tasks ran.\n",file.getAbsolutePath(),tasks.size());
		}
		addResultsFromTasks(list,tasks);
		return list;
	}

	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
		for(FolderProcessor items : tasks){
			list.addAll(items.join());
		}
		
	}

	private boolean checkFile(String absolutePath, String extension) {
		return absolutePath.equals(extension);
	}

}
