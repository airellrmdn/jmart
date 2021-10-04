package airellJmartAK;
import java.util.Date;
import java.util.ArrayList;

public abstract class Invoice extends Recognizable implements FileParser
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    public ArrayList<Record> history = new ArrayList<Record>();
    
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
        this.date = new Date();
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public abstract double getTotalPay();
    
    public class Record
    {
        public Status status;
        public Date date;
        public String message;
    }
}