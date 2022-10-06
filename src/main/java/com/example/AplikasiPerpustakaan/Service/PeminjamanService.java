package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PetugasDTO;

import java.util.List;

public interface PeminjamanService {
    PeminjamanDTO save(PeminjamanDTO param);

    List<PeminjamanDTO> findAllData();

    PeminjamanDTO update(PeminjamanDTO param, Integer id);

    Boolean delete(Integer id);

    PeminjamanDTO findById(Integer id);


}
