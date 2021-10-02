package airellJmartAK;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
    //public String date = "Senin";
    public Date date = new Date();
    public String desc;
   
    public Complaint(int id, String desc){
         super(id);
         this.desc = desc;
         this.date = date;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
}
