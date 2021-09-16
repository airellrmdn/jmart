package airellJmartAK;

public class Jmart
{
    public static void main(String[] args){
        
    }
    
    public static int getPromo(){
        return 0;
    }
    
    public static String getCustomer(){
        return "OOP";
    }
    
    public static float getDiscountPercentage(int before, int after){
        if (before < after || before == after){
            return 0.0f;
        }
        return 100.0f * (before - after) / before;
    }
    
    public static float getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage >= 100.0f){
            return 0;
        }
        float cut = price * discountPercentage / 100.0f;
        return price - (int) cut;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        float divider = 100.0f - discountPercentage;
        return (int) (discountedPrice * 100 / divider);
    }
    
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price){
        return (int) (price + (price * getCommissionMultiplier()));
    }
    
    public static int getAdminFee(int price){
        return (int) (price * getCommissionMultiplier());
    }
}
