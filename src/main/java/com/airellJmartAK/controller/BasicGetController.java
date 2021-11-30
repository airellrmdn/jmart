package com.airellJmartAK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.airellJmartAK.Algorithm;
import com.airellJmartAK.dbjson.JsonTable;
import com.airellJmartAK.dbjson.Serializable;

@RestController
public interface BasicGetController <T extends Serializable> {
	@GetMapping("/{id}")
	public default T getById(@PathVariable int id) {
		return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
	}
	
	public abstract JsonTable<T> getJsonTable();
	
	@GetMapping("/page")
	public default List<T> getPage(int page, int pageSize) {
		final JsonTable<T> table = getJsonTable();
		return Algorithm.paginate(table, page, pageSize, e -> true);
	}
}
