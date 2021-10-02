package airellJmartAK;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^(\\d[9,12])$";
   // public static final String REGEX_NAME = 
    public String name;
    public String address;
    public String phoneNumber;
   
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public String toString(){
        return "name: " + name + "\n" + "address: " + address + "\n" + "phoneNumber: " + phoneNumber;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean matchFound = matcher.find();
        String res = matchFound ? "FOUND" : "NOT FOUND";
        if(res == "FOUND"){
            return true;
        }
        else{
            return false;
        }
    }
}
