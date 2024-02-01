package com.asep.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
public class Konser extends AbsModel {
    @Id
    private String idKonser;
    private String namaKonser;
    private String descKonser;
    private String poster;

    private boolean isActive;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+7")
    private Date waktuPelaksanaan;
     @OneToMany(cascade = CascadeType.ALL)
     private List<Gate> hargaKonser;

    public Konser(String s, String s2) {
        super();
    }

    public Konser() {

    }

    public List<Gate> getHargaKonser() {
        return hargaKonser;
    }

    public void setHargaKonser(List<Gate> hargaKonser) {
        this.hargaKonser = hargaKonser;
    }

    public String getIdKonser() {
        return idKonser;
    }

    public void setIdKonser(String idKonser) {
        this.idKonser = idKonser;
    }

    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public String getDescKonser() {
        return descKonser;
    }

    public void setDescKonser(String descKonser) {
        this.descKonser = descKonser;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Date getWaktuPelaksanaan() {
        return waktuPelaksanaan;
    }

    public void setWaktuPelaksanaan(Date waktuPelaksanaan) {
        this.waktuPelaksanaan = waktuPelaksanaan;
    }




    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
