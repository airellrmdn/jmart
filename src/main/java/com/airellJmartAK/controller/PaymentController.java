package com.airellJmartAK.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.ObjectPoolThread;
import com.airellJmartAK.Payment;
import com.airellJmartAK.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
	public static final long DELIVERED_LIMIT_MS = 10;
	public static final long ON_DELIVERY_LIMIT_MS = 20;
	public static final long ON_PROGRESS_LIMIT_MS = 30;
	public static final long WAITING_CONF_LIMIT_MS = 40;
	
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread;

	@Override
	public JsonTable<Payment> getJsonTable() {
		return paymentTable;
	}
}
