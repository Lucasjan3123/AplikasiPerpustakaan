package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PetugasDTO;
import com.example.AplikasiPerpustakaan.Entity.Petugas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PetugasMapping {
    PetugasMapping instance= Mappers.getMapper(PetugasMapping.class);
    Petugas toEntity(PetugasDTO dto);
    PetugasDTO toDto(Petugas param);

    List<PetugasDTO> toListDto(List<Petugas>petugasList);

}
