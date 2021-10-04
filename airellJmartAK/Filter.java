package airellJmartAK;
import java.util.ArrayList;

public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> result = new ArrayList<PriceTag>();
        
        for (PriceTag listItem : list) {
            if (listItem.getAdjustedPrice() < value && less == true) {
                result.add(listItem);
            } else if (listItem.getAdjustedPrice() >= value && less == false) {
                result.add(listItem);
            }
        }
        return result;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        for(int i = 0; i < list.size(); ++i){
            final ProductRating e = list.get(i);
            if(less && e.getAverage() < value || !less && e.getAverage() >= value){
                list.remove(i);
            }
        }
    }
}
