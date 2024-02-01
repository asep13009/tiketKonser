package com.asep.test.impl;

import com.asep.test.model.Gate;
import com.asep.test.model.Konser;
import com.asep.test.repository.GateRepository;
import com.asep.test.repository.KonserRepository;
import com.asep.test.service.KonserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KonserServiceImpl  implements KonserService {
    @Autowired
    KonserRepository konserRepository;

    @Autowired
    GateRepository gateRepository;

    @Override
    public List<Konser> search(String search) {
        return konserRepository.search(search.toUpperCase(), search.toLowerCase());
    }

    @Override
    public Konser create(Konser konser) {
        konser.setIdKonser(UUID.randomUUID().toString());
        List<Gate> hargaList = new ArrayList<>();
        for (Gate gate : konser.getHargaKonser() ){
            gate = new ObjectMapper().convertValue(gate,Gate.class);
            gate.setIdKonser(konser.getIdKonser());
            gateRepository.save(gate);
            hargaList.add(gate);
        }
        konser.setHargaKonser(hargaList);
        return konserRepository.save(konser);
    }

    @Override
    public Konser update(String id, Konser konser) {
        Optional<Konser> konserFind = konserRepository.findById(id);
        if(konserFind.isPresent()){
            konser.setIdKonser(id);
            konser = new ObjectMapper().convertValue(konser,Konser.class);
            List<Gate> hargaList = new ArrayList<>();
            for (Gate gate : konser.getHargaKonser() ){
                gate = new ObjectMapper().convertValue(gate,Gate.class);
                gate.setIdKonser(konser.getIdKonser());
                gateRepository.save(gate);
                hargaList.add(gate);
            }
            konser.setHargaKonser(hargaList);
            return konserRepository.save(konser);
        }else {
            System.out.println("konser null");
            return null;
        }

    }

    @Override
    public Konser delete(String id) {
        Optional<Konser> konserFind = konserRepository.findById(id);
        if(konserFind.isPresent()){
            gateRepository.deleteAll(konserFind.get().getHargaKonser());
            konserRepository.delete(konserFind.get());
            return konserFind.get();
        }else {
            System.out.println("konser null");
            return null;
        }
    }

    @Override
    public Konser findById(String id) {
        Optional<Konser> konser = konserRepository.findById(id);
        return konser.orElse(null);
    }
}
