package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;

import java.util.List;

public interface AnggotaService {
    AnggotaDTO save(AnggotaDTO param);

    List<AnggotaDTO> findAllData();

    AnggotaDTO update(AnggotaDTO param, Integer id);

    Boolean delete(Integer id);

    AnggotaDTO findById(Integer id);




}
