package threadPrograms.cyclicBarrier;

public class Results {
	private int[] data;
	public Results(int size) {
		data = new int[size];
	}
	
	public void setData(int position, int number){
		data[position] = number;
	}
	
	public int[] getData(){
		return data;
	}
}
