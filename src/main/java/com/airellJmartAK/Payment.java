package com.airellJmartAK;

import java.util.ArrayList; 
import java.util.Date;

/**
 * This is class for representing a payment
 *
 * @author Airell Ramadhan B
 * 
 */

public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
	public int productCount;
    public Shipment shipment;
    
    /**
     * Creates payment.
     * 
     * @param buyerId      The buyer's id.
     * @param productId    The product's id.
     * @param productCount The product's quantity.
     * @param shipment     The order shipment
     */
    public Payment(int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    /**
     * Method to get total pay from product price, quantity, discount, and shipment
     * cost.
     * 
     * @param object product The product
     * @return total pay from product price, discount.
     */
    @Override
    public double getTotalPay(Product product){
        return product.price * product.discount;
    }
    
    /**
     * This is a class representing an order history record.
     */
    public static class Record {
    	public final Date date;
    	public String message;
    	public Status status;
    	
    	/**
    	 * Creates a record of the order history.
    	 * 
    	 * @param status status of order
    	 * @param message the message
    	 */
    	public Record(Status status, String message) {
    		this.status = status;
    		this.message = message;
    		date = java.util.Calendar.getInstance().getTime();
    	}
    }
}