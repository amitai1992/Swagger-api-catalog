package com.springboot.SwaggerAPI.Repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SwaggerAPI.Model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	Item findById(int id);
	@Modifying
	void deleteById(int id);

}
