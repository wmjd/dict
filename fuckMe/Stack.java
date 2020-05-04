class Stack<E>{
	protected E[] array;
	protected int currentSize, maxSize;

	public Stack(int capacity){
		currentSize = 0; maxSize = capacity;
		array = (E[]) new Object[maxSize];
	}
}
