package data_structures;
import java.util.*;

public class BalancedTreeDictionary<K extends Comparable <K>, V extends Comparable <V>> implements DictionaryADT<K, V>{

	protected Map<K, V> tmap;
	public BalancedTreeDictionary(){ tmap = new TreeMap<>(); }
	public boolean put(K key, V value){ return tmap.put(key, value) != null; }
	public boolean delete(K key){ return tmap.remove(key) != null; }
	public V get(K key){ return tmap.get(key); }
	public K getKey(V value){
		for(Map.Entry<K, V> entry : tmap.entrySet())
			if(value.compareTo(entry.getValue()) == 0)
				return entry.getKey();
		return null;
	}
	public int size(){ return tmap.size() ;}
	public boolean isFull(){ return false;}
	public boolean isEmpty(){ return tmap.size() == 0; }
	public void clear(){ tmap.clear(); }
	public Iterator<K> keys(){ return tmap.keySet().iterator(); }
	public Iterator<V> values(){ return tmap.values().iterator(); }

}
