import data_structures.*;
//import data_structures.DictionaryADT;
//import data_structures.BinarySearchTree;
import java.util.Scanner;
import java.util.Iterator;

public class HashDriver{
	public static void main(String args[]){

		DictionaryADT<String, Integer> Dict = new Hashtable<String, Integer>();
		Dict.put("A", 1);
	




		System.out.println("Dict.get returned: " + Dict.get("A"));
		Dict.put("C", 3);
		Dict.put("B", 2);
		Dict.put("D", 4);
		Dict.put("F", 6);
		Dict.put("G", 7);
		Dict.put("E", 5);

//		Iterator<String> it = Dict.keys();
//		while (it.hasNext())
//			System.out.println(it.next());

//		Dict.delete("D");		

//		System.out.println(Dict.get("D"));


/*		System.out.println(Dict.getKey(1));
		
		Iterator<Integer> it = Dict.values();

		while(it.hasNext())
			System.out.println(it.next());
		System.out.println();
		System.out.println(Dict.getKey(4));
*/
	}
}
