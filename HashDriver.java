import data_structures.*;
//import data_structures.DictionaryADT;
//import data_structures.BinarySearchTree;
import java.util.Scanner;
import java.util.Iterator;

public class HashDriver{
	public static void main(String args[]){

		DictionaryADT<Integer, String> Dict = new Hashtable<Integer, String>();

		System.out.println("Try to delete nonexistent: " + Dict.delete(99));

		System.out.println("Should be true: "+ Dict.put(1, "1"));
		System.out.println(Dict.put(1, "1"));
		System.out.println(Dict.put(1, "1"));
		System.out.println(Dict.put(1, "1"));
		System.out.println(Dict.put(1, "1"));
		System.out.println(Dict.put(1, "1"));
	
	

		Dict.delete(1);


		Dict.put(3, "3333");
		Dict.put(2, "2");
		Dict.put(4, "4");
		Dict.put(6, "6");
		Dict.put(7, "7");
		Dict.put(5, "5");
		System.out.println(Dict.size());
		System.out.println("Dict.get returned: " + Dict.get(2));
		System.out.println("Dict.getKey returned: " + Dict.getKey("3333"));

//		Iterator<String> it = Dict.keys();
//		while (it.hasNext())
//			System.out.println(it.next());

//		Dict.delete("D");		

//		System.out.println(Dict.get("D"));


		System.out.println(Dict.getKey("1"));
		
		Iterator<String> it = Dict.values();
		System.out.println(Dict.size());
		while(it.hasNext())
			System.out.println(it.next());

		Dict.clear();
		System.out.println(Dict.isEmpty());
		System.out.println(Dict.size());
		System.out.println(Dict.get(7));

		Dict.put(33, "333");
		Dict.put(22, "222");
		Dict.put(44, "444");
		Dict.put(66, "666");
		Dict.put(77, "777");
		Dict.put(55, "555");


		Iterator<Integer> it2 = Dict.keys();
		while(it2.hasNext())
			System.out.println(it2.next());
		System.out.println();
//		System.out.println(Dict.getKey(4));
		Iterator<Integer> it3 = Dict.keys();
		Dict.clear();
		while(it3.hasNext())
			System.out.println("SHOULD NOT SEE THIS IN TERMINAL" + it2.next());
		System.out.println();


	}
}
