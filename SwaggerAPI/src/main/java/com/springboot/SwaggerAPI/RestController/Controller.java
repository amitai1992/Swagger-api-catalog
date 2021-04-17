package com.springboot.SwaggerAPI.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SwaggerAPI.ItemService.ItemService;
import com.springboot.SwaggerAPI.Model.Item;

// rest controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ItemService itemService;
	
	//add item api
	@PostMapping("/addItem") 
	public Map<String, String> addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	
	//delete item api
	@DeleteMapping("/deleteItem")
	public Map<String, String> deletItem(int item_no) {
		return itemService.deleteItem(item_no);
	}
	
	// desposit api
	@PostMapping("/despositQuantity")
	public Map<String, String> desposit(@RequestBody int item_no,@RequestParam int quantity) {
		return itemService.despositQuantity(item_no, quantity);
	}
	
	// withdrawal api
	@PostMapping("/withdrawalquantity")
	public Map<String, String> Withdrawal(@RequestBody int item_no,@RequestParam int quantity) {
		return itemService.withdrawalquantity(item_no, quantity);
	}
	
	//get list api
	@GetMapping("/getListItems")
	public List<Item> getList() {
		return itemService.getAllItems();
	}
	
	// get item details api 
	@GetMapping("/getItem")
	public Item getItem(int item_no) {
		return itemService.getItem(item_no);
	}
	
}
