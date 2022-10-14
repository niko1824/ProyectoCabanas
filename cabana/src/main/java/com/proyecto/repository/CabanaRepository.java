package com.proyecto.repository;


import com.proyecto.entities.Cabana;
import com.proyecto.repository.crudRepository.CabanaCrudRepository;
import com.proyecto.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CabanaRepository {

    @Autowired
    private CabanaCrudRepository cabanaCrudRepository;

    public List<Cabana> getALL(){

        return  (List<Cabana>) cabanaCrudRepository.findAll();
    }

    public Optional<Cabana> getCabana(int id){

        return cabanaCrudRepository.findById(id);
    }

    public Cabana save(Cabana c){

        return cabanaCrudRepository.save(c);
    }

    public void delete(Cabana c){

        cabanaCrudRepository.delete(c);
    }




}
