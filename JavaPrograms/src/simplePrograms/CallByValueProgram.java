package simplePrograms;

import java.util.HashMap;
import java.util.Map;

public class CallByValueProgram {

	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("0", "m");
		new CallByValueProgram().get(map);
		System.out.println(map);
	}
	
	void get(Map map) {
		map.put("3", "s");
		map =  null;
		System.out.println(map);
		map = new HashMap<>();
		map.put("1", "s");
		map.put("2", "ss");
		System.out.println(map);
	}

}
