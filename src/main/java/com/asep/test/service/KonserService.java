package com.asep.test.service;

import com.asep.test.model.Konser;

import java.util.List;

public interface KonserService {

    List<Konser> search(String search);
    Konser create(Konser konser);


    Konser update(String id, Konser konser);


    Konser delete(String id);

    Konser findById(String id);
}
