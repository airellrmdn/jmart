package airellJmartAK;

import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable <Serializable>
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap();
    
    protected Serializable(){
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }
    
    public static <T> int setClosingId(Class<T>clazz, int id) {
    	return mapCounter.put(clazz, id);
    }
    
    public static <T> int getClosingId(Class<T>clazz) {
    	return mapCounter.get(clazz);
    }

    public boolean equals(Object other){
        return (other instanceof Serializable) && ((Serializable) other).id == id;
    }
    
    public boolean equals(Serializable other){
		return other.id == id;
	}
    
    @Override
    public int compareTo(Serializable other) {
    	if(id == other.id) {
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
}
