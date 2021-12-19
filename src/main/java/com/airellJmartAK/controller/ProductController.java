package com.airellJmartAK.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.*;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

/**
 * class for product controller
 *
 * @author Airell Ramadhan B
 * 
 */

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
	
	 /**
	  * The json table of Product class. save locally in this path.
	  */
	@JsonAutowired(value=Product.class, filepath="C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\product.json")
	public static JsonTable<Product> productTable;

	 /**
	  * Method to get product Json Table
	  * 
	  * @return product Json Table
	  */
	@Override
	public JsonTable<Product> getJsonTable() {
		return productTable;
	}
	
	/**
	  * For post request to creates product.
	  * 
	  * @param accountId     account id.
	  * @param name          product name.
	  * @param weight        product weight.
	  * @param conditionUsed product condition used. true if used, false if new.
	  * @param price         product price.
	  * @param discount      product discount.
	  * @param category      product category.
	  * @param shipmentPlans shipment plan
	  * @return the product that have been made
	  */
	@PostMapping("/create")
	@ResponseBody Product create 
	(
			@RequestParam int accountId,
			@RequestParam String name,
			@RequestParam int weight,
			@RequestParam boolean conditionUsed,
			@RequestParam double price,
			@RequestParam double discount,
			@RequestParam ProductCategory category,
			@RequestParam byte shipmentPlans
	) 
	{
		for(Product each : productTable) {
            if (each.accountId == accountId){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
	}
	
	 /**
	  * For get request to collect product list of a store.
	  * 
	  * @param id       account id of the store.
	  * @param page     page of product list.
	  * @param pageSize page size of product list.
	  * @return product list of a store.
	  */
	@GetMapping("/{id}/store")
	@ResponseBody List<Product> getProductByStore 
	(
			@RequestParam int id,
			@RequestParam int page,
			@RequestParam int pageSize
	) 
	{
		
        return Algorithm.paginate(productTable, page, pageSize, pred->pred.accountId == id);
	}
	
	 /**
	  * For get request to get all product that have been filtered
	  * 
	  * @param page      page of list.
	  * @param pageSize  page size of list.
	  * @param accountId account id.
	  * @param search    product name.
	  * @param minPrice  minimum price.
	  * @param maxPrice  maximum price.
	  * @param category  product category.
	  * @return all product that have been filtered with certain page and page size.
	  */
	@GetMapping("/getFiltered")
	@ResponseBody List<Product> getProductFiltered 
	(
			@RequestParam int page,
			@RequestParam int pageSize,
			@RequestParam String search,
			@RequestParam double minPrice,
			@RequestParam double maxPrice,
			@RequestParam ProductCategory category,
			@RequestParam boolean conditionUsed
	) 
	{
		List<Product> tempProduct = new ArrayList<>();
		for(Product each : productTable) {
			if(each.name.contains(search)) 
				if(minPrice <= each.price) 
					if(maxPrice >= each.price) 
						if(each.category == category)
							if(each.conditionUsed == conditionUsed)
								tempProduct.add(each);
		}
        return Algorithm.paginate(tempProduct, page, pageSize, pred -> pred.weight != 0);
	}
}
