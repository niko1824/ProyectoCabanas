package com.proyecto.service;


import com.proyecto.entities.Score;
import com.proyecto.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getALL(){

        return scoreRepository.getALL();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score p){
        if (p.getId()==null){

            return scoreRepository.save(p);
        }else {

            Optional<Score> e = scoreRepository.getScore(p.getId());
            if (e.isPresent()){
                return p;
            }else {

                return scoreRepository.save(p);
            }

        }


    }

    public Score update (Score p){

        if (p.getId()!=null){
            Optional<Score> q = scoreRepository.getScore(p.getId());
            if (q.isPresent()){
                if (p.getMessagetext()!=null){
                    q.get().setMessagetext(p.getMessagetext());
                }
                if (p.getStars()!=null){
                    q.get().setStars(p.getStars());
                }
                if (p.getReservas()!=null){
                    q.get().setReservas(p.getReservas());
                }
                scoreRepository.save(q.get());
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
        Optional<Score> p = scoreRepository.getScore(id);
        if (p.isPresent()){
            scoreRepository.delete(p.get());
            flag = true;
        }
        return flag;


    }


}
