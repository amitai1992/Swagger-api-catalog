package com.springboot.SwaggerAPI.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SwaggerAPI.ItemService.ItemService;
import com.springboot.SwaggerAPI.Model.Item;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/addItem") 
	public Map<String, String> addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	@DeleteMapping("/deleteItem")
	public Map<String, String> deletItem(int item_no) {
		return itemService.deleteItem(item_no);
	}
	
	@PostMapping("/despositQuantity")
	public Map<String, String> desposit(int item_no, int quantity) {
		return itemService.despositQuantity(item_no, quantity);
	}
	
	@PostMapping("/withdrawalquantity")
	public Map<String, String> Withdrawal(int item_no, int quantity) {
		return itemService.withdrawalquantity(item_no, quantity);
	}
	
	@GetMapping("/getListItems")
	public List<Item> getList() {
		return itemService.getAllItems();
	}
	
	@GetMapping("/getItem")
	public Item getItem(int item_no) {
		return itemService.getItem(item_no);
	}
	
}
