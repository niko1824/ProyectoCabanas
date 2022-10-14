package com.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;


    private Date startDate;

    private Date devolutionDate;

    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "cabana_id")
    @JsonIgnoreProperties({"reservations","client"})
    private Cabana cabana;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("reservations")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Message> messages;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservas")
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

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Cabana getCabana() {
        return cabana;
    }

    public void setCabana(Cabana cabana) {
        this.cabana = cabana;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
