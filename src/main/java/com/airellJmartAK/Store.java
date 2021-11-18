package com.airellJmartAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store
{
    public static final String REGEX_PHONE = "^(\\d[9,12])$";
    public static final String REGEX_NAME = "^(?=^[A-Z])(?![A-Z a-z]{20,})((?=[A-Z a-z]{4,}).)((?!\\s{2}).)*$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
   
    public Store(String name, String address, String phoneNumber, double balance){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
    public String toString(){
        return "name: " + name + "\n" + "address: " + address + "\n" + "phoneNumber: " + phoneNumber;
    }
    
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchPhone = matcherPhone.find();
        String res1 = matchPhone ? "FOUND" : "NOT FOUND";
        
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchName = matcherName.find();
        String res2 = matchName ? "FOUND" : "NOT FOUND";
        
        if(res1 == "FOUND" && res2 == "FOUND"){
            return true;
        }
        else{
            return false;
        }
    }
}
