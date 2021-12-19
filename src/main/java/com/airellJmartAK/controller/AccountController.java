package com.airellJmartAK.controller;

import com.airellJmartAK.Account;
import com.airellJmartAK.Store;
import com.airellJmartAK.dbjson.JsonAutowired;
import com.airellJmartAK.dbjson.JsonTable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

/**
 * class for account controller
 *
 * @author Airell Ramadhan B
 * 
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL) ;
	public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
	
	/**
	  * The json table of Account class. save locally in this path.
	  */
	@JsonAutowired(value=Account.class, filepath="C:\\Users\\Rivaldi\\Desktop\\Semester 3\\OOP\\Praktikum Jmart\\account.json")
	public static JsonTable<Account> accountTable;

	 /**
	  * Method to get account Json Table
	  * 
	  * @return account Json Table
	  */
	@Override
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}
	
	/**
	  * Post request to make an account logged in after validate the account
	  * existance and matching the email and password from the database (Json Table)
	  * 
	  * @param email    user's email
	  * @param password user's password
	  * @return The account which the email and password are matched from the
	  *         database
	  */
	@PostMapping("/login")
    @ResponseBody Account login
    (
    		@RequestParam String email,
    		@RequestParam String password
    ) 
	{
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < bytes.length; i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
			}
			password = sb.toString();
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		for (Account data : accountTable){
			if(data.email.equals(email) && data.password.equals(password)){
				return data;
			}
		}
		return null;
    }
	
	 /**
	  * Post request for register feature. This will check whether the parameters
	  * match the regex and the email is not being registered yet. This will add a
	  * new account to account Json Table.
	  * 
	  * @param name     account name.
	  * @param email    account email.
	  * @param password account password.
	  * @return the account which qualified to register.
	  */
	@PostMapping("/register")
	Account register
	(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String password
	)
	{
		boolean hasilEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean hasilPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try {
        	MessageDigest md = MessageDigest.getInstance("MD5");
        	md.update(password.getBytes());
        	byte[] bytes = md.digest();
        	StringBuilder sb = new StringBuilder();
        	
        	for(int i = 0; i < bytes.length; i++) {
        		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        	}
        	
        	password = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        if(!name.isBlank() && hasilEmail && hasilPassword && !accountTable.stream().anyMatch(account -> account.email.equals(email))){
            Account account =  new Account(name, email, password, 0);
            accountTable.add(account);
            return account;
        }
        return null;
	}
	
	 /**
	  * Post request to register store of an account.
	  * 
	  * @param id          account id
	  * @param name        store name
	  * @param address     store address
	  * @param phoneNumber store phone number
	  * @return the store being registered
	  */
	@PostMapping("/{id}/registerStore")
	@ResponseBody Store registerStore
    (
        @RequestParam int id,
        @RequestParam String name,
        @RequestParam String address,
        @RequestParam String phoneNumber
    )
    {
        for(Account data : accountTable){
            if (data.store == null && data.id == id){
                data.store = new Store(name, address, phoneNumber, 0);
                return data.store;
            }
        }
        return null;
    }
	
	/**
	  * Post request to top up account balance
	  * 
	  * @param id      account id
	  * @param balance the amount balance to top up
	  * @return return true if success, otherwise false
	  */
	@PostMapping("/{id}/topUp")
	@ResponseBody Boolean topUp
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