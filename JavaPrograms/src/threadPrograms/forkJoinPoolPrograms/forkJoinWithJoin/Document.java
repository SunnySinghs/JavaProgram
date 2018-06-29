package threadPrograms.forkJoinPoolPrograms.forkJoinWithJoin;

import java.util.Random;

public class Document {
	private String words[]={"the","hello","goodbye","packt", "java","thread","pool","random","class","main"};
	public String[][] generate(int size, int length, String word){
		int counter=0;
		String[][]  document = new String[size][length];
		Random r = new Random();
		for(int i=0; i<size; i++){
			for(int j=0; j<length; j++){
				int index = r.nextInt(words.length);
				document[i][j] = words[index];
				if(document[i][j].equals(word)){
					counter++;
				}
			}
		}
		System.out.printf("Document : The word appears %d times in the document.\n", counter);
		return document;
	}
}
