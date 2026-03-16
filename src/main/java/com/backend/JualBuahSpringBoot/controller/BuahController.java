package com.backend.JualBuahSpringBoot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.backend.JualBuahSpringBoot.model.Buah;  
import com.backend.JualBuahSpringBoot.service.BuahService;


@RestController 
// End point untuk mengakses API, misal: http://localhost:8080/api/buah
@RequestMapping("/api/buah")
public class BuahController {
    private final BuahService buahService;

    public BuahController(BuahService buahService){
        this.buahService = buahService;
    }

    @GetMapping
    // GET semua buah
    public List<Buah> getAll(){
        // abstraction, controller memanggil data dari service tanpa tahu bagaimana data diolah
        return buahService.getAllBuah();
    }

    // GET buah berdasarkan ID
    @GetMapping("/{id}")
    public Buah getById(@PathVariable Long id){
        return buahService.getBuahById(id);
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