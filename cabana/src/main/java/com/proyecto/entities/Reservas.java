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
    private Integer idReserva;


    private String cliente;

    private Date fechainicio;

    private Date fechafin;

    @ManyToOne
    @JoinColumn(name = "cabana_id")
    @JsonIgnoreProperties("reservas")
    private Cabana cabana;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservas","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy = "reservas")
    @JsonIgnoreProperties("reserva")
    private Score score;


    public Integer getIdReserva() {
        return idReserva;
    }


    public String getCliente() {
        return cliente;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }


    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }


    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Cabana getCabana() {
        return cabana;
    }

    public Client getClient() {
        return client;
    }

    public Score getScore() {
        return score;
    }

    public void setCabana(Cabana cabana) {
        this.cabana = cabana;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
