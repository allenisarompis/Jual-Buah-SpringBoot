package com.backend.JualBuahSpringBoot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.backend.JualBuahSpringBoot.model.Buah;  
import com.backend.JualBuahSpringBoot.service.BuahService;


@RestController
@RequestMapping("/api/buah")
public class BuahController {
    private final BuahService buahService;

    public BuahController(BuahService buahService){
        this.buahService = buahService;
    }

    @GetMapping
    public List<Buah> getAll(){
        return buahService.getAllBuah();
    }

    @PostMapping
    public Buah tambah(@RequestBody Buah buah){
        return buahService.tambahBuah(buah);
    }

    @PutMapping("/{id}")
    public Buah update(@PathVariable Long id, @RequestBody Buah buah){
        return buahService.updateBuah(id, buah);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        buahService.hapusBuah(id);
        return "Buah berhasil dihapus";
    }
}