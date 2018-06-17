package customImplementation;

import customImplementation.CustomHashMap;;
public class CustomHashMapApp {
	     
	    public static void main(String[] args) {
	           CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<Integer, Integer>();
	           hashMapCustom.put(21, 12);
	           hashMapCustom.put(25, 121);
	           hashMapCustom.put(30, 151);
	           hashMapCustom.put(33, 15);
	           hashMapCustom.put(35, 89);
	 
	           System.out.println("value corresponding to key 21="
	                        + hashMapCustom.get(21));
	           System.out.println("value corresponding to key 51="
	                        + hashMapCustom.get(51));
	 
	           System.out.print("Displaying : ");
	           hashMapCustom.display();
	 
	           System.out.println("\n\nvalue corresponding to key 21 removed: "
	                        + hashMapCustom.remove(21));
	           System.out.println("value corresponding to key 51 removed: "
	                        + hashMapCustom.remove(51));
	 
	           System.out.print("Displaying : ");
	           hashMapCustom.display();
	 
	    }
	}
