package com.proyecto.repository;


import com.proyecto.entities.Cabin;
import com.proyecto.repository.crudRepository.CabanaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabanaRepository {

    @Autowired
    private CabanaCrudRepository cabanaCrudRepository;

    public List<Cabin> getALL(){

        return  (List<Cabin>) cabanaCrudRepository.findAll();
    }

    public Optional<Cabin> getCabana(int id){

        return cabanaCrudRepository.findById(id);
    }

    public Cabin save(Cabin c){

        return cabanaCrudRepository.save(c);
    }

    public void delete(Cabin c){

        cabanaCrudRepository.delete(c);
    }




}
