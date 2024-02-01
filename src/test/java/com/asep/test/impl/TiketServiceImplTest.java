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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TiketServiceImplTest {

    @Mock
    private TiketRepository tiketRepository;

    @Mock
    private KonserService konserService;

    @Mock
    private GateRepository gateRepository;

    @InjectMocks
    private TiketServiceImpl tiketService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testPemesanan() throws JsonProcessingException {
        String konserId = "1";
        List<Pemesanan> pemesananList = new ArrayList<>();
        Pemesanan pemesanan = new Pemesanan();
        pemesanan.setGateId(1L);
        pemesanan.setBanyaknya(2);
        pemesananList.add(pemesanan);

        Konser konser = new Konser();
        konser.setIdKonser(konserId);

        Gate gate = new Gate();
        gate.setId(1L);
        gate.setHarga(BigInteger.valueOf(50));

        Tiket tiket = new Tiket();
        tiket.setIdTiket(UUID.randomUUID().toString());
        tiket.setKonser(konser);
        tiket.setGates(Arrays.asList(gate));
        tiket.setBanyaknya(2);
        tiket.setTotalHarga(BigInteger.valueOf(100));
        tiket.setPayment(false);

        when(konserService.findById(konserId)).thenReturn(konser);
        when(gateRepository.findById(pemesanan.getGateId())).thenReturn(Optional.of(gate));
        when(tiketRepository.save(any(Tiket.class))).thenReturn(tiket);

        Tiket result = tiketService.pemesanan(konserId, pemesananList);

        assertEquals(tiket, result);
        verify(konserService, times(1)).findById(konserId);
        verify(gateRepository, times(1)).findById(pemesanan.getGateId());
        verify(tiketRepository, times(1)).save(any(Tiket.class));
    }
}