package com.proyecto.repository;

import com.proyecto.entities.AdminUser;
import com.proyecto.repository.crudRepository.AdminUserCrudRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminUserRepository {

    @Autowired
    private AdminUserCrudRepositoy adminUserCrudRepositoy;

    public List<AdminUser> getALL(){

        return (List<AdminUser>) adminUserCrudRepositoy.findAll();
    }

    public Optional<AdminUser> getAdminUser(int id){
        return adminUserCrudRepositoy.findById(id);
    }

    public AdminUser save(AdminUser p){

        return adminUserCrudRepositoy.save(p);
    }

    public void delete (AdminUser p){

        adminUserCrudRepositoy.delete(p);
    }
}
