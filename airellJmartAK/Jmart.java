package airellJmartAK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Jmart
{
	public static List<Product> filterByAccountId(List<Product>list, int accountId, int page, int pageSize){
		List<Product> result = new ArrayList<Product>();
		for(Product product : list) {
			if (product.accountId == accountId) {
				result.add(product);
			}
		}
		return paginate(list, page, pageSize, null);
	}
	
	public static List<Product> filterByName(List<Product>list, int accountId, int page, int pageSize){
		//Predicate<Product> predicate = temp -> (temp.name.toLowerCase().contains(search.toLowerCase()));
      //  return paginate(list, page, pageSize, predicate);
		return null;
	}
	
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred){
		List<Product> result = new ArrayList<Product>();
		int paging = page > 1 ? (page - 1) * pageSize : 0;
		for (int i = 0; i < pageSize && i < list.size() - paging; i++) {
			if (pred.predicate(list.get(i))) {
				result.add(list.get(paging + i));
			}
		}
		return result;
	}
	
	public static List<Product> filterByCategory(List<Product>list, ProductCategory category){
		List<Product> result = new ArrayList<Product>();
		for (Product product : list) {
			if (product.category.equals(category)) {
				result.add(product);
			}
		}
		return result;
	}
	
	public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
		List<Product> result = new ArrayList<Product>();
        for (Product product : list)
        {
            if (minPrice != 0.0 && product.price < minPrice)
            {
                continue;
            }
            if (maxPrice != 0.0 && product.price > maxPrice)
            {
                continue;
            }
            result.add(product);
        }
        return result;
	}
	
    public static void main(String[] args){
    	
    }
    
   public static List<Product> read(String filepath) throws FileNotFoundException{
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		List<Product> returnList = gson.fromJson(br, userListType);
		return returnList;
    }
}