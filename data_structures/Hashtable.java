package data_structures;
import data_structures.*;

import java.util.*;

public class Hashtable<K extends Comparable <K>, V extends Comparable <V>> implements DictionaryADT<K,V> {
	
	private class Pair<K, V> implements Comparable<Pair<K,V>>{
		public K key;
		public V value;
	
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		public int compareTo(Pair<K,V> p){
//			System.out.println("in compareTo, p.key == " +(K)p.key);
//			System.out.println(key);
//			System.out.println("compare key to itself: "+ (Comparable <K>)key.compareTo((K) key));
//			System.out.println(key + "\n");
//			return 0;
			return ((Comparable<K>) key).compareTo((K)p.key);
		}
	}

	private ListADT<Pair<K,V>> table[]; 
	private int tableSize;
	private int modificationCounter;

	public Hashtable(int size){
		tableSize = size;
		table = new LinkedListDS[tableSize];
		for(int i=0; i < tableSize; i++){
			table[i] = new LinkedListDS<Pair<K,V>>();
		}
	}
	public Hashtable(){
		tableSize = 7919;	//some reasonably large prime integer
		table =  new LinkedListDS[tableSize];
		for(int i=0; i < tableSize; i++){
			table[i] = new LinkedListDS<Pair<K,V>>();
		}
	}

	public boolean put(K key, V value){
//		System.out.println(key.hashCode() % tableSize);
//		System.out.println(key +", "+ value);
		Pair<K,V> entry = new Pair<>(key, value);
		table[key.hashCode() % tableSize].addLast(entry);
		return true;
	}

	public V get(K key){
//		System.out.println(table[key.hashCode() % tableSize].search(new Pair(key, null)));
//		Pair<K,V> p = new Pair<>(key, null);
//		System.out.println("in get, p.key == " + p.key);
//		System.out.println(p.compareTo(p));
		Pair<K,V> searchResult = table[key.hashCode() % tableSize].search(new Pair(key, null));
		return searchResult == null ? null : (V) searchResult.value;
	}

	
	private class IterK implements Iterator<K>{
		private int state;
		Iterator<Pair<K,V>> iter;	
		int currentTableIndex;

		public IterK(){
			state = modificationCounter;
			iter = table[0].iterator();
			currentTableIndex = 0;
		}
		public boolean hasNext(){
			if(state != modificationCounter) throw new ConcurrentModificationException();
			else if(iter.hasNext()) return true;
			else if(++currentTableIndex < tableSize){
				iter = table[currentTableIndex].iterator();
				return iter.hasNext();
			}
			else return false;
		}
		public K next(){
			return iter.next().key;
		}
	}

	public Iterator<K> keys(){
		return new IterK();
	}
	
}
