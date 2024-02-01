package com.asep.test.controller;
import com.asep.test.model.Konser;
import com.asep.test.service.KonserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

 class KonserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private KonserService konserService;

    @InjectMocks
    private KonserController konserController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(konserController).build();
    }

    @Test
     void testSearch() throws Exception {
        List<Konser> konserList = new ArrayList<>();
        konserList.add(new Konser());
        when(konserService.search(anyString())).thenReturn(konserList);

        mockMvc.perform(get("/konser/search")
                        .param("search", "KKKK"))
                .andExpect(status().isOk());
    }

    @Test
     void testCreate() throws Exception {
        Konser konser = new Konser();
        when(konserService.create(any(Konser.class))).thenReturn(konser);

        mockMvc.perform(post("/konser/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"namaKonser\": \"KONSER KKKK\",\n" +
                                "    \"descKonser\": \"KONSER RAKYAT\",\n" +
                                "    \"poster\": \"-\",\n" +
                                "    \"waktuPelaksanaan\": \"2024-01-31 14:50:09\",\n" +
                                "    \"hargaKonser\": [\n" +
                                "        {  \n" +
                                "            \"nameGate\": \"TRIBUN A+\",\n" +
                                "            \"harga\": 200000\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \n" +
                                "            \"nameGate\": \"TIBUN B+\",\n" +
                                "            \"harga\": 300000\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \n" +
                                "            \"nameGate\": \"TRIBUN C+\",\n" +
                                "            \"harga\": 450000\n" +
                                "        },\n" +
                                "         {\n" +
                                "          \n" +
                                "            \"nameGate\": \"TRIBUN C\",\n" +
                                "            \"harga\": 400000\n" +
                                "        }\n" +
                                "    ],\n" +
                                "    \"active\": true\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
     void testUpdate() throws Exception {
        Konser konser = new Konser();
        when(konserService.update(anyString(), any(Konser.class))).thenReturn(konser);

        mockMvc.perform(post("/konser/update/{id}", "xxxx")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
     void testDelete() throws Exception {
        Konser konser = new Konser();
        when(konserService.delete(anyString())).thenReturn(konser);

        mockMvc.perform(delete("/konser/delete/{id}", "xxxx"))
                .andExpect(status().isOk());
    }

    @Test
     void testFindById() throws Exception {
        Konser konser = new Konser();
        when(konserService.findById(anyString())).thenReturn(konser);

        mockMvc.perform(get("/konser/find/{id}", "xxxx"))
                .andExpect(status().isOk());
    }
}