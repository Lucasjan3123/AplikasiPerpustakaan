package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Anggota;
import com.example.AplikasiPerpustakaan.Entity.DTO.AnggotaDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengembalianDTO;
import com.example.AplikasiPerpustakaan.Entity.Pengembalian;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PengembalianMapping {
    PengembalianMapping instance= Mappers.getMapper(PengembalianMapping.class);
    Pengembalian toEntity(PengembalianDTO dto);
    PengembalianDTO toDto(Pengembalian param);

    List<PengembalianDTO> toListDto(List<Pengembalian>pengembalianList);

}
