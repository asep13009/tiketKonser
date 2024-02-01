package com.asep.test.controller;

import com.asep.test.model.Konser;
import com.asep.test.service.KonserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("konser")
public class KonserController {

    @Autowired
    KonserService konserService;

    //search
    @GetMapping("/search")
    public List<Konser> search(@RequestParam(value = "search", required = true, defaultValue = "") String search){
        return konserService.search(search);
    }

    //create
    @PostMapping("/create")
    public Konser create(@RequestBody Konser konser){

        return konserService.create(konser);
    }

    //update
    @PostMapping("/update/{id}")
    public Konser update(@PathVariable("id") String id, @RequestBody Konser konser){
        return konserService.update(id,konser);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public Konser update(@PathVariable("id") String id){
        return konserService.delete(id);
    }

    //findbyID
    @GetMapping("/find/{id}")
    public Konser findById(@PathVariable("id") String id){
        return konserService.findById(id);
    }
}
