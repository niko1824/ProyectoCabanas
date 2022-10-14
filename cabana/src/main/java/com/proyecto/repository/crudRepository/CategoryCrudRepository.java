package com.proyecto.repository.crudRepository;

import org.springframework.data.repository.CrudRepository;
import com.proyecto.entities.Category;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {

}
