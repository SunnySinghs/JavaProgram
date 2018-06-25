package threadPrograms;

public class DiffThreadPrintDiffNoApp {

	public static void main(String[] args) {
		DiffThreadPrintDiffNo d1 = new DiffThreadPrintDiffNo();
		DiffThreadPrintDiffNo d2 = new DiffThreadPrintDiffNo();
		DiffThreadPrintDiffNo d3 = new DiffThreadPrintDiffNo();
		
		d1.diff = d2;
		d2.diff = d3;
		d3.diff = d1;
		
		new Thread(d1,"Thread1").start();
		new Thread(d2,"Thread2").start();
		new Thread(d3,"Thread3").start();
		
		d1.accept(1);
	}

}
