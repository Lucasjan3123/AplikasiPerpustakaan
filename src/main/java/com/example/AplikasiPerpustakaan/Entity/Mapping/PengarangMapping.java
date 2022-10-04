package com.example.AplikasiPerpustakaan.Entity.Mapping;

import com.example.AplikasiPerpustakaan.Entity.Buku;
import com.example.AplikasiPerpustakaan.Entity.DTO.BukuDTO;
import com.example.AplikasiPerpustakaan.Entity.DTO.PengarangDTO;
import com.example.AplikasiPerpustakaan.Entity.Pengarang;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengarangMapping {
    PengarangMapping instance= Mappers.getMapper(PengarangMapping.class);
    Pengarang toEntity(PengarangDTO dto);
    PengarangDTO toDto(Pengarang param);

    List<PengarangDTO> toListDto(List<Pengarang>pengarangList);

}
