package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper
public interface PeminjamanMapping {
      PeminjamanMapping instance= Mappers.getMapper(PeminjamanMapping.class);
       Peminjaman toEntity(PeminjamanDTO dto);
       PeminjamanDTO toDto(Peminjaman param);

      List<PeminjamanDTO> toListDto(List<Peminjaman>peminjamanList);



}
