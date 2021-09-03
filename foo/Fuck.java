import java.util.*;

public class Fuck<E> implements Comparable<Fuck<E>>{
	private E data;

	public Fuck(E data){
		this.data = data;
	}
	public int compareTo(Fuck<E> f){
		System.out.println(data);	
		return ((Comparable<E>)data).compareTo((E)f.data);
	}
}
