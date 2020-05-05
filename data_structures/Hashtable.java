package data_structures;
import data_structures.*;

import java.util.Iterator;
import java.util.NoSuchElementException; 
import java.util.ConcurrentModificationException;

public class Hashtable<K extends Comparable <K>, V extends Comparable <V>> implements DictionaryADT<K,V> {
	
	private class Pair<K, V> implements Comparable<Pair<K,V>>{
		public K key;
		public V value;
	
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		public int compareTo(Pair<K,V> p){
			return ((Comparable<K>) key).compareTo((K)p.key);
		}
	}

	private ListADT<Pair<K,V>> table[]; 
	private int tableSize;
	private int numberCurrentEntries;
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
		modificationCounter++;
		Pair<K,V> entry = new Pair<>(key, value);
		if(table[key.hashCode() % tableSize].contains(entry))
			return false;
		table[key.hashCode() % tableSize].addLast(entry);
		numberCurrentEntries++;
		return true;
	}

	public boolean delete(K key){
		boolean res = table[key.hashCode() % tableSize].remove(new Pair(key, null));
		if(res){
			modificationCounter++;
			numberCurrentEntries--;
			return true;
		} else return false;
	}

	public V get(K key){
		Pair<K,V> searchResult = table[key.hashCode() % tableSize].search(new Pair(key, null));
		return searchResult == null ? null : (V) searchResult.value;
	}

	public K getKey(V value){
		Iterator<Pair<K,V>> iter;	
		Pair<K,V> p;

		for(int i = 0; i < tableSize; i++){
			iter = table[i].iterator();
			while(iter.hasNext()){
				p = iter.next();
				if(p.value.compareTo(value) == 0)
					return p.key;
			}
		}	
		return null;
	}

	public int size(){return numberCurrentEntries;}
	public boolean isFull(){return false;}
	public boolean isEmpty(){return numberCurrentEntries == 0;}

	public void clear(){
		for(int i=0; i<tableSize; i++)
			table[i].makeEmpty();
		modificationCounter++;
		numberCurrentEntries = 0;
	}

	private class IterK implements Iterator<K>{
		private int state;
		private Iterator<Pair<K,V>> iter;	
		private int keysIndex;
		private K[] keys;
	

	public IterK(){
			state = modificationCounter;
			keys = (K[]) new Comparable[numberCurrentEntries];
			int j;
			keysIndex = j = 0;
			for(int i = 0; i < tableSize; i++){
				iter = table[i].iterator();
				while(iter.hasNext())
					keys[j++] = iter.next().key;
			}			
		}
		public boolean hasNext(){
			if(state != modificationCounter) throw new ConcurrentModificationException();
			return keysIndex < numberCurrentEntries;
		}
		public K next(){
			return keys[keysIndex++];
		}
	}
	private class IterV implements Iterator<V>{
		private int state;
		private Iterator<Pair<K,V>> iter;	
		private int valuesIndex;
		private V[] values;
	


		public IterV(){
			state = modificationCounter;
			values = (V[]) new Comparable[numberCurrentEntries];
			int j;
			valuesIndex = j = 0;
			for(int i = 0; i < tableSize; i++){
				iter = table[i].iterator();
				while(iter.hasNext())
					values[j++] = iter.next().value;
			}			
		}
		public boolean hasNext(){
			if(state != modificationCounter) throw new ConcurrentModificationException();
			return valuesIndex < numberCurrentEntries;
		}
		public V next(){
			return values[valuesIndex++];
		}
	}

	public Iterator<K> keys(){
		return new IterK();
	}
	public Iterator<V> values(){
		return new IterV();
	}
	
}
