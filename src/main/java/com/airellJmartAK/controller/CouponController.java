package com.airellJmartAK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.Algorithm;
import com.airellJmartAK.Coupon;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
	
	@JsonAutowired(value=Coupon.class, filepath="C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\coupon.json")
	public static JsonTable<Coupon> couponTable;

	@Override
	public JsonTable<Coupon> getJsonTable() {
		return couponTable;
	}
	
	@GetMapping("/{id}/isUsed")
	@ResponseBody boolean isUsed (@RequestParam int id) {
		for(Coupon data : getJsonTable()) {
			if(data.id == id) {
				return data.isUsed();
			}
		}
		return false;
	}
	
	@GetMapping("/{id}/canApply")
	@ResponseBody boolean canApply 
	(
			@RequestParam int id,
			@RequestParam double price,
			@RequestParam double discount
	) 
	{
		for(Coupon data : getJsonTable()) {
			if(data.id == id) {
				return data.canApply(price, discount);
			}
		}
		return false;
	}
	
	@GetMapping("/getAvailable")
	@ResponseBody List<Coupon> getAvailable 
	(
			@RequestParam int page,
			@RequestParam int pageSize
	) 
	{
		//return Algorithm.paginate(couponTable, page, pageSize, pred -> pred.isUsed() == false);
		return null;
	}
}
