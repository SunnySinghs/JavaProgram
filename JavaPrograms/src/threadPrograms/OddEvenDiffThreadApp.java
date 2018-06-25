package threadPrograms;

public class OddEvenDiffThreadApp {
	public static void main(String[] args) {
		OddEvenDifferentThreads od = new OddEvenDifferentThreads();
		new Thread(od,"Thread1").start();
		new Thread(od,"Thread2").start();
	}
}
