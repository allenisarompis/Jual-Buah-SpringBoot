package com.backend.JualBuahSpringBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.JualBuahSpringBoot.model.Buah;  

@Service
public class BuahService {
    private List<Buah> daftarBuah = new ArrayList<>();

    // Get semua buah
    public List<Buah> getAllBuah(){
        return daftarBuah;
    }

    // GET buah berdasarkan ID
    public Buah getBuahById(Long id){
        for(Buah buah : daftarBuah){
            if(buah.getId().equals(id)){
                return buah;
            }
        }
        return null;
    }

    public Buah tambahBuah(Buah buah){
        daftarBuah.add(buah);
        return buah;
    }

    public Buah updateBuah(Long id, Buah buahBaru){

        for(Buah buah : daftarBuah){
            if(buah.getId().equals(id)){
                buah.setNama(buahBaru.getNama());
                buah.setHarga(buahBaru.getHarga());
                buah.setStok(buahBaru.getStok());
                return buah;
            }
        }

        return null;
    }

    public void hapusBuah(Long id){
        daftarBuah.removeIf(b -> b.getId().equals(id));
    }
}
