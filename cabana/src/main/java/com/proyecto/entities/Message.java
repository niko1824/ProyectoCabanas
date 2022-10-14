package com.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mensaje")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    private String messageText;

    @OneToOne
    @JoinColumn(name = "cabana_id")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cabana cabin;
    @ManyToOne
    @JoinColumn(name= "category_id")
    @JsonIgnoreProperties("cabins")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;




    public Client getClient() {
        return client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }


    public Cabana getCabin() {
        return cabin;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setCabin(Cabana cabin) {
        this.cabin = cabin;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
