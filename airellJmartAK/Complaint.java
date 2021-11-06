package airellJmartAK;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable
{
    public Date date;
    public String desc;
   
    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
   }
    
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(this.date);
        return "Complaint{date = " + date + ", desc = '" + desc + "'}";
    }
}