package com.airellJmartAK;

public class ProductRating
{
    private long total;
    private long count;

    public ProductRating(){
        total = 0;
        count = 0;
    }
    
    public void insert(int rating){
        total += rating;
        count++;
    }
    
    public double getAverage(){
        if(count == 0){
            return 0.0;
        } 
        double average = total / count;
        return average;
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){
        return total;
    }
}
