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

// service api
@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	// return list of items or null if database is empty
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
	
	// return item or null if not been found
	public Item getItem(int id) {
		if(repository.existsById(id)) { // if item exist return the item
			return repository.findById(id);
		}
		else {
			return null;
		}
		
	}
	
	// return a key value map object with the right response if item added or not
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
	
	//return a key value map object depends if item deleted
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
	
	//return a key value map object depends on result
	public Map<String, String> despositQuantity(int id, int quantity) {
		Map<String, String> res = new HashMap<>();
		if(repository.existsById(id)) { // if item exist add quantity
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
	
	//return a key value map object depends on result
	public Map<String, String> withdrawalquantity(int id, int quantity) {
		Map<String, String> res = new HashMap<>();
		if(repository.existsById(id)) { // if item exist
		Item item = repository.findById(id);
		int sub = item.getAmount() - quantity;
		if(sub >= 0) { // if quantity <= item.amount do the action
			item.setAmount(sub);
			repository.save(item);
			res = Collections.singletonMap("response" ,"desposit succeeded");
		}
		else { // else dont do
			res = Collections.singletonMap("response" ,"quantity is too big");
		}
		}
		else {
			res = Collections.singletonMap("response" ,"item not found");
		}
		return res;
	}

}
