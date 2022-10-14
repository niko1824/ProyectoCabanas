package com.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String messagetext;

    @Column(nullable = false)
    private Integer stars;

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservas reservas;

    public Integer getId() {
        return id;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public Integer getStars() {
        return stars;
    }

    public Reservas getReservas() {
        return reservas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public void setReservas(Reservas reservas) {
        this.reservas = reservas;
    }
}
