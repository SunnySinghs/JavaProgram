package treeMapPrograms.treeMapDemo1;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ClientTest {

	public static void main(String[] args) {
		Employee e1 = new Employee("sam", 10000.00, 21, "s@s.com");
		Employee e2 = new Employee("emanual", 20000.00, 11, "e@e.com");
		Employee e3 = new Employee("raja", 10000.00, 21, "r@r.com");
		Employee e4 = new Employee("karen", 10000.00, 21, "k@k.com");
		Employee e5 = new Employee("dough", 10000.00, 21, "d@d.com");
		
		Department d1 = new Department(71, "CSE", "Punjab");
		Department d2 = new Department(51, "ECE", "Delhi");
		
		Map<Employee,Department> treeMap = new TreeMap<>();
		treeMap.put(e1, d1);
		treeMap.put(e2, d1);
		treeMap.put(e3, d1);
		
		treeMap.put(e4, d2);
		treeMap.put(e5, d2);
		
		Set<Entry<Employee, Department>> set = treeMap.entrySet();
		Iterator<Entry<Employee, Department>> it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry<Employee, Department> entry = (Map.Entry<Employee, Department>)it.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}
