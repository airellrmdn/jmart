package airellJmartAK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	private Algorithm() {
		
	}
	
	public static <T> List<T> collect(T[] array, T value){
		final  Iterator<T>it = Arrays.stream(array).iterator();
		return collect(it, value);
	} 
	
	public static <T> List<T> collect(Iterable<T> iterable, T value){
		final Iterable<T>iter = (Iterable<T>)iterable.iterator();
		return collect(iter, value);
	}
	
	public static <T> List<T> collect(Iterator<T> iterator, T value){
		final Predicate<T> predicate = value::equals;
        return collect(iterator, value);
	}
	
	public static <T> List<T> collect(T[] array, Predicate<T> pred){
		final Iterator<T> itArray = Arrays.stream(array).iterator();
        return collect(itArray, pred);
	}
	
	public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
		return null;
	}
	
	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred){
		int count = 0;
        while(iterator.hasNext()){
            count++;
        }
        final Predicate<T> predicate = pred::equals;
        return collect(iterator, pred);
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
		int counter = 0;
        while (iterator.hasNext()){
            counter++;
        }
        return counter;
	}
	
	public static <T> int count(T[] array, Predicate<T> pred) {
		int counter = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            for (T a:array){
                counter++;
            }
        }
        return counter;
	}
	
	public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
		 int counter = 0;
	        if (pred.equals(false)) {
	            return 0;
	        }else{
	            for (T a:iterable){
	                counter++;
	            }
	        }
	        return counter;
	}
	
	public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
		 int counter = 0;
	        if (pred.equals(false)) {
	            return 0;
	        }else{
	            while (iterator.hasNext()){
	                counter++;
	            }
	        }
	        return counter;
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
		if(first.hashCode() > second.hashCode()){
	           return first;
	       }
		else {
	           return second;
	       }
	}
	
	public static <T> T max(T[] array) {
		int max = 0;
        T maxT = null;
        for (T t : array) {
            if (t.hashCode() > max) {
                max = t.hashCode();
                maxT = t;
            }
        }
        return maxT;
	}
	
	public static <T> T max(Iterable<T> iterable, T value) {
		if(iterable.hashCode() > value.hashCode()){
            return (T) iterable;
        }
		else {
            return value;
        }
	}
	
	public static <T> T max(Iterator<T> iterator) {
		return null;
	}
	
	public static <T> T max(T first, T second, Comparator<?super T> comparator) {
		int res = ((Comparable<T>)first).compareTo(second);
		return res == -1 ? second : first;
	}
	
	public static <T> T max(T[] array, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T max(Iterable<T> iterable, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T max(Iterator<T> iterator, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T min(T first, T second) {
		if(first.hashCode() > second.hashCode()){
	           return second;
	       }
		else {
	           return first;
	       }
	}
	
	public static <T> T min(Iterable<T> iterable) {
		return null;
	}
	
	public static <T> T min(Iterator<T> iterator) {
		return null;
	}
	
	public static <T> T min(T first, T second, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T min(T[] array, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T min(Iterable<T> iterable, Comparator<?super T> comparator) {
		return null;
	}
	
	public static <T> T min(Iterator<T> iterator, Comparator<?super T> comparator) {
		return null;
	}
	
}
