package airellJmartAK;

public class Product extends Recognizable implements FileParser
{
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;
   
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.multiDuration = multiDuration;
        this.rating = new ProductRating();
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public String toString(){
        return "name: " + this.name + "\n" + "Weight: " + weight + "\n" + "ConditionUsed: " + this.conditionUsed + "\n" + "priceTag: " + 
        this.priceTag.getAdjustedPrice() + "\n" + "Category: " + this.category + "\n" + "rating: " + this.rating.getAverage() + "storeId: " + storeId;
    }
}