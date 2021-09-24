package airellJmartAK;

public class Coupon
{
    public String name;
    public int code;
    public double cut;
    public Type type;
    public double minimum;
    private boolean used;
    
    public enum Type{
        DISCOUNT, REBATE
    }
    
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed(){
        return used;
    }
    
    public boolean canApply(PriceTag priceTag){
        if(priceTag.getAdjustedPrice() >= minimum && used == false){
            return true;
        }
        else{
            return false;
        }
    }
    
    public double apply(PriceTag priceTag){
        used = true;
        switch (type){
            case DISCOUNT: 
                cut = priceTag.discount;
                break;
            case REBATE:
                cut = priceTag.price * priceTag.discount / 100.0;
                break;
        }
        return priceTag.getAdjustedPrice() - cut;
    }
}
