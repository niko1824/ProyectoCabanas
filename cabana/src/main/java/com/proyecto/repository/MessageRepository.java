package com.proyecto.repository;


import com.proyecto.entities.Message;
import com.proyecto.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {


    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getALL(){

        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){

        return messageCrudRepository.findById(id);
    }

    public Message save(Message p){

        return messageCrudRepository.save(p);
    }

    public void delete(Message p){

        messageCrudRepository.delete(p);
    }
}
