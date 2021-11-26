package com.airellJmartAK.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.*;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
	
	@JsonAutowired(value=Product.class, filepath="C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\product.json")
	public static JsonTable<Product> productTable;

	@Override
	public JsonTable<Product> getJsonTable() {
		return productTable;
	}
	
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
}
