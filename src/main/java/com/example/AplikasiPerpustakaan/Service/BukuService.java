package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;

import java.util.List;

public interface BukuService {
    BukuDTO save(BukuDTO param);

    List<BukuDTO> findAllData();

    BukuDTO update(BukuDTO param, Integer id);

    Boolean delete(Integer id);

    BukuDTO findById(Integer id);


}
