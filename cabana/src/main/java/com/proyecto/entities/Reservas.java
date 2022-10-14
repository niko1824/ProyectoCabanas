package com.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;




    private Date startDate;

    private Date devolutionDate;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservas","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy = "reservas")
    @JsonIgnoreProperties("reserva")
    private Score score;


    public Integer getIdReservation() {
        return idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }


    public Client getClient() {
        return client;
    }

    public Score getScore() {
        return score;
    }



    public void setClient(Client client) {
        this.client = client;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
