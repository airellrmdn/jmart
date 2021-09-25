package airellJmartAK;

public class Transaction extends Recognizable
{
    public String time;
    public int buyerId;
    public int storeId;
    
    protected Transaction(int id, int buyerId, int storeId){
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
}
