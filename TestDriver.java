import data_structures.DictionaryADT;
import data_structures.BalancedTreeDictionary;
import java.util.Scanner;
import java.util.Iterator;

public class TestDriver{
	public static void main(String args[]){

		DictionaryADT<String, Integer> Dict = new BalancedTreeDictionary<String, Integer>();
		Dict.put("A", 1);
		Dict.put("C", 3);
		Dict.put("B", 2);
		Dict.put("D", 4);
		Dict.put("F", 6);
		Dict.put("G", 7);
		Dict.put("E", 5);
	
		Iterator<Integer> it = Dict.values();
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println();
		System.out.println(Dict.getKey(4));

	}
}
