package com.airellJmartAK;

import com.airellJmartAK.dbjson.Serializable;

public class Coupon extends Serializable
{
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public static enum Type{
        DISCOUNT, REBATE
    }
    
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(double price, double discount){
        if(Treasury.getAdjustedPrice(minimum, cut) >= minimum && used == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(double price, double discount){
        used = true;
        switch (type){
            case REBATE: 
            	return (Treasury.getAdjustedPrice(minimum, cut) - cut);
            default:
                return (Treasury.getAdjustedPrice(minimum, cut) * (1 - (cut / 100.0)));
        }
    }
}
