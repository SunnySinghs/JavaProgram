package threadPrograms.forkJoinPoolPrograms.forkJoinWithoutJoin;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {
	public List<Products> generate(int size){
		List<Products> product = new ArrayList<>(size);
		for(int i=0; i<size; i++) {
			Products p = new Products();
			p.setName("Product_"+i);
			p.setPrice(10);
			product.add(p);
		}
		return product;
	}
}
