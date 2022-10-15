package com.proyecto.controller;


import com.proyecto.entities.Cabin;
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
    public List<Cabin> getALL(){

        return cabanaService.getALL();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin p){

        return cabanaService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin update(@RequestBody Cabin p){

        return cabanaService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return cabanaService.delete(id);
    }
}
