package com.springboot.SwaggerAPI.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.SwaggerAPI.Model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
	Item findById(int id);

}
