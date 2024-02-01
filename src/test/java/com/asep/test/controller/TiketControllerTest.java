package com.asep.test.controller;
import com.asep.test.model.Tiket;
import com.asep.test.req.Pemesanan;
import com.asep.test.service.TiketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TiketControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TiketService tiketService;

    @InjectMocks
    private TiketController tiketController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tiketController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testPemesanan() throws Exception {
        List<Pemesanan> pemesananList = new ArrayList<>();
        Pemesanan pemesanan = new Pemesanan();
        pemesanan.setGateId(1L);
        pemesanan.setBanyaknya(2);
        pemesananList.add(pemesanan);

        Tiket tiket = new Tiket();
        tiket.setIdTiket("1");
        tiket.setTotalHarga(BigInteger.valueOf(100));
        tiket.setBanyaknya(2);
        tiket.setPayment(false);

        when(tiketService.pemesanan(anyString(), anyList())).thenReturn(tiket);

        mockMvc.perform(post("/tiket/pemesanan/{konserId}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pemesananList)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTiket").value("1"))
                .andExpect(jsonPath("$.totalHarga").value(100))
                .andExpect(jsonPath("$.banyaknya").value(2))
                .andExpect(jsonPath("$.payment").value(false));
    }
}