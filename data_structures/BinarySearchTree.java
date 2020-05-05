package data_structures;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class BinarySearchTree<K extends Comparable <K>, V extends Comparable <V>> implements DictionaryADT<K, V> {
	
	private class Node<K, V>{
		private K key;
		private V value;
		private Node<K, V> leftChild;
		private Node<K, V> rightChild;
			
		public Node(K k, V v){
			key = k;
			value = v;
			leftChild = rightChild = null;
		}
	}

	private Node<K, V> root;
	private int currentSize;
	private int modificationCounter;
	
	public BinarySearchTree(){
		root = null;
		modificationCounter = currentSize = 0;
	}

	public boolean put(K k, V v){
		if(root == null){
			root = new Node<K, V>(k, v);
			currentSize++;
			modificationCounter++;
			return true;
		}
		else
			return insert(k,v,root,null,false);
	}
	private boolean insert(K k, V v, Node<K, V> n, Node<K, V> parent, boolean wasLeft){
		if(n == null){
			if(wasLeft) parent.leftChild = new Node<K, V>(k, v);
			else parent.rightChild = new Node<K, V>(k, v);
			currentSize++;
			modificationCounter++;
			return true;
		} else if(((Comparable <K>) k).compareTo((K) n.key) == 0)
			return false; //duplicate
		else if(((Comparable <K>) k).compareTo((K) n.key) < 0)
			return insert(k,v,n.leftChild,n,true);
		else
			return insert(k,v,n.rightChild,n,false);
	}
	public boolean delete(K key){
		modificationCounter++;
		Node<K,V> parent = null;
		Node<K,V> current = root;
		while(current != null){
			if(current.key.compareTo(key) == 0){
				if(current.leftChild == null && current.rightChild == null){ //leaf
					if(parent == null) root = null;
					else if(parent.leftChild == current) parent.leftChild = null;
					else parent.rightChild = null;
				}else if (current.leftChild != null && current.rightChild == null){ //only has leftChild
					if(parent == null) root = current.leftChild;
					else if(parent.leftChild == current) parent.leftChild = current.leftChild;
					else parent.rightChild = current.leftChild;
				}else if(current.leftChild == null && current.rightChild != null){ //only has rightChild
					if(parent == null) root = current.rightChild;
					else if (parent.leftChild == current) parent.leftChild = current.rightChild;
					else parent.rightChild = current.rightChild; 
				}else { //has both leftChild and rightChild.
					Node<K,V> suc = current.rightChild;
					while(suc.leftChild != null) suc = suc.leftChild; //find suc
					Node<K,V> temp = new Node<K, V>(suc.key, suc.value); //copy key,value
					temp.rightChild = suc.rightChild; //copy pointer (has no leftChild or that would in fact be suc)
					delete(suc.key);
					current = temp;
				}
				currentSize--;
				return true;
			} else if (current.key.compareTo(key) < 0){
				parent = current;
				current = current.rightChild;
			} else {
				parent = current;
				current = current.leftChild;
			}
		}
		return false;	
	}

	public V get(K key){
		return find(key, root);
	}
	public V find(K key, Node<K, V> n){
		if(n == null) return null;
		int result = ((Comparable<K>) key).compareTo(n.key); 
		if(result < 0)
			return find(key, n.leftChild);
		if(result > 0)
			return find(key, n.rightChild);
		return (V) n.value;
	}

	public K getKey(V value){
		return findKey(value, root);
	}
	private K findKey(V value, Node<K,V> node){
		if(node == null) return null;
		if(((Comparable<V>) value).compareTo(node.value) == 0) return node.key;
		K res = findKey(value, node.leftChild);
		return (res == null) ? findKey(value, node.rightChild) : res;
	}
	
	public int size(){return currentSize;}
	public boolean isFull(){return false;}
	public boolean isEmpty(){return currentSize == 0;}
	public void clear(){modificationCounter++; currentSize = 0; root=null;}

	private class IterK implements Iterator<K>{
		private int state;
		private Node<K,V> stack[];
		private int sp;
		private int max;

		public IterK(){
			state = modificationCounter;
			sp = 0;
			max = currentSize;
			stack = (Node<K,V> []) new Node[max];
			fillStack(root);
			sp = 0;
		}

		private void fillStack(Node<K,V> cur){
			if(cur == null) return;
			else{
				fillStack(cur.leftChild);
				stack[sp++] = cur;
				fillStack(cur.rightChild);
			}
		}

		public boolean hasNext(){
			if(state != modificationCounter) throw new ConcurrentModificationException();
			return sp < max;
		}
		public K next(){
			if(!hasNext()) throw new NoSuchElementException();
			else{ 
				
				return stack[sp++].key; 
			}
		}
	}
	public Iterator<K> keys(){ 
		return new IterK();
	}
	
	private class IterV implements Iterator<V>{
		private int state;
		private Node<K,V> stack[];
		private int sp;
		private int max;

		public IterV(){
			state = modificationCounter;
			sp = 0;
			max = currentSize;
			stack = (Node<K,V> []) new Node[max];
			fillStack(root);
			sp = 0;
		}

		private void fillStack(Node<K,V> cur){
			if(cur == null) return;
			else{
				fillStack(cur.leftChild);
				stack[sp++] = cur;
				fillStack(cur.rightChild);
			}
		}

		public boolean hasNext(){
			if(state != modificationCounter) throw new ConcurrentModificationException();
			return sp < max;
		}
		public V next(){
			if(!hasNext()) throw new NoSuchElementException();
			else{ 
				return stack[sp++].value; 
			}
		}
	}
	public Iterator<V> values(){
		return new IterV();
	}
	
}
