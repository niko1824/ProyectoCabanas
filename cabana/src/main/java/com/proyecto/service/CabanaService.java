package com.proyecto.service;


import com.proyecto.entities.Cabana;
import com.proyecto.repository.CabanaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabanaService {

    @Autowired
    private CabanaRepository cabanaRepository;

    public List<Cabana> getALL(){

        return cabanaRepository.getALL();
    }

    public Optional<Cabana> getCabana(int id){

        return cabanaRepository.getCabana(id);
    }

    public Cabana save(Cabana p){

        if (p.getId()==null){
            return cabanaRepository.save(p);
        }else {
            Optional<Cabana> e = cabanaRepository.getCabana(p.getId());
            if (e.isPresent()){
                return p;
            }else {
                return cabanaRepository.save(p);
            }
        }
    }

    public Cabana update(Cabana p){

        if (p.getId()!=null){
            Optional<Cabana> q = cabanaRepository.getCabana(p.getId());
            if (q.isPresent()){
                if (p.getName()!= null){
                    q.get().setName(p.getName());
                }
                if (p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if (p.getRooms()!= null){
                    q.get().setRooms(p.getRooms());
                }
                if (p.getCategory()!= null){
                    q.get().setCategory(p.getCategory());
                }
                if (p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                cabanaRepository.save(q.get());
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
        Optional<Cabana> p = cabanaRepository.getCabana(id);
        if(p.isPresent()){
            cabanaRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }
}
