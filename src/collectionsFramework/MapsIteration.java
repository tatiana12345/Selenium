package collectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsIteration {

	public static void main(String[] args) {
		
		//HashMap - does not maintain any order
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "BMW");
		hashMap.put(2, "Audi");
		hashMap.put(3, "Honda");
		
		System.out.println("hashMap, Interation 1");
		for (Map.Entry<Integer, String> entry: hashMap.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + ", value: " + value);
		}
		
		System.out.println("\nhashMap, Interation 2");
		for (Integer key: hashMap.keySet()){
			String value = hashMap.get(key);
			System.out.println("Key: " + key + ", value: " + value);
		}
		
		//LinkedHashMap - maintains the order in which hey are added
		Map<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();
		
		linkedMap.put(1, "Bentley");
		linkedMap.put(2, "Rols Roys");
		linkedMap.put(3, "Jaguar");
		linkedMap.put(3, "Jaguar");
		
		System.out.println("\nlinkedMap");
		for (Integer key: linkedMap.keySet()){
			String value = linkedMap.get(key);
			System.out.println("Key: " + key + ", value: " + value);
		}

		//TreeMap - maintains natural sorting (0, 1, 2, 3, 4.../a, b, c,
		// d...), does not store duplicate values
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(1, "maclaren");
		treeMap.put(2, "lotus");
		treeMap.put(3, "ferrarri");
		treeMap.put(3, "ferrarri");
		
		System.out.println("\ntreeMap");
		for (Integer key: treeMap.keySet()){
			String value = treeMap.get(key);
			System.out.println("Key: " + key+ ", value " + value);
		}
	}

}
