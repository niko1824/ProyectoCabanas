package com.proyecto.controller;


import com.proyecto.entities.Reservas;
import com.proyecto.entities.client.CountClient;
import com.proyecto.entities.client.DescriptionAmount;
import com.proyecto.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @GetMapping("/all")
    public List<Reservas> getALL(){
        return reservasService.getALL();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas save(@RequestBody Reservas p){
        return reservasService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas update(@RequestBody Reservas p){

        return reservasService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservasService.delete(id);
    }



   @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservasService.getTopClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservas> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo") String d2){
        return reservasService.getReservasPeriod(d1, d2);
    }
    @GetMapping("/report-status")
    public DescriptionAmount getReservasDescriptionStatus(){
        return reservasService.getStatus();
    }
}
