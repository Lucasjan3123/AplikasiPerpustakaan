package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PenerbitDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengarangDTO;
import com.example.AplikasiPerpustakaan.Entity.Pengarang;

import java.util.List;

public interface PengarangService {
    PengarangDTO save(PengarangDTO param);

    List<PengarangDTO> findAllData();

    PengarangDTO update(PengarangDTO param, Integer id);

    Boolean delete(Integer id);

    PengarangDTO findById(Integer id);

}
