package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;

import java.util.List;

public interface PengembalianService {
    PengembalianDTO save(PengembalianDTO param);

    List<PengembalianDTO> findAllData();

    PengembalianDTO update(PengembalianDTO param, Integer id);

    Boolean delete(Integer id);

    PengembalianDTO findById(Integer id);

}
