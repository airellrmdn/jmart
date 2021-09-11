package airellJmartAK;

public class Jmart
{
    public static void main(String[] args) {

    }
    
    public static int getPromo (){
        return 0;
    }
    
    public static String getCustomer (){
        return "OOP";
    }
    
    public static float getDiscountPercentage (int sebelum, int sesudah){
        if (sebelum < sesudah){
            return 0.0f;
        }
        else {
            return ((sebelum - sesudah) / sebelum) * 100;
        }
    }
}
