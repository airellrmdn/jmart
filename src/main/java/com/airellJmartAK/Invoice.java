package com.airellJmartAK;

import java.util.Date;

import com.airellJmartAK.dbjson.Serializable; 

public abstract class Invoice extends Serializable
{
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId = -1;
    public Rating rating;
    
    public static enum Rating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public static enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }
    
    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = java.util.Calendar.getInstance().getTime();
        this.rating = Rating.NONE;
    }
    
    public abstract double getTotalPay(Product product);
}