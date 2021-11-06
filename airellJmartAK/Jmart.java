package airellJmartAK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Jmart
{
	public static List<Product> filterByCategory(List<Product>list, ProductCategory category){
		return new ArrayList<Product>();
	}
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
		List<Product> result = new ArrayList<Product>();
        for (Product product : list)
        {
            if (minPrice <= 0.0 && product.price < minPrice)
            {
                continue;
            }
            if (maxPrice <= 0.0 && product.price > maxPrice)
            {
                continue;
            }
            result.add(product);
        }
        return result;
	}
	
    public static void main(String[] args){
    	
    }
    
//   public static List<Product> read(String filepath) throws FileNotFoundException{
//		final JsonReader reader = new JsonReader(new FileReader(filepath));
//   }
}