package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;

import java.util.List;

public interface BukuService {
    BukuDTO save(BukuDTO param);

    List<BukuDTO> findAllData();

    BukuDTO update(BukuDTO param, Integer Id);

    Boolean delete(Integer Id);

    BukuDTO findById(Integer Id);


}
