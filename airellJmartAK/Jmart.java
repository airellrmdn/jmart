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
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
/**	public static List<Product> filterByAccountId(List<Product>list, int accountId, int page, int pageSize){
		Predicate<Product> predicate = product -> product.accountId == accountId;
		return paginate(list, page, pageSize, predicate);
	}
	
	public static List<Product> filterByName(List<Product>list, String search, int page, int pageSize){
		Predicate<Product> predicate = product -> (product.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
	}
	
	private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred){
		return list.stream().filter(i -> pred.predicate(i)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
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
	}  **/
	
    public static void main(String[] args){
  /**  	try{
    		String filepath = "C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\jmart\\Account.json";
    		
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password", 100));
            tableAccount.writeJson();
            
            tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.forEach(account -> System.out.println(account.toString()));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }  **/
    	try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class,"C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\jmart\\randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add(payment));
            while (paymentPool.size() != 0);
            paymentPool.exit();
            while (paymentPool.isAlive());
            System.out.println("Thread exited successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static boolean paymentTimekeeper(Payment payment) {
    	long startTime = System.currentTimeMillis();
    	if(System.currentTimeMillis() - startTime > WAITING_CONF_LIMIT_MS) {
    		payment.history.add(new Payment.Record(Invoice.Status.FAILED, "ERROR"));
    	}
    	return false;
    }
    
 /**  public static List<Product> read(String filepath) throws FileNotFoundException{
		Gson gson = new Gson();
		Type userListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		List<Product> returnList = gson.fromJson(br, userListType);
		return returnList;
    } **/
}