package airellJmartAK;

public class Transaction extends Recognizable
{
    public String time;
    public int buyerId;
    public int storeId;
    public Rating rating;
    
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
}
