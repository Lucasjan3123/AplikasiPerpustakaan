package com.example.AplikasiPerpustakaan.Service;

import com.example.AplikasiPerpustakaan.Entity.DTO.PetugasDTO;

import java.util.List;

public interface PetugasService
{
     PetugasDTO save(PetugasDTO param);

        List<PetugasDTO> findAllData();

        PetugasDTO update(PetugasDTO param, Integer id);

        Boolean delete(Integer id);

        PetugasDTO findById(Integer id);


    }
