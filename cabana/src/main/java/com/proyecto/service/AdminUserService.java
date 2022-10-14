package com.proyecto.service;


import com.proyecto.entities.AdminUser;
import com.proyecto.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;
    public List<AdminUser> getALL(){
        return adminUserRepository.getALL();
    }

    public Optional<AdminUser> getAdminUser(int id){

        return adminUserRepository.getAdminUser(id);
    }
    public AdminUser save(AdminUser p){
        if (p.getId()==null){
            return adminUserRepository.save(p);
        }else {
            Optional<AdminUser> e = adminUserRepository.getAdminUser(p.getId());

            if (e.isPresent()){
                return p;
            }else {
                return adminUserRepository.save(p);
            }
        }
    }

    public AdminUser update(AdminUser p){

        if (p.getId()!=null){
            Optional<AdminUser> q = adminUserRepository.getAdminUser(p.getId());
            if (q.isPresent()){
                if (p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if (p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if (p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }

                adminUserRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else {
            return p;
        }

    }

    public boolean delete (int id){

        boolean flag = false;
        Optional<AdminUser> p =adminUserRepository.getAdminUser(id);
        if (p.isPresent()){
            adminUserRepository.delete(p.get());
            flag = true;
        }
        return flag;

    }

}
