package com.asep.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.List;

@Entity
public class Gate extends  AbsModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameGate;
    private String description;
    private BigInteger harga;


    @JsonIgnore
    private String idKonser;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tiket> tiket;


    public void setTiket(List<Tiket> tiket) {
        this.tiket = tiket;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdKonser() {
        return idKonser;
    }

    public void setIdKonser(String idKonser) {
        this.idKonser = idKonser;
    }

    public String getNameGate() {
        return nameGate;
    }

    public void setNameGate(String nameGate) {
        this.nameGate = nameGate;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
