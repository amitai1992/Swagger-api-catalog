package com.springboot.SwaggerAPI.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SwaggerAPI.ItemService.ItemService;
import com.springboot.SwaggerAPI.Model.Item;


@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private ItemService itemService;
	
	
	@PostMapping("/addItem") 
	public void addItem(Item item) {
		itemService.addItem(item);
	}
	
	@PostMapping("/deleteItem")
	public void deletItem(int item_no) {
		itemService.deleteItem(item_no);
	}
	
	@PostMapping("/despositQuantity")
	public void desposit(int item_no, int quantity) {
		itemService.despositQuantity(item_no, quantity);
	}
	
	@PostMapping("/withdrawalquantity")
	public void Withdrawal(int item_no, int quantity) {
		itemService.withdrawalquantity(item_no, quantity);
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
