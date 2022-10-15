package com.proyecto.controller;


import com.proyecto.entities.Reservas;
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

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas update(@RequestBody Reservas p){

        return reservasService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservasService.delete(id);
    }
}
