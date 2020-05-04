import data_structures.*;
//import data_structures.DictionaryADT;
//import data_structures.BinarySearchTree;
import java.util.Scanner;
import java.util.Iterator;

public class HashDriver{
	public static void main(String args[]){

		DictionaryADT<Integer, String> Dict = new Hashtable<Integer, String>();
		Dict.put(1, "1");
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
		System.out.println(Dict.size());

		Iterator<Integer> it2 = Dict.keys();
		while(it2.hasNext())
			System.out.println(it2.next());
		System.out.println();
//		System.out.println(Dict.getKey(4));

	}
}
