package com.proyecto.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name ="categoria")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Cabin> cabins;




    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



    public void setIdCategory(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCabins(List<Cabin> cabins) {
        this.cabins = cabins;
    }
}
