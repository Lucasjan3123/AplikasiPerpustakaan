package com.example.AplikasiPerpustakaan.Service.Impl;

import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Repository.AnggotaRepository;
import com.example.AplikasiPerpustakaan.Service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaServiceImpl implements AnggotaService {
    @Autowired
    private AnggotaRepository repository;


    @Override
    public AnggotaDTO save(AnggotaDTO param) {
        return null;
    }

    @Override
    public List<AnggotaDTO> findAllData() {
        return null;
    }

    @Override
    public AnggotaDTO update(AnggotaDTO param, Integer Anggota_id) {
        return null;
    }

    @Override
    public Boolean delete(Integer Anggota_id) {
        return null;
    }

    @Override
    public AnggotaDTO findById(Integer Anggota_id) {
        return null;
    }
}
