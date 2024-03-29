package com.airellJmartAK;

import com.airellJmartAK.dbjson.Serializable;

public class Product extends Serializable
{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
   
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans){
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    
    public String toString(){
        return "name: " + this.name + "\n" + "Weight: " + weight + "\n" + "ConditionUsed: " + this.conditionUsed + "\n" + "price: " + 
        price + "\n" + "Category: " + this.category + "\n" + "Discount: " + discount + "accountId: " + accountId;
    }
}