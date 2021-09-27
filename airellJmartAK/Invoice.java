package airellJmartAK;

public abstract class Invoice extends Recognizable implements FileParser
{
    public String date = "Senin";
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    
    public enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public abstract double getTotalPay();
}