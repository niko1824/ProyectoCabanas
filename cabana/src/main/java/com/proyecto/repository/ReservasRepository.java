package com.proyecto.repository;


import com.proyecto.entities.Reservas;
import com.proyecto.repository.crudRepository.ReservasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservasRepository {

    @Autowired
    private ReservasCrudRepository reservasCrudRepository;

    public List<Reservas> getALL(){

        return (List<Reservas>) reservasCrudRepository.findAll();

    }

    public Optional<Reservas> getReservas(int id){
        return reservasCrudRepository.findById(id);
    }

    public Reservas save(Reservas p){
        return reservasCrudRepository.save(p);
    }

    public void delete(Reservas p){

        reservasCrudRepository.delete(p);
    }
}
