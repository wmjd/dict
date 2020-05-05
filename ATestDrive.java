import data_structures.*;
//import data_structures.DictionaryADT;
//import data_structures.BinarySearchTree;
import java.util.Scanner;
import java.util.Iterator;

public class ATestDrive{
	public static void main(String args[]){

		DictionaryADT<Integer, Integer> Dict = new BinarySearchTree<Integer, Integer>();
		Dict.put(5, 5);
		Dict.put(3, 3);
		Dict.put(10, 10);
		Dict.put(2, 2);
		Dict.put(4, 4);
		Dict.put(7, 7);
		Dict.put(11, 11);
		Dict.put(8, 8);
		Dict.put(9, 9);
		System.out.println("size: "+Dict.size());
		System.out.println("size: "+Dict.size());
		System.out.println("size: "+Dict.size());
			System.out.println(	Dict.delete(4));
		System.out.println(Dict.get(4));

		System.out.println(Dict.delete(5));		
		System.out.println(Dict.get(5));
	
		System.out.println(Dict.delete(3));
		System.out.println(Dict.get(3));

		System.out.println(Dict.delete(10));		
		System.out.println(Dict.get(10));

		System.out.println(	Dict.delete(2));
		System.out.println(Dict.get(2));

	
		System.out.println(	Dict.delete(7));
		System.out.println(Dict.get(7));

		System.out.println(	Dict.delete(11));
		System.out.println(Dict.get(11));

		System.out.println(	Dict.delete(8));
		System.out.println(Dict.get(8));

		System.out.println(Dict.delete(9));
		System.out.println(Dict.get(9));


	
	//	Iterator<String> i = Dict.keys();
	//	while(i.hasNext())
	//		System.out.print(" "+i.next());	


//		System.out.println(Dict.getKey(1));
		
		Iterator<Integer> it = Dict.keys();

		while(it.hasNext())
			System.out.println("using iter" + it.next());
		System.out.println();
//		System.out.println(Dict.getKey(4));
		
	}
}
