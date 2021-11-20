package com.airellJmartAK.controller;

import com.airellJmartAK.Account;
import com.airellJmartAK.Store;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL) ;
	public static final Pattern REGEX_PATTER_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	
	@JsonAutowired(value=Account.class, filepath="data/account.json")
	public static JsonTable<Account> accountTable;

	@Override
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	@GetMapping
	String index() { return "account page"; }
	
	@PostMapping("/account/login")
    @ResponseBody Account login(String email, String password) {
        for(Account each : accountTable){
            if(each.email == email && each.password == password){
                return each;
            }
        }
        return null;
    }
	
	@PostMapping("/register")
	Account register
	(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String password
	)
	{
		return new Account(name, email, password, 0);
	}
	
	@PostMapping("/{id}/registerStore")
    Store registerStore
            (
                    @RequestParam int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        for(Account data : accountTable){
            if (data.store == null && data.id == id){
                data.store = new Store(name,address,phoneNumber,0);
                return data.store;
            }
        }
        return null;
    }
	
	 @PostMapping("/{id}/topUp")
	 boolean topUp
	        (
	        		@RequestParam int id,
	                @RequestParam double balance
	        )
	 {
	       for(Account data : accountTable){
	           if(data.id == id) {
	               data.balance += balance;
	               return true;
	           }
	      }
	      return false;
	 }
}