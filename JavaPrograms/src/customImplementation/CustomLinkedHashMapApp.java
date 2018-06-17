package customImplementation;
import customImplementation.CustomLinkedHashMap;

public class CustomLinkedHashMapApp {
	public static void main(String[] args) {
		CustomLinkedHashMap<Employee, Integer> linkedHashMapCustom = new CustomLinkedHashMap<Employee, Integer>();
		linkedHashMapCustom.put(new Employee("10", "sam"), 12);
		linkedHashMapCustom.put(new Employee("21", "amy"), 121);
		linkedHashMapCustom.put(new Employee("31", "rob"), 151);
		linkedHashMapCustom.put(new Employee("41", "sam"), 15);
		linkedHashMapCustom.put(new Employee("42", "wil"), 89);

		System.out.println("Display values corresponding to keys>");
		System.out.println("value corresponding to employee with id=21 & name='amy' : "+linkedHashMapCustom.get(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' : "+linkedHashMapCustom.get(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		linkedHashMapCustom.display();

		System.out.println("\n\nvalue corresponding to employee with id=21 & name='amy' removed: "+linkedHashMapCustom.remove(new Employee("21", "amy")));
		System.out.println("value corresponding to employee with id=51 & name='pat' removed: "+linkedHashMapCustom.remove(new Employee("51", "pat")));

		System.out.print("Displaying : ");
		linkedHashMapCustom.display();
	}
}
