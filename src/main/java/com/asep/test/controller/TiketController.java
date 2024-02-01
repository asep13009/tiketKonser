package com.asep.test.controller;

import com.asep.test.model.Konser;
import com.asep.test.model.Tiket;
import com.asep.test.req.Pemesanan;
import com.asep.test.service.TiketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tiket")
public class TiketController {

    @Autowired
    TiketService tiketService;



    @PostMapping("/pemesanan/{konserId}")
    @ResponseBody
    public Tiket pemesanan(@PathVariable("konserId") String konserId,@RequestBody List<Pemesanan> pemesanan) throws JsonProcessingException {
        return tiketService.pemesanan(konserId,pemesanan);
    }

}
