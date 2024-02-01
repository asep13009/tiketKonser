package com.asep.test.service;
import com.asep.test.model.Tiket;
import com.asep.test.req.Pemesanan;
import com.asep.test.service.TiketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TiketServiceTest {

    @Mock
    private TiketService tiketService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPemesanan() throws JsonProcessingException {

        String konserId = "K123";
        List<Pemesanan> pemesananList = new ArrayList<>();
        pemesananList.add(new Pemesanan("John", 2));
        pemesananList.add(new Pemesanan("Jane", 3));

        Tiket tiket = new Tiket(konserId, pemesananList);

        when(tiketService.pemesanan(konserId, pemesananList)).thenReturn(tiket);

        Tiket result = tiketService.pemesanan(konserId, pemesananList);

        verify(tiketService, times(1)).pemesanan(konserId, pemesananList);
        assertEquals(tiket, result);
    }
}