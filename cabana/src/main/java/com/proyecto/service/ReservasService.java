package com.proyecto.service;


import com.proyecto.entities.Reservas;
import com.proyecto.entities.client.CountClient;
import com.proyecto.entities.client.DescriptionAmount;
import com.proyecto.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {


    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> getALL(){

        return reservasRepository.getALL();
    }

    public Optional<Reservas> getProduct(int id){

        return reservasRepository.getReservas(id);
    }

    public Reservas save(Reservas p){

        if (p.getIdReservation()==null){
            return reservasRepository.save(p);
        }else {

            Optional<Reservas> e = reservasRepository.getReservas(p.getIdReservation());
            if (e.isPresent()){
                return p;
            }else {
                return reservasRepository.save(p);
            }
        }
    }

    public Reservas update (Reservas p){

        if(p.getIdReservation()!= null){

            Optional<Reservas> q = reservasRepository.getReservas(p.getIdReservation());
            if (q.isPresent()){
                if (p.getIdReservation()!=null){
                    q.get().setIdReservation(p.getIdReservation());
                }

                if (p.getClient()!=null){
                    q.get().setClient(p.getClient());
                }
                if (p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservasRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else {
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservas> p = reservasRepository.getReservas(id);
        if ((p.isPresent())){
            reservasRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }

    public List<CountClient>getTopClient(){
        return reservasRepository.getTopClient();
    }

    public DescriptionAmount getStatus(){

        List<Reservas> completed=reservasRepository.getReservasByStatus("completed");
        List<Reservas> cancelled=reservasRepository.getReservasByStatus("cancelled");

        DescriptionAmount descAmount=new DescriptionAmount(completed.size(), cancelled.size());
        return descAmount;
    }

    public List<Reservas> getReservasPeriod(String d1, String d2){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if (dateOne.before(dateTwo)){
            return reservasRepository.getReservasPeriod(dateOne,dateTwo);
        }else {
            return new ArrayList<>();
        }


    }
}


