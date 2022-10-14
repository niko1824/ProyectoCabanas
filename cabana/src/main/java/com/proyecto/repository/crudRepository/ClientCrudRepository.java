package com.proyecto.repository.crudRepository;

import org.springframework.data.repository.CrudRepository;
import com.proyecto.entities.Client;


public interface ClientCrudRepository extends CrudRepository<Client,Integer> {
}
