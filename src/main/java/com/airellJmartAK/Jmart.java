package com.airellJmartAK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airellJmartAK.dbjson.JsonDBEngine;

@SpringBootApplication
public class Jmart
{
	public static void main(String[] args){
    	JsonDBEngine.Run(Jmart.class);
		SpringApplication.run(Jmart.class, args);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	}
}