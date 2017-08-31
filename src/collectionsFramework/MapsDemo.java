package collectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "BMW");
		map.put(2, "Audi");
		map.put(3, "Honda");
		
		String value1 = map.get(1);
		System.out.println(value1);
		
		//Keys are unique, value can be duplicated, 
		//if a key duplicated with different value, 
		//2nd key value will overwrite the value of the 1st key
		
		map.put(2, "CAR");
		map.put(4, "Moto");
		String value2 = map.get(2);
		System.out.println(value2);
		
		System.out.println("All values of the map:\n" + map);
		
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map2.put(1, 1);
		map2.put(2, 2);
		map2.put(3, 3);
		Integer value3 = map2.get(3);
		System.out.println(value3);
  }

}
