package collectionsFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {

	public static void main(String[] args) {

		// HashSet does not maintain any order, does not store duplicate values
		Set<String> set = new HashSet<String>();

		System.out.println("HashSet");
		
		set.add("BMW");
		set.add("Audi");
		set.add("Honda");
		set.add("Honda");
		set.add("Acura");

		System.out.println(set);

		for (String item : set) {
			System.out.println(item);
		}
		// LinkedHashSet - maintains the order in which the elements were added
		// does not store duplicate values
		Set<String> LHSet = new LinkedHashSet<String>();

		System.out.println("LinkedHashSet");
		
		LHSet.add("BMW");
		LHSet.add("Audi");
		LHSet.add("Honda");
		LHSet.add("Honda");
		LHSet.add("Acura");

		System.out.println(LHSet);

		for (String item : LHSet) {
			System.out.println(item);
		}

		// TreeSet - maintains the natural sorting (0, 1, 2, 3, 4.../a, b, c,
		// d...), does not store duplicate values
		Set<String> TSet = new TreeSet<String>();

		System.out.println("TreeSet");
		
		TSet.add("BMW");
		TSet.add("Audi");
		TSet.add("Honda");
		TSet.add("Honda");
		TSet.add("Acura");
		
		System.out.println(TSet);

		for (String item : TSet) {
			System.out.println(item);
		}

		// Array list stores all added values
		List<String> list = new ArrayList<String>();
		
		System.out.println("ArrayList");
		list.add("BMW");
		list.add("Audi");
		list.add("Honda");
		list.add("Honda");
		list.add("Acura");

		System.out.println(list);
		System.out.println(list.get(1));
	}

}
