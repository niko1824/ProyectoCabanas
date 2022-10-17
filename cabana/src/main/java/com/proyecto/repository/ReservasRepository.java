package com.proyecto.repository;


import com.proyecto.entities.Client;
import com.proyecto.entities.Reservas;
import com.proyecto.entities.client.CountClient;
import com.proyecto.repository.crudRepository.ReservasCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservas> getReservasByStatus(String status){
        return reservasCrudRepository.findAllByStatus(status);
    }

    public List<Reservas> getReservasPeriod(Date dateOne, Date dateTwo){
        return reservasCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public List<CountClient>getTopClient(){
        List<CountClient> resultado=new ArrayList<>();

        List<Object[]> reporte= reservasCrudRepository.countTotalReservasByClient();
        for(int i=0; i<reporte.size();i++){
            resultado.add(new CountClient((Integer) reporte.get(i)[1],(Client) reporte.get(i)[0]));
        }

        return resultado;

    }
}
