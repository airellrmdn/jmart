package airellJmartAK;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Shipment implements FileParser
{
    String address;
    int shipmentCost;
    Duration duration;
    String receipt;
    
    public static class Duration
    {
        public static final  Duration INSTANT =  new Duration ((byte)(1<<0));
        public static final Duration SAME_DAY =  new Duration ((byte)(1<<1));
        public static final Duration NEXT_DAY = new Duration ((byte)(1<<2));
        public static final Duration REGULER = new Duration ((byte)(1<<3));
        public static final Duration KARGO = new Duration ((byte)(1<<4));
        public byte bit;
        public static SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E dd MMM yyyy");
    
        private Duration(byte bit){
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference){
            Calendar cal = Calendar.getInstance();
            if(this.bit == 1<<0 || this.bit == 1<<1){
                return ESTIMATION_FORMAT.format(reference.getTime());
            }
            else if(this.bit == 1<<2){
                cal.setTime(reference);
                cal.add(Calendar.DATE, 1);
                return ESTIMATION_FORMAT.format(cal);
            }
            else if(this.bit == 1<<3){
                cal.setTime(reference);
                cal.add(Calendar.DATE, 2);
                return ESTIMATION_FORMAT.format(cal);
            }
            else{
                cal.setTime(reference);
                cal.add(Calendar.DATE, 5);
                return ESTIMATION_FORMAT.format(cal);
            }
        }
    }
    
    public class MultiDuration
    {
        byte bit;
        
        public MultiDuration(Duration... args){
            for(Duration i: args){
                this.bit |= i.bit;
            }
        }
        
        public boolean isDuration(Duration reference){
            if((this.bit & reference.bit) == reference.bit){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public Shipment(String address, int shipmentCost, Duration duration, String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
