package airellJmartAK;
import java.util.Iterator;

public class Algorithm {
	private Algorithm() {
		
	}
	
	public static <T> int count(T[] array, T value) {
		return array.length;
	} 
	
	public static <T> int count(Iterable<T> iterable, T value) {
		int counter = 0;
		for(Object i : iterable) {
			counter++;
		}
		return counter;
	} 
	
	public static <T> int count (Iterator<T> iterator, T value) {
		return 0;
	}
	
	public static <T> int count(T[] array, Predicate<T> pred) {
		return 0;
	}
	
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		return 0;
	}
	
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		return 0;
	}
	
	public static <T> boolean exists(T[] array, T value) {
		return false;
	}
	
	public static <T> boolean exists(Iterable<T> iterable, T value) {
		return false;
	}
	
	public static <T> boolean exists(Iterator<T> iterator, T value) {
		return false;
	}
	
	public static <T> boolean exists(T[] array, Predicate<T> pred) {
		return false;
	}
	
	public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
		return false;
	}
	
	public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
		return false;
	}
	
	public static <T> T find(T[] array, T value) {
		return null;
	}
	
	public static <T> T find(Iterable<T> iterable, T value) {
		return null;
	}
	
	public static <T> T find(Iterator<T> iterator, T value) {
		return null;
	}
	
	public static <T> T find(T[] array, Predicate<T> pred) {
		return null;
	}
	
	public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
		return null;
	}
	
	public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
		return null;
	}
	
	public static <T> T max(T first, T second) {
		return null;
	}
	
	public static <T> T min(T first, T second) {
		return null;
	}
}
