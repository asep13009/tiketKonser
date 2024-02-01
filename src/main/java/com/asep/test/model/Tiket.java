package com.asep.test.model;

import com.asep.test.req.Pemesanan;
import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
public class Tiket extends AbsModel {
    @Id
    private String idTiket;
    private BigInteger totalHarga;
    private int banyaknya;
    private boolean isPayment = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_konser", nullable = false)
    private  Konser konser;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Gate> gates;


    private String pemesanan;

    public Tiket(String konserId, List<Pemesanan> pemesananList) {
        super();
    }

    public Tiket() {

    }


    public String getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(String pemesanan) {
        this.pemesanan = pemesanan;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public Konser getKonser() {
        return konser;
    }

    public void setKonser(Konser konser) {
        this.konser = konser;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public BigInteger getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(BigInteger totalHarga) {
        this.totalHarga = totalHarga;
    }

    public int getBanyaknya() {
        return banyaknya;
    }

    public void setBanyaknya(int banyaknya) {
        this.banyaknya = banyaknya;
    }

    public boolean isPayment() {
        return isPayment;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

}
