package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PenerbitDTO;
import com.example.AplikasiPerpustakaan.Entity.Penerbit;

import java.util.List;

public interface PenerbitService {
    PenerbitDTO save(PenerbitDTO param);

    List<PenerbitDTO> findAllData();

    PenerbitDTO update(PenerbitDTO param, Integer id);

    Boolean delete(Integer id);

    PenerbitDTO findById(Integer id);


}
