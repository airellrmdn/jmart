package com.airellJmartAK.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.ObjectPoolThread;
import com.airellJmartAK.Payment;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
	public static final long DELIVERED_LIMIT_MS = 10;
	public static final long ON_DELIVERY_LIMIT_MS = 20;
	public static final long ON_PROGRESS_LIMIT_MS = 30;
	public static final long WAITING_CONF_LIMIT_MS = 40;
	
	@JsonAutowired(value=Payment.class, filepath="C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\payment.json")
	public static JsonTable<Payment> paymentTable;
	
	public static ObjectPoolThread<Payment> poolThread;

	@Override
	public JsonTable<Payment> getJsonTable() {
		return paymentTable;
	}
	
	@PostMapping("/create")
	Payment create
	(
			@RequestParam int buyerId,
            @RequestParam int productId,
			@RequestParam int productCount,
			@RequestParam String shipmentAddress,
			@RequestParam byte shipmentPlan
    )  
	{
		return null;
	}
	
	@PostMapping("/{id}/accept")
	boolean accept
	(
			@RequestParam int id
    )  
	{
		return false;
	}
	
	@PostMapping("/{id}/cancel")
	boolean cancel
	(
			@RequestParam int id
    )  
	{
		return false;
	}
	
	@PostMapping("/{id}/submit")
	boolean submit
	(
			@RequestParam int id,
			@RequestParam String receipt
    )  
	{
		return false;
	}
	
	private static boolean timekeeper(Payment payment) {
		return false;
	}
}
