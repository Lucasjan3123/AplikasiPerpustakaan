package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PeminjamanDetailDTO;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman;
import com.example.AplikasiPerpustakaan.Entity.Peminjaman_detail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanDetailMapping {
    PeminjamanDetailMapping instance= Mappers.getMapper(PeminjamanDetailMapping.class);
    Peminjaman_detail toEntity(PeminjamanDetailDTO dto);
    PeminjamanDetailDTO toDto(Peminjaman_detail param);

    List<PeminjamanDetailDTO> toListDto(List<Peminjaman_detail>peminjaman_detailList);

}
