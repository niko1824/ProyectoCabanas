package com.proyecto.controller;


import com.proyecto.entities.Cabana;
import com.proyecto.service.CabanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cabin")
public class CabanaController {

    @Autowired
    private CabanaService cabanaService;

    @GetMapping("/all")
    public List<Cabana> getALL(){

        return cabanaService.getALL();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabana save(@RequestBody Cabana p){

        return cabanaService.save(p);
    }
}
