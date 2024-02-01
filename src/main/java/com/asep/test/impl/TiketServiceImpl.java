package com.asep.test.impl;

import com.asep.test.model.Gate;
import com.asep.test.model.Konser;
import com.asep.test.model.Tiket;
import com.asep.test.repository.GateRepository;
import com.asep.test.repository.TiketRepository;
import com.asep.test.req.Pemesanan;
import com.asep.test.service.KonserService;
import com.asep.test.service.TiketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class TiketServiceImpl  implements TiketService {

    @Autowired
    TiketRepository tiketRepository;

    @Autowired
    KonserService konserService;

    @Autowired
    GateRepository gateRepository;

    @Override
    public Tiket pemesanan(String konserId, List<Pemesanan> pemesanan) throws JsonProcessingException {
        Konser konser = konserService.findById(konserId);
        if(konser!=null){

            Tiket tiket = new Tiket();
            tiket.setIdTiket(UUID.randomUUID().toString());
            tiket.setKonser(konser);
            BigInteger[] hargaTotal = new BigInteger[pemesanan.size()];
            int[] banyakTotal = new int[pemesanan.size()];
            int i =0;
            List<Gate> gates = new ArrayList<>();
            for (Pemesanan p : pemesanan){
                Optional<Gate> gate = gateRepository.findById(p.getGateId());
                if(gate.isPresent()){
                    for(int j=0;j<p.getBanyaknya(); j++){
                        gates.add(gate.get());
                    }
                    hargaTotal[i] =   BigInteger.valueOf(p.getBanyaknya()).multiply(gate.get().getHarga());
                    banyakTotal[i] = p.getBanyaknya();
                    i++;
                }else {
                    System.out.println("null >>> "+p.getGateId());
                    return  null;

                }
            }
            tiket.setGates(gates);
            tiket.setBanyaknya(Arrays.stream(banyakTotal).sum());
            tiket.setTotalHarga(Arrays.stream(hargaTotal).reduce(BigInteger.valueOf(0), BigInteger::add));
            tiket.setPayment(false);
            ObjectMapper mapper = new ObjectMapper();
            tiket.setPemesanan(mapper.writeValueAsString(pemesanan));
            return tiketRepository.save(tiket);
        }

        return null;
    }
}
