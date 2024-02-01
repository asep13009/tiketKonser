package com.asep.test.service;

import com.asep.test.model.Tiket;
import com.asep.test.req.Pemesanan;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface TiketService {


    Tiket pemesanan(String konserId, List<Pemesanan> pemesanan) throws JsonProcessingException;
}
