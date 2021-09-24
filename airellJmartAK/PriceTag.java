package airellJmartAK;

public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    
    public double discount;
    public double price;

    public PriceTag(double price){
       this.price = price;
       this.discount = 0.0;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
        if(getDiscountedPrice() < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
        return getDiscountedPrice() - (COMMISSION_MULTIPLIER * getDiscountedPrice());
    }
    
    private double getDiscountedPrice(){
        if(discount >= 100.0){
            return 0.0;
        }
        else{
            return price - (price * discount / 100.0);
        }
    }
}
