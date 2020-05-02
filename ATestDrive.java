import data_structures.*;
//import data_structures.DictionaryADT;
//import data_structures.BinarySearchTree;
import java.util.Scanner;
import java.util.Iterator;

public class ATestDrive{
	public static void main(String args[]){

		DictionaryADT<String, Integer> Dict = new BinarySearchTree<String, Integer>();
		Dict.put("A", 1);
		Dict.put("C", 3);
		Dict.put("B", 2);
		Dict.put("D", 4);
		Dict.put("F", 6);
		Dict.put("G", 7);
		Dict.put("E", 5);
//		Dict.delete("D");		
//		System.out.println(Dict.get("D"));

		
		Iterator<String> it = Dict.keys();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println();
//		System.out.println(Dict.getKey(4));
		
	}
}
