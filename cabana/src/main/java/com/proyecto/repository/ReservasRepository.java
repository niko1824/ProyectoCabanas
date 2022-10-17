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

    public static List<Reservas> getReservasByStatus(String status){
        return ReservasCrudRepository.findAllByStatus(status);
    }

    public List<Reservas> getReservasPeriod(Date dateOne, Date dateTwo){
        return ReservasCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }

    public static List<CountClient>getTopClient(){
        List<CountClient> resultado=new ArrayList<>();

        List<Object[]> reporte=ReservasCrudRepository.countTotalReservasByClient();
        for(int i=0; i<reporte.size();i++){
            Client cli=(Client) reporte.get(i)[0];
            Integer cantidad=(Integer) reporte.get(i)[1];
            CountClient cc=new CountClient(cantidad,cli);
            resultado.add(cc);
        }

        return resultado;

    }
}
