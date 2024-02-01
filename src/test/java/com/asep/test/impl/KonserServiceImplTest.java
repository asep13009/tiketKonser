package com.asep.test.impl;
import com.asep.test.model.Gate;
import com.asep.test.model.Konser;
import com.asep.test.repository.GateRepository;
import com.asep.test.repository.KonserRepository;
import com.asep.test.service.KonserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class KonserServiceImplTest {

    @Mock
    private KonserRepository konserRepository;

    @Mock
    private GateRepository gateRepository;

    @InjectMocks
    private KonserServiceImpl konserService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testSearch() {
        List<Konser> konserList = new ArrayList<>();
        when(konserRepository.search(anyString(), anyString())).thenReturn(konserList);

        List<Konser> result = konserService.search("keyword");

        assertEquals(konserList, result);
        verify(konserRepository, times(1)).search(anyString(), anyString());
    }

    @Test
    public void testCreate() {
        Konser konser = new Konser();
        konser.setIdKonser(UUID.randomUUID().toString());
        konser.setHargaKonser(new ArrayList<>());

        when(konserRepository.save(any(Konser.class))).thenReturn(konser);

        Konser result = konserService.create(konser);

        assertEquals(konser, result);
        verify(konserRepository, times(1)).save(any(Konser.class));
    }

    @Test
    public void testUpdate() {
        String id = "1";
        Konser konser = new Konser();
        konser.setIdKonser(id);
        konser.setHargaKonser(new ArrayList<>());

        when(konserRepository.findById(id)).thenReturn(Optional.of(konser));
        when(konserRepository.save(any(Konser.class))).thenReturn(konser);

        Konser result = konserService.update(id, konser);

        assertEquals(konser, result);
        verify(konserRepository, times(1)).findById(id);
        verify(konserRepository, times(1)).save(any(Konser.class));
    }

    @Test
    public void testDelete() {
        String id = "1";
        Konser konser = new Konser();
        konser.setIdKonser(id);
        konser.setHargaKonser(new ArrayList<>());

        when(konserRepository.findById(id)).thenReturn(Optional.of(konser));

        Konser result = konserService.delete(id);

        assertEquals(konser, result);
        verify(gateRepository, times(1)).deleteAll(konser.getHargaKonser());
        verify(konserRepository, times(1)).delete(konser);
    }

    @Test
    public void testFindById() {
        String id = "1";
        Konser konser = new Konser();
        konser.setIdKonser(id);
        konser.setHargaKonser(new ArrayList<>());

        when(konserRepository.findById(id)).thenReturn(Optional.of(konser));

        Konser result = konserService.findById(id);

        assertEquals(konser, result);
        verify(konserRepository, times(1)).findById(id);
    }
}