package com.proyecto.repository.crudRepository;


import com.proyecto.entities.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
