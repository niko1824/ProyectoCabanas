package com.proyecto.controller;

import com.proyecto.entities.AdminUser;
import com.proyecto.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apli/Admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping("/all")
    public List<AdminUser> getALL(){

        return adminUserService.getALL();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUser save(@RequestBody AdminUser p){
        return adminUserService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUser update(@RequestBody AdminUser p){

         return adminUserService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){

        return adminUserService.delete(id);
    }

}
