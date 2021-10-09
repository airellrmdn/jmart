package airellJmartAK;

public class Recognizable implements Comparable <Recognizable>
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    
    public static int setClosingId(Class<Recognizable>Class, int id) {
    	if(Class.class.isAssignableFrom(Recognizable.class)) {
    		return 0;
    	}
    	else {
    		return 1;
    	}
    }
    
    public static int getClosingId(Class<Recognizable>id) {
    	if(Class.class.isAssignableFrom(Recognizable.class)) {
    		return 0;
    	}
    	else {
    		return 1;
    	}
    }

    public boolean equals(Object recognizable){
        return (recognizable instanceof Recognizable) && ((Recognizable) recognizable).id == id;
    }
    
    public boolean equals(Recognizable recognizable){
		return recognizable.id == id;
	}
    
    @Override
    public int compareTo(Recognizable other) {
    	if(id == other.id) {
    		return 1;
    	}
    	else {
    		return 0;
    	}
    }
}
