package com.springboot.SwaggerAPI.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



//Entity class
@Entity
public class Item {
	@Id
	private int item_no; // primery key

	@Column(unique = true)
	private String name; // unique

	private int amount;

	@Column(unique = true)

	private int inventory_code; //unique
	
	protected Item() {};

	public Item(String name, int amount, int inventory_code, int item_no) {
		this.name = name;
		this.amount = amount;
		this.inventory_code = inventory_code;
		this.item_no = item_no;
	}

	public int getItem_no() {
		return item_no;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	public int getInventory_code() {
		return inventory_code;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Item[item_no=%d, name=%s, quantiy=%d, inventory_code=%s]", item_no, name, amount, inventory_code);
	}

}
