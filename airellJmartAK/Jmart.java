package airellJmartAK;

public class Jmart
{
    public static void main(String[] args){
        
    }
    
    public static Product create(){
        return new Product("Bike", 1, true, new PriceTag(100), ProductCategory.TOYS);
    }
}
