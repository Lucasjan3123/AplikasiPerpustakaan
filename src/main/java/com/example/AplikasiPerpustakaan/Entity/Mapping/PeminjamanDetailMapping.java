package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.PeminjamanDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanDetailMapping {
    PeminjamanDetailMapping instance= Mappers.getMapper(PeminjamanDetailMapping.class);
    PeminjamanDetail toEntity(PeminjamanDetailDTO dto);
    PeminjamanDetailDTO toDto(PeminjamanDetail param);

    List<PeminjamanDetailDTO> toListDto(List<PeminjamanDetail>peminjamanDetailList);
}
