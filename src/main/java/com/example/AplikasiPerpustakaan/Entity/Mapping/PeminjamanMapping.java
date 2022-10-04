package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanMapping {
    PeminjamanMapping instance= Mappers.getMapper(PeminjamanMapping.class);
    Peminjaman toEntity(PeminjamanDTO dto);
    PeminjamanDTO toDto(Peminjaman param);

    List<PeminjamanDTO> toListDto(List<Peminjaman>peminjamanList);

}
