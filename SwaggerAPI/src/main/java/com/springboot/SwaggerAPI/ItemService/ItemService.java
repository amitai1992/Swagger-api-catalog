package com.springboot.SwaggerAPI.ItemService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.SwaggerAPI.Model.Item;
import com.springboot.SwaggerAPI.Repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		repository.findAll().forEach(items:: add);
		return items;
	}
	
	public Item getItem(int id) {
		return repository.findById(id);
	}
	
	public void addItem(Item item) {
		repository.save(item);
	}
	
	public void deleteItem(int id) {
		Item item = repository.findById(id);
		repository.delete(item);
	}
	
	public void despositQuantity(int id, int quantity) {
		Item item = repository.findById(id);
		int sum = item.getAmount() + quantity;
		item.setAmount(sum);
		repository.save(item);
	}

}
