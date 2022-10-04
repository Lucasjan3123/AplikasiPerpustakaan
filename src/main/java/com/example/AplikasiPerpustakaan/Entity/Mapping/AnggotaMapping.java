package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnggotaMapping {
    AnggotaMapping instance= Mappers.getMapper(AnggotaMapping.class);
    Anggota toEntity(AnggotaDTO dto);
    AnggotaDTO toDto(Anggota param);

    List<AnggotaDTO> toListDto(List<Anggota>anggotaList);

}
