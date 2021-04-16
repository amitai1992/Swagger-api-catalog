package com.springboot.SwaggerAPI.ItemService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.SwaggerAPI.Model.Item;
import com.springboot.SwaggerAPI.Repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public List<Item> getAllItems() {
		if(repository.count() > 0) {
		List<Item> items = new ArrayList<>();
		repository.findAll().forEach(items:: add);
		return items;
		}
		else {
			return null;
		}
	}
	
	public Item getItem(int id) {
		if(repository.existsById(id)) {
			return repository.findById(id);
		}
		else {
			return null;
		}
		
	}
	
	public Map<String, String> addItem(Item item) {
		Map<String, String> res = new HashMap<String, String>(); 
		if (repository.existsById(item.getItem_no())) {
			res = Collections.singletonMap("response", "item number already exist");
		}
		else {
			repository.save(item);
			res = Collections.singletonMap("response", "added succesfully");
		}
		return res;
		
	}
	
	public Map<String, String> deleteItem(int id) {
		Map<String, String> res = new HashMap<>();
		if(repository.existsById(id)) {
		repository.deleteById(id);
		res = Collections.singletonMap("response", "item deleted succesfully");
		}
		else {
			res = Collections.singletonMap("response" ,"item not been found, delete failed");
		}
		return res;
		
	}
	
	public Map<String, String> despositQuantity(int id, int quantity) {
		Map<String, String> res = new HashMap<>();
		if(repository.existsById(id)) {
		Item item = repository.findById(id);
		int sum = item.getAmount() + quantity;
		item.setAmount(sum);
		repository.save(item);
		res = Collections.singletonMap("response" ,"desposit succeeded");
		}
		else {
			res = Collections.singletonMap("response" ,"item not exist");
		}
		return res;
	}
	
	public Map<String, String> withdrawalquantity(int id, int quantity) {
		Map<String, String> res = new HashMap<>();
		if(repository.existsById(id)) {
		Item item = repository.findById(id);
		int sub = item.getAmount() - quantity;
		if(sub >= 0) {
			item.setAmount(sub);
			repository.save(item);
			res = Collections.singletonMap("response" ,"desposit succeeded");
		}
		else {
			res = Collections.singletonMap("response" ,"quantity is too big");
		}
		}
		else {
			res = Collections.singletonMap("response" ,"item not found");
		}
		return res;
	}

}
