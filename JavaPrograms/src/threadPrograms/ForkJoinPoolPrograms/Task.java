package threadPrograms.ForkJoinPoolPrograms;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private int first, last;
	private double increment;
	private List<Products> products;
	
	public Task(int first, int last, double increment, List<threadPrograms.ForkJoinPoolPrograms.Products> products) {
		this.first = first;
		this.last = last;
		this.increment = increment;
		this.products = products;
	}

	@Override
	protected void compute() {
		if(last-first<10) {
			updatePrice();
		}else {
			int mid = (first+last)/2;
			System.out.printf("Task : Pending Task %s\n",getQueuedTaskCount());
			Task t1 = new Task(first, mid, increment, products);
			Task t2 = new Task(mid+1, last, increment, products);
			invokeAll(t1, t2);
		}

	}

	private void updatePrice() {
		for(int i=first; i<last;i++) {
			Products product = products.get(i);
			product.setPrice(product.getPrice()+(10*increment));
		}
		
	}

}
